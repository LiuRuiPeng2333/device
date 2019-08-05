package com.jw.device.constant;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum ResCode {

    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

    //数据类型不支持
    TYPE_NOT_SUPPORTED(601);


    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
