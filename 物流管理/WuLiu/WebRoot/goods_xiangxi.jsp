<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
Goods_xiangxi page

</title>
</head>
<%!
ResultSet rs=null;
String sql;
String code,userName;
String username,login;
int num;
%>

<body bgcolor="#ffffff">
<%
code=request.getParameter("id");
sql="select * from tb_GoodsMeg where ID="+code;

login=(String)session.getAttribute("login");
username=(String)session.getAttribute("name");
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
%>
<jsp:include page="top.jsp"/>
<table width="785" height="480" border="1" align="center" cellpadding="0" cellspacing="0"bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
  <tr>
    <td width="100%" height="52" colspan="4" align="center">
  ������ϸ��Ϣ</td>
  </tr>
<%try
{
rs=connection.executeQuery(sql);
if(rs.next())
{
%>
<tr>
    <td width="17%" height="29" align="center">�������ͣ�</td>
    <td width="36%" height="29" align="center"><%=rs.getString("GoodsStyle")%></td>
    <td width="17%" height="29" align="center" valign="middle">�������ƣ�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("GoodsName")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">����������</td>
    <td width="36%" height="29" align="center"><%=rs.getString("GoodsNumber")%> </td>
    <td width="17%" height="29" align="center" valign="middle">������λ��</td>
    <td width="30%" height="29" align="center">  <%=rs.getString("GoodsUnit")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">��ʼʡ�ݣ�</td>
    <td width="36%" height="29" align="center"><%=rs.getString("StartProvince")%></td>
    <td width="17%" height="29" align="center" valign="middle">��ʼ���У�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("StartCity")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">�ִ�ʡ�ݣ�</td>
    <td width="36%" height="29" align="center"><%=rs.getString("EndProvince")%></td>
    <td width="17%" height="29" align="center" valign="middle">�ִ���У�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("EndCity")%></td>
  </tr>
  <tr>
    <td width="17%" height="30" align="center">�������ͣ�</td>
    <td width="36%" height="30" align="center"> <%=rs.getString("Style")%></td>
    <td width="17%" height="30" align="center" valign="middle">����ʱ�䣺</td>
    <td width="30%" height="30" align="center"> <%=rs.getString("TransportTime")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">��ϵ�绰��</td>
    <td width="36%" height="29" align="center"><%=rs.getString("Phone")%></td>
    <td width="17%" height="29" align="center" valign="middle">��ϵ�ˣ�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("Link")%> </td>
  </tr>
  <tr>
    <td width="17%" height="31" align="center">����ʱ�䣺</td>
    <td width="36%" height="31" align="left" colspan="3"><%=rs.getDate("IssueDate")%></td>

  </tr>
  <tr>
    <td width="17%" height="1" align="center">��ע��</td>
    <td width="83%" height="1" align="center" colspan="3">
      <p align="left"><textarea rows="3" name="S1" cols="76"><%=rs.getString("Remark")%></textarea></td>
  </tr>
  <tr>
    <td width="17%" height="52" align="center">����Ҫ��</td>
    <td width="83%" height="52" align="center" colspan="3">
      <p align="left"><textarea rows="3" name="S1" cols="76"><%=rs.getString("Request")%></textarea></td>
  </tr>
<tr>
 <%
userName=rs.getString("UserName");
 %>
    <td width="17%" height="31" align="center">�����ˣ�</td>
    <td width="36%" height="31" align="left" colspan="3"><%=userName%></td>
  
  </tr>
<%
if(userName.equals(username))
   {
   %>
    <tr>
      <td width="100%" height="45" colspan="4" align="center">
        <a href="goods_change.jsp?id=<%=code%>">�޸�</a>&nbsp;&nbsp;
        <a href="goods_delete.jsp?id=<%=code%>">ɾ��</a></td>
  </tr>

<%
   }

}

}catch(SQLException e)
{
 System.out.print("��ѯ�쳣����");
}

%>
</table>
</body>
</html>
