<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
Car_show page
</title>
</head>
<%!
ResultSet rs=null;
String sql,sqlshow;
String username,login;
int pagesize=10;
int rowcount=0;
int pagecount=1,n;
%>
<body bgcolor="#ffffff">
<%
login=(String)session.getAttribute("login");
 username=(String)session.getAttribute("name");
if(login==null)
{
%>
<script language="javascript">
alert("����δ��¼�����������ϸ��Ϣ������");
</script>
<%
response.sendRedirect("login.jsp");
}
%>   <jsp:include page="top.jsp"/>
<table width="786"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
<tr>
  <td width="786" colspan="9">
  
      <p align="center">������Ϣ
    </td>
  </tr>

  <tr align="center">
    <td width="786" height="29" align="center">���ƺ���</td>
    <td width="786" height="29" align="center">����Ʒ��</td>
    <td width="786" height="29" align="center">����</td>
    <td width="786" height="29" align="center">��������</td>
    <td width="786" height="29" align="center">��ʹ��</td>
    <td width="786" height="29" align="center">��ʻԱ����</td>
    <td width="786" height="29" align="center">��������</td>

    <td width="786" height="29">����</td>
  </tr>
<%
    sql="select * from tb_CarMessage order by IssueDate desc";
try
{
 rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("û�г�����Ϣ");
</script>
<%
}else
{
rs.last();
rowcount=rs.getRow();
int showpage=1;
pagecount=((rowcount%pagesize)==0?(rowcount/pagesize):(rowcount/pagesize)+1);
 String topage=request.getParameter("topage");
if(topage!=null)
{
showpage=Integer.parseInt(topage);
if(showpage>pagecount){
  showpage=pagecount;
  }else if(showpage<=0){
  showpage=1;
  }
}
rs.absolute((showpage-1)*pagesize+1);
for(int i=1;i<=pagesize;i++)
{
n=rs.getInt("Code");
%>
<tr>
<td width="786" height="29" align="center"><%=rs.getString("LicenceNumber")%></td>
<td width="786" height="29" align="center"><%=rs.getString("Brand")%></td>
<td width="786" height="29" align="center"><%=rs.getString("Style")%></td>
<td width="786" height="29" align="center"><%=rs.getString("CarLoad")%></td>
<td width="786" height="29" align="center"><%=rs.getString("UsedTime")%></td>
<td width="786" height="29" align="center"><%=rs.getString("DriverTime")%></td>
<td width="786" height="29" align="center"><%=rs.getString("TranspotStyle")%></td>

<td width="786" height="29"> <p align="center">
  <a href="car_xiangxi.jsp?id=<%=n%>">��ϸ</a></td>
</tr>
<%
if(!rs.next())
break;
}
%>
<tr>
    <td width="786" height="30" colspan="9" align="right">

<table width="786" align="center">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
        ��<%=pagecount%>ҳ&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=showpage-1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=showpage+1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="car_select.jsp?topage=<%=pagecount%>">���һҳ</a>
</td>
</tr>
</table>
</td>
  </tr>
<%
}
}catch(Exception e)
{e.printStackTrace();}
%>
</table>
</body>
</html>
