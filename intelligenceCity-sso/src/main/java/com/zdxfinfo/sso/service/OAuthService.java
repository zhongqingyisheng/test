package com.zdxfinfo.sso.service;

import java.util.Map;

public interface OAuthService {
	   public void addAuthCode(String authCode, Map<String,Object> map);// 添加 auth code  
	   public void addAccessToken(String accessToken, Map<String,Object> map); // 添加 access token  
	   public void addUserIdToToken(String userId, String token);
	   boolean checkAuthCode(String authCode); // 验证auth code是否有效  
	   boolean checkAccessToken(String accessToken); // 验证access token是否有效  
	   boolean checkOldAccessToken(String accessToken); // 验证access token是否有效  
	   Map<String,Object> getByAuthCode(String authCode);// 根据auth code获取用户id  
	   Map<String,Object> getByAccessToken(String accessToken);// 根据access token获取用户id
	   long getExpireIn();//auth code / access token 过期时间  
//	   public boolean checkClientId(String clientId);// 检查客户端id是否存在  
//	   public boolean checkClientSecret(String clientSecret);// 坚持客户端安全KEY是否存在  
}
