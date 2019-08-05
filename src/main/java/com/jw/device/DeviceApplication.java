package com.jw.device;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement  //开启事务
@EnableConfigurationProperties   //自定义bean配置
@MapperScan(value = "com.jw.device.mapper")
@SpringBootApplication
public class DeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run( DeviceApplication.class, args );
    }

}
