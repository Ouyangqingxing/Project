<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>趣学习!去超越!(≧▽≦)y </title>
  </head>

  <frameset rows="61px,*,50px" frameborder="no" framespacing="0" > 
    <frame src="public/header.jsp"  name="header" scrolling="no"></frame>
    <frame src="ShowMain.action" name="mainFrame"></frame>
    <frame src="public/footer.jsp"  name="bottom" scrolling="no"></frame>
  </frameset>
</html>

