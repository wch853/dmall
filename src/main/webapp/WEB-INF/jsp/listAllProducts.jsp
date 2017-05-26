<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath }/">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="resources/js/listAllProducts.js"></script>
<link href="resources/css/standard.css" rel="stylesheet">
<title>所有商品</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div>
				<table id="productTable"></table>
			</div>

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
								加入购物车</button>
						</div>
					</div>
				</div>
			</div>

			<div id="promptModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">提示</h4>
						</div>
						<div class="modal-body">
							<span class="lead">该商品已成功加入购物车！</span>
						</div>
						<div class="modal-footer">
							<a type="button" class="btn btn-primary">前往购物车</a>
							<button type="button" class="btn btn-primary" data-dismiss="modal">
								关闭
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>