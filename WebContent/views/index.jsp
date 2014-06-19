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
									<li class="active"><a href="#">首页</a></li>
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
				<div class="carousel slide" id="carousel-195940">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-195940"></li>
						<li data-slide-to="1" data-target="#carousel-195940"></li>
						<li data-slide-to="2" data-target="#carousel-195940"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="../img/top/1.jpg">
							<div class="carousel-caption">
								<h4>第一张图</h4>
								<p>~~</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="../img/top/2.jpg">
							<div class="carousel-caption">
								<h4>第二张图</h4>
								<p>！！！</p>
							</div>
						</div>
						<div class="item">
							<img alt="" src="../img/top/3.jpg">
							<div class="carousel-caption">
								<h4>第三张图</h4>
								<p>%%%%</p>
							</div>
						</div>
					</div>
					<a data-slide="prev" href="#carousel-195940"
						class="left carousel-control">‹</a> <a data-slide="next"
						href="#carousel-195940" class="right carousel-control">›</a>
				</div>
			</div>

			<div class="row-fluid">
				<div class="span8">
					<a style="font-size: 22pt; color: grey">  最新新闻 </a>
					<hr>
					<h2>今日第一要闻</h2>
					<hr>
					<h2>今日第二要闻</h2>
					<hr>
					<h2>今日第三要闻</h2>
					<hr>
					<h2>今日第四要闻</h2>
					<hr>
					<h2>今日第五要闻</h2>
					<hr>
					<h2>今日第六要闻</h2>
				</div>
			</div>
		</div>
</body>
</html>
