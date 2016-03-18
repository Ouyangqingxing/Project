<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title></title>
<Script language="javascript">
function check1()
{
if(form_u.name.value=="")
{
alert("请添入姓名");
form_u.name.focus();
return false;
}
if(form_u.password.value=="")
{
alert("请添入密码");
form_u.password.focus();
return false;
}
}
</Script>
<%!
ResultSet rs1=null ,goodrs=null;
String sql,goodsql,placardsql,esql,login,username,pow;
int code,gcode;
%>

<body  link="#669900" alink="#FFCC66" vlink="#FF3300">

<jsp:include page="top.jsp"/>
<table width="786" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="202" height="255" valign="top" background="image/8.jpg">	
	
	<jsp:include page="left.jsp" flush="true" /></td>
    <td width="484" valign="top"><table width="100" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="image/13.jpg" width="370" height="39"></td>
      </tr>
    </table>
      <table width="370"  border="0" cellpadding="0" cellspacing="0" background="image/14.jpg">
        <tr>
          <td valign="top">
		  
		  <table width="370" border="0" cellpadding="0" cellspacing="0">
<%
goodsql="select top 8 ID,GoodsStyle,GoodsName,StartProvince,StartCity,EndProvince,EndCity,Style,UserName from tb_GoodsMeg order by IssueDate desc";
try{
rs1=connection.executeQuery(goodsql);
while(rs1.next()){
gcode=rs1.getInt("ID");
%>
            <tr>
              <td width="36" height="25">&nbsp;</td>
              <td width="334"><a href="goods_xiangxi.jsp?id=<%=gcode%>">
			<%=rs1.getString("GoodsStyle")%>--<%=rs1.getString("GoodsName")%>- -<%=rs1.getString("StartProvince")%>- -<%=rs1.getString("StartCity")%>- -<%=rs1.getString("EndProvince")%>- -<%=rs1.getString("EndCity")%> 
					</a></td>
            </tr>
<%
}
}catch(Exception e)
{e.printStackTrace();}
%>
			    <tr>
              <td width="36" height="25">&nbsp;</td>
              <td width="334" align="right"><a href="goods_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
            </tr>
          </table>		  		  </td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="image/16.jpg" width="370" height="23"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="image/17.jpg">
                <%
sql="select top 8 Code,TradeMark,Brand,Style,CarLoad,TranspotStyle,UserName from tb_CarMessage order by IssueDate desc";
 try
{
 rs1=connection.executeQuery(sql);
while(rs1.next())
{
code=rs1.getInt("Code");
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="car_show.jsp?id=<%=code%>"><%=rs1.getString("TradeMark")%>- -<%=rs1.getString("Brand")%> - -<%=rs1.getString("Style")%>--<%=rs1.getString("CarLoad")%>吨- -<%=rs1.getString("TranspotStyle")%></td>
        </tr>
        <%
}
}catch(Exception e)
{e.printStackTrace();}
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="car_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table>
      <table width="100" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><img src="image/18.jpg" width="370" height="29"></td>
        </tr>
      </table>
      <table width="370" border="0" cellpadding="0" cellspacing="0" background="image/19.jpg">
                  <%
sql="select top 7 ID,EnterpriseSort,EnterpriseName,Operation,WorkArea,Address,UserName from tb_Enterprise order by IssueDate desc";
 try
{
 rs1=connection.executeQuery(sql);
while(rs1.next())
{
code=rs1.getInt("ID");
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334"><a href="enterprise_show.jsp?id=<%=code%>"> <%=rs1.getString("EnterpriseSort")%>- -<%=rs1.getString("EnterpriseName")%>- -<%=rs1.getString("Operation")%>- -<%=rs1.getString("WorkArea")%>
					  </a>     </td>
        </tr>
        <%
}
}catch(Exception e)
{e.printStackTrace();}
%>
        <tr>
          <td width="36" height="25">&nbsp;</td>
          <td width="334" align="right"><a href="enterprise_select.jsp">&nbsp;>>>更多信息&nbsp;&nbsp;&nbsp;</a></td>
        </tr>
      </table></td><!--存放中间的代码-->
    <td valign="top" width="215" background="image/12.jpg"><jsp:include page="right.jsp" flush="true" /></td>
  </tr>
</table><jsp:include page="down.jsp" flush="true" />

</body>

</html>
