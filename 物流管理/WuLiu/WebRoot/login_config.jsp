<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<title>login_config</title>
</head>
<%
ResultSet rs=null;
request.setCharacterEncoding("gb2312");
String name=request.getParameter("name");
String password=request.getParameter("password");
if(name==""&&name==null&&password==""&&password==null)
{
%>
<jsp:forward page="index.jsp"/>
<%}
else{
try
{
String sql="select * from tb_Customar where Name='"+name+"' and Password='"+password+"'";
rs = connection.executeQuery(sql);
if(rs.next())
{
String Name=rs.getString("Name");
String pow=rs.getString("pow");
session.setAttribute("name",Name);
session.setAttribute("pow",pow);
session.setAttribute("login","success");
%>
<script language="javascript">
alert("µÇÂ¼³É¹¦£¡£¡£¡");
window.location.href="index.jsp";
</script>
<%
}
else
{
%>
<script language="javascript">
alert("µÇÂ¼Ê§°Ü£¡£¡£¡");
history.back();
</script>
<%
}
}catch(Exception e)
{
System.out.println("Á¬½ÓÒì³£login_config");
}
}
%>
<body bgcolor="#ffffff">
</body>
</html>
