package com.jw.device.mapper;

import com.jw.device.entity.AdminUser;
import com.jw.device.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {

    /**
     *  添加用户
     *
     */
    int addUser(UserInfo userInfo);
    /**
     *  根据用户名查询用户
     *
     */
    UserInfo findByUserForName(@Param( "name" )String name);

    /**
     *  查询用户
     * @param userInfo
     * @return
     */
    List<UserInfo> queryUser(UserInfo userInfo);
}
