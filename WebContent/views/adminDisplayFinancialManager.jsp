<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <meta charset="utf-8"> -->
<title>FinancialSystem</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/index.css">

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/favicon.png">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/scripts.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a href="#" class="brand">财务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li class="divider-vertical"><a
										href='<s:url action='adminDisplayProjectsAction'></s:url>'>项目管理</a></li>
									<li class="divider-vertical"><a
										href='<s:url action='adminGetAllCommonUserAction'></s:url>'>查看普通用户</a></li>
									<li class="divider-vertical"><a
										href='<s:url action='adminGetAllFinancialStaffAction'></s:url>'>查看审核主管</a></li>
									<li class="divider-vertical"><a
										href='<s:url action='adminGetAllFinancialManagerAction'></s:url>'>查看财务主管</a></li>
								</ul>
								<ul class="nav pull-middle">
									<li class="divider-vertical"><a
										href="<%=request.getContextPath()%>/views/adminAddProject.jsp">新增项目</a></li>
									<li class="divider-vertical"><a
										href="<%=request.getContextPath()%>/views/adminAddCommonUser.jsp">添加普通用户</a></li>
									<li class="divider-vertical"><a
										href="<%=request.getContextPath()%>/views/adminAddFinancialStaff.jsp">添加审核主管</a></li>
									<li class="divider-vertical"><a
										href="<%=request.getContextPath()%>/views/adminAddFinancialManager.jsp">添加财务主管</a></li>
								</ul>
								<ul class="nav pull-right">
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#"> <%=request.getSession().getAttribute("name")%>
											<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href='<s:url action=''></s:url>'>个人信息</a></li>
											<li class="divider"></li>
											<li><a href="error.jsp">登出</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="respond" style='margin-left: 9cm; margin-right: 2cm'>
		<form action='adminUpdateFinancialManagerAction' method='post'>
			<br /> <label name="identifier" style="font-size: 18px;">七位识别码:&nbsp&nbsp&nbsp
				<%=request.getParameter("identifier")%>
			</label>
			<hr />
			<input type=hidden name='identifier'
				value='<%=request.getParameter("identifier")%>' /> <label
				style="font-size: 18px;">名字: </label>
			<textarea name="new_name"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1"><%=request.getParameter("name")%></textarea>
			<hr />

			<label style="font-size: 18px;">旧密码: </label> <input type='password'
				name="oldPassword"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1"></input>
			<hr />

			<label style="font-size: 18px;">新密码: </label> <input type='password'
				name="new_password"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1"></input>
			<hr />

			<label style="font-size: 18px;">再输一遍新密码: </label> <input
				type='password' name="newPasswordAgain"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1"></input>
			<hr />

			<span style='float: left'> <input class="graybtn"
				type="submit" value="修改" />
			</span> <input type="hidden" name="p_id"
				value="<%=request.getParameter("p_id")%>" />
		</form>
	</div>
</body>
</html>