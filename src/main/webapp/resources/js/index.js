$(function() {
	
	/*登录*/
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
				if (res == false) {
					$('div.alert').text('登录失败了(´･ω)~ 请检查您的用户名密码是否正确ʅ(‾◡◝)ʃ')
								  .fadeIn(500).delay(3000).fadeOut(1000);
				} else {
					window.location.href = "product";
				}
			},
			error : function() {
				alert('获取请求失败，请稍后重试！');
				location.reload();
			}
		});
	});
});