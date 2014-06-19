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




<link rel="shortcut icon" href="/favicon.ico" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	jQuery.noConflict();
</script>


<!-- Highslide code -->
<script type="text/javascript" src="/highslide/highslide-full.min.js"></script>
<script type="text/javascript" src="/highslide/highslide.config.js"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="/highslide/highslide.css" />
<!--[if lt IE 7]>
<link rel="stylesheet" type="text/css" href="/highslide/highslide-ie6.css" />
<![endif]-->
<!-- End Highslide code -->

<script type="text/javascript">
	var example = 'line-basic', theme = 'default';
</script>

<script type="text/javascript" src="/demo/scripts.js"></script>


<link rel="stylesheet" href="/templates/yoo_symphony/css/template.css"
	type="text/css" />
<link rel="stylesheet"
	href="/templates/yoo_symphony/css/variations/brown.css" type="text/css" />
<link href="/demo/demo.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	(function($) { // encapsulate jQuery

		$(function() {
			$('#container')
					.highcharts(
							{
								chart : {
									type : 'column'
								},
								title : {
									text : '项目统计'
								},
								xAxis : {
									categories : ['项目数量', '项目主持人数', '项目参与人数'],
								},
								yAxis : {
									min : 0,
									title : {
										text : '人数(个)',
										align : 'high'
									},
								},
								tooltip : {
									valueSuffix : '个'
								},
								legend : {
									headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
									pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
											+ '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
									footerFormat : '</table>',
									shared : true,
									useHTML : true
								},
								credits : {
									enabled : true
								},

								plotOptions : {
									column : {
										pointPadding : 0.2,
										borderWidth : 0
									}
								},
								series : [ {
									name : 'FinancialSystem',
									data : [ 10,9,8]
								} ]
							});
		});

	})(jQuery);
</script>
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
										href='http://localhost:8080/FinancialSystem/views/financialManagerIndex.jsp'>首页</a></li>
									<li class="divider-vertical"><a
										href='http://localhost:8080/FinancialSystem/views/financialManagerDisplay.jsp'>统计查询</a></li>
								</ul>
								<ul class="nav pull-middle">
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

		<div id="demo-header">
			<center>
				<h1>统计图</h1>
			</center>


		</div>
		<div id="demo-content">


			<div style="margin: 0 1em">
				<script src="http://code.highcharts.com/highcharts.js"></script>
				<script src="http://code.highcharts.com/modules/exporting.js"></script>

				<div id="container"
					style="min-width: 400px; height: 400px; margin: 0 auto"></div>
				<center>上图展示了部分项目统计情况</center>
			</div>
		</div>

	</div>
</body>
</html>