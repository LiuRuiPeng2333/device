package com.jw.device.service.Impl;

import com.jw.device.constant.ResCode;
import com.jw.device.entity.AdminUser;
import com.jw.device.mapper.AdminUserMapper;
import com.jw.device.mapper.DeviceInfoMapper;
import com.jw.device.service.AdminUserService;
import com.jw.device.units.BaseResponse;
import com.jw.device.units.MD5Utils;
import com.jw.device.units.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;


    @Override
    public BaseResponse addUser(AdminUser adminUser) {

        AdminUser user = adminUserMapper.findByUserForUserName( adminUser.getUserName() );
    if(null!=user){
        return new BaseResponse( ResCode.FAIL.getCode(), "该用户已经注册！");
    }
    /*String MD5password= MD5Utils.getSaltMD5( adminUser.getPassword() );
    adminUser.setPassword( MD5password );*/
        int i = adminUserMapper.addAdminUser( adminUser );
        if(i<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "注册失败");
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "注册成功！");
    }

    @Override
    public BaseResponse userLogin(AdminUser adminUser) {
        AdminUser user = adminUserMapper.findByUserForUserNameAndPwd( adminUser.getUserName() ,adminUser.getPassword());
        if(null==user){
            return new BaseResponse( ResCode.FAIL.getCode(), "用户名/密码错误！");
        }
       /* boolean flag = MD5Utils.getSaltverifyMD5( adminUser.getPassword(), user.getPassword() );
        if(flag==false){
            return new BaseResponse( ResCode.FAIL.getCode(), "密码错误！");
        }*/
        return new BaseResponse( ResCode.SUCCESS.getCode(), "登录成功！");
    }
}
