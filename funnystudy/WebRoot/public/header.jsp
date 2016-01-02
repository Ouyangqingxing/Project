<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/page.css">
	</head>
	<body style="margin: 0px;">
		<div class="header">
		<a href="<%=basePath%>/ShowMain.action" target="mainFrame">
			<img style="left:200px;position:relative;top:5px;" src="<%=basePath%>images/logo.png" alt="头像" width="50" height="50"/></img>		 				
		</a>
			<!-- c标签，如果能找到username则已登陆显示个人信息，否则显示登陆注册提示 -->
			<c:choose>
				<c:when test="${selfPlayerId==null}">	
					<div class="loginRegister">
						<a href="<%=basePath%>/login.jsp" 		   target="mainFrame">登陆&nbsp&nbsp&nbsp</a>
						<a href="<%=basePath%>/register.jsp" 	   target="mainFrame">注册</a>
					</div>
				</c:when>				
				<c:otherwise> 
					<div class="userName">${selfPlayerInfo}</div>
					<div class="userMessage">&nbsp&nbsp
						<a href="<%=basePath%>Logout.action" >退出</a>
					</div>
					<a title="战斗！" href="<%=basePath%>ShowBattle.action" 	target="mainFrame">
						<img style="top:15px;left:1150px;border-radius:10px"  src="../images/jian.jpg" alt="动如雷霆" width="30" height="30"/></img>
					</a>
					<a title="学习~"href="<%=basePath%>ShowSelfStudy.action?selfPlayerId=${playerId}" target="mainFrame">
						<img style="top:15px;left:1190px;border-radius:10px"  src="../images/dun.jpg"  alt="不动如山" width="30" height="30"/></img>
					</a>
					
				</c:otherwise>	
			</c:choose>	
			
			<!-- 头像 -->
			<c:if test="${selfPlayerId!=null}">		
				<c:choose>		
						<c:when test="${selfFace==2}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>images/face/boy2.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==3}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==4}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==5}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==6}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==7}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==8}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==9}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>images/face/boy9.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==10}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==11}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==12}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==13}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==14}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==15}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>
						<c:when test="${selfFace==16}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==17}"> 
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:when test="${selfFace==18}">
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:when>					
						<c:otherwise>
							<img style="left:700px;border-radius:20px;" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="40" height="40"/></img>		 
						</c:otherwise>
				</c:choose>
			</c:if>	
		</div>
	</body>
</html>