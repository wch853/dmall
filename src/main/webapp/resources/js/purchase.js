$(function() {
	
	//反选按钮
	$('#allCheck').click(function() {
		$('[name="singleCheck"]').click();
	});
	
	// 每行复选框单击事件
	$('[name="singleCheck"]').click(function() {
		var $num = $(this).parent().parent().find(':text');
		var $addBut = $(this).parent().parent().find('.addNum');
		
		if ($(this).is(':checked')) {
			$addBut.prop('disabled', false);
		} else {
			$addBut.prop('disabled', true);
			$num.val(0);
		}
	});
	
	// 按批采购按钮单击事件
	$('.addNum').click(function() {
		var $text = $(this).parent().parent().find('input');
		var id = '#' + $text.prop('id');
		var value = $(id).val();

		$(id).val(Number(value) + 20);
	});
	
	// 提交订单
	$('#confirmPurchase').click(function() {
		var $text = $(':text');
		var cata = {};
		var num = 0;
		
		// 处理采购信息
		$text.each(function() {
			if ($(this).val() != 0) {
				cata[$(this).prop('id')] = $(this).val();
				num++;
			}
		});
		
		// 获取供应商
		var provId = $('option:selected').prop('id');
		
		if (num == 0) {
			$('#purchaseAlert').text('订单为空，生成采购订单失败！').fadeIn(500).delay(5000).fadeOut(1000);
		} else {
			$.ajax({
				url : 'admin/sendCata',
				data : {
					providerId : provId,
					cata : JSON.stringify(cata)
				},
				success : function() {
					$('#purchaseTip').modal({
						backdrop : 'static',
						keyboard : false
					});
				},
				error : function() {
					alert('提交请求失败，请稍后重试！')
				}
			});
		}
		
	});
	
	// 处理订单
	$('#removeNone').click(function() {
		$('[name="singleCheck"]:not(:checked)').parent().parent().hide();
	});
	
	// 重置订单
	$('#resetNone').click(function() {
		location.reload();
	});
});