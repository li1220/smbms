<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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

header span.left, header div.time {
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

article aside, article section {
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

#dd {
	margin: 0 50px 20px 30px;
}
</style>
</head>
<body>
	<header>
		<span class="left"><img src="statics/img/001.jpg" alt="" />&nbsp;超市管理系统</span>
		<div class="time">2011-11-11 11:11:11</div>
		<span class="right"><span style="color: #8CC657;">${name }</span>,欢迎你！&nbsp;<a
			href="loginout"><button class="btn btn-danger">退出</button></a></span>
	</header>
	<article>
		<aside>
			<ul class="parent">
				<ul class="child">
					<li><a href="dingdan">订单管理</a></li>
					<li><a href="gongyingshang">供应商管理</a></li>
					<li><a href="yhgl">用户管理</a></li>
					<li><a href="juese">角色管理</a></li>
					<li><a href="xiugaimima.jsp"><span style="color: #cccc00">密码修改</span></a></li>
					<li><a href="loginout">退出系统</a></li>
				</ul>
			</ul>
		</aside>
		<section>
			<ol class="breadcrumb">
				<span style="color: #428bca;">当前位置：</span>&nbsp;
				<li><a href="xiugaimima.jsp">密码修改</a></li>
			</ol>
			<div id="dd">
				<form action="xgxx" id="contact-form" class="form-horizontal"
					method="post">
					<fieldset style="color: black">
						<div class="control-group">
							<label class="control-label" for="name">旧密码&nbsp;&nbsp;<span
								id="sp10"></span></label>
							<div class="controls">
								<input type="password" class="form-control" name="yuanmima">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="name">新密码&nbsp;&nbsp;<span
								id="sp11"></span></label>
							<div class="controls">
								<input type="password" class="form-control" name="xinmima">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="name">确认新密码&nbsp;&nbsp;<span
								id="sp12"></span></label>
							<div class="controls">
								<input type="password" class="form-control" name="queren">
							</div>
						</div>
						<div class="form-actions" style="margin: 20px 0 0 0;">
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</fieldset>
				</form>
			</div>
		</section>
	</article>
	<footer> © 2019. All RIGHT RESERVED </footer>
	<script type="text/javascript" src="statics/js/jquery.js"></script>
	<script type="text/javascript" src="statics/js/bootstrap.js"></script>
	<script>
		$(function() {

			$("input[name=yuanmima]").blur(function() {
				var text = $(this).val();
				if (text == "" || text == null) {
					$("#sp10").html("请输入旧密码");
				} else {
					var text = $(this).val();
					$.ajax({
						"url" : "panduan",
						"type" : "post",
						"data" : "pass=" + text,
						"dataType" : "text",
						"success" : callBack,
						"error" : function(data) {
							alert("请求失败");
						}
					});
					function callBack(data) {
						if (data == "true") {
							$("#sp10").html("");
						} else {
							$("#sp10").html("密码输入错误");
						}
					}
				}
			});

			$("input[name=yuanmima]").focus(function() {
				$("#sp10").html("请输入原密码");
			});
			$("input[name=xinmima]").blur(function() {
				var text = $(this).val();
				if (text == "" || text == null) {
					$("#sp11").html("密码输入不规范，请重新输入");
				} else {
					var text = $(this).val();
					var reguser = /^[a-z0-9]{6,20}$/;
					if (reguser.test(text) == true) {
						$("#sp11").html("");
					} else {
						$("#sp11").html("密码输入不规范，请重新输入");
					}
				}
			});

			$("input[name=xinmima]").focus(function() {
				$("#sp11").html("密码长度必须大于6小于20");
			});

			$("input[name=queren]").blur(function() {
				var text = $(this).val();
				var mima = $("input[name=xinmima]").val();
				if (text == "" || text == null) {
					$("#sp12").html("两次密码输入不一致，请重新输入");
				} else {
					if (text == mima) {
						$("#sp12").html("");
					} else {
						$("#sp12").html("两次密码输入不一致，请重新输入");
					}
				}
			});
			$("input[name=queren]").focus(function() {
				$("#sp12").html("请输入与上面一致的密码");
			});

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

