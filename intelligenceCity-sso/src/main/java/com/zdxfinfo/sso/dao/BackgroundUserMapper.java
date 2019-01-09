package com.zdxfinfo.sso.dao;

import com.zdxfinfo.sso.bean.BackgroundUser;

public interface BackgroundUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackgroundUser record);

    int insertSelective(BackgroundUser record);

    BackgroundUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackgroundUser record);

    int updateByPrimaryKey(BackgroundUser record);
    
    BackgroundUser findByUsername(String userName);
}