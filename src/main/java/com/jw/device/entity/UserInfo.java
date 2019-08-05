package com.jw.device.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jw.device.dto.PageDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户管理表
 */
@Data
public class UserInfo implements Serializable {
    /**
     * 用户表主键id
     */

    private  Integer id;
    /**
     * 用户姓名
     */
    @NotNull(message = "用户名称不能为空")
    private  String name;
    /**
     * 联系方式
     */
    @NotNull(message = "联系方式不能为空")
    private  String phone;
    /**
     * 地址
     */
    @NotNull(message = "地址不能为空")
    private  String address;
    /**
     * 注册日期
     */
    @NotNull(message = "注册日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registDate;
    /**
     * 设备编号
     */
    @NotNull(message = "设备编号不能为空")
    private String deviceId;
    /**
     * 设备数量
     */
    private Integer deviceNumber;
    /**
     * 分页对象
     */
    private PageDTO pageDTO;
}
