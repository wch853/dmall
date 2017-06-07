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
<link href="https://cdn.bootcss.com/bootstrap-select/1.12.2/css/bootstrap-select.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="resources/js/deliverOrders.js"></script>
<link href="resources/css/standard.css" rel="stylesheet">
<title>采购管理</title>
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
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown">
									${admin.username }<strong class="caret"></strong>
								</a>
								<ul class="dropdown-menu">
									<li><a href="admin/order"><span class="glyphicon glyphicon-th-list"></span>订单处理</a></li>
									<li><a href="admin/purchase"><span class="glyphicon glyphicon-th-list"></span>采购管理</a></li>
									<li><a href="admin/receive"><span class="glyphicon glyphicon-th-list"></span>收货管理</a></li>
									<li class="divider"></li>
									<li><a href="admin/offline"><span class="glyphicon glyphicon-off"></span>退出登录</a></li>
								</ul>
							</li>
						</ul>
					</div>					
				</nav>
			</div>
			
			<div id="page-wrapper">
			
				<div class="col-md-6 col-md-offset-3 col-xs-12">
					
					<div>
						<img alt="pic" id="titleImg" src="resources/img/dmall2.png">
						
						<div class="pull-right">
							<h4>下达采购订单</h4>
						</div>
						
						<table class="table table-striped table-bordered">
							<thead>
								<tr><th colspan="5" class="text-center">产品采购订单</th></tr>
							</thead>
							
							<tbody>
								<tr id="provTd">
									<td>选择供货单位</td>
									<td colspan="4">
										<select class="selectpicker text-center">
											<c:forEach items="${providers }" var="provider">
												<option>${provider.providerName }</option>
											</c:forEach>
										</select>
									</td>
								</tr>
							</tbody>
							
							<thead>
								<tr>
									<th>产品编号</th>
									<th>产品名称</th>
									<th>产品库存</th>
									<th>采购数量</th>
									<th><button class="btn btn-xs btn-primary pull-right">批量采购</button></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products }" var="product">
									<tr id="prodTd">
										<td>${product.productId }</td>
										<td>${product.productName }</td>
										<td>${product.storage }</td>
										<td colspan="2">
											<input id="input${product.productId }" type="text" value="0" class="form-control">
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<button class="btn btn-primary pull-right">确认发货</button>
 					</div>
 				</div>
 			</div>	<!-- page-wrapper -->
 		</div>	<!-- container -->
 	</div>	<!-- wrapper -->
</body>
</html>