<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/study.css">
  </head>
  <body>
    <!-- ----------------------------------页面左侧部分（个人战斗属性展示）------------------------------------ -->
   	<div class="battleInfo">
   		<div class="battleTitle">战斗资料</div>
		<c:choose>		
				<c:when test="${face==2}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==3}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==4}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==5}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==6}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==7}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==8}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==9}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==10}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==11}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==12}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==13}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==14}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==15}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${face==16}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==17}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${face==18}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:otherwise>
					<img class="battleFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:otherwise>
		</c:choose> 
		
		<div class="baseBattleInfo"> 
			${player.name}&nbsp&nbsp&nbsp
			<a style="color:red;" href="Battle.action?bePlayerId=${player.id}">挑战!</a>
			<br>[
			<c:choose>
					<c:when test="${player.backpack[0]==0}">
						人<!-- //-3魔  -2鬼  -1 妖  0人  1侠   2仙  3神  -->
					</c:when>
					<c:when test="${player.backpack[0]==1}">
						侠
					</c:when>
					<c:when test="${player.backpack[0]==-1}">
						妖 
					</c:when>
					<c:when test="${player.backpack[0]==2}">
						仙
					</c:when>
					<c:when test="${player.backpack[0]==-2}">
						鬼
					</c:when>
					<c:when test="${player.backpack[0]>2}">
						神
					</c:when>
					<c:when test="${player.backpack[0]<-2}">
						魔
					</c:when> 
			</c:choose>
			]&nbsp Lv.${player.lv}<br>
			阵营：
			<c:choose>
				<c:when test="${player.campId==1}">
					<span style="color:#0D0;">正义萌</span><br>
				</c:when>
				<c:when test="${player.campId==2}">
					<span style="color:red;">邪魅会</span><br>
				</c:when>
				<c:when test="${player.campId==3}">
					<span style="color:#FB0;">浣月宫</span><br>
				</c:when>
				<c:when test="${player.campId==0}">
					无。
				</c:when>
			</c:choose>
			
			<c:choose>
				<c:when test="${player.teamId==0}">
					帮会：无<br>
				</c:when>		
				<c:otherwise>
					帮会：${teamName}<br>
				</c:otherwise>					
			</c:choose>				
		</div> 
		
		<div class="remarkInfo">
			签名：
			<c:choose>
				<c:when test="${empty remark}">
					无。
				</c:when>
				<c:otherwise>
					${remark}
				</c:otherwise>
			</c:choose>	
		</div>
		
		<div class="personalValue1">
			体力：
			<c:choose>
				<c:when test="${player.hp<=10000}">
					${player.hp}		
				</c:when>			
				<c:when test="${player.hp>10000 && player.hp<100000000}">
					<fmt:formatNumber type="number" value="${player.hp / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player.hp>100000000}">
					<fmt:formatNumber type="number" value="${player.hp / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>  
			
			攻击：			
			<c:choose>
				<c:when test="${player.atk<=10000}">
					${player.atk}		
				</c:when>			
				<c:when test="${player.atk>10000 && player.atk<100000000}">
					<fmt:formatNumber type="number" value="${player.atk / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player.atk>100000000}">
					<fmt:formatNumber type="number" value="${player.atk / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
			防御：			
			<c:choose>
				<c:when test="${player.def<=10000}">
					${player.def}		
				</c:when>			
				<c:when test="${player.def>10000 && player.def<100000000}">
					<fmt:formatNumber type="number" value="${player.def / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player.def>100000000}">
					<fmt:formatNumber type="number" value="${player.def / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
			速度：			
			<c:choose>
				<c:when test="${player.spd<=10000}">
					${player.spd}		
				</c:when>			
				<c:when test="${player.spd>10000 && player.spd<100000000}">
					<fmt:formatNumber type="number" value="${player.spd / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player.spd>100000000}">
					<fmt:formatNumber type="number" value="${player.spd / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
		</div>
		<div class="personalValue2">
			<span style="color:#FB0">运势：${player.rp}%</span><br>
			<span style="color:red;">暴击：${player.critical}%</span><br>
			<span style="color:#0D0;">闪避：${player.dodge}%</span><br>
			<c:choose>
				<c:when test="${player.coreCheck>=0}">
					<span style="color:#3CF">灵气：${player.coreCheck}</span><br>	
				</c:when>
				<c:otherwise> 
					<span style="color:C0F">煞气：${-player.coreCheck}</span><br>
				</c:otherwise>				
			</c:choose>		 
		</div>
    </div>
    
    <!-- ------------------------------------页面右侧部分（个人动态部分）----------------------------------- -->
	<div class="action">
		<div class="actionTitle">动态</div>
		<br>
		<c:forEach items="${actionList}" var="action">		
			<div class = "oneAction">	 		 	
				<span style="	color:red;	width:100px;">${userName}</span>&nbsp&nbsp&nbsp
				Lv.${playerLv}
				<div class="actionTime">${action.time}</div>
				<br>${action.content}<br><br>					
				<a href="UpdateActionNumber.action?actionId=${action.id}">点赞(${action.number})</a> 	
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
					<jsp:include page="cut/actionCutOthers.jsp"></jsp:include>
		    	</div>
			</c:otherwise>				 
		</c:choose> 	
    </div>
   
    <!-- ---------------------------------------页面下侧部分（留言板部分）--------------------------------- -->
  	<div class="message">
  	  	<div class="messageTitle">留言板</div>
  	  	 
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
					<a href="ShowStudy.action?playerId=${messageX.playerId}" style="color: #F00;width: 100px;text-decoration: none; ">${messageX.userName}</a>&nbsp&nbsp&nbsp
					Lv.${messageX.userLv}<br><br>
					<div class="messageTime">${messageX.time}</div>
				</div>
				<div class="messageContent">${messageX.content}</div>
			</div><hr style="border-top:1px solid #DCDCDC;"/> 
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
					<jsp:include page="cut/messageCutOthers.jsp"></jsp:include>
			   	</div>
			   	<br><br>
			</c:otherwise>	 		 
		</c:choose> 
		
		<div class="addMessage">
			<div class="qq">
				<p class="qq_title">快给我留言吧（＞▽＜）</p>
				<form method="post" action="AddMessage.action"> 
					<textarea class="qq_msg2" name="messageContent" style="height:50px;"></textarea>  
					<p class="qq_box"> 
						<input type="submit" class="qq_btn" value=" 留 言  "/>   
					</p>
				</form>
			</div>			
		</div><br><br>
  	</div>
  	
  </body>
</html>
