<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>服务器出现错误啦！</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="css/allErrors.css"/>
		<script type="text/javascript" src="js/error.js"></script>
	</head>
	
	<body>
		<script type="text/javascript" >
			ResizeImages();
		</script>
	
		<div class="bg">
			<div class="cont">
				<div class="c1">
					<img src="images/catError.png" id="error" class="img1" />
				</div>
				
				<h2>呀!…您的操作导致了一个未知的错误~</h2>
				
				<div class="c2">
					<a href="#" class="re">刷新一下</a>
					<a href="page.jsp" class="home">欢迎页面</a>
					<a href="http://www.baidu.com" class="sr">百度一下，你就知道</a>
				</div>
				
				<div class="c3">
					温馨提示 ： 您可能进行了不规范的操作，或者该网页部分功能存在Bug。
				</div>
			</div>
		</div>
	</body>
</html>