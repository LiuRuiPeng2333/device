package com.jw.device.contorller;

import com.jw.device.constant.ResCode;
import com.jw.device.dto.DeviceInfoDTO;
import com.jw.device.dto.UserDeviceDTO;
import com.jw.device.entity.AdminUser;
import com.jw.device.service.DeviceInfoService;
import com.jw.device.units.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;
    /**
     * 添加设备
     */
    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody DeviceInfoDTO deviceInfoDTO) {
        log.info( "设备添加~~~~~~~~~~~~~~~~~"+deviceInfoDTO );
        return deviceInfoService.addDevice(deviceInfoDTO);
    }

    /**
     * 查询设备
     */
    @RequestMapping(value = "/queryDevice", method = RequestMethod.POST)
    public BaseResponse queryDevice(@RequestBody DeviceInfoDTO deviceInfoDTO) {
        log.info( "设备查询~~~~~~~~~~~~~~~~~" );
        return deviceInfoService.queryDevice(deviceInfoDTO);
    }
    /**
     * 查询设备设备查询未绑定
     */
    @RequestMapping(value = "//queryDeviceNotbound", method = RequestMethod.POST)
    public BaseResponse queryDeviceNotbound(@RequestBody DeviceInfoDTO deviceInfoDTO) {
        log.info( "设备查询未绑定，~~~~~~~~~~~~~~~~~" );
        return deviceInfoService.queryDeviceNotbound(deviceInfoDTO);
    }
    /**
     * 绑定设备
     */
    @RequestMapping(value = "//boundDevice", method = RequestMethod.POST)
    public BaseResponse boundDevice(@RequestBody UserDeviceDTO deviceInfoDTO) {
        log.info( "绑定设备~~~~~~~~~~~~~~~~~" );
        return deviceInfoService.boundDevice(deviceInfoDTO);
    }

    /**
     *  修改状态和客户
     */
    @RequestMapping(value = "/updateDevice", method = RequestMethod.POST)
    public BaseResponse updateName(@RequestBody DeviceInfoDTO deviceInfoDTO) {
        log.info( "修改状态和客户~~~~~~~~~~~~~~~~~" );
       int i= deviceInfoService.updateDevice(deviceInfoDTO);
        log.info( "修改状态和客户i:{}",i);
       if(i==0){
           return new BaseResponse( ResCode.FAIL.getCode(), "修改失败！");
       }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "修改成功！");
    }
    /**
     *  删除设备
     */
    @RequestMapping(value = "/deleteDevice/{deviceId}", method = RequestMethod.GET)
    public BaseResponse deleteDevice(@PathVariable String deviceId) {
        log.info( "删除设备~~~~~~~~~~~~~~~~~" );
        int i= deviceInfoService.deleteDevice(deviceId);
        log.info( "删除设备i:{}",i);
        if(i==0){
            return new BaseResponse( ResCode.FAIL.getCode(), "删除失败！");
        }
        return new BaseResponse( ResCode.SUCCESS.getCode(), "删除成功！");
    }
}
