package com.plxcc.admin.shiro;


import com.plxcc.admin.entity.BlAdmin;
import com.plxcc.admin.entity.BlUser;
import com.plxcc.admin.service.BlAdminService;
import com.plxcc.admin.service.BlUserService;
import com.plxcc.admin.token.UsernamePasswordToken;
import com.plxcc.admin.utils.StateEnums;
import com.plxcc.servicebase.exception.ZTException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private BlAdminService adminService;
    @Autowired
    private BlUserService userService;

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        int state = usernamePasswordToken.getState();
        if (state == StateEnums.ADMIN.getCode()) {
            BlAdmin admin = adminService.getByUsername(username);
            if (admin == null) {
                // 用户不存在
                throw new ZTException(20001,"用户不存在");
            }
            return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
        } else {
            BlUser user = userService.getByUsername(username);
            if (user == null || user.getDeleted() == 1) {
                throw new ZTException(20001,"用户不存在");
            }
            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        }
    }
}
