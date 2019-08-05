package com.jw.device.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员表
 */
@Data
public class AdminUser implements Serializable {
    /**
     * 管理员表主键id
     */
    private  Integer id;
    /**
     * 管理员账号
     */
    private  String userName;
    /**
     * 密码(MD5加密）
     */
    private  String password;
    /**
     * 管理员状态(默认为0）
     */
    private  Integer state;
}
