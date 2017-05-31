$(function() {
	var $confirmModal = $('#payTipModal');
	
	$('#confirmPayBtn').click(function() {
		$confirmModal.modal('show');
	});
	
	
	$('#payBtn').click(function() {
		$.ajax({
			url : 'payOrder',
			success : function(res) {
				$confirmModal.modal('hide');
				$('#goModal .lead').text(res);
				// 设置点击不可关闭，ESC不可关闭
				$('#goModal').modal({backdrop: 'static', keyboard: false});
			}
		});
	});
	
	$('#goProduct').click(function() {
		window.location.href = "product";
	})
	
});