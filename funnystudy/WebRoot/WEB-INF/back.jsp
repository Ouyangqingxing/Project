<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/back.css">
    <title>后台管理</title>
  </head>
  	
  <body>
  	<div class="showPlayer">
  		<div class="title">
			<span>玩家信息管理</span>
		</div>
			<table>
				<thead>
					<tr>
						<td>id</td>
						<td>玩家名</td>  
						<td>体力</td>
						<td>攻击</td>
						<td>防御</td>
						<td>速度</td>
						<td>运势</td>
						<td>暴击</td>
						<td>闪避</td>
						<td>等级</td>
						<td>经验</td>
						<td>武功</td>
						<td>武器</td>
						<td>高阶等级</td>
						<td>阵营id</td>
						<td>正邪</td>
						<td>状态</td>
						<td>剩余战斗次数</td>
						<td>修为</td>
						<td>可分配点数</td>
						<td>排名</td>
						<td>战斗力</td>
						<td>杀护</td>
						
						<td colspan="2">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${backPlayerList}" var="player">
						<tr>
							<td>${player.id}	</td>
							<td>${player.name}	</td> 
							<td>${player.hp}	</td>
							<td>${player.atk}	</td>
							<td>${player.def}	</td>
							<td>${player.spd}	</td>
							<td>${player.rp}	</td>
							<td>${player.critical}	</td>
							<td>${player.dodge}	</td>
							<td>${player.lv}	</td>
							<td>${player.exp}	</td>
							<td>${player.wugong}	</td>
							<td>${player.equipment}	</td>
							<td>${player.backpack}	</td>
							<td>${player.campId}	</td>
							<td>${player.coreCheck}	</td>
							<td>${player.state}	</td>
							<td>${player.lastFightChance}	</td>
					 		<td>${player.xiuwei}	</td>
					 		<td>${player.points}	</td>
					 		<td>${player.ranking}	</td>
					 		<td>${player.power}	</td>
							<td>${player.pk}	</td>					  			
							<td>
								<a href="SealPlayer.action?playerId=${player.id}" onclick="return confirm('确定封号？')">封号</a>
							</td> 							
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6"><jsp:include page="../cut/backCut.jsp"></jsp:include></td>
					</tr>
				</tfoot>
			</table>
  	</div>
  </body>
</html>
