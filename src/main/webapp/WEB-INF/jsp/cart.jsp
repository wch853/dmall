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
<link href="resources/css/standard.css" rel="stylesheet">
<title>购物车</title>
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
							<li>
								<a>
									<span class="glyphicon glyphicon-shopping-cart">购物车</span>
								</a>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown">
									${client.username }<strong class="caret"></strong>
								</a>
								<ul class="dropdown-menu">
									<li><a><span class="glyphicon glyphicon-info-sign"></span>我的订单</a></li>
									<li class="divider"></li>
									<li><a><span class="glyphicon glyphicon-off"></span>退出登录</a></li>
								</ul>
							</li>
						</ul>
					</div>					
				</nav>
			</div>
			
			<div id="page-wrapper">
				<div class="col-md-6 col-md-offset-3 col-xs-12">
					
					<div>
						<img alt="pic" id="searchImg" src="resources/img/dmall2.png">
						
						<div class="pull-right">
							<h3>我的购物车</h3>
						</div>
 					</div>
					
					<table class="table table-striped">
						<thead>
							<tr>
								<th>订单编号</th>
								<th>商品名称</th>
								<th>商品单价</th>
								<th>商品数量</th>
								<th>金额小计</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${orderItems }" var="orderItem" varStatus="st">
								<tr>
									<td>${orderItem.orderItemId }</td>
									<td>${orderItem.product.productName }</td>
									<td>${orderItem.product.doublePrice }</td>
									<td>${orderItem.productQuantity }</td>
									<td>${orderItem.doublePrice }
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div class="pull-right">
						<span id="totalPrice">总金额：${sumOfOrderItem }</span>
						<button class="btn btn-primary">确认付款</button>
					</div>
				</div>
			</div>
			
		</div>	<!-- container -->
	</div>	
</body>
</html>