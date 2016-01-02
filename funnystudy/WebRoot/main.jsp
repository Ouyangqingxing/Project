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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/gb.css">
		<script type="text/javascript" src="<%=basePath%>js/main.js"></script> 
		<script type="text/javascript" src="<%=basePath%>js/jquery.min.js" ></script>
	</head>
	<body>
		<!-- -------------------------------页面左侧部分------------------------------- -->	
		<div class="mainContext"> 
				<ul>
					<li>
						<img src="images/fenlei1.png" title="[1]" width="100" height="100">
						<div class="link"> <br>							
							<a href="http://www.kekenet.com/" target="frame1"><a1 class="redText">趣味英语&nbsp&nbsp</a1></a>     							
							<a href="http://www.ribenyu.cn/home.php" target="frame1"><a1 class="orangeText">日语&nbsp&nbsp</a1></a> 
							<a href="http://kr.xsjedu.org/" target="frame1">韩语&nbsp&nbsp</a>  
							<br><br>
							<a href="http://www.52xyz.com/" target="frame1"><a1 class="blueText">小语种&nbsp&nbsp</a1></a>  
							<a href="http://www.fyan8.com/jichu.htm" target="frame1">粤语&nbsp&nbsp</a>
							<br>
						</div>		
					</li>
					 
					<li>
						<img src="images/fenlei2.png" title="[2]" width="100" height="100">
						<div class="link"><br>							
							<a href="http://bbs.yingjiesheng.com/" target="frame1"><a1 class="redText">求职技巧&nbsp&nbsp</a1></a> 
							<a href="http://jk.lady8844.com/235261/" target="frame1">职场社交&nbsp&nbsp</a>
							<a href="http://www.officezhushou.com/" target="frame1">办公软件&nbsp&nbsp</a>
							<a href="http://www.ps-xxw.cn/" target="frame1"><a1 class="blueText">ps&nbsp&nbsp</a1></a>
							<br><br>						 
							<a href="http://www.domarketing.org/" target="frame1">市场营销&nbsp&nbsp</a> 
							<a href="http://www.shejipai.cn/" target="frame1"><a1 class="orangeText">设计&nbsp&nbsp</a1></a> 
							<br>
						</div>	
					</li>
					
					<li>
						<img src="images/fenlei3.png" title="[4]" width="100" height="100">
						<div class="link"><br>
							<a href="http://www.exam8.com/" target="frame1">职业考证&nbsp&nbsp</a> 
							<a href="http://www.chinagwy.org/" target="frame1">公务员&nbsp&nbsp</a>
							<br><br>	
							<a href="http://sk.neea.edu.cn/jsjdj/" target="frame1">计算机二级&nbsp&nbsp</a>
							<a href="http://www.shanbay.com/" target="frame1"><a1 class="redText">英语四六级&nbsp&nbsp</a1></a>  
							<br>
						</div>
					</li>
					
					<li>
						<img src="images/fenlei4.png" title="[5]" width="100" height="100">
						<div class="link"><br>
							<a href="http://www.meishichina.com/" target="frame1"><a1 class="orangeText">美食&nbsp&nbsp</a1></a>  
							<a href="http://www.fengniao.com/" target="frame1">摄影&nbsp&nbsp</a> 
							<a href="http://5sing.kugou.com/index.html" target="frame1">唱歌&nbsp&nbsp</a> 
							<a href="http://www.fitnes.cn/" target="frame1"><a1 class="redText" >健身&nbsp&nbsp</a1></a>  
							<a href="http://www.yoka.com/dna/214/810/index.html" target="frame1">运动&nbsp&nbsp</a> 
							<br><br>
							<a href="http://www.mf100.org/index.htm" target="frame1">魔方&nbsp&nbsp</a>  
							<a href="http://www.magicyou.net/" target="frame1"><a1 class="blueText">魔术&nbsp&nbsp</a1></a> 
							<a href="http://www.xuehuahua.net/" target="frame1">绘画&nbsp&nbsp</a>  
							<a href="http://www.cyueqi.com/" target="frame1">乐器&nbsp&nbsp</a> 
 							<br>
						</div>
					</li>	
					
					<li>
						<img src="images/fenlei5.png" title="[3]" width="100" height="100">
						<div class="link"><br>							
							<a href="http://www.gaokao.com/zyk/" target="frame1"><a1 class="redText">高考&nbsp&nbsp</a1></a>
							<a href="http://www.zk5u.com/" target="frame1">中考&nbsp&nbsp</a> 
							<a href="http://www.mengya.com/portal.php" target="frame1"><a1 class="blueText">新概念作文&nbsp&nbsp</a1></a>  
							<br><br>
							<a href="http://www.33iq.com/quiz/mensa.html" target="frame1">智商测试&nbsp&nbsp</a> 
							<a href="http://www.brainxly.com/" target="frame1">大脑训练&nbsp&nbsp</a> 
							<br> 
						</div>
					</li>
				</ul> 
		</div>			
		
		<!-- -------------------------------页面中间部分------------------------------- -->
		<!-- 中间（上） -->
		<div class="noticeDiv"> 
			<div class="notice">${notice}</div>
		</div>
		
		<!-- 中间（中） -->
		<div id="container">
   			<div id="list" style="left: -415px;">
				<a href="ShowStudy.action?playerId=4"><img src="<%=basePath%>images/gb5.jpg" alt="1"/></a>
			    <a href="ShowStudy.action?playerId=1"><img src="<%=basePath%>images/gb1.jpg" alt="1"/></a>
			    <a href="ShowStudy.action?playerId=8"><img src="<%=basePath%>images/gb2.jpg" alt="2"/></a>
	    	    <a href="ShowStudy.action?playerId=9"><img src="<%=basePath%>images/gb3.jpg" alt="3"/></a>
		        <a href="ShowStudy.action?playerId=14"><img src="<%=basePath%>images/gb4.jpg" alt="4"/></a>
		        <a href="ShowStudy.action?playerId=4"><img src="<%=basePath%>images/gb5.jpg" alt="5"/></a>
			    <a href="ShowStudy.action?playerId=1"><img src="<%=basePath%>images/gb1.jpg" alt="5"/></a>
	     	</div>
			<div id="buttons">
			    <span index="1" class="on"></span>
			    <span index="2"></span>
			    <span index="3"></span>
			    <span index="4"></span>
			    <span index="5"></span>
			</div>
			<a href="javascript:;" id="prev" class="arrow">&lt;</a>
			<a href="javascript:;" id="next" class="arrow">&gt;</a>
	 	</div>

		<!-- 中间（下） -->
		<div class="sentenceDiv">
			<div class="sentence">${sentence}</div>
		</div>
		
		<!-- -------------------------------页面右侧部分（元气值、排行榜部分）------------------------------- -->
	 	<div class="rightPage">
		 	<div class="power">
				<img style="position: relative;left: 73px;top: 24px;" src="<%=basePath%>images/fire3.jpg" alt="1"/>
				<p style="position: relative;top: -9px;left: 130px;width: 120px;">元气值：${WebPower}</p>
			</div>
		 
		 	<div class="lucky">
		 		今日福利：
		 		<c:choose>
		 			<c:when test="${lucky==0}">
		 				无。
		 			</c:when>
		 			<c:when test="${lucky==1}">
		 				战斗获得双倍修为。
		 			</c:when>
		 			<c:when test="${lucky==2}">
		 				战斗获得双倍经验。
		 			</c:when>
		 			<c:when test="${lucky==3}">
		 				正义萌成员攻击提高50%。
		 			</c:when>
		 			<c:when test="${lucky==4}">
		 				魅邪教成员攻击提高50%。
		 			</c:when>
		 			<c:when test="${lucky==5}">
		 				浣月宫成员攻击提高50%。
		 			</c:when>
		 			<c:when test="${lucky==6}">
		 				正义萌成员生命提高100%。
		 			</c:when>
		 			<c:when test="${lucky==7}">
		 				魅邪教成员生命提高100%。
		 			</c:when>
		 			<c:when test="${lucky==8}">
		 				浣月宫成员生命提高100%。
		 			</c:when>
		 			<c:when test="${lucky==9}">
		 				仙剑奇侠们提高20%的攻防体速。
		 			</c:when>
		 			<c:when test="${lucky==10}">
		 				乱世枭雄们提高20%的攻防体速。
		 			</c:when>
		 		</c:choose>
		 	</div>
		 	
		 	<div class="phb">  
				<ul>
					<li style="color: #2464B2;">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名次&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					昵称&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					等级</li></b>
					<li>	&nbsp&nbsp&nbsp<span class="phbRed">1</span>	<a href="ShowStudy.action?playerId=${playerList1[0].id}" class="phbUsername">${playerList1[0].name}</a>	 <div class="phbUserinfo">lv.${playerList1[0].lv}</div> </li>
					<li>	<span class="phbRed">2</span>	<a href="ShowStudy.action?playerId=${playerList1[1].id}" class="phbUsername">${playerList1[1].name}</a>	 <div class="phbUserinfo">lv.${playerList1[1].lv}</div>	</li>
					<li>	<span class="phbRed">3</span>	<a href="ShowStudy.action?playerId=${playerList1[2].id}" class="phbUsername">${playerList1[2].name}</a>	 <div class="phbUserinfo">lv.${playerList1[2].lv}</div>	</li>
					<li>	<span class="phbRed">4</span>	<a href="ShowStudy.action?playerId=${playerList1[3].id}" class="phbUsername">${playerList1[3].name}</a>	 <div class="phbUserinfo">lv.${playerList1[3].lv}</div>	</li>
					<li>	<span class="phbRed">5</span>	<a href="ShowStudy.action?playerId=${playerList1[4].id}" class="phbUsername">${playerList1[4].name}</a>	 <div class="phbUserinfo">lv.${playerList1[4].lv}</div>	</li>
					<li>	<span class="phbRed">6</span>	<a href="ShowStudy.action?playerId=${playerList1[5].id}" class="phbUsername">${playerList1[5].name}</a>	 <div class="phbUserinfo">lv.${playerList1[5].lv}</div>	</li>
					<li>	<span class="phbRed">7</span>	<a href="ShowStudy.action?playerId=${playerList1[6].id}" class="phbUsername">${playerList1[6].name}</a>	 <div class="phbUserinfo">lv.${playerList1[6].lv}</div>	</li>
				</ul>			
				<br><br><br><br><br>			
				&nbsp&nbsp&nbsp&nbsp&nbsp
				<a title="等级排行榜" href="ShowMain.action?ranking=3" style="color:#0D0 ;">世外高人</a>
				&nbsp&nbsp&nbsp&nbsp&nbsp<a title="品剑排行榜" href="ShowMain.action?ranking=4" style="color:red ;">擂台贤者</a>
				&nbsp&nbsp&nbsp&nbsp&nbsp<a title="灵气排行榜" href="ShowMain.action?ranking=1" style="color: #0DD;">仙剑奇侠</a>
				&nbsp&nbsp&nbsp&nbsp&nbsp<a title="煞气排行榜" href="ShowMain.action?ranking=2" style="color: #C0C;">乱世枭雄</a>
			</div>
		</div>
		 	 
	</body>
</html>
