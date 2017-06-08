$(function() {
	
	$('#allCheck').click(function() {
		if ($(this).is(':checked')) {
			$('[name="singleCheck"]').prop('checked', true);
		} else {
			$('[name="singleCheck"]').prop('checked', false);
		}
	});
	
	$('[name="singleCheck"]').click(function() {
		var $button = $(this).parent().parent().find('button');
		if (this.checked) {
			$button.prop('disabled', false);
		} else {
			$button.prop('disabled', true);
		}
	})
	
	$('.addNum').click(function() {
		var $text = $(this).parent().parent().find('input');
		var id = '#' + $text.prop('id');
		
		var value = $(id).val();
		$(id).val(Number(value) + 20);
	});
	
	$('#confrimPurchase').click(function() {
		var $text = $(':text');
	});
	
	$('#removeNone').click(function() {
		$('[name="singleCheck"]:not(:checked)').parent().parent().hide();
	});
	
	$('#resetNone').click(function() {
		$('tr:hidden').show();
		$('button[disabled="disabled"]').prop('disabled', true);
	});
});