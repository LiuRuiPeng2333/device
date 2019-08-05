package com.jw.device.contorller;

import com.jw.device.entity.AdminUser;
import com.jw.device.entity.UserInfo;
import com.jw.device.service.UserInfoService;
import com.jw.device.units.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 添加客户
     */
    @RequestMapping(value = "/User/addUser", method = RequestMethod.POST)
    public BaseResponse addUser(@RequestBody UserInfo user) {
        log.info( "添加客户:"+user );
        return userInfoService.addUser(user);
    }
    /**
     * 查询客户
     */
    @RequestMapping(value = "/User/queryUser", method = RequestMethod.POST)
    public BaseResponse queryUser(@RequestBody UserInfo user) {
        log.info( "查询客户:"+user );
        return userInfoService.queryUser(user);
    }
}


