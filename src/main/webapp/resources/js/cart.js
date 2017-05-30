$(function() {
	var $tip = $('#payTipModal .lead');
	
	$('#confirmPayBtn').click(function() {
		$('#payTipModal').modal('show');
		$tip.text('请确认支付！');
	});
	
	$('#payBtn').click(function() {
		$.ajax({
			url : 'payOrder',
			success : function(res) {
				$tip.text(res);
				$('#payBtn').attr('id', 'goProduct');
			}
		});
	});
	
	$('#goProduct').click(function() {
		window.location.href = "product";
	})
	
});