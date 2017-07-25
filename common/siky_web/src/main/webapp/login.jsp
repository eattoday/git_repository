<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,innitial-scale=1">  
		<title>BOS管理系统 登陆页面</title>
		<script src="./js/jquery-1.8.3.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript">
			if(window.self != window.top){
				window.top.location = window.location;
			}
			$(function(){
				//页面加载完成后，将光标定位到账号输入框中
				$("input[name=username]").focus();
				//为验证码输入框绑定键盘事件，提交表单
				$("input[name=checkcode]").keydown(function(e){
					if(e.keyCode == 13){//回车
						$("#loginform").submit();//提交表单
					}
				});
			});
		</script>
	</head>
	
	<body>
		<div class="loginbox">
		<div class="loginnav">
			<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><img src="images/logo.png"></a>
						<span class="logintitle">员工登录</span>
					</div>
				</div>
			</nav>
		</div>
		
		<section class="mainlogin">
			<div class="container">
				<div class="col-md-4 col-md-offset-7 logincontent">
				
					<h4>员工登录</h4>
					<form class="form-horizontal" id="loginform" name="loginform" 
					method="post" action="userAction_login.action">
						<div class="form-group" id="idInputLine">
							<label for="inputPassword3" class="col-sm-3 control-label">账号</label>
							<div class="col-sm-8">
								<input id="loginform:idInput" type="text" name="username" class="form-control" placeholder="请输入手机号/邮箱/用户名">
							</div>
						</div>
						<div class="form-group" id="pwdInputLine">
							<label id="loginform:pwdInput" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-8">
								<input for="pwdInput" type="password" name="password" class="form-control" id="inputaccount" placeholder="请输入您的密码">
							</div>
						</div>
					
					
						<div class="col-md-offset-3 col-md-8">
							<a href="javascript:document.getElementById('loginform').submit();" id="loginform:j_id19" name="loginform:j_id19"
								 class="btn btn-danger">立即登录</a>
						</div>
					</form>
				</div>
			</div>
		</section>
		
		</div>
	</body>
</html>