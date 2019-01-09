package com.zdxfinfo.sso.service;

import com.zdxfinfo.base.common.utils.SwaggerResultUtil;
import com.zdxfinfo.sso.bean.LoginLog;

public abstract interface LoginLogService {

	SwaggerResultUtil<LoginLog> create(LoginLog loginLog);

	LoginLog getByToken(String accessToken);
}