<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8"">
<title>文件上传</title>
</head>
<body>
	<form action="<%=basePath %>/upload/multipleFileUpload.shtml" method="post" enctype="multipart/form-data">
		<p>photo1:<input type="file" name="bigHeadImage1"></p>
		<p>photo2:<input type="file" name="bigHeadImage2"></p>
		<p>photo3:<input type="file" name="bigHeadImage3"></p>
		<p>name:<input type="text" name="username"></p>
		<p><input type="submit" name="上传"></p>
	</form>
</body>
</html>