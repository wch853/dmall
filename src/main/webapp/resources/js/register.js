$(function() {
	
	var $alert = $('div.alert');
	/*注册*/
	$('#registerBtn').click(function() {
		var name = $('#username').val();
		var pwd = $('#password').val();
		
		var reg = /^[0-9a-zA-Z]{6,16}$/;

		if (!reg.test(name) || !reg.test(pwd)) {
			$alert.text('用户名和密码必须是6~16位的数字与英文字母组合~')
			      .fadeIn(500).delay(10000).fadeOut(1000);
		} else {
			register(name, pwd);
		}
		
	});
	
	function register(name, pwd) {
		$.ajax({
			url : 'registerInfo',
			data : {
				username : name,
				password : pwd
			},
			success : function(res) {
				if (res == false) {
					$alert.text('注册失败了(´･ω)~ 该帐号已被注册ʅ(‾◡◝)ʃ')
								  .fadeIn(500).delay(5000).fadeOut(1000);
				} else {
					// 清空表单内容
					$(':input').val('');
					$alert.html('注册成功，快去<a href="product">挑选商品</a>吧~').fadeIn(500);
				}
			}
		});
	}
});