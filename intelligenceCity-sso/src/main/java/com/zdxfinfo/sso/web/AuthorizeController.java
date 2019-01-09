package com.zdxfinfo.sso.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zdxfinfo.base.common.config.Global;
import com.zdxfinfo.base.common.utils.SwaggerResultUtil;
import com.zdxfinfo.sso.service.OAuthService;
import com.zdxfinfo.sso.shrio.UserToken;

@Controller
@RequestMapping("")
public class AuthorizeController {
	@Autowired
	private OAuthService oAuthService;
	// @Autowired
	// private ClientService clientService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/authorize")
	public Object authorize(Model model, HttpServletRequest request) throws URISyntaxException, OAuthSystemException {

		try {
			// 构建OAuth 授权请求
			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);

			// 检查传入的客户端id是否正确
			// if (!oAuthService.checkClientId(oauthRequest.getClientId())) {
			// OAuthResponse response =
			// OAuthASResponse.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
			// .setError(OAuthError.TokenResponse.INVALID_CLIENT)
			// .setErrorDescription(Constants.INVALID_CLIENT_DESCRIPTION).buildJSONMessage();
			// return new ResponseEntity(response.getBody(),
			// HttpStatus.valueOf(response.getResponseStatus()));
			// }

			Subject subject = SecurityUtils.getSubject();
			// 如果用户没有登录，跳转到登陆页面
			if (!subject.isAuthenticated()) {
				SwaggerResultUtil<Boolean> resultMap = login(subject, request);
				if (!resultMap.getData()) {// 登录失败时跳转到登陆页面
					// model.addAttribute("client",
					// clientService.findByClientId(oauthRequest.getClientId()));
					return "login";
				}
			}

			UserToken token = (UserToken) subject.getPrincipal();
			// 生成授权码
			String authorizationCode = null;
			// responseType目前仅支持CODE，另外还有TOKEN
			String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
			if (responseType.equals(ResponseType.CODE.toString())) {
				OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
				authorizationCode = oauthIssuerImpl.authorizationCode();
				Map<String, Object> bean = new HashMap<String, Object>();
				bean.put("userId", token.getId());
				bean.put("userName", token.getUsername());
				oAuthService.addAuthCode(authorizationCode, bean);
			}

			// 进行OAuth响应构建
			OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse.authorizationResponse(request,
					HttpServletResponse.SC_FOUND);
			// 设置授权码
			builder.setCode(authorizationCode);
			// 得到到客户端重定向地址
			String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

			// 构建响应
			final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();

			// 根据OAuthResponse返回ResponseEntity响应
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(new URI(response.getLocationUri()));
			return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
		} catch (OAuthProblemException e) {

			// 出错处理
			String redirectUri = e.getRedirectUri();
			if (OAuthUtils.isEmpty(redirectUri)) {
				// 告诉客户端没有传入redirectUri直接报错
				return new ResponseEntity("OAuth callback url needs to be provided by client!!!", HttpStatus.NOT_FOUND);
			}

			// 返回错误消息（如?error=）
			final OAuthResponse response = OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND).error(e)
					.location(redirectUri).buildQueryMessage();
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(new URI(response.getLocationUri()));
			return new ResponseEntity(headers, HttpStatus.valueOf(response.getResponseStatus()));
		}
	}

	@RequestMapping("/authorizeAPI")
	public HttpEntity<Object> authorizeAPI(HttpServletRequest request) throws URISyntaxException, OAuthSystemException {
		SwaggerResultUtil<String> result = new SwaggerResultUtil<String>();
		try {
			// 构建OAuth 授权请求
			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
			// 检查传入的客户端id是否正确
			// if (!oAuthService.checkClientId(oauthRequest.getClientId())) {
			// OAuthResponse response = OAuthASResponse
			// .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
			// .setError(OAuthError.TokenResponse.INVALID_CLIENT)
			// .setErrorDescription(Constants.INVALID_CLIENT_DESCRIPTION)
			// .buildJSONMessage();
			// return new ResponseEntity(
			// response.getBody(),
			// HttpStatus.valueOf(response.getResponseStatus()));
			// }
			Subject subject = SecurityUtils.getSubject();
			// 如果用户没有登录，跳转到登陆页面
			if (!subject.isAuthenticated()) {
				SwaggerResultUtil<Boolean> loginResult = login(subject, request);
				if (!loginResult.getData()) {
					result.setCode(loginResult.getCode());
					result.setMsg(loginResult.getMsg());
					String body = JSON.toJSONString(result);
					return new ResponseEntity<Object>(body, HttpStatus.valueOf(Global.SUCCESS));
				}
			}
			UserToken token = (UserToken) subject.getPrincipal();
			// 生成授权码
			String authorizationCode = null;
			// responseType目前仅支持CODE，另外还有TOKEN
			String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
			if (responseType.equals(ResponseType.CODE.toString())) {
				OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
				authorizationCode = oauthIssuerImpl.authorizationCode();
				Map<String, Object> bean = new HashMap<String, Object>();
				bean.put("userId", token.getId());
				bean.put("userName", token.getUsername());
				oAuthService.addAuthCode(authorizationCode, bean);
			}
			result.setCode(Global.SUCCESS);
			result.setData(authorizationCode);
			String body = JSON.toJSONString(result);
			return new ResponseEntity<Object>(body, HttpStatus.valueOf(Global.SUCCESS));
		} catch (OAuthProblemException e) {
			// 出错处理
			result.setCode(Global.INTERNAL_SERVER_ERROR);
			result.setMsg(e.getMessage());
			String body = JSON.toJSONString(result);
			return new ResponseEntity<Object>(body, HttpStatus.valueOf(Global.SUCCESS));
		}
	}

	private SwaggerResultUtil<Boolean> login(Subject subject, HttpServletRequest request) {
		SwaggerResultUtil<Boolean> result = new SwaggerResultUtil<Boolean>();
		if ("get".equalsIgnoreCase(request.getMethod())) {
			result.setCode(Global.PARAM_ERROR);
			result.setData(false);
			result.setMsg("only post");
			return result;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			result.setData(false);
			result.setCode(Global.PARAM_ERROR);
			result.setMsg("username or password is empty");
			return result;
		}
		UserToken token = new UserToken(username, password);
		try {
			subject.login(token);
			result.setData(true);
			return result;
		} catch (UnknownAccountException e) {
			result.setData(false);
			result.setCode(Global.FORBIDDEN_ERROR);
			result.setMsg("username not exist");
			return result;
		} catch (IncorrectCredentialsException e) {
			result.setData(false);
			result.setCode(Global.PASSWORD_ERROR);
			result.setMsg("password error");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Global.INTERNAL_SERVER_ERROR);
			result.setData(false);
			result.setMsg(e.getMessage());
			return result;
		}
	}
}
