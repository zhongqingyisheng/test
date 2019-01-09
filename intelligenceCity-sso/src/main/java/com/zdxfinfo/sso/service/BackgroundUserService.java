package com.zdxfinfo.sso.service;

import java.util.List;

import com.zdxfinfo.sso.bean.BackgroundUser;


public interface BackgroundUserService {

    Integer updateByPrimaryKey(BackgroundUser record);
	
    public BackgroundUser createUser(BackgroundUser user);// 创建用户  
    
    public BackgroundUser updateUser(BackgroundUser user);// 更新用户  
    
    public void deleteUser(Long userId);// 删除用户  
    
    public void changePassword(Long userId, String newPassword); //修改密码  
    
    BackgroundUser findOne(Long userId);// 根据id查找用户  
    
    List<BackgroundUser> findAll();// 得到所有用户  
    
    public BackgroundUser findByUsername(String userName);// 根据用户名查找用户  
	
}
