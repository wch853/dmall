<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link id="favicon" href="http://www.easyicon.net/api/resizeApi.php?id=1188709&size=128" rel="icon" type="image/x-icon"/>
<base href="${pageContext.request.contextPath }/">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/standard.css" rel="stylesheet">
<title>出错了</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div id="errorPrompt" class="text-center col-md-6 col-md-offset-3">
				<div class="col-md-8 col-xs-6">
					<a href=""><img alt="pic" src="resources/img/dmall.png" id="dmallImg"></a>
				</div>
				<div class="col-md-4 col-xs-6">
					<h4>出错了啊~ ${ex.message }</h4>
					<h4><span class="glyphicon glyphicon-hand-left"></span><a href="">打开地猫之门~</a></h4>
				</div>
			</div>
		</div>
	</div>
</body>
</html>