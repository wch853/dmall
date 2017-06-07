$(function() {
	
	/*发货按钮点击事件*/
	$(".deliverBtn").click(function() {
		// 获取相应的订单编号
		var orderId = $(this).prop('id');
		
		var $deliverTip = $('#deliverModal .lead');
		
		$.ajax({
			url : 'admin/deliver/' + orderId,
			success : function(res) {
				if (res == true) {
					$deliverTip.text('发货成功！');
				} else {
					$deliverTip.text('发货失败，该订单含有缺件！');
					$('#deliverModal a').prop('href', 'admin/purchase').text('前往采购');
				}
				$('#deliverModal').modal({
					backdrop : 'static',
					keyboard : false
				});
			},
			error : function() {
				alert('获取请求失败，请稍后重试！');
			}
		});
	});
});