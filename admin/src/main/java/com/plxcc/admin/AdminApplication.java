package com.plxcc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @PackgeName: com.plxcc.admin
 * @ClassName: AdminApplication
 * @Author: plxc
 * Date: 2020/9/6 20:50
 * project name: blog
 * @Version:
 * @Description:
 */
@SpringBootApplication
@ComponentScan("com.plxcc")
@MapperScan("com.plxcc.admin.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
