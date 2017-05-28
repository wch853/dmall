$(function() {
	
	/*初始化bootstrap-table*/
	$('#productTable').bootstrapTable({
		url : 'getProducts', 			// 请求数据
		striped : true, 				// 隔行着色
		pagination : true, 				// 分页 
		queryParams : queryParams,		// 传递参数 
		sidePagination : "server", 		// 分页方式，服务端分页 
		pageNumber : 1, 				// 加载首页 
		pageSize : 10, 					// 每页的记录行数 
		pageList : [10, 25, 50, 100], 	// 可供选择的分页
		showColumns : true, 			// 显示列按钮
		showRefresh : true, 			// 刷新按钮
		minimumCountColumns : 1, 		// 最少允许的列数
		showToggle : true, 				// 详细视图和列表视图切换按钮
		columns : [ {					// 列
			field : 'productId',
			title : '编号'
		}, {
			field : 'productName',
			title : '名称'
		}, {
			field : 'doublePrice',
			title : '单价'
		} ],
		onClickRow : clickRow			// 单击表格行事件
	});
	
	// 向后台传递的参数
	function queryParams(params) {
		return {
			offset : params.offset,			// 分页偏移量
			limit : params.limit,			// 每页数量	
			search : $('#searchText').val()	// 搜索关键字
		}
	}

	var price, pid;
	/*单击表格行事件*/
	function clickRow(row, $element) {		// row参数表示该行
		// 添加购物车弹窗
		$('#buyModal').modal('show');		
		$('#numText').val(1);
		$('#numPrompt').text('');
		$('#pname').text(row.productName);
		$('#pprice').text(row.doublePrice);
		$('#ptotal').text(row.doublePrice);
		price = row.doublePrice;
		pid = row.productId;
	}
	
	/*验证数量输入条件*/
	function regNumber() {
		var num = $('#numText').val();
		var reg = /^[0-9]{1,}$/;
		if (!reg.test(num) || Number(num) == 0) {
			$('#numPrompt').text('商品数量是正整数哟(ÒܫÓױ)~');
			return false;
		} else {
			$('#numPrompt').text('');
			return true;
		}
	}
	
	/*增加按钮点击事件*/
	$('#addBut').click(function() {
		var $numText = $('#numText');
		if (regNumber()) {
			var value = Number($numText.val()) + 1;
			$numText.val(value);
			// 计算的价格保留两位小数
			$('#ptotal').text((price * value).toFixed(2));	
		}
	});

	/*加入购物车点击事件*/
	$('#submit').click(function() {
		if (regNumber()) {
			// 禁用提交按钮，等待提交
			$(this).prop('disabled', true);
			
			// TODO 提交业务逻辑
			$.ajax({
				url : 'addOrderItem',
				data : {
					productId : pid,
					productQuantity : $('#numText').val()
				},
				success : function(res) {
					$('#buyModal').modal('hide');
					// 弹出提示加入成功窗口
					$('#promptModal').modal('show');
					$(this).prop('disabled', false);
				}
			});
			
		}
	})
	
	/*搜索商品，传入关键字并刷新*/
	$('#searchBtn').click(function() {
		$('#productTable').bootstrapTable('refresh');
	});
	
	/*重置搜索框并刷新*/
	$('#resetBtn').click(function() {
		$('#searchText').val('');
		$('#productTable').bootstrapTable('refresh');
	});
});
