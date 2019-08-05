package com.jw.device.service;

import com.jw.device.entity.UserInfo;
import com.jw.device.units.BaseResponse;

public interface UserInfoService {
    /**
     * 添加用户
     */
    BaseResponse addUser(UserInfo userInfo);
    /**
     * 查询用户列表
     */
    BaseResponse queryUser(UserInfo userInfo);

}
