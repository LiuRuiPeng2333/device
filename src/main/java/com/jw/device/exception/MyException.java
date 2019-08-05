/**
 * Copyright (c) 2016-2019 上海玖维 All rights reserved.
 * <p>
 * https://www.shjw.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.jw.device.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 400;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
