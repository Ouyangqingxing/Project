<%@ page contentType="text/html; charset=GBK" import="java.sql.*,java.util.Date"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<title>
Good_config page
</title>
</head>
<%!
Date date=new Date();
String sql;
ResultSet rs;
%>
<%
request.setCharacterEncoding("gb2312");
String gname=request.getParameter("gname");
String gclass=request.getParameter("gclass");
String gcount=request.getParameter("gcount");
String gunit=request.getParameter("gunit");
String startProvince=request.getParameter("startProvince");
String gstartcity=request.getParameter("gstartcity");
String endProvince=request.getParameter("endProvince");
String gendcity=request.getParameter("gendcity");
String gtransstyle=request.getParameter("gtransstyle");
String gtime=request.getParameter("gtime");
String glink=request.getParameter("glink");
String gphone=request.getParameter("gphone");
String gremark=request.getParameter("gremark");
String grequest=request.getParameter("grequest");
String username=(String)session.getAttribute("name");
java.sql.Date gshowdate=new java.sql.Date(date.getYear(),date.getMonth(),date.getDate());
sql="insert into tb_GoodsMeg values('"+gclass+"','"+
    gname+"','"+gcount+"','"+gunit+"','"+startProvince+"','"+
    gstartcity+"','"+endProvince+"','"+gendcity+"','"+
    gtransstyle+"','"+gtime+"','"+gphone+"','"+
    glink+"','"+gshowdate+"','"+gremark+"','"+grequest+"','"+username+"')";
	
boolean sert=connection.executeUpdata(sql);
if(sert)
{%>
<script language="javascript">
alert("������Ļ�����Ϣ�Ѿ��ɹ���ɣ�����");
</script>
<%
response.sendRedirect("goods_select.jsp");
}else
{
%>
<script language="javascript">
alert("������Ļ�����Ϣ����ʧ�ܣ�����");
</script>
<%
response.sendRedirect("goods_add.jsp");
}
%>
<body bgcolor="#ffffff">
</body>
</html>
