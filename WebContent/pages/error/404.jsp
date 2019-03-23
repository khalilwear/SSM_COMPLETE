<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>404</p>
	<img alt="" src="<%=basePath %>/resource/images/error.jpg">
</body>
</html>