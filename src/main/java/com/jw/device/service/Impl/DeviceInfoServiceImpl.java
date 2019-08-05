package com.jw.device.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jw.device.constant.ResCode;
import com.jw.device.dto.DeviceInfoDTO;
import com.jw.device.dto.PageDTO;
import com.jw.device.dto.UserDeviceDTO;
import com.jw.device.entity.DeviceInfo;
import com.jw.device.exception.MyException;
import com.jw.device.mapper.DeviceInfoMapper;
import com.jw.device.service.DeviceInfoService;
import com.jw.device.units.BaseResponse;
import com.jw.device.units.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public BaseResponse addDevice(DeviceInfoDTO deviceInfoDTO) {
        ValidatorUtils.validateEntity(deviceInfoDTO);
        DeviceInfo device = deviceInfoMapper.findDeviceByDeviceId( deviceInfoDTO.getDeviceId() );
        if(device!=null){
            return new BaseResponse( ResCode.FAIL.getCode(), "该设备已入库！");
        }
        deviceInfoDTO.setLastLoginDate( deviceInfoDTO.getDecisionDate() );
        deviceInfoDTO.setSoftwareVersions( "V1.0.0" );
        int i = deviceInfoMapper.addDevice( deviceInfoDTO );
        if(i<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "设备入库失败！");
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "设备入库成功！");
    }

    @Override
    public BaseResponse queryDevice(DeviceInfoDTO deviceInfoDTO) {
        if ( null==deviceInfoDTO.getPageDTO() ) {
            deviceInfoDTO.setPageDTO(new PageDTO());
        }
        if (null == deviceInfoDTO.getPageDTO().getPageNum()) {
            deviceInfoDTO.getPageDTO().setPageNum(0);
        }
        if (null == deviceInfoDTO.getPageDTO().getPageSize()) {
            deviceInfoDTO.getPageDTO().setPageSize(10);
        }
        PageHelper.startPage(deviceInfoDTO.getPageDTO().getPageNum(), deviceInfoDTO.getPageDTO().getPageSize());
        List<DeviceInfo> deviceInfolist = deviceInfoMapper.queryDevice(deviceInfoDTO);
        if(deviceInfolist.size()<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "没有数据！");
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "查询成功！",new PageInfo<>(deviceInfolist));
    }

    @Override
    public BaseResponse queryDeviceNotbound(DeviceInfoDTO deviceInfoDTO) {
        if ( null==deviceInfoDTO.getPageDTO() ) {
            deviceInfoDTO.setPageDTO(new PageDTO());
        }
        if (null == deviceInfoDTO.getPageDTO().getPageNum()) {
            deviceInfoDTO.getPageDTO().setPageNum(0);
        }
        if (null == deviceInfoDTO.getPageDTO().getPageSize()) {
            deviceInfoDTO.getPageDTO().setPageSize(10);
        }
        PageHelper.startPage(deviceInfoDTO.getPageDTO().getPageNum(), deviceInfoDTO.getPageDTO().getPageSize());
        List<DeviceInfo> deviceInfolist = deviceInfoMapper.queryDeviceNotCurrentAffiliation(deviceInfoDTO);
        if(deviceInfolist.size()<=0){
            return new BaseResponse( ResCode.FAIL.getCode(), "没有数据！");
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "查询成功！",new PageInfo<>(deviceInfolist));
    }

    @Override
    public BaseResponse boundDevice(UserDeviceDTO deviceDTO) {
      if(deviceDTO.getDeviceList().size()==0){
          return new BaseResponse( ResCode.FAIL.getCode(), "没有选择设备！");
      }
      if(deviceDTO.getUserName()==null){
          return new BaseResponse( ResCode.FAIL.getCode(), "客户姓名为空！");
      }
        for (int i = 0; i <deviceDTO.getDeviceList().size() ; i++) {
            deviceInfoMapper.updateDeviceByDeviceId( deviceDTO.getUserName(),deviceDTO.getDeviceList().get( i ) );
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "添加设备成功！");
    }

    @Override
    public int updateDevice(DeviceInfoDTO deviceInfoDTO) {
        if(deviceInfoDTO.getDeviceId()==null){
            throw  new MyException("设备编号为空!");
        }
        if(deviceInfoDTO.getHealthState()==null){
            throw  new MyException("设备健康状态为空!");
        }
        if(deviceInfoDTO.getCurrentAffiliation()==null){
            throw  new MyException("客户名称为空!");
        }
        int i = deviceInfoMapper.updatehealthstateAndCurrentAffiliation( deviceInfoDTO );
        return i;
    }

    @Override
    public int deleteDevice(String deviceId) {
        if(deviceId==null){
            throw  new MyException("设备编号为空!");
        }
        int i =deviceInfoMapper.deleteDevice( deviceId );
        return i;
    }
}
