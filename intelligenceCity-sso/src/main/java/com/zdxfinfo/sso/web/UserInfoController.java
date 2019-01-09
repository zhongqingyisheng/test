package com.zdxfinfo.sso.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zdxfinfo.base.common.config.Global;
import com.zdxfinfo.base.common.utils.StringUtil;
import com.zdxfinfo.base.common.utils.SwaggerResultUtil;
import com.zdxfinfo.sso.Constants;
import com.zdxfinfo.sso.service.OAuthService;

/**
 * <p>
 * User: yh
 * <p>
 * Date: 14-2-16
 * <p>
 * Version: 1.0
 */
@RestController
public class UserInfoController {

	@Autowired
	private OAuthService oAuthService;

	@RequestMapping("/userInfo")
	public HttpEntity<Object> userInfo(HttpServletRequest request) throws OAuthSystemException {
		try {
			// 构建OAuth资源请求
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
			// 获取Access Token
			String accessToken = oauthRequest.getAccessToken();

			// 验证Access Token
			if (!oAuthService.checkAccessToken(accessToken)) {
				// 如果不存在/过期了，返回未验证错误，需重新验证
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.setRealm(Constants.RESOURCE_SERVER_NAME).setError(OAuthError.ResourceResponse.INVALID_TOKEN)
						.buildHeaderMessage();

				HttpHeaders headers = new HttpHeaders();
				headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
				return new ResponseEntity<Object>(headers, HttpStatus.UNAUTHORIZED);
			}
			// 返回用户信息
			Map<String, Object> map = oAuthService.getByAccessToken(accessToken);
			return new ResponseEntity<Object>(JSON.toJSONString(map), HttpStatus.OK);
		} catch (OAuthProblemException e) {
			// 检查是否设置了错误码
			String errorCode = e.getError();
			if (OAuthUtils.isEmpty(errorCode)) {
				OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
						.setRealm(Constants.RESOURCE_SERVER_NAME).buildHeaderMessage();
				HttpHeaders headers = new HttpHeaders();
				headers.add(OAuth.HeaderType.WWW_AUTHENTICATE,
						oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
				return new ResponseEntity<Object>(headers, HttpStatus.UNAUTHORIZED);
			}

			OAuthResponse oauthResponse = OAuthRSResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
					.setRealm(Constants.RESOURCE_SERVER_NAME).setError(e.getError())
					.setErrorDescription(e.getDescription()).setErrorUri(e.getUri()).buildHeaderMessage();

			HttpHeaders headers = new HttpHeaders();
			headers.add(OAuth.HeaderType.WWW_AUTHENTICATE, oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping("/userInfoAPI")
	public HttpEntity<Object> userInfoAPI(HttpServletRequest request) throws OAuthSystemException {
		SwaggerResultUtil<Object> result = new SwaggerResultUtil<Object>();
		String body = "";
		try {
			String accessToken = request.getParameter("token");
			// System.err.println("accessToken>>>>>>>>.." + accessToken);
			if (StringUtil.isEmpty(accessToken)) {
				result.setCode(Global.BAD_REQUIRED_ERROR);
				result.setMsg("token is empty");
			}
			// 验证Access Token
			if (oAuthService.checkAccessToken(accessToken)) {
				// 检查token时效性
				if (oAuthService.checkOldAccessToken(accessToken)) {
					// 返回正确登录信息
					Map<String, Object> map = oAuthService.getByAccessToken(accessToken);
					// System.err.println("map>>>>>>>>.." + map.toString());
					// System.err.println("accessToken>>>>>>>>.." + accessToken);
					result.setData(map);
					result.setCode(Global.SUCCESS);
					body = JSON.toJSONString(result);
					System.err.println("body>>>>>>>>.." + body);
					return new ResponseEntity<Object>(body, HttpStatus.OK);
				} else {
					// 返回过期信息
					result.setCode(Global.UNAUTHORIZED_OLD);
					result.setMsg("token is old");
					body = JSON.toJSONString(result);
					return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
				}
			}
			// System.err.println("????>>>验证Access Token不通过>>>>>>>>..");
			// LoginLog loginLog1 = loginLogService.getByToken(accessToken);
			// System.err.println("数据库获得的loginLog1>>>>>>>>.." + loginLog1);
			// // token超时做一条日志记录
			// loginLogService.create(loginLog1);
			// 如果不存在/过期了，返回未验证错误，需重新验证
			result.setCode(Global.UNAUTHORIZED_ERROR);
			result.setMsg("token is invalid");
			body = JSON.toJSONString(result);
			return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
