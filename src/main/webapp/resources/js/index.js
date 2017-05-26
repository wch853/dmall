$(function() {
	$('#loginBtn').click(function() {
		var name = $('#username').val();
		var pwd = $('#password').val();
		
		$.ajax({
			url : 'login',
			data : {
				username : name,
				password : pwd
			},
			success : function(res) {
				if (res == 0) {
					$('div.alert').fadeIn(500).delay(3000).fadeOut(1000);
				} else {
					window.location.href = "product";
				}
			}
		});
	});
});