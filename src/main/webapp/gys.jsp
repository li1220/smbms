<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
		<!--<li><span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;功能列表-->
		<ul class="child">
			<li><a href="dingdan">订单管理</a></li>
			<li><a href="gongyingshang"><span style="color:#cccc00 ">供应商管理</span></a></li>
			<li><a href="yhgl">用户管理</a></li>
			<li><a href="juese">角色管理</a></li>
			<li><a href="xiugaimima.jsp">密码修改</a></li>
			<li><a href="loginout">退出系统</a></li>
		</ul>
		<!--	</li>-->
	</ul>
	</aside> <section>
	<ol class="breadcrumb">
		<span style="color: #428bca;">当前位置：</span>&nbsp;
		<li><a href="gongyingshang">供应商管理</a></li>
	</ol>
	<div class="managerList">
		<div class="title">
			<a class="btn btn-success" type="button" href="gys_add.jsp">添加</a>
			<div class="form-group form-inline" style="color:black">
				<form action="gongyingshang" method="post">
					<input type="text" class="form-control" placeholder="请输入供应商名称" name="name">
					<input type="text" class="form-control" placeholder="请输入供应商编码" name="code">
					<button class="btn btn-primary">搜索</button>
				</form>
			</div>
		</div>
		<table
			class="table table-responsive table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>  
	 				<td>供应商编码</td>
	 				<td>供应商名称</td>
	 				<td>联系人</td>
	 				<td>联系电话</td>
	 				<td>传真</td>
	 				<td>创建时间</td>
	 				<td>操作</td>
	 			</tr>
			</thead>
			<tbody>
				<c:forEach items="${page }" var="p">
					<tr>
						<td>${p.proCode }</td>
		 				<td>${p.proName }</td>
		 				<td>${p.proContact }</td>
		 				<td>${p.proPhone }</td>
		 				<td>${p.proFax }</td>
		 				<td>${p.creationTime }</td>
						<td>
							<a class="btn btn-primary btn-sm" href="gys_view/${p.proCode }">查看</a> 
							<a class="btn btn-danger btn-sm" href="gys_show/${p.proCode }">修改</a>
							<a class="btn btn-info btn-sm" href="gys_delect/${p.proCode }">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<ul class="pager">
							<li><span>共${count }条记录</span></li>
							<li><a href="gongyingshang?pageNum=1">首页</a></li>
							<li><a
								href="gongyingshang?pageNum=${page2.pageNum<=1?1:page2.pageNum-1 }">&laquo;上一页</a></li>
							<li><a
								href="gongyingshang?pageNum=${page2.pageNum==page2.zongYe?page2.zongYe:page2.pageNum+1 }">下一页&raquo;</a></li>
							<li><a href="gongyingshang?pageNum=${page2.zongYe }">末页</a></li>
							<li><span>${page2.pageNum }/${page2.zongYe }</span></li>
						</ul>
					</td>
				</tr>
			</tfoot>
		</table>
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

