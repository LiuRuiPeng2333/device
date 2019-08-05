package com.jw.device.service;

import com.jw.device.dto.DeviceInfoDTO;
import com.jw.device.dto.UserDeviceDTO;
import com.jw.device.units.BaseResponse;

public interface DeviceInfoService {
    /**
     * 添加设备
     */
    BaseResponse addDevice(DeviceInfoDTO deviceInfoDTO);

    /**
     * 查询设备
     */
    BaseResponse queryDevice(DeviceInfoDTO deviceInfoDTO);

    /**
     * 查询设备未绑定
     */
    BaseResponse queryDeviceNotbound(DeviceInfoDTO deviceInfoDTO);

    /**
     * 用户绑定设备
     */
    BaseResponse boundDevice(UserDeviceDTO deviceDTO);

    /**
     * 修改设备信息
     */
    int updateDevice(DeviceInfoDTO deviceInfoDTO);
    /**
     * 删除设备信息
     */
    int deleteDevice(String deviceId);
}
