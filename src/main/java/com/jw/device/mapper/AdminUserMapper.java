package com.jw.device.mapper;

import com.jw.device.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    /**
     *  添加管理员
     *
     */
    int addAdminUser(AdminUser adminUser);
    /**
     *  根据用户名查询管理员
     *
     */
   AdminUser findByUserForUserName(@Param( "userName" )String userName);
    /**
     *  根据用户名和密码查询管理员
     *
     */
    AdminUser findByUserForUserNameAndPwd(@Param( "userName" )String userName,@Param( "password" )String password);
}
