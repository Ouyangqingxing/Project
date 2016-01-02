<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/register.css">
		<script src="<%=basePath%>js/register.js" type="text/javascript"  charset="utf-8"></script>
		<script src="<%=basePath%>js/jquery-1.11.2.js" type="text/javascript"></script>
	</head>
	<body>
		<img style="position: absolute;top: 138px;left: 252px;width: 400px;" class="registerImg" src="<%=basePath%>/images/register.gif" alt="喵"/></img>	
		<input type="hidden" id="userHide1" />
		<fieldset class="register" id="div_register" style="display:block">
			<legend style="font-size: 24px;" class="legend" id='legend'>注册</legend>	 
			<form name="register" onsubmit="return checkAll()" action="Register.action" method="post">
				<table><tbody>
					<tr>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp用户名:</td>
						<td><input maxlength="15" type="text" name="username" id="username" onblur="checkUsername()"/><span id = "span">不能有特殊字符哦</span></td>   
					</tr>
					<tr>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp密码:</td>
						<td><input type="password"name="password" id="password" onblur="checkPassword(this)"/><span id = "span2"></span></td>
					</tr>
					<tr>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp确认密码:</td>
						<td><input type="password" name="password2" id="password2" onblur="checkPassword2()"/><span id = "span3"></span></td>
					</tr>
					<tr>
						<td>&nbsp&nbsp&nbsp&nbsp&nbsp签名:</td>
						<td><input type="text" name="remark" id="remark" /></td>
					</tr>	
 	 				<tr>
 						<td>&nbsp&nbsp&nbsp&nbsp&nbsp验证码:</td>
 						<td><input type="text" name="checkcode" id="checkcode"> 
 						<img src="Identify.action"  alt="看不清？换一张" onclick="changeImage(this)"></td>
 					</tr>
				</tbody></table>
				</br></br><input type="submit" value="确定" class="sure" />	
				<span style="color: #F00;float: left;position: relative;left: 32px;top: -23px;">${errorR}</span>		
			</form>
		</fieldset>
		
		<script>
			var field=document.getElementById('div_register');
			var legend=document.getElementById('legend');
			field.addEventListener('mouseover',function(){
				this.style.border='1px solid #0F0';
				legend.style.color='#0F0';
			},false);
			field.addEventListener('mouseout',function(){
				this.style.border='1px solid red';
				legend.style.color='red';
			},false);
	</script>
	</body>
</html>
