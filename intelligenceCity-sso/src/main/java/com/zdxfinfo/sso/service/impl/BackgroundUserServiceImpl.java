package com.zdxfinfo.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdxfinfo.sso.bean.BackgroundUser;
import com.zdxfinfo.sso.dao.BackgroundUserMapper;
import com.zdxfinfo.sso.service.BackgroundUserService;

@Service
public class BackgroundUserServiceImpl implements BackgroundUserService{

	@Autowired  
    private BackgroundUserMapper backgroundUserMapper;

	@Override
	public Integer updateByPrimaryKey(BackgroundUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackgroundUser createUser(BackgroundUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackgroundUser updateUser(BackgroundUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BackgroundUser findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BackgroundUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BackgroundUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return backgroundUserMapper.findByUsername(username);
	}
	
}
