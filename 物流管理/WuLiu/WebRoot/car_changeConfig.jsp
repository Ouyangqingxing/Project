<%@ page contentType="text/html; charset=GBK" import="java.sql.*,java.util.Date"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<title>
car_change_config page
</title>
</head>
<body bgcolor="#ffffff">
<%!
Date date=new Date();
String sql;
ResultSet rs;
%>
<%
request.setCharacterEncoding("gb2312");

String gclass=request.getParameter("gclass");
String gname=request.getParameter("gname");
String gcount=request.getParameter("gcount");
String gunit=request.getParameter("gunit");
String startProvince=request.getParameter("StartProvince");
String gstartcity=request.getParameter("StartCity");
String endProvince=request.getParameter("EndProvince");
String gendcity=request.getParameter("EndCity");
String gtransstyle=request.getParameter("gtransstyle");
String gtime=request.getParameter("gtime");
String glink=request.getParameter("glink");
String gphone=request.getParameter("gphone");
String gremark=request.getParameter("gremark");
String grequest=request.getParameter("grequest");
String username=request.getParameter("username");
String text=request.getParameter("dd");
String code=request.getParameter("code");
java.sql.Date gshowdate=new java.sql.Date(date.getYear(),date.getMonth(),date.getDate());

sql="update tb_CarMessage set Style='"+
    gclass+"',CarLoad='"+gname+"',UsedTime='"+gcount+"',DriverName='"+
    gunit+"',DriverTime='"+startProvince+"',LicenceNumber='"+
    gstartcity+"',LicenceStyle='"+endProvince+"',TranspotStyle='"+gendcity+"',LinkPhone='"+
    gphone+"',LinkMan='"+glink+"',IssueDate='"+gshowdate+"',Remark='"+
    gremark+"',UserName='"+
    username+"' where code="+request.getParameter("code");
	
	
boolean sert=connection.executeUpdata(sql);


if(sert)
{%>
<script language="javascript">
alert("您输入的货物信息已经成功修改！！！");
</script>
<%
response.sendRedirect("car_select.jsp");
}else
{
%>
<script language="javascript">
alert("您输入的货物信息修改失败！！！");
history.back();
</script>
<%
}
%>
</body>
</html>
