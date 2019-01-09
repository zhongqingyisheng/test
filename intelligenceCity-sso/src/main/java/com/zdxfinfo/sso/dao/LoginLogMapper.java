
package com.zdxfinfo.sso.dao;

import com.zdxfinfo.sso.bean.LoginLog;

public abstract interface LoginLogMapper {

	Integer save(LoginLog loginLog);

	LoginLog getByToken(LoginLog loginLog);

}
