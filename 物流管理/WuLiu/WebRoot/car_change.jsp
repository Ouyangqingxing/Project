<%@ page contentType="text/html; charset=gb2312" import="java.sql.*"%>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="CSS/style.css">
<title>
car_change page
</title>
</head>


<body bgcolor="#ffffff">
<Script language="javascript">
function check()
{
 if(form1.gclass.value=="")
{
 alert("请填写车辆类型：！！");
form1.gclass.focus();
return false;
}
if(form1.gname.value=="")
{
alert("请填写车辆限量！！！");
form1.gname.focus();
return false;
}
if(form1.gcount.value=="")
{
alert("请填写已使用！！！");
form1.gcount.focus();
return false;
}
if(form1.gunit.value=="")
{
alert("请填写驾驶员名称！！！");
form1.gunit.focus();
return false;
}
if(form1.startProvince.value=="")
{
alert("请填写驾驶证驾龄！！！");
form1.startProvince.focue();
return false;
}
if(form1.gstartcity.value=="")
{
alert("请填写驾驶证号码！！！");
form1.gstartcity.focue();
return false;
}
if(form1.endProvince.value=="")
{
alert("请填写驾驶员类型！！！");
form1.endProvince.focus();
return false;
}
if(form1.gendcity.value=="")
{
alert("请填写运输类型！！！");
form1.gendfirm.focus();
return false;
}
if(form1.gtransstyle.value=="")
{
alert("请填写联系电话！！！");
form1.gtransstyle.focue();
return false;
}
if(form1.gtime.value=="")
{
alert("请填写联系人！！！");
form1.gtime.focus();
return false;
}
if(form1.grequest.value=="")
{
alert("请填写发布时间！！！");
form1.grequest.focus();
return false;}
if(form1.gremark.value=="")
{
alert("请填写备注！！！");
form1.gremark.focus();
return false;
}

if(form1.username.value=="")
{
alert("请填写完整发布人名！！！");
form1.grequest.focus();
return false;
}
}
</Script>
<jsp:include page="top.jsp"/>
<p align="center"><b>车辆信息修改</b></p>
<form method="POST" action="car_changeConfig.jsp" name="form1">
<%
int num;
String sql="select * from tb_CarMessage where Code="+request.getParameter("id");
ResultSet rs=connection.executeQuery(sql);
if(rs.next())
{
num=rs.getInt("code");
%>
  <table width="786" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#333333" bordercolorlight="#FFFFFF">
    <tr>
      <td width="20%" height="43">
        <p align="center">车辆类型：</p>
      </td>
      <td width="36%" height="43">
        <p align="center"><input type="text" name="gclass" value=" <%=rs.getString("Style")%>" size="20"></p>
      </td>
      <td width="18%" height="43">
        <p align="center">车辆限量：</p>
      </td>
      <td width="30%" height="43">
        <p align="center"><input type="text" name="gname" size="20" value="<%=rs.getString("CarLoad")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="42">
        <p align="center">已使用：</p>
      </td>
      <td width="36%" height="42">
        <p align="center"><input type="text" name="gcount" size="20"value="<%=rs.getString("UsedTime")%>"></p>
      </td>
      <td width="18%" height="42">
        <p align="center">驾驶员名称：</p>
      </td>
      <td width="30%" height="42">
        <p align="center"><input type="text" name="gunit" size="20" value=" <%=rs.getString("DriverName")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="43">
        <p align="center">驾驶证驾龄：</p>
      </td>
      <td width="36%" height="43">
        <p align="center"><input type="text" name="StartProvince" size="20" value="<%=rs.getString("DriverTime")%>"></p>
      </td>
      <td width="18%" height="43">
        <p align="center">驾驶证号码：</p>
      </td>
      <td width="30%" height="43">
        <p align="center"><input type="text" name="StartCity" size="20" value="<%=rs.getString("LicenceNumber")%>"></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="46">
        <p align="center">驾驶员类型：</p>
      </td>
      <td width="36%" height="46">
        <p align="center"><input type="text" name="EndProvince" size="20" value="<%=rs.getString("LicenceStyle")%>"></p>
      </td>
      <td width="18%" height="46">
        <p align="center">运输类型：</p>
      </td>
      <td width="30%" height="46">
        <p align="center"><input type="text" name="EndCity" size="20" value="<%=rs.getString("TranspotStyle")%>"></p>
      </td>
    </tr>

    <tr>
      <td width="20%" height="45">
        <p align="center">联系电话></p>
      </td>
      <td width="36%" height="45">
        <p align="center"><input type="text" name="gphone" size="20" value="<%=rs.getString("LinkPhone")%>"></p>
      </td>
      <td width="18%" height="45">
        <p align="center">联系人：</p>
      </td>
      <td width="30%" height="45">
        <p align="center"><input type="text" name="glink" size="20"value="<%=rs.getString("LinkMan")%>"></p>
      </td>
    </tr>
 <tr>
      <td width="20%" height="40"  c>
        <p align="center">发布时间：</td>
      <td width="36%" height="40" colspan="3">
       <input type="text" name="dd" size="20" value="<%=rs.getDate("IssueDate")%>">
       </td>
    </tr>
    <tr>
      <td width="20%" height="78">
        <p align="center">备注：</p>
      </td>
      <td width="84%" height="78" colspan="3">
        <p align="left"><textarea rows="5" name="gremark" cols="80"><%=rs.getString("Remark")%></textarea></p>
      </td>
    </tr>
    <tr>
      <td width="20%" height="33">
      <p align="center">发布人：</td>
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
        <input type="submit" name="change" value="修改" onClick="return check()">
       <input type="reset" value="重置">
     </td>
    </tr>
  </table>
<%}%>
</form>
</body>
</html>
