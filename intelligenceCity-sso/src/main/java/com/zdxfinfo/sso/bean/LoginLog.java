package com.zdxfinfo.sso.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.builder.HashCodeBuilder;

public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private java.lang.Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// 后台用户ID
	private java.lang.Integer backgroundUserId;

	public void setBackgroundUserId(Integer backgroundUserId) {
		this.backgroundUserId = backgroundUserId;
	}

	public Integer getBackgroundUserId() {
		return this.backgroundUserId;
	}

	// 1系统登录 2手动登出 3超时登出 4默认登出
	private java.lang.Integer type;

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	// ip地址
	private java.lang.String ip;

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getIp() {
		return this.ip;
	}

	// 浏览器
	private java.lang.String browser;
	// 超时之前的token
	private java.lang.String accessToken;

	public java.lang.String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(java.lang.String accessToken) {
		this.accessToken = accessToken;
	}

	public void setBrowser(String browser) {
		this.browser = browser == null ? null : browser.trim();
	}

	public String getBrowser() {
		return this.browser;
	}

	public LoginLog() {
		super();
	}

	public LoginLog toPojo_Map(Map<String, Object> map) throws ParseException {
		if (map.get("id") != null)
			setId(Integer.parseInt(String.valueOf(map.get("id"))));
		if (map.get("backgroundUserId") != null)
			setBackgroundUserId(Integer.parseInt(String.valueOf(map.get("backgroundUserId"))));
		if (map.get("type") != null)
			setType(Integer.parseInt(String.valueOf(map.get("type"))));
		if (map.get("ip") != null)
			setIp(String.valueOf(map.get("ip")));
		if (map.get("browser") != null)
			setBrowser(String.valueOf(map.get("browser")));
		if (map.get("accessToken") != null)
			setAccessToken(String.valueOf(map.get("accessToken")));
		return this;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new LinkedHashMap<>();
		if (getId() != null)
			map.put("id", getId());
		if (getBackgroundUserId() != null)
			map.put("backgroundUserId", getBackgroundUserId());
		if (getType() != null)
			map.put("type", getType());
		if (getIp() != null)
			map.put("ip", getIp());
		if (getBrowser() != null)
			map.put("browser", getBrowser());
		if (getAccessToken() != null)
			map.put("accessToken", getAccessToken());
		return map;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(LoginLog obj) {
		if (this.getId() == obj.getId())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "LoginLog [id=" + id + ", backgroundUserId=" + backgroundUserId + ", type=" + type + ", ip=" + ip
				+ ", browser=" + browser + ", accessToken=" + accessToken + "]";
	}

}
