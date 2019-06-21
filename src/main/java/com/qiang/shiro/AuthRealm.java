package com.qiang.shiro;

import com.qiang.model.Permission;
import com.qiang.model.Role;
import com.qiang.model.User;
import com.qiang.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: qiang
 * @ProjectName: adminsystem
 * @Package: com.qiang.shiro
 * @Description: 认证授权
 * @Date: 2019/6/20 0020 13:02
 **/
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    // 用于授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> list = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(CollectionUtils.isNotEmpty(roles)){
            for (Role role:
                 roles) {
                roleNameList.add(role.getRname());
                Set<Permission> permissionSet = role.getPermissionSet();
                if(CollectionUtils.isNotEmpty(permissionSet)){
                    for (Permission permission:
                         permissionSet) {
                        list.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        info.addRoles(roleNameList);
        return info;
    }

    // 用户认证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User byUsername = userService.findByUsername(username);
        return new SimpleAuthenticationInfo(byUsername, byUsername.getPassword(), this.getClass().getName());
    }
}
