<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link id="favicon" href="http://www.easyicon.net/api/resizeApi.php?id=1188709&size=128" rel="icon" type="image/x-icon"/>
<base href="${pageContext.request.contextPath }/">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/adminLogin.js"></script>
<link href="resources/css/standard.css" rel="stylesheet">
<title>管理员登录</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			
			<!-- 左侧图片 -->
			<div class="col-md-4 col-md-offset-2 col-xs-12">
				<div class="page-header">
					<h1 id="h1">
						地猫商城 <small>dmall 后台管理系统</small>
					</h1>
				</div>
				<div>
					<img alt="pic" src="resources/img/dmall.png" id="dmallImg">
				</div>
			</div>
			
			<!-- 右侧登录入口 -->
			<div class="col-md-3 col-xs-12" id="formDiv">	
				<blockquote>
					<p>欢迎您，管理员！</p>
				</blockquote>
				<form>
					<div class="form-group">
						<label for="username">帐号</label> 
						<input type="text" class="form-control" id="username" />
					</div>
					<div class="form-group">
						<label for="password">密码</label> 
						<input type="password" class="form-control" id="password" />
					</div>
					<div class="pull-right">
						<button type="reset" class="btn btn-default">
							<strong>重置</strong>
						</button>
						<button type="button" id="loginBtn" class="btn btn-default">
							<strong>登录</strong>
						</button>
					</div>
				</form>
				
				<!-- 登录失败弹出提示 -->
				<div class="alert alert-warning wrongAlert"></div>
			</div>
			
		</div>	<!-- row -->
	
	</div>	<!-- container -->
</body>
</html>