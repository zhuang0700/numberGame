<%@page import="java.io.PrintWriter"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.alibaba.fastjson.support.spring.FastJsonJsonView" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.parser.ParserConfig" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="com.telan.numbergame.domain.UserDO" %>
<%@ page import="com.telan.numbergame.mapper.UserDOMapper" %>
<%@ page import="com.telan.numbergame.manager.UserManager" %>
<%@ page import="com.telan.numbergame.game.param.OperateGameParam" %>
<%@ page import="com.telan.numbergame.game.enums.ActionType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
	long gameTypeId = 0, fromId= 3, toId=2;
	String actionType = "";
	PrintWriter write = response.getWriter();
	try {
		gameTypeId = Long.valueOf(request.getParameter("gameTypeId"));
	} catch (NumberFormatException e) {
	}
	try {
		actionType = request.getParameter("action");
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		fromId = Long.valueOf(request.getParameter("from"));
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	try {
		toId = Long.valueOf(request.getParameter("to"));
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}


	int code = 0;

	JSONArray jsonArray = new JSONArray();
	write.print(JSON.toJSONString(code));
	write.flush();
	write.close();

%>

