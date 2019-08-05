package com.jw.device.dto;

import lombok.Data;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 设备管理表
 */
@Data
public class DeviceInfoDTO {
    /**
     * 设备表主键id
     */
    private  Integer id;
    /**
     * 采购日期
     */
    @NotNull(message = "采购日期不能为空")
    private Date decisionDate;
    /**
     * 采购批次
     */
    @NotNull(message = "采购批次不能为空")
    private  Integer decisionBatch;
    /**
     * 供应商名称
     */
    @NotNull(message = "供应商名称不能为空")
    private  String providerName;
    /**
     * 设备编号
     */
    @NotNull(message = "设备编号不能为空")
    private  String deviceId;
    /**
     * 设备健康状态
     */
    @NotNull(message = "设备健康状态不能为空")
    private  String healthState;
    /**
     * 设备系统版本
     */
    @NotNull(message = "设备系统版本不能为空")
    private  String systemVersions;
    /**
     * 设备应用软件版本
     */
    private  String softwareVersions;
    /**
     * 最后登录时间
     */
    private Date lastLoginDate;
    /**
     * 设备当前所属单位
     */
    private  String currentAffiliation;
    /**
     * 分页对象
     */
    private  PageDTO pageDTO;
}
