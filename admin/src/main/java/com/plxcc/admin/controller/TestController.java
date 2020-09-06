package com.plxcc.admin.controller;

import com.plxcc.servicebase.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackgeName: com.plxcc.admin.controller
 * @ClassName: TestController
 * @Author: plxc
 * Date: 2020/9/6 21:21
 * project name: blog
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public Result hi(){
        return Result.success().setMsg("hello world");
    }

}
