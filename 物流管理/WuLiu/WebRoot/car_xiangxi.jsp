<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
car_xiangxi page

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
sql="select * from tb_CarMessage where code="+code;

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
  ������Ϣչʾ</td>
  </tr>
<%try
{
rs=connection.executeQuery(sql);
if(rs.next())
{
%>
<tr>
    <td width="17%" height="29" align="center">���ƺ��룺</td>
    <td width="36%" height="29" align="center"><%=rs.getString("TradeMark")%></td>
    <td width="17%" height="29" align="center" valign="middle">����Ʒ����</td>
    <td width="30%" height="29" align="center"><%=rs.getString("Brand")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">�������ͣ�</td>
    <td width="36%" height="29" align="center"><%=rs.getString("Style")%> </td>
    <td width="17%" height="29" align="center" valign="middle">����������</td>
    <td width="30%" height="29" align="center">  <%=rs.getString("CarLoad")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">��ʹ�ã�</td>
    <td width="36%" height="29" align="center"><%=rs.getString("UsedTime")%></td>
    <td width="17%" height="29" align="center" valign="middle">��ʻԱ���ƣ�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("DriverName")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">��ʻԱ���䣺</td>
    <td width="36%" height="29" align="center"><%=rs.getString("DriverTime")%></td>
    <td width="17%" height="29" align="center" valign="middle">��ʻ֤���룺</td>
    <td width="30%" height="29" align="center"><%=rs.getString("LicenceNumber")%></td>
  </tr>
  <tr>
    <td width="17%" height="30" align="center">�˼�ʻԱ���ͣ�</td>
    <td width="36%" height="30" align="center"> <%=rs.getString("LicenceStyle")%></td>
    <td width="17%" height="30" align="center" valign="middle">�������ͣ�</td>
    <td width="30%" height="30" align="center"> <%=rs.getString("TranspotStyle")%></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">��ϵ�绰��</td>
    <td width="36%" height="29" align="center"><%=rs.getString("LinkPhone")%></td>
    <td width="17%" height="29" align="center" valign="middle">��ϵ�ˣ�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("LinkMan")%> </td>
  </tr><tr>
    <td width="17%" height="1" align="center">��ע��</td>
    <td width="83%" height="1" align="center" colspan="3">
      <p align="left"><textarea rows="3" name="S1" cols="76"><%=rs.getString("Remark")%></textarea></td>
  </tr>
  <tr>
    <td width="17%" height="29" align="center">����ʱ�䣺</td>
    <td width="36%" height="29" align="center"><%=rs.getString("IssueDate")%></td>
    <td width="17%" height="29" align="center" valign="middle">�����ˣ�</td>
    <td width="30%" height="29" align="center"><%=rs.getString("UserName")%></td>
  </tr>

 <%
userName=rs.getString("UserName");
 %>

<%
if(1 == 1)
   {
   %>
    <tr>
      <td width="100%" height="45" colspan="4" align="center">
        <a href="car_change.jsp?id=<%=code%>">�޸�</a>&nbsp;&nbsp;
        <a href="car_delete.jsp?id=<%=code%>">ɾ��</a></td>
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
