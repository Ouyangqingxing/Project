<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
Goods_change page
</title>
</head>
<Script language="javascript">
function check()
{
 if(form1.gclass.value=="")
{
 alert("����д�������ͣ���");
form1.gclass.focus();
return false;
}
if(form1.gname.value=="")
{
alert("����д�������ƣ�����");
form1.gname.focus();
return false;
}
if(form1.gcount.value=="")
{
alert("����д��������������");
form1.gcount.focus();
return false;
}
if(form1.gunit.value=="")
{
alert("����д����������λ������");
form1.gunit.focus();
return false;
}
if(form1.startProvince.value=="")
{
alert("����д��ʼʡ�ݣ�����");
form1.startProvince.focue();
return false;
}
if(form1.gstartcity.value=="")
{
alert("����д��ʼ���У�����");
form1.gstartcity.focue();
return false;
}
if(form1.endProvince.value=="")
{
alert("����д�ִ�ʡ�ݣ�����");
form1.endProvince.focus();
return false;
}
if(form1.gendcity.value=="")
{
alert("����д�ִ���У�����");
form1.gendfirm.focus();
return false;
}
if(form1.gtransstyle.value=="")
{
alert("����д�������ͣ�����");
form1.gtransstyle.focue();
return false;
}
if(form1.gtime.value=="")
{
alert("����д����ʱ�䣡����");
form1.gtime.focus();
return false;
}
if(form1.glink.value=="")
{alert("����д��ϵ�ˣ�����");
form1.glink.focus();
return false;
}
if(form1.gphone.value=="")
{
alert("����д��ϵ�绰������");
form1.gphone.focus();
return false;
}
if(form1.gremark.value=="")
{
alert("����д��ע������");
form1.gremark.focus();
return false;
}
if(form1.grequest.value=="")
{
alert("����дҪ�󣡣���");
form1.grequest.focus();
return false;}
if(form1.username.value=="")
{
alert("����д������������������");
form1.grequest.focus();
return false;
}
}
</Script>

<body bgcolor="#ffffff"><jsp:include page="top.jsp"/>
<p align="center"><b>������Ϣ�޸�</b></p>
<form method="POST" action="goods_changeConfig.jsp" name="form1">
<%
int num;
String sql="select * from tb_GoodsMeg where ID="+request.getParameter("id");
ResultSet rs=connection.executeQuery(sql);
if(rs.next())
{
num=rs.getInt("ID");
%>
  <table width="786" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
      <td width="20%" height="43">
        <p align="center">�������ͣ�</p>
      </td>
      <td width="36%" height="43">
        <p align="center"><input type="text" name="gclass" value=" <%=rs.getString("GoodsStyle")%>" size="20"></p>
      </td>
      <td width="18%" height="43">
        <p align="center">�������ƣ�</p>
      </td>
      <td width="30%" height="43">
        <p align="center"><input type="text" name="gname" size="20" value="<%=rs.getString("GoodsName")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="42">
        <p align="center">����������</p>
      </td>
      <td width="36%" height="42">
        <p align="center"><input type="text" name="gcount" size="20"value="<%=rs.getString("GoodsNumber")%>"></p>
      </td>
      <td width="18%" height="42">
        <p align="center">������λ��</p>
      </td>
      <td width="30%" height="42">
        <p align="center"><input type="text" name="gunit" size="20" value=" <%=rs.getString("GoodsUnit")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="43">
        <p align="center">��ʼʡ�ݣ�</p>
      </td>
      <td width="36%" height="43">
        <p align="center"><input type="text" name="StartProvince" size="20" value="<%=rs.getString("StartProvince")%>"></p>
      </td>
      <td width="18%" height="43">
        <p align="center">��ʼ���У�</p>
      </td>
      <td width="30%" height="43">
        <p align="center"><input type="text" name="StartCity" size="20" value="<%=rs.getString("StartCity")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="46">
        <p align="center">�ִ�ʡ�ݣ�</p>
      </td>
      <td width="36%" height="46">
        <p align="center"><input type="text" name="EndProvince" size="20" value="<%=rs.getString("EndProvince")%>"></p>
      </td>
      <td width="18%" height="46">
        <p align="center">�ִ���У�</p>
      </td>
      <td width="30%" height="46">
        <p align="center"><input type="text" name="EndCity" size="20" value="<%=rs.getString("EndCity")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="45">
        <p align="center">�������ͣ�</p>
      </td>
      <td width="36%" height="45">
      <p align="center">
      &nbsp; <select size="1" name="gtransstyle">
        <option value="��ͨ" selected>��ͨ</option>
        <option value="����">����</option>
        <option value="�ؿ�">�ؿ�</option>
        <option value="�Ӽ�">�Ӽ�</option>
       </select>
      </p>
      </td>
      <td width="18%" height="45">
        <p align="center">����ʱ�䣺</p>
      </td>
      <td width="30%" height="45">
        <p align="center"><input type="text" name="gtime" size="20" value="<%=rs.getString("TransportTime")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="45">
        <p align="center">��ϵ�绰></p>
      </td>
      <td width="36%" height="45">
        <p align="center"><input type="text" name="gphone" size="20" value="<%=rs.getString("Phone")%>"></p>
      </td>
      <td width="18%" height="45">
        <p align="center">��ϵ�ˣ�</p>
      </td>
      <td width="30%" height="45">
        <p align="center"><input type="text" name="glink" size="20"value="<%=rs.getString("Link")%>"></p>
      </td>
    </tr>
 <tr>
      <td width="20%" height="40"  c>
        <p align="center">����ʱ�䣺</td>
      <td width="36%" height="40" colspan="3">
       <input type="text" name="dd" size="20" value="<%=rs.getDate("IssueDate")%>">
       </td>
    </tr>
    <tr>
      <td width="20%" height="78">
        <p align="center">��ע��</p>
      </td>
      <td width="84%" height="78" colspan="3">
        <p align="left"><textarea rows="5" name="gremark" cols="80"><%=rs.getString("Remark")%></textarea></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="74">
        <p align="center">����Ҫ��</p>
      </td>
      <td width="84%" height="74" colspan="3">
        <p align="left"><textarea rows="5" name="grequest" cols="80"><%=rs.getString("Request")%></textarea></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="33">
      <p align="center">�����ˣ�</td>
      <td width="36%" height="33">
      <p align="center"><input type="text" name="username" size="20" value="<%=rs.getString("UserName")%>"></td>
       <td width="20%" height="33">
      <p align="center">ID</td>
	   <td width="20%" height="33">
      <p align="center"><%=num%><input type="hidden" name="code" value="<%=num%>"></p>      </td>
    </tr>
    <tr>
      <td width="786" height="40" colspan="4">
        <p align="center">
        <input type="submit" name="change" value="�޸�" onClick="return check()">
       <input type="reset" value="����">
     </td>
    </tr>
  </table>
<%}%>
</form>
</body>
</html>
