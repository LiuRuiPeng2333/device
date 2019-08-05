package com.jw.device.contorller;

import com.jw.device.entity.AdminUser;
import com.jw.device.service.AdminUserService;
import com.jw.device.units.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;
    /**
     * 注册管理员
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody AdminUser adminUser) {

        return adminUserService.addUser(adminUser);
    }
    /**
     * 管理员登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(@RequestBody AdminUser adminUser) {

        return adminUserService.userLogin(adminUser);
    }
}
