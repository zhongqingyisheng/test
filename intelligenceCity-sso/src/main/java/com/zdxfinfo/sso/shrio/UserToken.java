package com.zdxfinfo.sso.shrio;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {
	
	
	public UserToken(String username,String password){
		super(username,password);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
