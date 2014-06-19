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
	</div>

	<div class="respond" style='margin-left: 9cm; margin-right: 2cm'>
		<h3>项目信息</h3>
		<hr />
		<label style="font-size: 18px;">项目名称:&nbsp&nbsp&nbsp <s:property
				value='project.p_name' />
		</label>
		<hr />
		<label style="font-size: 18px;">项目主持人:&nbsp&nbsp&nbsp <s:property
				value='project.host_name' />
		</label>
		<hr />
		<label style="font-size: 18px;">总经费:&nbsp&nbsp&nbsp <s:property
				value='project.money' />
		</label>
		<hr />
		<label style="font-size: 18px;">开始时间:&nbsp&nbsp&nbsp <s:property
				value='project.start_time' />
		</label>
		<hr />
		<label style="font-size: 18px;">结束时间:&nbsp&nbsp&nbsp <s:property
				value='project.end_time' />
		</label>
		<hr />
		<label style="font-size: 18px;">差旅报销比例:&nbsp&nbsp&nbsp <s:property
				value='project.travel_ratio' />
		</label>
		<hr />
		<label style="font-size: 18px;">设备报销比例:&nbsp&nbsp&nbsp <s:property
				value='project.device_ratio' />
		</label>
		<hr />
		<label style="font-size: 18px;">其他报销比例:&nbsp&nbsp&nbsp <s:property
				value='project.others_ratio' />
		</label>
		<hr />

		<h3>个人项目参与信息:</h3>

		<label style="font-size: 18px;"> 名字：<%=request.getSession().getAttribute("name")%>&nbsp&nbsp&nbsp
			可用资金：<s:property value="involvedProject.money" />
		</label>
		<hr />
		<label style="font-size: 18px;">报销金额:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.expense' />
		</label>
		<hr />
		<label style="font-size: 18px;">开始时间:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.start_time' />
		</label>
		<hr />
		<label style="font-size: 18px;">结束时间:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.end_time' />
		</label>
		<hr />
		<label style="font-size: 18px;">差旅费比例:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.travel_ratio' />
		</label>
		<hr />
		<label style="font-size: 18px;">设备费用比例:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.device_ratio' />
		</label>
		<hr />
		<label style="font-size: 18px;">其他费用比例:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.others_ratio' />
		</label>
		<hr />
		<label style="font-size: 18px;">报销状态:&nbsp&nbsp&nbsp <s:property
				value='involvedProject.state' />
		</label>
		<hr />

		<h3>填写修改报销信息</h3>
		<form action='updateInvolvedProjectAction' method='post'>
			<label style="font-size: 18px;">报销金额: </label>
			<textarea name="expense"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.expense' /></textarea>
			<hr />
			<label style="font-size: 18px;">报销开始时间: </label>
			<textarea name="start_time"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.start_time' /></textarea>
			<hr />
			<label style="font-size: 18px;">报销结束时间: </label>
			<textarea name="end_time"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.end_time' /></textarea>
			<hr />
			<label style="font-size: 18px;">差旅费比例: </label>
			<textarea name="travel_ratio"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.travel_ratio' /></textarea>
			<hr />
			<label style="font-size: 18px;">设备费用比例: </label>
			<textarea name="device_ratio"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.device_ratio' /></textarea>
			<hr />
			<label style="font-size: 18px;">其他费用比例: </label>
			<textarea name="others_ratio"
				style="margin-right: 10cm; width: 20%; repeat: repeat-x;" cols="62"
				rows="1" value=""><s:property
					value='involvedProject.others_ratio' /></textarea>
			<hr />
			<span style='float: left'> <input class="graybtn"
				type="submit" value="报销" />
			</span> <input type="hidden" name="p_id"
				value="<%=request.getParameter("p_id")%>" />
		</form>
	</div>
</body>
</html>