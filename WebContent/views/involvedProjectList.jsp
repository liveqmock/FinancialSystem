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
									<li class="active"><a
										href="<%=request.getContextPath()%>/views/index.jsp">首页</a></li>
									<!-- <li class="divider-vertical"></li> -->
								</ul>
								<ul class="nav pull-middle">

									<li class="divider-vertical"><a
										href='<s:url action='displayHostProjectList'></s:url>'>主持项目</a></li>
									<li class="divider-vertical"><a
										href='<s:url action='displayInvolvedProjectList'></s:url>'>参与项目</a></li>
								</ul>
								<ul class="nav pull-right">
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#"> <%=request.getSession().getAttribute("name")%>
											<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a
												href='<s:url action='getPersonalInfoAction'></s:url>'>个人信息</a></li>
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

		<div class="row-fluid">
			<div class="span8">
				<a style="font-size: 22pt; color: grey"> 参与项目列表 </a>
				<hr>

				<s:iterator value="involvedProjects" id="project">
					<h2>
						<s:property value="#project.p_name" />
						<span class='date' style='font-size: 15px'>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							From &nbsp&nbsp&nbsp<s:property value="#project.start_time" />&nbsp&nbsp&nbsp
							to &nbsp&nbsp&nbsp<s:property value="#project.end_time" />
						</span>
					</h2>
					<p>
						money:&nbsp&nbsp
						<s:property value="#project.money" />
					</p>
					<p>
						<a class='btn'
							href='<s:url action='displayInvolvedProjectAction'><s:param name='p_id' value='#project.p_id'/></s:url>'>View
							deatils »</a>
					</p>
					<hr>
				</s:iterator>
			</div>
		</div>

	</div>
</body>
</html>