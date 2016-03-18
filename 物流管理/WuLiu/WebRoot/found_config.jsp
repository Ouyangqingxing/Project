<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ page import="java.util.Date,java.sql.*"%>
<jsp:directive.page import="com.wy.CountTime"/>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<title>
found_config
</title>
</head>
<% request.setCharacterEncoding("gb2312"); %>
<body bgcolor="#ffffff">

<%
	Date date=new Date();
    String name=request.getParameter("name");

    String str="select Password from tb_customar where Name='"+name+"'";
	ResultSet rs=connection.executeQuery(str);
	if(rs.next()){

			String password = rs.getString(1);
		
 %>
	
<script language="javascript">
	alert("你的密码为："+<%=password%>);
	window.location.href="index.jsp";
	</script>

<%
	}else{
		%>
<script language="javascript">
	alert("没有这个用户名");
	window.location.href="found.jsp";
	</script>

<%
}
%>
</body>
</html>
