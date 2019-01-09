package com.zdxfinfo.sso.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.zdxfinfo.sso.service.OAuthService;

@Service
public class OAuthServiceImpl implements OAuthService {

	private Cache cache;

	// @Autowired
	// private ClientService clientService;

	@Autowired
	public OAuthServiceImpl(CacheManager cacheManager) {
		this.cache = cacheManager.getCache("code-cache");
	}

	@Override
	public void addAuthCode(String authCode, Map<String, Object> obj) {
		cache.put(authCode, obj);
	}

	@Override
	public void addAccessToken(String accessToken, Map<String, Object> obj) {
		cache.put(accessToken, obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addUserIdToToken(String userId, String token) {
		if (cache.get(userId) == null) {
			cache.put(userId, new HashMap<String, Boolean>());
		}
		Map<String, Boolean> map = (Map<String, Boolean>) cache.get(userId).get();
		// 所有已存在的token变为false
		for (String key : map.keySet()) {
			map.put(key, false);
		}
		// 新增token为true
		map.put(token, true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getByAuthCode(String authCode) {
		return (Map<String, Object>) cache.get(authCode).get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getByAccessToken(String accessToken) {
		return (Map<String, Object>) cache.get(accessToken).get();
	}

	@Override
	public boolean checkAuthCode(String authCode) {
		return cache.get(authCode) != null;
	}

	@Override
	public boolean checkAccessToken(String accessToken) {
		return cache.get(accessToken) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkOldAccessToken(String accessToken) {
		// 根据token取得userId
		Map<String, Object> userMap = (Map<String, Object>) cache.get(accessToken).get();
		// 再根据userId获取tokenMap
		if (cache.get(userMap.get("userId").toString()) == null) {
			return true;
		}
		Map<String, Boolean> tokenMap = (Map<String, Boolean>) cache.get(userMap.get("userId").toString()).get();
		return tokenMap.get(accessToken);
	}

	// @Override
	// public boolean checkClientId(String clientId) {
	// return clientService.findByClientId(clientId) != null;
	// }

	// @Override
	// public boolean checkClientSecret(String clientSecret) {
	// return clientService.findByClientSecret(clientSecret) != null;
	// }

	@Override
	public long getExpireIn() {
		return 3600L;
	}

}
