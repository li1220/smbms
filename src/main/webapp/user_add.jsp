<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>超市管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>超市管理系统 V 1.3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="statics/css/bootstrap.css">

<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

body {
	background: url(statics/img/bg.jpg);
}

header {
	width: 100%;
	color: white;
	overflow: hidden;
	padding: 30px 30px;
}

header div.time {
	text-align: center;
	border: 1px solid rgba(0, 0, 0, 0.2);
	line-height: 30px;
	width: 200px;
	border-radius: 50px;
	background-color: steelblue;
	margin-left: 10rem;
}

header span.right {
	float: right;
	display: inline-block;
}

header span.left {
	display: inline-block;
	font-size: 30px;
	font-weight: bold;
}

header span.left,header div.time {
	float: left;
}

footer {
	width: 100%;
	text-align: center;
	color: white;
	line-height: 50px;
}

article {
	width: 90%;
	color: white;
	min-height: 510px;
	overflow: hidden;
}

article aside {
	width: 20%;
	height: auto;
}

article aside ul {
	margin: 0px;
}

article section {
	width: 80%;
	height: auto;
	background-color: white;
}

article aside,article section {
	float: left;
}

article aside ul li {
	padding: 10px 60px;
	list-style: none;
}

article aside ul.parent {
	background-color: rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	margin: 10px;
}

article aside ul.parent>li:hover {
	background-color: rgba(0, 0, 0, 0.2);
	cursor: pointer;
}

article aside ul.child>li {
	padding: 10px 20px;
}

article aside ul.child>li>a {
	text-decoration: none;
	color: white;
}

div.title {
	margin-top: 15px;
}

div.title div.form-group {
	float: right;
}

div.managerList {
	padding: 0px 15px;
}

div.managerList table {
	color: rgba(0, 0, 0, 0.7);
}

header img {
	width: 42px;
	height: 42px;
	display: inline-block;
	position: relative;
	z-index: 1000;
}
#dd{
margin:0 50px 20px 30px;

}
</style>
</head>
<body>
	<header> <span class="left"><img
		src="statics/img/001.jpg" alt="" />&nbsp;超市管理系统</span>
	<div class="time">2011-11-11 11:11:11</div>
	<span class="right"><span style="color: #8CC657;">${name }</span>,欢迎你！&nbsp;<a
		href="loginout"><button class="btn btn-danger">退出</button></a></span> </header>
	<article> <aside>
	<ul class="parent">
		<ul class="child">
			<li><a href="dingdan">订单管理</a></li>
			<li><a href="gongyingshang">供应商管理</a></li>
			<li><a href="yhgl"><span style="color:#cccc00 ">用户管理</span></a></li>
			<li><a href="juese">角色管理</a></li>
			<li><a href="xiugaimima.jsp">密码修改</a></li>
			<li><a href="loginout">退出系统</a></li>
		</ul>
		<!--	</li>-->
	</ul>
	</aside> <section>
	<ol class="breadcrumb">
		<span style="color: #428bca;">当前位置：</span>&nbsp;
		<li><a href="yhgl">用户管理</a></li>
		<li><a href="user_add">添加用户</a></li>
	</ol>
	<div id="dd">
	<form action="user_insert" id="contact-form" class="form-horizontal" method="post">
		<fieldset style="color:black">
			<div class="control-group">
				<label class="control-label" for="name">用户编号</label>
				<div class="controls">
					<input type="text" class="form-control" name="userCode">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="name">用户名称</label>
				<div class="controls">
					<input type="text" class="form-control" name="userName">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="name">用户密码</label>
				<div class="controls">
					<input type="text" class="form-control" name="password">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="name">用户性别</label>
				<div class="controls">
					<select name="gender" class="form-control">
						<option value="1" selected="selected">男</option>
					    <option value="2">女</option>
	 				</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="name">出生日期</label>
				<div class="controls">
					<input type="date" class="form-control" name="riqi">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">用户电话</label>
				<div class="controls">
					<input type="text" class="form-control" name="phone" >
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="subject">用户地址</label>
				<div class="controls">
					<input type="text" class="form-control" name="address" >
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="subject">用户角色</label>
				<div class="controls">
					<select name="userRole" class="form-control">
						<option value="-1">--请选择--</option>
		 				<c:forEach items="${rlist }" var="list">
	    					<option value="${list.id }">${list.roleName }</option>
	    				</c:forEach> 
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">个人证件照</label>
				<div class="controls">
					<input type="file"  name="gerenimg" class="form-control">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="email">工作证照片</label>
				<div class="controls">
					<input type="file"  name="workimg" class="form-control">
				</div>
			</div>
			<div class="form-actions" style="margin:20px 0 0 0;">
				<button type="submit" class="btn btn-primary">提交</button>
				<a class="btn btn-success" href="yhgl">返回</a>
			</div>
		</fieldset>
		</form>
		</div>
	</section> </article>
	<footer> © 2017. All RIGHT RESERVED. ORACLE 版权所有 </footer>
	<script type="text/javascript" src="statics/js/jquery.js"></script>
	<script type="text/javascript" src="statics/js/bootstrap.js"></script>
	<script>
		$(function() {
			var articleHeight = $("article").height();
			$("article aside").height(articleHeight);
			$("article section").height(articleHeight);
			setInterval("getDateTime()", 1000);
		});
		function getDateTime() {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var h = date.getHours();
			var m = date.getMinutes();
			var s = date.getSeconds();
			if (month < 10)
				month = "0" + month;
			if (day < 10)
				day = "0" + day;
			if (h < 10)
				h = "0" + h;
			if (m < 10)
				m = "0" + m;
			if (s < 10)
				s = "0" + s;
			var str = year + "-" + month + "-" + day
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + h + ":" + m
					+ ":" + s;
			$("header div.time").html(str);
		}
	</script>
</body>
</html>

