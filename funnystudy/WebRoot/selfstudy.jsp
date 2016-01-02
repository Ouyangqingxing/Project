<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/selfstudy.css">
  </head>
  <body>
  	<!-- -------------------------------页面上左侧部分（写动态）------------------------------- -->
  	<div class="addAction">  
		<div class="qq">
			<p class="qq_title">有什么新鲜事想告诉大家(⊙ˍ⊙)？</p>
			<form method="post" action="AddAction.action"> 
				<textarea class="qq_msg2" name="actionContent"></textarea>  
				<p class="qq_box"> 
					<input type="submit" class="qq_btn" value="  发 表  " style="position:relative;right:16px;"/>   
				</p>
			</form>
		</div> 
  	</div>
  	
  	<!-- -------------------------------页面上右侧部分（修改资料）------------------------------- -->
  	<div class="baseInfo">
  		 <div class="qq">
  		 	<p class="qq_title">修改一下（修改后需要重新登陆一下哦 ╮(╯▽╰)╭）</p>
	  		<form method="post" action="UpdateStudyBaseInfo.action"> 
	  			<div class="qq_msg4">
					新签名：<input type="text" name="remark"/><br>
					旧密码：<input type="text" name="oldPassword"/><br> 
					新密码：<input type="text" name="newPassword"/><br>
				</div>
				<br>&nbsp&nbsp&nbsp&nbsp&nbsp<a class="changeFaceA" style="color:blue;">修改头像~</a>
				<p class="qq_box">
					<input style="margin: -32px 20px 0px 0px;" type="submit" class="qq_btn" value="修改"/>    
				</p>
			</form> 
		</div>
  	</div>
  	
  	<div class="changeFace">
  		<img class="closeRelativeInfo" src="<%=basePath%>/images/close.png" alt="关闭阵营信息" width="20" height="20" style="float:right;padding:3px;"/>
  		
  		<div class="boyFace">
  			<a href="UpdateUserFace.action?newFace=1"><img style="left:700px;" src="<%=basePath%>images/face/boy1.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=2"><img style="left:700px;" src="<%=basePath%>images/face/boy2.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=3"><img style="left:700px;" src="<%=basePath%>images/face/boy3.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=4"><img style="left:700px;" src="<%=basePath%>images/face/boy4.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=5"><img style="left:700px;" src="<%=basePath%>images/face/boy5.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=6"><img style="left:700px;" src="<%=basePath%>images/face/boy6.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=7"><img style="left:700px;" src="<%=basePath%>images/face/boy7.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=8"><img style="left:700px;" src="<%=basePath%>images/face/boy8.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=9"><img style="left:700px;" src="<%=basePath%>images/face/boy9.jpg" alt="头像" width="50" height="50"/></img></a> 		
  		</div>
  		
  		<div class="girlFace">
  			<a href="UpdateUserFace.action?newFace=10"><img style="left:700px;" src="<%=basePath%>images/face/girl1.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=11"><img style="left:700px;" src="<%=basePath%>images/face/girl2.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=12"><img style="left:700px;" src="<%=basePath%>images/face/girl3.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=13"><img style="left:700px;" src="<%=basePath%>images/face/girl4.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=14"><img style="left:700px;" src="<%=basePath%>images/face/girl5.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=15"><img style="left:700px;" src="<%=basePath%>images/face/girl6.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=16"><img style="left:700px;" src="<%=basePath%>images/face/girl7.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=17"><img style="left:700px;" src="<%=basePath%>images/face/girl8.jpg" alt="头像" width="50" height="50"/></img></a>
	  		<a href="UpdateUserFace.action?newFace=18"><img style="left:700px;" src="<%=basePath%>images/face/girl9.jpg" alt="头像" width="50" height="50"/></img></a>
 
  		</div>
  	</div>
  	
  	<!-- -------------------------------页面中间左侧部分（个人动态部分）------------------------------- -->
	<div class="action">	
		<div class="actionTitle">我的动态</div>
		<br>
		<c:forEach items="${actionList}" var="action">		
			<div class = "oneAction">	 		 	
				<span style="	color:red;	width:100px;">${selfUserName}</span>&nbsp&nbsp&nbsp
				Lv.${selfPlayerLv}
				<a style="float:right;" href="DeleteAction.action?actionId=${action.id}" onclick="return confirm('一定要删除这条动态么= =?')">删除</a>
				<div class="actionTime">${action.time}</div>
				<br>${action.content}<br><br>					 
				<a href="UpdateActionNumber.action?actionId=${action.id}&playerId=${selfPlayerId}">点赞(${action.number})</a>
			</div>	
			<br><hr style="border-top:1px solid #DCDCDC;"/>	
		</c:forEach>
	
		<%-- 如果动态为空则不显示分页的信息，改成显示一句话 --%>
		<c:choose>    	
			<c:when test="${empty actionList}">	
				<div class = "actionNull">
					这家伙真懒，什么东西都没留下。
				</div>
			</c:when>
			<c:otherwise>
				<div class="actionPage">
					<jsp:include page="cut/actionCut.jsp"></jsp:include>
			   	</div>
			</c:otherwise>	 		 
		</c:choose> 	
    </div>
    
    <!-- -------------------------------页面中间右侧部分（今日学习情况部分）------------------------------- -->
   	<div class="studyInfo">
   		<div class="studyInfoTitle">我的学习情况</div>
   		<c:choose>		
			<c:when test="${checkStudyInfo==1}">
				<div class="studyInfoContent">
   					${studyinfo.content}
   				</div>
			</c:when>
			
			<c:when test="${checkStudyInfo==0}">
			<div class="qq">  
				<br><br>
				<span class="qq_title">今天还没有更新学习情况哦(。・д・。)</span><br> 
				<form method="post" action="AddStudyInfo.action"> 
					<textarea class="qq_msg3" name="studyInfoContent"></textarea>  
					<p class="qq_box"> 
						<input type="submit" class="qq_btn" value="  我 写！ "/>   
					</p>
				</form>
			</div>
			</c:when>
			
			<c:when test="${checkStudyInfo==-1}">
				<div class="studyInfoNull">
					哎呀，这一天你并没有更新学习情况哦。
				</div>
			</c:when>
		</c:choose>
						
		<div class="arrow">
			<a href="<%=basePath%>ShowSelfStudy.action?addOrSub=1" style="position:relative;left: 20px; font-size:16px;text-decoration:none;"> <-新的一天 </a> 
			<a href="<%=basePath%>ShowSelfStudy.action?addOrSub=0" style="position:relative;right: -150px; font-size:16px;text-decoration:none;"> 旧的一天-> </a>
		</div>
    </div>
    
    <!-- -------------------------------页面下侧部分（留言板部分）------------------------------- -->
  	<div class="message">
  		<div class="messageTitle">我的留言板</div>
  		<br><br><br>
		<c:forEach items="${messageList}" var="messageX">		
			<div class = "oneMessage">	  
					<c:choose>		
						<c:when test="${messageX.userFace==2}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==3}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==4}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==5}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==6}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==7}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==8}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==9}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==10}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==11}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==12}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==13}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==14}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==15}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>
						<c:when test="${messageX.userFace==16}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==17}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:when test="${messageX.userFace==18}">
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:when>					
						<c:otherwise>
							<img style="border-radius:10px;" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="80" height="80"/></img>		 
						</c:otherwise>
				</c:choose>
				<br>	
				<div class="namelvtime"> 	
					<a href="ShowStudy.action?playerId=${messageX.userId}" style="color: #F00;width: 100px;text-decoration: none; ">${messageX.userName}</a>&nbsp&nbsp&nbsp
					Lv.${messageX.userLv}<br><br>
					<div class="messageTime">${messageX.time}</div>
				</div>
				<a style="float:right;position:relative;top:-130px;"href="DeleteMessage.action?messageId=${messageX.id}" onclick="return confirm('确定删除这条留言咩?')">删除</a>
				<pre class="messageContent">${messageX.content}</pre>
			</div><hr style="border-top:1px solid #DCDCDC;"/><br><br>	
		</c:forEach>
	
		<%-- 如果动态为空则不显示分页的信息，改成显示一句话 --%>
		<c:choose>    	
			<c:when test="${empty messageList}">	
				<div class = "messageNull">
					居然还没有给我留过言，桑心QAQ
				</div>
			</c:when>
			<c:otherwise>
				<div class="messagePage">
					<jsp:include page="cut/messageCut.jsp"></jsp:include>
			   	</div>
			</c:otherwise>	 		 
		</c:choose>   
		
		<br><br>
		<div class="addMessage">
			<div class="qq">
				<p class="qq_title">快给我留言吧（＞▽＜）</p>
				<form method="post" action="AddMessage.action?playerId=${selfPlayerId}"> 
					<textarea class="qq_msg2" name="messageContent" style="height:50px;"></textarea>  
					<p class="qq_box"> 
						<input type="submit" class="qq_btn" value=" 留 言  "/>   
					</p>
				</form>
			</div>			
		</div> 
		<br><br>
  	</div> 
  	
  	   	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
		<script type="text/javascript">
			$(function(){
				 
				$(".changeFaceA").click(function(){  
					$(".baseInfo").hide(500);
					$(".changeFace").show(500);
				});
				
				$(".closeRelativeInfo").click(function(){ 
					$(".baseInfo").show(500);
					$(".changeFace").hide(500);
				});
			});
		</script>
  </body>
</html>
