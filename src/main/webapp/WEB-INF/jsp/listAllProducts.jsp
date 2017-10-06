<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="resources/js/listAllProducts.js"></script>
<link href="resources/css/standard.css" rel="stylesheet">
<title>所有商品</title>
</head>
<body>
	<div id="wrapper">
		<div class="container-fluid">
		
			<!-- navgation -->
			<div class="row">
				<nav class="navbar navbar-fixed-top navbar-inverse "> 
					<div class="navbar-header">
						<a class="navbar-brand">DMALL 地猫商城</a>
						<button class="navbar-toggle" data-toggle="collapse" data-target="#collapseMenu">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>

					<div class="collapse navbar-collapse" id="collapseMenu">
						<ul class="nav navbar-nav">
							<li>
								<a href="product">
									<span class="glyphicon glyphicon-apple">所有商品</span>
								</a>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
						
							<c:choose>
								<%--未登录时导航栏右侧显示的是登录提示 --%>
								<c:when test="${empty client }">
									<li>
										<a href="index.jsp">
											<span class="glyphicon glyphicon-user"> 登录</span>
										</a>
									</li>
								</c:when>
								<%-- 登录后显示的是用户菜单 --%>
								<c:otherwise>
									<li>
										<a href="cart">
											<span class="glyphicon glyphicon-shopping-cart">购物车</span>
										</a>
									</li>
									<li class="dropdown">
										<a class="dropdown-toggle" data-toggle="dropdown">
											${client.username }<strong class="caret"></strong>
										</a>
										<ul class="dropdown-menu">
											<li><a href="order"><span class="glyphicon glyphicon-th-list"></span>历史订单</a></li>
											<li class="divider"></li>
											<li><a href="offline"><span class="glyphicon glyphicon-off"></span>退出登录</a></li>
										</ul>
									</li>
								</c:otherwise>
							</c:choose>
							
						</ul>
					</div>					
				</nav>
			</div>
			
			<div id="page-wrapper">
			<div class="col-md-6 col-md-offset-3 col-xs-12">

				<!-- 头部图片和搜索框 -->
				<div id="topSearch">
					<img alt="pic" id="searchImg" src="resources/img/dmall2.png">

					<div id="search">
						<span class="input-group"> 
							<input type="text" id="searchText" class="form-control"> 
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" id="searchBtn">
									<strong>搜地猫</strong>
								</button>
							</span>
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button" id="resetBtn">
									<strong>重置</strong>
								</button>
							</span>
						</span>
					</div>
					
				</div>

				<!-- 商品展示列表 -->
				<table id="productTable">
					<caption><span>点击商品加入购物车</span></caption>
				</table>

				<!-- 加入购物车弹窗 -->
				<div id="buyModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">购买详情</h4>
							</div>
							<div class="modal-body">
								<ul>
									<li>商品名称：<span id="pname"></span></li>
									<li>商品单价：<span id="pprice"></span></li>
								</ul>
								<div>
									<span class="input-group"> 
										<input type="text" id="numText" class="form-control"> 
										<span class="input-group-btn">
											<button class="btn btn-primary" type="button" id="addBut">
												<strong>+</strong>
											</button>
										</span> 
										<span id="numPrompt"></span>
									</span>
								</div>
							</div>
							<div class="modal-footer">
								<ul>
									<li>商品总价：<span id="ptotal"></span></li>
								</ul>
								<button type="button" id="submit" class="btn btn-primary">
									加入购物车
								</button>
							</div>
						</div>
					</div>
				</div>

				<!-- 成功加入购物车提示弹窗 -->
				<div id="promptModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">提示</h4>
							</div>
							<div class="modal-body">
								<span class="lead"></span>
							</div>
							<div class="modal-footer">
								<a href="cart" type="button" class="btn btn-primary">前往购物车</a>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">关闭</button>
							</div>
						</div>
					</div>
				</div>

			</div>
			</div>	<!-- page-wrapper -->
		</div>	<!-- container -->
	</div>	<!-- wrapper -->

</body>
</html>