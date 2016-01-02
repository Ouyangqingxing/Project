<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css"> 
	</head>

	<body>  
		<img style="position: absolute;left: 402px;top: 96px;width: 300px;}" class="loginImg" src="<%=basePath%>/images/login.jpg" alt="喵"/></img>		 
		<fieldset id='login' class="Login">
			<legend id='legend' class="legend">登陆</legend>
			<form action="Login.action"  method="post">
				<table><tbody>
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="username"/><span1>${errorL}</span></td>   
					</tr>
					<tr>
						<td>&nbsp&nbsp&nbsp密&nbsp码:</td>
						<td><input type="password" name="password" /><span2></span></td>
					</tr>
				</tbody></table>			
				<div class="registerSure">
					</br><a href="<%=basePath%>/register.jsp" class="register">还没有账号呢0.0</a>
					<input type="submit" value="确定" class="sure" />
				</div>
			</form>
		</fieldset> 
	</body>
	<script>
		var field=document.getElementById('login');
		var legend=document.getElementById('legend');
		field.addEventListener('mouseover',function(){
			this.style.border='1px solid #0F0';
			legend.style.color='#0F0';
		},false);
		field.addEventListener('mouseout',function(){
			this.style.border='1px solid red';
			legend.style.color='red';
		},false);
		
	
		window.onload=function()
		{
			function refreshHeader()
			{  
				window.setTimeout(refresh(),5000); 
			} 
			function refresh()
			{ 
				window.parent.frames["header"].location.reload(); 
			}
			refreshHeader();
		};
		
	</script>
</html>
