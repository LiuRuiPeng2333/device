package com.jw.device.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jw.device.constant.ResCode;
import com.jw.device.dto.PageDTO;
import com.jw.device.entity.DeviceInfo;
import com.jw.device.entity.UserInfo;
import com.jw.device.mapper.DeviceInfoMapper;
import com.jw.device.mapper.UserInfoMapper;
import com.jw.device.service.UserInfoService;
import com.jw.device.units.BaseResponse;
import com.jw.device.units.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Override
    public BaseResponse addUser(UserInfo userInfo) {
        ValidatorUtils.validateEntity( userInfo );
      /*  DeviceInfo device = deviceInfoMapper.findDeviceByDeviceId( userInfo.getDeviceId() );
        if(device==null){
            return new BaseResponse( ResCode.FAIL.getCode(), "该设备还未入库，添加失败");
        }*/
       UserInfo user = userInfoMapper.findByUserForName( userInfo.getName() );
        if(user!=null){
            return new BaseResponse( ResCode.FAIL.getCode(), "该客户已经注册！");
        }
        int i = userInfoMapper.addUser( userInfo );
        if(i<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "注册失败");
        }
        /*int k = deviceInfoMapper.updateDeviceByDeviceId( device.getDeviceId() );
        if(k<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "绑定设备失败");
        }*/
        return new BaseResponse( ResCode.SUCCESS.getCode(), "注册成功！");
    }

    @Override
    public BaseResponse queryUser(UserInfo userInfo) {
        if ( null==userInfo.getPageDTO() ) {
            userInfo.setPageDTO(new PageDTO());
        }
        if (null == userInfo.getPageDTO().getPageNum()) {
            userInfo.getPageDTO().setPageNum(0);
        }
        if (null == userInfo.getPageDTO().getPageSize()) {
            userInfo.getPageDTO().setPageSize(10);
        }
        PageHelper.startPage(userInfo.getPageDTO().getPageNum(), userInfo.getPageDTO().getPageSize());

        List<UserInfo> userlist = userInfoMapper.queryUser(userInfo);
        if(userlist.size()<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "没有数据！");
        }

        for (int i=0;i<userlist.size();i++){
            userlist.get( i ).setDeviceNumber( deviceInfoMapper.queryDeviceNumber( userlist.get( i ).getName() ) );
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "查询成功！",new PageInfo<>(userlist));
    }
}
