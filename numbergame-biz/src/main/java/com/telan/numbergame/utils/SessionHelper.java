package com.telan.numbergame.utils;

import com.telan.numbergame.constant.ApiConstant;
import com.telan.numbergame.domain.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionHelper {
	private static final Logger logger = LoggerFactory.getLogger("SessionHelper");

	
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null == attrs) {
			logger.error("error operation, is not in RequestContext");
			return null;
		}
		return attrs.getRequest();
	}

	public static HttpServletResponse getResponse() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (null == attrs) {
			logger.error("error operation, is not in RequestContext");
			return null;
		}
		HttpServletResponse response = attrs.getResponse();
		return response;

	}

	public static String getSessionKey(HttpServletRequest request) {
		return request.getHeader(ApiConstant.WEREWOLF_SESSION_KEY);
	}


	public static String getSessionKey() {
		HttpServletRequest request = getRequest();
		return request.getHeader(ApiConstant.WEREWOLF_SESSION_KEY);
	}

	public static UserDO getUser() {
		HttpSession session = getRequest().getSession();
		return (UserDO)session.getAttribute("user");
	}
}
