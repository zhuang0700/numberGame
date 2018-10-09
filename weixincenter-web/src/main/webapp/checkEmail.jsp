<%@page import="java.io.PrintWriter"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="com.telan.weixincenter.utils.EmailUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

	WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

	PrintWriter write = response.getWriter();
	EmailUtils.receive();

%>

