package com.jw.device.dto;


import lombok.Data;

/**
 * 分页dto
 * @author liuRuiPeng
 * @date 2019/06/21
 */
@Data
public class PageDTO {
    /**
     *  每页大小
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNum;

}
