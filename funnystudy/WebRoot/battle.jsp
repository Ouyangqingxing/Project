<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/battle.css">
  </head>
  <body>
    <!-- -------------------------------页面左上侧部分（个人信息部分）-------------------------------------- -->
    <div class="baseInfo">
    	<div class="baseInfoTitle">我的资料</div>	 
			<c:choose>		
				<c:when test="${selfFace==2}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==3}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==4}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==5}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==6}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==7}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==8}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==9}">
					<img class="battleFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==10}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==11}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==12}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==13}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==14}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==15}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>
				<c:when test="${selfFace==16}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==17}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:when test="${selfFace==18}">
					<img class="battleFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:when>					
				<c:otherwise>
					<img class="battleFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="120" height="120"/></img>		 
				</c:otherwise>
		</c:choose>		
							
		<div class="baseBattleInfo"> 
			<span style="color:red;">${player1.name}&nbsp&nbsp</span>
			[
			<c:choose>
					<c:when test="${player1.backpack[0]==0}">
						人<!-- //-3魔  -2鬼  -1 妖  0人  1侠   2仙  3神  -->
					</c:when>
					<c:when test="${player1.backpack[0]==1}">
						侠
					</c:when>
					<c:when test="${player1.backpack[0]==-1}">
						妖 
					</c:when>
					<c:when test="${player1.backpack[0]==2}">
						仙
					</c:when>
					<c:when test="${player1.backpack[0]==-2}">
						鬼
					</c:when>
					<c:when test="${player1.backpack[0]>2}">
						神
					</c:when>
					<c:when test="${player1.backpack[0]<-2}">
						魔
					</c:when> 
			</c:choose>
			] 
			
			&nbsp&nbspLv.${player1.lv}<br>
			阵营：<c:choose>
				<c:when test="${player1.campId==1}">
					<a style="color:#0D0;" class="camp">正义萌</a>
				</c:when>
				<c:when test="${player1.campId==2}">
					<a style="color:red;" class="camp">魅邪教</a>
				</c:when>
				<c:when test="${player1.campId==3}">
					<a style="color:#FB0;" class="camp">浣月宫</a>
				</c:when>
				<c:when test="${player1.campId==0}">
					无。
				</c:when>
			</c:choose>
			
			&nbsp&nbsp&nbsp&nbsp帮会：<c:choose>
				<c:when test="${player1.teamId==0}">
					<a class="team">无</a>
				</c:when>
				<c:otherwise>
					<a class="team">${selfTeamName}</a>
				</c:otherwise>
			</c:choose>
			<br>状态：
			<c:choose>
				<c:when test="${player1.state==1}">
						正常 <br>	 
				</c:when>
				<c:when test="${player1.state==0}">
						封号 <br>	 
				</c:when>
				<c:when test="${player1.state==5}">
						修炼 <br>	 
				</c:when>
				<c:when test="${player1.state==-10}">
						绝情<br>	 
				</c:when>
				<c:otherwise>
					其他 <br>	
				</c:otherwise>	
			</c:choose>
			今日剩余战斗次数：${player1.lastFightChance}
			<form action="UpdatePk.action" method="get"> 
 			 战胜后： 
   				<label><input name="pk" type="radio" value="0" checked="checked"/>杀</label>
   				<label><input name="pk" type="radio" value="1" />护 </label>&nbsp
   				<input type="submit" value="确定" onclick="return confirm('确定要修改吗?')"/>  
   			</form>
				
		</div> 		
		<div class="personalValue1">
			体力：
			<c:choose>
				<c:when test="${player1.hp<=10000}">
					${player1.hp}		
				</c:when>			
				<c:when test="${player1.hp>10000 && player1.hp<100000000}">
					<fmt:formatNumber type="number" value="${player1.hp / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player1.hp>100000000}">
					<fmt:formatNumber type="number" value="${player1.hp / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>  
			
			攻击：			
			<c:choose>
				<c:when test="${player1.atk<=10000}">
					${player1.atk}		
				</c:when>			
				<c:when test="${player1.atk>10000 && player1.atk<100000000}">
					<fmt:formatNumber type="number" value="${player1.atk / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player1.atk>100000000}">
					<fmt:formatNumber type="number" value="${player1.atk / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
			防御：			
			<c:choose>
				<c:when test="${player1.def<=10000}">
					${player1.def}		
				</c:when>			
				<c:when test="${player1.def>10000 && player1.def<100000000}">
					<fmt:formatNumber type="number" value="${player1.def / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player1.def>100000000}">
					<fmt:formatNumber type="number" value="${player1.def / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
			速度：			
			<c:choose>
				<c:when test="${player1.spd<=10000}">
					${player1.spd}		
				</c:when>			
				<c:when test="${player1.spd>10000 && player1.spd<100000000}">
					<fmt:formatNumber type="number" value="${player1.spd / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player1.spd>100000000}">
					<fmt:formatNumber type="number" value="${player1.spd / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>
			战力：			
			<c:choose>
				<c:when test="${player1.power<=10000}">
					${player1.power}		
				</c:when>			
				<c:when test="${player1.power>10000 && player1.power<100000000}">
					<fmt:formatNumber type="number" value="${player1.power / 10000}" maxFractionDigits="1"/>万		
				</c:when>
				<c:when test="${player1.power>100000000}">
					<fmt:formatNumber type="number" value="${player1.power / 100000000}" maxFractionDigits="1"/>亿		
				</c:when>
			</c:choose><br>	
		</div>
		<div class="personalValue2">
			<span style="color:#FB0">运势：${player1.rp}%</span><br>
			<span style="color:red;">暴击：${player1.critical}%</span><br>
			<span style="color:#0D0;">闪避：${player1.dodge}%</span><br>		 		
			<span style="color:yellow;">修为：${player1.xiuwei}</span><br>
			
			<c:choose>
				<c:when test="${player1.coreCheck>=0}">
					<span style="color:#3CF;">灵气：${player1.coreCheck}</span></br>	
				</c:when>
				<c:otherwise> 
					<span style="color:C0F;">煞气：${-player1.coreCheck}</span></br>
				</c:otherwise>				
			</c:choose><br>
   		</div>
   		<br>
   		<div class="battleComplex">
	   		<a class="goOut">外出</a>
	   		&nbsp&nbsp&nbsp&nbsp&nbsp
	   		<a class="xiuLianDian">修炼点(${player1.points})</a>
	   		<br>
	   		<a class="weapon">武器</a>
	   		&nbsp&nbsp&nbsp&nbsp&nbsp
	   		<a class="wuGong">武功</a><br>
	   		 
	   	</div>
    </div>
    
    <!-- -------------------------------页面右上侧部分---------------------------------------------------- -->
	<div class="rightPage">
   		<div class="rightPageTitle">排行榜</div>
		<div class="phbClass">
			&nbsp<a title="等级排行榜" style="color:#0D0;" href="<%=basePath%>ShowBattle.action?battlePhb=3">世外高人&nbsp&nbsp&nbsp</a>
			<a title="品剑排行榜" style="color:red;"	href="<%=basePath%>ShowBattle.action?battlePhb=4">擂台贤者&nbsp&nbsp&nbsp</a>	
			<a title="灵气排行榜" style="color: #0DD;" href="<%=basePath%>ShowBattle.action?battlePhb=1">仙剑奇侠&nbsp&nbsp&nbsp</a>	
			<a title="煞气排行榜" style="color: #C0C;" href="<%=basePath%>ShowBattle.action?battlePhb=2">乱世枭雄</a>
		</div>
		<div class="phb">
			<ul>  	 
				<c:forEach items="${battlePlayerList}" var="player">
				<li>
					<span class="phbRed">${player.sex}</span>	
					<a class="phbUsername" href="ShowStudy.action?playerId=${player.id}">${player.name}</a>	 
					<div class="phbUserLv">lv.${player.lv}</div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<div class="phbUserPower">						
				<c:choose>
					<c:when test="${player.power<=10000}">
						${player.power}		
					</c:when>			
					<c:when test="${player.power>10000 && player.power<100000000}">
						<fmt:formatNumber type="number" value="${player.power / 10000}" maxFractionDigits="1"/>万		
					</c:when>
					<c:when test="${player.power>100000000}">
						<fmt:formatNumber type="number" value="${player.power / 100000000}" maxFractionDigits="1"/>亿		
					</c:when>
				</c:choose>
			</div>		
			
		 
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<a class="phbUserBattle"  href="Battle.action?bePlayerId=${player.id}">挑战!</a>
		 
				</li>
				</c:forEach>
		
			</ul>
		</div>
		<div class="phbPage">
			<jsp:include page="cut/battlePhb.jsp"></jsp:include>
		</div>		
    </div>    
	
	<!-- -------------------------------页面左下侧近期战斗情况部分--------------------------------------------- -->
    <div class="battleInfo">
    	<div class="battleInfoTitle">战斗情况</div>
 		<c:choose>    	
			<c:when test="${empty lastBattleInfo}">	
				<div class = "battleInfoNull">
					最近没有战斗情况哦= =。
				</div>
			</c:when>
			<c:otherwise>
				<pre class="battleInfoText">${lastBattleInfo}</pre>
			</c:otherwise>	 		 
		</c:choose>
    </div>
   
    <!-- -------------------------------页面右下侧随机玩家部分--------------------------------------------- -->
	<div class="randomPlayer">
    	<div class="randomPlayerTitle">品剑大会</div>
    	<div class="pkRemark">不打不相识，以武会友，少侠来一发！</div>
    	<div class="leftPlayer">
    		<div>    		
			    <c:choose>		
						<c:when test="${player2.sex==2}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==3}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==4}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==5}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==6}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==7}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==8}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==9}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==10}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==11}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==12}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==13}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==14}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==15}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player2.sex==16}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==17}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player2.sex==18}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:otherwise>
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:otherwise>
				</c:choose>
	    		    		
	    		<div class="playerBaseInfo">
		    		<a class="randomUserName" href="ShowStudy.action?playerId=${player2.id}">${player2.name}</a><br> 
		    		战斗力：${player2.power}<br>
		    		排名：${player2.ranking}<br>
		    		<a style="color:red;" href="Battle.action?bePlayerId=${player2.id}">挑战!</a>
	    		</div>	
	    		<div class="playerRemark">${player2.remark}</div>
    		</div>
    		<div style="position: relative;top: -46px;">
	    					    <c:choose>		
						<c:when test="${player3.sex==2}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==3}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==4}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==5}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==6}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==7}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==8}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==9}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==10}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==11}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==12}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==13}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==14}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==15}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player3.sex==16}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==17}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player3.sex==18}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:otherwise>
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:otherwise>
				</c:choose>
				
				<div class="playerBaseInfo">
		    		<a class="randomUserName" href="ShowStudy.action?playerId=${player3.id}">${player3.name}</a><br> 
		    		战斗力：${player3.power}<br>
		    		排名：${player3.ranking}<br>
		    		<a style="color:red;" href="Battle.action?bePlayerId=${player3.id}">挑战!</a>
	    		</div>	
	    		<div class="playerRemark">${player3.remark}</div>
	    	</div>
    	</div>
    	
    	<div class="rightPlayer">
    		<div>
	    					    <c:choose>		
						<c:when test="${player4.sex==2}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==3}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==4}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==5}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==6}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==7}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==8}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==9}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==10}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==11}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==12}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==13}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==14}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==15}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player4.sex==16}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==17}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player4.sex==18}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:otherwise>
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:otherwise>
				</c:choose>
				<div class="playerBaseInfo">
		    		<a class="randomUserName" href="ShowStudy.action?playerId=${player4.id}">${player4.name}</a><br>
		    		战斗力：${player4.power}<br>
		    		排名：${player4.ranking}<br>
		    		<a style="color:red;" href="Battle.action?bePlayerId=${player4.id}">挑战!</a>
	    		</div>	
	    		<div class="playerRemark">${player4.remark}</div>
    		</div>
    		<div style="position: relative;top: -47px;">
	    					    <c:choose>		
						<c:when test="${player5.sex==2}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==3}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==4}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==5}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==6}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==7}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==8}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==9}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==10}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==11}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl2.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==12}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl3.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==13}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl4.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==14}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl5.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==15}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl6.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>
						<c:when test="${player5.sex==16}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl7.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==17}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl8.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:when test="${player5.sex==18}">
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/girl9.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:when>					
						<c:otherwise>
							<img class="randomPlayerFace" src="<%=basePath%>/images/face/boy1.jpg" alt="头像" width="70" height="70"/></img>		 
						</c:otherwise>
				</c:choose>
				<div class="playerBaseInfo">
		    		<a class="randomUserName" href="ShowStudy.action?playerId=${player5.id}">${player5.name}</a><br>
		    		战斗力：${player5.power}<br>
		    		排名：${player5.ranking}<br>
		    		<a style="color:red;" href="Battle.action?bePlayerId=${player5.id}">挑战!</a>
	    		</div>	
	    		<div class="playerRemark">${player5.remark}</div>
	    	</div>	
    	</div>
    	
    	<div class="pkInfo">
    		<span style="position:absolute;left:41px;color:red">我的排名：${player1.ranking}。</span>
    		<a style="position:absolute;right:41px;" href="<%=basePath%>ShowBattle.action">
    			O&nbsp换一批对手
    		</a>
    	</div>
    </div>   
    
    <!-- -------------------------------页面下侧部分（国家、帮派、武器、武功、物品信息部分）------------------------------- -->
   	<img class="closeRelativeInfo" src="<%=basePath%>/images/close.png" alt="关闭阵营信息" width="20" height="20" style="float:right;"/>
    <div class="campInfo">
    	<div class="campInfoTitle">阵营信息</div>
    	<div class="camp1">
    		<p style="font-size:22px;margin:0;color:#0D0">正义萌(${population1}人)</p>
    		<span>武林正道为对抗邪教而组织的联盟。</span><br>
    		萌主：	<a href="ShowStudy.action?playerId=19">欧阳辰</a><br>
    		副萌主：	<a href="ShowStudy.action?playerId=22">墨青玄</a> 
    	</div>
    	<div class="camp2">
    		<p style="font-size:22px;margin:0;color:red">魅邪教(${population2}人)</p>
    		<span>数年前，黯邪笼络起来的一帮江湖恶人，个个心狠手辣，不择手段。</span><br>
    		教主：<a href="ShowStudy.action?playerId=20">黯邪</a><br>
    		护法：<a href="ShowStudy.action?playerId=23">百里寒修</a>  
    	</div>
    	<div class="camp3">
    		<p style="font-size:22px;margin:0;color:yellow">浣月宫(${population3}人)</p>
    		<span>以剑法闻名天下的浣月宫，但宫主似乎对江湖事宜并不感兴趣。</span><br>
    		宫主：<a href="ShowStudy.action?playerId=21">祈灵</a><br>
    		宫主：<a href="ShowStudy.action?playerId=24">祈玉</a> 
    	</div>
    </div>
    <div class="teamInfo">
    	<div class="campInfoTitle">帮会信息</div>
    	<p>目前还不能成立或者使用帮会哦 - -。</p>
    </div>
    <div class="goOutInfo">
    	<div class="goOutInfoTitle">外出历练</div>
    	<div class="place1">
    		<p style="font-size:22px;margin:0;font-family:'楷体','楷体_GB2312';">修炼涯</p> 
    		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp你开始潜心修炼。一段时间（24小时）无法进行战斗，修炼时间到后获得大量经验，同在修炼涯的侠士越多经验越高。<br>
    		<a>(修炼涯暂时禁止入内。)</a>
    	</div>
    	<div class="place2">
    		<p style="font-size:22px;margin:0;font-family:'楷体','楷体_GB2312';">绝情谷</p>
    		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp你似乎厌倦了江湖的纷争。不用担心有人再来抢你的武器，没有人可以再和你比武，除非他战斗力超过谷主。<br>
    		<a>(谷主去找他媳妇儿了。)</a>
    	</div>
    	<div class="place3">
    		<p style="font-size:22px;margin:0;font-family:'楷体','楷体_GB2312';">光明圣殿</p><a href="GoOut.action?where=3">前往</a>
    		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp放佛脑海中灵光一现，在此你将有新的认识。消耗20000灵气值，你的等级回到1级，属性值不变。<br>
    	</div>
    	<div class="place4">
    		<p style="font-size:22px;margin:0;font-family:'楷体','楷体_GB2312';">暗黑堡垒</p><a href="GoOut.action?where=4">前往</a>
    		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp多年来你体内已经累积了足够多的煞气，在此你将有新的认识。消耗10000煞气值，你的等级回到1级，属性值不变。<br>
    	</div> 
    </div>
    <div class="xiuLianDianInfo">
    	<div class="xiuLianDianInfoTitle">分配修炼点</div>
  
    	<form action="ChangeCheck.action?check=1"  method="post" style="position:relative;top:80px;left:60px;width:400px;">
  			<br>Tips:1修炼点=1攻击力=1防御力=1速度=10体力值=1000修为<br><br><br>
  			例如0.0：<br>
  			拥有10点。分配为3、4、3、0，则体力+30 攻击+4 防御+3 速度不增加。<br><br><br>
    		体力<input type="text" name="hp"/><br>
    		攻击<input type="text" name="atk"/><br>
    		防御<input type="text" name="def"/><br>
    		速度<input type="text" name="spd"/><br>
    		<br><br><a href="ChangeCheck.action?check=0">将修为转化为修炼点！</a>
    		<input type="submit" value="确定" style="float:right;" class="sure" onclick="return confirm('确定要这样分配修炼点吗?')"/>
    	</form>
    </div>
    <div class="weaponInfo">
    	<div class="weaponInfoTitle">武器信息</div>
    	<c:choose>
    		<c:when test="${empty weaponList}">
    			<p style="text-align:center;line-height:430px;overflow:hidden;">你还没有武器哦~</p>
    		</c:when>
    		<c:otherwise>
    		    <ul>
		    		<li><p>${weaponList[0].name}</p>&nbsp&nbsp${weaponList[0].remark}</li> 
		    		<li><p>${weaponList[1].name}</p>&nbsp&nbsp${weaponList[1].remark}</li> 
		    		<li><p>${weaponList[2].name}</p>&nbsp&nbsp${weaponList[2].remark}</li> 
    			</ul>
    		</c:otherwise>
    	</c:choose>
    	<a class="showAllWeaponA" style="position: absolute;right: 20px;top: 398px;">查看所有武器~</a>
    </div>
    <div class="showAllWeapon">
    	<div class="showAllWeaponDetail">
	   		<p>${allWeaponList[0].name}</p>
	   		<a href="ShowStudy.action?playerId=${allWeaponList[0].holderId}">持有者</a>
	   		<span>${allWeaponList[0].remark}</span><br><br>
	  		
	  		<p>${allWeaponList[1].name}</p>
	  		<a href="ShowStudy.action?playerId=${allWeaponList[1].holderId}">持有者</a>
	  		<span>${allWeaponList[1].remark}</span><br><br>
	  		
	  		<p>${allWeaponList[2].name}</p>
	  		<a href="ShowStudy.action?playerId=${allWeaponList[2].holderId}">持有者</a>
	  		<span>${allWeaponList[2].remark}</span><br><br>
	  		
	  		<p>${allWeaponList[3].name}</p>
	  		<a href="ShowStudy.action?playerId=${allWeaponList[3].holderId}">持有者</a>
	  		<span>${allWeaponList[3].remark}</span><br><br>
	  		
	  		<p>${allWeaponList[4].name}</p>
	  		<a href="ShowStudy.action?playerId=${allWeaponList[4].holderId}">持有者</a>
	  		<span>${allWeaponList[4].remark}</span><br><br>
    	</div>
    </div>
    <div class="wugongInfo">
    	<div class="wugongInfoTitle">武功信息</div>
    	<c:choose>
    		<c:when test="${empty wugongList}">
    			<p style="text-align:center;line-height:430px;overflow:hidden;">你还没有武功哦~</p>
    		</c:when>
    		<c:otherwise>
    		    <ul>
		    		<li><p>${wugongList[0].name}</p>&nbsp&nbsp${wugongList[0].remark}</li><br>
		    		<li><p>${wugongList[1].name}</p>&nbsp&nbsp${wugongList[1].remark}</li><br>
		    		<li><p>${wugongList[2].name}</p>&nbsp&nbsp${wugongList[2].remark}</li><br> 
    			</ul>
    		</c:otherwise>
    	</c:choose>
    </div>
    
  	<!-- --------------------------------------页面的js内容-------------------------------------- -->
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
			$(function(){
				$(".camp").click(function(){ 
					$(".campInfo").show(500);
					$(".closeRelativeInfo").show(500);
				});
				$(".team").click(function(){ 
					$(".teamInfo").show(500);
					$(".closeRelativeInfo").show(500);
				});
				$(".goOut").click(function(){ 
					$(".goOutInfo").show(500);
					$(".closeRelativeInfo").show(500);
				}); 
				$(".xiuLianDian").click(function(){ 
					$(".xiuLianDianInfo").show(500);
					$(".closeRelativeInfo").show(500);
				});
				$(".weapon").click(function(){ 
					$(".weaponInfo").show(500);
					$(".closeRelativeInfo").show(500);
				});
				$(".showAllWeaponA").click(function(){ 
					$(".showAllWeapon").show(500); 
				});
				
				$(".wuGong").click(function(){ 
					$(".wugongInfo").show(500);
					$(".closeRelativeInfo").show(500);
				});
				
				$(".closeRelativeInfo").click(function(){ 
					$(".campInfo").hide(500);
					$(".teamInfo").hide(500);
					$(".goOutInfo").hide(500); 
					$(".xiuLianDianInfo").hide(500);
					$(".weaponInfo").hide(500);
					$(".wugongInfo").hide(500);
					$(".closeRelativeInfo").hide(500);
					$(".showAllWeapon").hide(500); 
				});
			});
		</script>
 </body>
</html>