<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	

<!-- //<meta charset="utf-8"> -->
<title>超市管理系统 V 1.3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="statics/css/bootstrap.css">
<link rel="stylesheet" href="statics/css/signin.css">


	
  </head>
  
  <body>
  	<div id="status">&nbsp;</div>

	<div class="container">

		<div class="" id="login-wrapper">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div id="logo-login">
						<h1>
							超市管理系统 <span>v1.3</span>
						</h1>
					</div>
				</div>

			</div>

			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="account-box">
						<form action="login" method="post">
							<div class="form-group">

								<label for="inputUsername">用户名</label> <input type="text"
									class="form-control" name="username" id="inputUsername">
								
							</div>
							<div class="form-group">

								<label for="inputPassword">密码</label> <input type="password"
									class="form-control" name="password" id="inputPassword">
								
							</div>

							<button class="btn btn btn-primary pull-right" type="submit">
								登 录</button>
						</form>
						<a class="forgotLnk" href="index.html"></a>

						<div class="row-block">
							<div class="row"></div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<p>&nbsp;</p>
		<div style="text-align:center;margin:0 auto;">
			<h6 style="color:#fff;">Copyright(C)2018 All Rights Reserved</h6>
		</div>

	</div>
	<div id="test1" class="gmap3"></div>

  </body>
</html>
