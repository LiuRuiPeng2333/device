package com.jw.device.mapper;


import com.jw.device.dto.DeviceInfoDTO;
import com.jw.device.entity.AdminUser;
import com.jw.device.entity.DeviceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceInfoMapper {

    /**
     * 添加设备
     */
    int addDevice(DeviceInfoDTO deviceInfoDTO);

    /**
     * 查询设备
     */
    List<DeviceInfo> queryDevice(DeviceInfoDTO deviceInfoDTO);

    /**
     * 查询设备未绑定
     */
    List<DeviceInfo> queryDeviceNotCurrentAffiliation(DeviceInfoDTO deviceInfoDTO);

    /**
     * 根据设备编号查询设备信息
     */
    DeviceInfo findDeviceByDeviceId(@Param("deviceId") String deviceId);

    /**
     * 根据设备编号绑定客户
     */
    int updateDeviceByDeviceId(@Param("currentAffiliation") String currentAffiliation, @Param("deviceId") String deviceId);

    /**
     * 根据客户姓名查询该客户订购的设备数量
     */
    int queryDeviceNumber(@Param("currentAffiliation") String currentAffiliation);

    /**
     * 根据设备编号修改设备状态和客户名称
     *
     * @param deviceInfoDTO
     * @return
     */
    int updatehealthstateAndCurrentAffiliation(DeviceInfoDTO deviceInfoDTO);

    /**
     * 根据设备编号删除设备
     *
     * @param deviceId
     * @return
     */
    int deleteDevice(@Param("deviceId") String deviceId);
}
