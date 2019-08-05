package com.jw.device.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDeviceDTO {

    /**
     * 客户姓名
     */
    private String userName;
    /*
      * 设备编号集合
     */
    private List<String> deviceList;
}
