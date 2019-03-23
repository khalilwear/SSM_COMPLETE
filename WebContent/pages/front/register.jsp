<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册QQ</title>
	<!-- 加入jquery -->
	<script type="text/javascript" src="<%=basePath %>/resource/js/jquery.min.js"></script>
</head>
<body>
	<center>
		<form action="#" method="post" onsubmit="return false" id="login">
			<table>
				<tr>
					<td>昵称</td>
					<!-- 三元运算，如果报错信息为null，则显示原信息，否则置空 -->
					<td><input type="text" name="nick" value="${errorMessage.nick==null?registerInfo.nick:''}" placeholder="请输入4-10位汉字"><span style="color:red;">${errorMessage.nick}</span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" placeholder="请输入3-6位数字、字母、下划线组合">${errorMessage.password}</td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" placeholder="请输入正确的手机格式"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="text" name="email" placeholder="请输入正确的邮箱格式"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="text" name="age" placeholder="请输入数字"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="注册"><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
		<%-- 将提交的数据表单生成json --%>
		$.fn.serializeObject = function()    
		{    
		   var o = {};    
		   var a = this.serializeArray();    
		   $.each(a, function() {    
		       if (o[this.name]) {    
		           if (!o[this.name].push) {    
		               o[this.name] = [o[this.name]];    
		           }    
		           o[this.name].push(this.value || '');    
		       } else {    
		           o[this.name] = this.value || '';    
		       }    
		   });    
		   //return o;
		   return JSON.stringify(o);
		};
		
			$("input[type=submit]").click(function(){
				<%--
				var json=$("#login").serializeObject();
				alert(json);
				--%>
				$.ajax({
					url:'<%=basePath %>/front/getJson.shtml',
					type:'post',
					dataType:'json',
					contentType:'application/json',
					data:$("#login").serializeObject(),
					success:function(flag){
						alert(flag);
					}
				});
			});
		</script>
	</center>
</body>
</html>