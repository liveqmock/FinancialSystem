<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="login" action="login" method=post>
		<input type="text" name="name" class="login-field" value=""
			placeholder="Enter your name" id="login-name">
		<p>
		<p>
			<input type="password" name="password" class="login-field" value=""
				placeholder="Password" id="login-pass">
		<p>
		<p>
			<input class="btn btn-primary btn-lg btn-block" name="log"
				type=submit value="Login">
	</form>

	<%-- <s:form action="login">
	<center><h2>银行余额查询系统</h2></center>
	<center><s:textfield name="name" label="用户名："/></center>
	</br>
	<center><s:password name="password" label="密码"/></center>
	</br>
	<center><s:submit value="登录"/></center>
</s:form> --%>

</body>
</html>