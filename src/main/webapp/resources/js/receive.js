$(function() {
	
	// 一键入库点击事件
	$('.enterBtn').click(function() {
		var $row = $(this).parents('table').find('.valignTr');
		$row.each(function() {
			var purchaseNum = $(this).find('td:eq(3)').text();
			$(this).find('input').val(purchaseNum);
		});
	});
	
	// 校验入库数字
	function verifyNum(num, purchase) {
		if (num.length == 0 ) {
			return false;
		}
		
		var number = Number(num);
		var purchaseNum = Number(purchase);
		
		var reg = /^\d{1,}$/;
		if (!reg.test(number)) {
			return false;
		}
		
		if (number > purchaseNum || number < 0 || number.length == 0) {
			return false;
		}
		
		return true;
	}
	
	$('.confirmReceive').click(function() {
		var $table = $(this).siblings('table');
		var pId = $table.find('span:first').text();
		// 该订单的所有行
		var $row = $table.find('.valignTr');
		var rece = {};
		
		// 判断循环是否出错的标志
		var flag = true;
		$row.each(function() {
			var productId = $(this).find('td:eq(1)').prop('id');
			var purchase = $(this).find('td:eq(3)').text();
			var num = $(this).find('input').val();

			if (!verifyNum(num, purchase)) {
				$('#verifyTip .lead').text('入库信息填写错误，请重新填写！');
				$('#verifyTip').modal('show');
				flag = false;
				// 终止each循环
				return false;
			} else {
				rece[productId] = num;
			}
		});
		
		if (flag) {
			$.ajax({
				url : 'admin/sendRece',
				data : {
					purchaseId : pId,
					rece : JSON.stringify(rece)
				},
				success : function() {
					$('#verifyTip .lead').text('采购商品入库成功！');
					$('#verifyTip').modal({
						backdrop : 'static',
						keyboard : false
					});
					$('.modal-footer button').click(function() {
						location.reload();
					});
				},
				error : function() {
					alert('获取请求失败，请稍后重试！');
					location.reload();
				}
			});
		}
	});
});