package com.jw.device.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备管理表
 */
@Data
public class DeviceInfo implements Serializable {
    /**
     * 设备表主键id
     */
    private  Integer id;
    /**
     * 采购日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date decisionDate;
    /**
     * 采购批次
     */
    private  Integer decisionBatch;
    /**
     * 供应商名称
     */
    private  String providerName;
    /**
     * 设备编号
     */
    private  String deviceId;
    /**
     * 设备健康状态
     */
    private  String healthState;
    /**
     * 设备系统版本
     */
    private  String systemVersions;
    /**
     * 设备应用软件版本
     */
    private  String softwareVersions;
    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastLoginDate;
    /**
     * 设备当前所属单位
     */
    private  String currentAffiliation;
}
