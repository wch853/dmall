<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="resources/js/receive.js"></script>
<link href="resources/css/standard.css" rel="stylesheet">
<title>入库处理</title>
</head>
<body>
	<div id="wrapper">
		<div class="container-fluid">
			<!-- navgation -->
			<div class="row">
				<nav class="navbar navbar-fixed-top navbar-inverse ">
				<div class="navbar-header">
					<a class="navbar-brand">DMALL 地猫商城</a>
					<button class="navbar-toggle" data-toggle="collapse"
						data-target="#collapseMenu">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse" id="collapseMenu">
					<ul class="nav navbar-nav">
						<li><a href="product"> <span
								class="glyphicon glyphicon-apple">所有商品</span>
						</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown"> ${admin.username }<strong
								class="caret"></strong>
						</a>
							<ul class="dropdown-menu">
									<li><a href="admin/order"><span class="glyphicon glyphicon-th-list"></span>订单处理</a></li>
									<li><a href="admin/purchase"><span class="glyphicon glyphicon-pushpin"></span>采购管理</a></li>
									<li><a href="admin/receive"><span class="glyphicon glyphicon-import"></span>入库管理</a></li>
								<li class="divider"></li>
								<li><a href="admin/offline"><span
										class="glyphicon glyphicon-off"></span>退出登录</a></li>
							</ul></li>
					</ul>
				</div>
				</nav>
			</div>

			<div id="page-wrapper">

				<div class="col-md-6 col-md-offset-3 col-xs-12">
					<div>
						<img alt="pic" id="titleImg" src="resources/img/dmall2.png">

						<div class="pull-right">
							<h4>采购商品入库</h4>
						</div>
					</div>

					<c:choose>
						<c:when test="${empty purchases }">
							<div id="nullTip" class="alert alert-warning">
								<span>待入库项为空，当前没有待入库的采购订单！</span>
							</div>
						</c:when>
						<c:otherwise>
							<c:forEach items="${purchases }" var="purchase">
								<div>
									<table class="table table-striped table-bordered table-hover">
										<caption>
											订单编号：<span>${purchase.purchaseId }</span> 下单时间：<span><fmt:formatDate
													value="${purchase.createDate }"
													pattern="yyyy-MM-dd HH:mm:ss" /></span> 供应商：<span>${purchase.provider.providerName }</span>
										</caption>
										<thead>
											<tr>
												<th>订单项编号</th>
												<th>商品名称</th>
												<th>商品库存</th>
												<th>采购数量</th>
												<th>入库数量</th>
												<th><button class="btn btn-primary btn-xs pull-right enterBtn">一键入库</button></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${purchase.purchaseItems }"
												var="purchaseItem">
												<tr class="valignTr">
													<td>${purchaseItem.purchaseItemId }</td>
													<td id="${purchaseItem.product.productId }">${purchaseItem.product.productName }</td>
													<td>${purchaseItem.product.storage }</td>
													<td>${purchaseItem.purchaseNum }</td>
													<td colspan="2"><input id="${purchaseItem.purchaseItemId }" type="text" value="0"
														class="form-control">
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<button class="btn btn-primary pull-right confirmReceive">确认入库</button>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
					<div id="verifyTip" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h4>提示</h4>
								</div>
								<div class="modal-body">
									<span class="lead"></span>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary" data-dismiss="modal">确定</button>
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