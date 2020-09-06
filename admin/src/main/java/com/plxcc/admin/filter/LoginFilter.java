package com.plxcc.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.plxcc.servicebase.common.Result;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @PackgeName: com.plxcc.admin.filter
 * @ClassName: LoginFilter
 * @Author: plxc
 * Date: 2020/9/6 22:42
 * project name: blog
 * @Version:
 * @Description:
 */
public class LoginFilter extends UserFilter {

    /**
     * 这个方法用于处理未登录时页面重定向的逻辑
     * 因此，只要进入了这个方法，就意味着登录失效了
     * 我们只需要在这个方法里，给前端返回一个登录失效的状态码即可
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(Result.fail().setMsg("登陆失败")));
    }
}