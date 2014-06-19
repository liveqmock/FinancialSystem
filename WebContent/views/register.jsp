<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="../css/login.css">
</head>

<body>
	<div class="container">
		<div class="login">
			<div class="login-screen">
				<div class="login-form">
					<form name="register" action="register" method=post>
						<input type="text" name="name" class="login-field" value=""
							placeholder="Enter your name" id="login-name">
						<p>
						<p>
							<input type="password" name="password" class="login-field"
								value="" placeholder="Please enter the password" id="login-pass">
						<p>
						<p>
							<input type="password" name="passwordAgain" class="login-field"
								value="" placeholder="Please enter the password again~"
								id="login-pass">
						<p>
						<p>
							<input type="text" name="bank_card" class="login-field" value=""
								placeholder="Enter your bank card">
						<p>
						<p>
							<input type="text" name="bank_cardAgain" class="login-field"
								value="" placeholder="Enter your bank card again~"> <input
								class="btn btn-primary btn-lg btn-block" name="log" type=submit
								value="Register">
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

</html>