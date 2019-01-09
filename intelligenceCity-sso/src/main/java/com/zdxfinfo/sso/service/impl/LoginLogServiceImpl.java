//
// package com.zdxfinfo.sso.service.impl;
//
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
//
// import org.springframework.stereotype.Service;
//
// import com.zdxfinfo.base.common.base.BaseController;
// import com.zdxfinfo.base.common.config.Global;
// import com.zdxfinfo.base.common.utils.SwaggerResultUtil;
// import com.zdxfinfo.sso.DBUtils;
// import com.zdxfinfo.sso.bean.LoginLog;
// import com.zdxfinfo.sso.service.LoginLogService;
//
// @Service
//// @Transactional
// public class LoginLogServiceImpl extends BaseController implements
// LoginLogService {
// private static final long serialVersionUID = 1L;
// // @Autowired
// // private LoginLogMapper loginLogMapper;
// private DBUtils DBUtils;
//
// // 超时做一条日志超时的记录
// @Override
// public SwaggerResultUtil<LoginLog> create(LoginLog loginLog) {
// SwaggerResultUtil<LoginLog> result = new SwaggerResultUtil<LoginLog>();
// try {
// // loginLog.setBackgroundUserId(UserInfoUtil.getUserId(request));
// // loginLog.setIp(HttpServletUtil.getRealIP(request));
// // 1系统登录 2手动登出 3超时登出 4默认登出
// loginLog.setType(3);
// // 获取浏览器信息
// // String ua = request.getHeader("User-Agent");
// // // 转成UserAgent对象
// // UserAgent userAgent = UserAgent.parseUserAgentString(ua);
// // // 获取浏览器信息
// // Browser browser = userAgent.getBrowser();
// log.info("loginLog>>>>>>>>>>>>>>>>>>>>>>>>>===" + loginLog);
// // log.info("browser>>>>>>>>>>>>>>>>>>>>>>>>>===" + browser);
// // log.info("browser.toString()>>>>>>>>>>>>>>>>>>>>>>>>>===" +
// // browser.toString());
// // log.info("userAgent>>>>>>>>>>>>>>>>>>>>>>>>>===" + userAgent);
// // log.info("userAgent.getBrowserVersion()>>>>>>>>>>>>>>>>>>>>>>>>>===" +
// // userAgent.getBrowserVersion());
// // loginLog.setBrowser(browser + "(版本 " +
// // userAgent.getBrowserVersion().toString() + ")");
// // loginLog.setBrowser(browser.toString() + "(版本 " +
// // userAgent.getBrowserVersion().toString() + ")");
// // log.info("loginLog>>>>>>>>>>>>>>>>>>>>>>>>>===" + loginLog);
// // Integer d = loginLogMapper.save(loginLog);
// Integer d = addLoginLog(loginLog);
// log.info("d>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>===" + d);
// if (d > 0) {
// result.setData(loginLog);
// result.setMsg("添加成功,id:" + loginLog.getId());
// } else {
// result.setMsg("添加失败");
// result.setCode(Global.FORBIDDEN_ERROR);
// }
// } catch (Exception e) {
// result.setCode(Global.INTERNAL_SERVER_ERROR);
// result.setMsg("服务器内部错误");
// log.error(e.getMessage(), e);
// }
// return result;
//
// }
//
// @Override
// public LoginLog getByToken(String accessToken) {
// return getLoginLogByToken(accessToken);
// }
//
// public int addLoginLog(LoginLog loginLog) {
// // 1、获得连接
// Connection ct = DBUtils.getConnection();
// PreparedStatement st = null;
// ResultSet rt = null;
// String sql = " insert into t_login_log ( backgroundUserId,type,ip,browser,
// accessToken) "//
// + " values ( ?,?,?,?,? ) ; ";
// // 2、获得PreparedStatement对象
// try {
// // 3、处理sql语句,返回自增序列
// st = ct.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
// // 4、给占位符赋值
// st.setInt(1, loginLog.getBackgroundUserId());
// st.setInt(2, loginLog.getType());
// st.setString(3, loginLog.getIp());
// st.setString(4, loginLog.getBrowser());
// st.setString(5, loginLog.getAccessToken());
// // 5、执行sql语句,除了查询，都用executeUpdate方法
// int i = st.executeUpdate();
// // 6、获得自增长的序列号
// rt = st.getGeneratedKeys();
// if (rt.next()) {
// int index = rt.getInt(1);// 只有一条结果集
// System.out.println("添加的是第" + index + "条");
// }
// // 7、提交事务
// ct.commit();
// return i;
// } catch (Exception e) {
// try {
// // 8、事务回滚
// ct.rollback();
// } catch (Exception e1) {
// e1.printStackTrace();
// }
// e.printStackTrace();
// } finally {
// // 关闭资源
// DBUtils.close(st, rt, ct);
// }
// return 0;
// }
//
// // 根据accessToken 获取日志信息
// public LoginLog getLoginLogByToken(String accessToken) {
// // 1、ct
// Connection ct = DBUtils.getConnection();
// // 2、st
// PreparedStatement st = null;
// // 3、rt
// ResultSet rt = null;
// String sql = " select * from t_login_log where accessToken = ? ; ";
// try {
// st = ct.prepareStatement(sql);
// st.setString(1, accessToken);
// // 5、exe
// rt = st.executeQuery();
// // 6、处理结果集
// if (rt.next()) {
// LoginLog loginLog = new LoginLog();
// loginLog.setBackgroundUserId(rt.getInt("backgroundUserId"));
// loginLog.setIp(rt.getString("ip"));
// loginLog.setBrowser(rt.getString("browser"));
// loginLog.setAccessToken(rt.getString("accessToken"));
// return loginLog;
// }
// } catch (Exception e) {
// e.printStackTrace();
// } finally {
// DBUtils.close(st, rt, ct);
// }
// return null;
// }
//
// }