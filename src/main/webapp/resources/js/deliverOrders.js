$(function() {
	
	/*发货按钮点击事件*/
	$(".deliverBtn").click(function() {
		// 获取相应的订单编号
		var orderId = $(this).attr('id');
		
		$.ajax({
			url : 'admin/deliver/' + orderId,
			success : function(res) {
				if (res == true) {
					// TODO 返回不同的发货结果提示信息
				}
			}
		});
	});
});