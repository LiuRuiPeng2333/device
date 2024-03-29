package com.jw.device.units;


import com.jw.device.constant.ResCode;
import lombok.Data;


/**
 * 统一返回格式
 */

@Data
public class BaseResponse {

    /**
     * 状态码
     */
    private  Integer code;
    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public BaseResponse(){
        this.code = Integer.valueOf(0);
        this.msg = "";
        this.data = null;
    }
    /**
     *返回状态码、信息、以及数据
     */
    public BaseResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     *只返回状态码，以及信息可以用于失败时候来使用
     */
    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    /**
     *只返回状态码和数据
     */
    public BaseResponse(Integer code, Object data) {
        this.code = code;
        this.msg = "";
        this.data = data;
    }
    public BaseResponse(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = ResCode.FAIL.getCode();
    }
}
