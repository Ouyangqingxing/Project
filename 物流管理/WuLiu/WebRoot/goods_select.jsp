<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
Goods_show page
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
alert("您还未登录，不能浏览详细信息！！！");
</script>
<%
response.sendRedirect("login.jsp");
}
%>   <jsp:include page="top.jsp"/>
<table width="786"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
<tr>
  <td width="786" colspan="9">
  
      <p align="center">货物信息
    </td>
  </tr>
  <tr>
    <td width="786" height="30" colspan="9" align="right"><a href="goods_add.jsp">发布信息...</a></td>
  </tr>
  <tr align="center">
    <td width="786" height="29" align="center">货物类型</td>
    <td width="786" height="29" align="center">货物名称</td>
    <td width="786" height="29" align="center">货物数量</td>
    <td width="786" height="29" align="center">数量单位</td>
    <td width="786" height="29" align="center">起始省份</td>
    <td width="786" height="29" align="center">起始城市</td>
    <td width="786" height="29" align="center">抵达省份</td>
    <td width="786" height="29" align="center">抵达城市</td>
    <td width="786" height="29">操作</td>
  </tr>
<%
    sql="select * from tb_GoodsMeg order by IssueDate desc";
try
{
 rs=connection.executeQuery(sql);
if(!rs.next())
{
%>
<script language="javascript">
	alert("没有货物信息");
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
n=rs.getInt("ID");
%>
<tr>
<td width="786" height="29" align="center"><%=rs.getString("GoodsStyle")%></td>
<td width="786" height="29" align="center"><%=rs.getString("GoodsName")%></td>
<td width="786" height="29" align="center"><%=rs.getString("GoodsNumber")%></td>
<td width="786" height="29" align="center"><%=rs.getString("GoodsUnit")%></td>
<td width="786" height="29" align="center"><%=rs.getString("StartProvince")%></td>
<td width="786" height="29" align="center"><%=rs.getString("StartCity")%></td>
<td width="786" height="29" align="center"><%=rs.getString("EndProvince")%></td>
<td width="786" height="29" align="center"><%=rs.getString("EndCity")%></td>
<td width="786" height="29"> <p align="center">
  <a href="goods_xiangxi.jsp?id=<%=n%>">详细</a></td>
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
        共<%=pagecount%>页&nbsp;&nbsp;
        <a href="goods_select.jsp?topage=<%=1%>">第一页</a>&nbsp;&nbsp;
        <a href="goods_select.jsp?topage=<%=showpage-1%>">上一页</a>&nbsp;&nbsp;
        <a href="goods_select.jsp?topage=<%=showpage+1%>">下一页</a>&nbsp;&nbsp;
        <a href="goods_select.jsp?topage=<%=pagecount%>">最后一页</a>
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
