<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
placard page
</title>
</head>
<%!
ResultSet rs=null;
String sql;
int code;
int pagesize=10;
int rowcount=0;
int pagecount=1;
%>

<body bgcolor="#ffffff">
<%
String login=(String)session.getAttribute("login");
String username=(String)session.getAttribute("name");
if(login==null)
{
%>
<script language="javascript">
alert("����δ��¼�����������ϸ��Ϣ������");
<%
response.sendRedirect("login.jsp");
%>
</script>
<%}
%><jsp:include page="top.jsp"/>
<table width="785" height="117" border="1" align="center" cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td height="38" align="center" colspan="6">��̬��Ϣ</td>
  </tr>
  <tr>
    <td width="108" height="29" align="center">ID</td>
    <td width="108" height="29" align="center">����</td>
    <td width="108" height="29" align="center">����</td>
    <td width="209" height="29" align="center">��������</td>
    <td width="245" height="29" align="center">����</td>
   
  </tr>
<%

sql="select ID,Title,Author,IssueDate from tb_logistics ";
try
{
rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("û����Ϣ");
    history.back();
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
code=rs.getInt("ID");
%>
 <tr>
    <td width="108" height="32" align="center"><%=code%></td>
    <td width="108" height="32" align="center"><%=rs.getString("Title")%></td>
    <td width="108" height="32" align="center"><%=rs.getString("Author")%></td>
    <td width="209" height="32" align="center"><%=rs.getDate("IssueDate")%></td>
    <td width="245" height="32" align="center">
   <a href="#"onClick="window.open('active_show.jsp?id=<%=code%>','','width=790,height=530');">��ϸ</a></td>  
  </tr>
<%
if(!rs.next())
break;
}
%>
<tr>
    <td height="30" colspan="9" align="right">

<table width="786" align="center" cellpadding="0" cellspacing="0">
	<tr>
    <td width="786" height="30" colspan="9" align="right">
��<%=pagecount%>ҳ&nbsp;&nbsp;
        <a href="active_select.jsp?topage=<%=1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="active_select.jsp?topage=<%=showpage-1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="active_select.jsp?topage=<%=showpage+1%>">��һҳ</a>&nbsp;&nbsp;
        <a href="active_select.jsp?topage=<%=pagecount%>">���һҳ</a>
    
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
