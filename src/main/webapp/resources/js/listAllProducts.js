$(function() {

	$('#productTable').bootstrapTable({
		url : 'getProducts', // 请求数据
		striped : true, // 隔行着色
		pagination : true, // 分页 
		queryParams : queryParams,// 传递参数 
		sidePagination : "server", // 分页方式 
		pageNumber : 1, // 初始化加载第一页 
		pageSize : 10, // 每页的记录行数 
		pageList : [ 10, 25, 50, 100 ], // 可供选择的分页
		showColumns : true, // 显示列按钮
		showRefresh : true, // 刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 点击选中行
		showToggle : true, // 详细视图和列表视图切换按钮
		columns : [ {
			field : 'productId',
			title : '编号'
		}, {
			field : 'productName',
			title : '名称'
		}, {
			field : 'doublePrice',
			title : '单价'
		} ],
		onClickRow : clickRow
	});

	function queryParams(params) {
		return {
			limit : params.limit,
			offset : params.offset
		}
	}

	var price, pid;
	function clickRow(row, $element) {
		$('#buyModal').modal('show');
		$('#numText').val(1);
		$('#pname').text(row.productName);
		$('#pprice').text(row.doublePrice);
		$('#ptotal').text(row.doublePrice);
		price = row.doublePrice;
		pid = row.productId;
	}
	
	
	function regNumber() {
		var num = $('#numText').val();
		var reg = /^[0-9]{1,}$/;
		if (!reg.test(num)) {
			$('#numPrompt').text('请输入大于0的数字！');
			return false;
		} else {
			$('#numPrompt').text('');
			return true;
		}
	}
	$('#addBut').click(function() {
		if (regNumber()) {
			var value = Number($('#numText').val()) + 1;
			$('#numText').val(value);
			$('#ptotal').text((price * value).toFixed(2));
		}
	});

	$('#submit').click(function() {
		if (regNumber()) {
			$('#buyModal').modal('hide');
			$('#promptModal').modal('show');
		}
	})
});
