package com.jw.device.service;

import com.jw.device.constant.BaseConstant;
import com.jw.device.entity.AdminUser;
import com.jw.device.units.BaseResponse;

public interface AdminUserService {
    /**
     * 添加管理员
     */
    BaseResponse  addUser(AdminUser adminUser);
    /**
     * 管理员登录
     */
    BaseResponse  userLogin(AdminUser adminUser);
}
