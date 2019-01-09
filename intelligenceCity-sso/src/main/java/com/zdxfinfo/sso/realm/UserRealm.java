package com.zdxfinfo.sso.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdxfinfo.sso.bean.BackgroundUser;
import com.zdxfinfo.sso.service.BackgroundUserService;
import com.zdxfinfo.sso.shrio.UserToken;

/**
 * 系统安全认证实现类
 * @author YuHangInfo
 * @version 2014-7-5
 */
@Service
public class UserRealm extends AuthorizingRealm {


	public UserRealm() {
		this.setCachingEnabled(false);
	}
	
    @Autowired
    private BackgroundUserService backgroundUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //暂时不加权限
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	UserToken usertoken = (UserToken)token;
    	
        String username = usertoken.getUsername();

        BackgroundUser user = backgroundUserService.findByUsername(username);
        
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        
        usertoken.setId(user.getId());
        
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        		usertoken, //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
