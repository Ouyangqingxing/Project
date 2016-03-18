<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:directive.page import="com.wy.CountTime"/>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
    	System.out.print("yyy");
    	String question="";
    	String name=request.getParameter("name");
    	System.out.print(name);
    	String str="select Question from tb_Customar where Name='"+name+"'";
    	ResultSet rs=connection.executeQuery(str);
    	if(rs.next()){
    		question=rs.getString(1);
    		System.out.print(question);
    		response.getWriter().write(question);
    		response.getWriter().print(question);
    	}
    	
     %>
    

  </head>
  
  <body>
  </body>
</html>
