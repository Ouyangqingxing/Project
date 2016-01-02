<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
    	<base href="<%=basePath%>">
    	<title>Welcome!</title>
    	<link rel="stylesheet" type="text/css" href="css/index.css"/>
    	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    	<script type="text/javascript" src="js/index.js"></script>
  	</head>
  
  	<body>
  		<div id="indexFont1">
	        <img src= "images/indexFont1.png"  id="indexFont1"  alt="图片1"   title="welcome" />    
    	</div>
    	
    	<div id="indexFont2">
	        <a href="page.jsp"><img src= "images/indexFont2.png"  id="indexFont2"  alt="图片2"   title="click" /></a>    
    	</div>
    	
    	<div id="indexCentre">
		  	<img src= "images/indexCentre.jpg"  id="indexCentre"  alt="indexCentre"   title="据说，入口不止一个" />
		</div>
		
		<div id="indexGhost">
		  	<a href="hide.jsp"><img src= "images/indexGhost.gif"  id="indexGhost"  alt="indexGhost"/></a>
		</div>
		
		<div id="indexUFO">
		  	<img src= "images/UFO.gif"  id="indexUFO"  alt="indexUFO"/>
		</div>
		
		<div id="indexStar1">
		  	<img src= "images/star1.jpg"  id="indexStar1"  alt="indexStar1"/>
		</div>
		
		<div id="indexStar2">
		  	<img src= "images/star2.jpg"  id="indexStar2"  alt="indexStar2"/>
		</div>
		
		<div id="indexStar3">
		  	<img src= "images/star3.jpg"  id="indexStar3"  alt="indexStar3"/>
		</div>
		
		<div id="indexStar4">
		  	<img src= "images/star4.jpg"  id="indexStar4"  alt="indexStar4"/>
		</div>
		
    	
    	<div id="indexBottom">
		  	<img src= "images/indexBottom.png"  id="indexBottom"  alt="图片4"   title="haha" width="1340" height="187" />
		</div>
    	
  </body>
</html>
