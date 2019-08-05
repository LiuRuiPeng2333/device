package com.jw.device.constant;

import lombok.Data;
import okhttp3.MediaType;

/**
 * @author: lucifer
 * @date: 2019/4/8
 * @description: 常量类
 */
@Data
public class BaseConstant {

    /**
     * 删除标识 0：未删除
     */
    public static final int IS_NOT_DELETE = 0;

    /**
     * 删除标识 1：删除
     */
    public static final int IS_DELETE = 1;
    /**
     * 可用标识 0：可用
     */
    public static final int IS_ENABLE = 0;

    /**
     * 可用标识 1：不可用
     */
    public static final int IS_DISABLE = 1;
    /**
     * 查询条件字符串其他
     */
    public static final String STING_OTHER = "其他";

    /**
     * 是临时访客标记
     */
    public static final int IS_COLLER = 1;
    /**
     *  是常住人员标记
     */
    public static final int IS_PERMANENT = 2;
    /**
     *  是接待区域标记
     */
    public static final int IS_RECEPTIONAREA = 0;
    /**
     *  是内部区域标记  interior
     */
    public static final int IS_INTERIORAREA = 1;


}
