<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../CSS/style.css">
<title>
Manager_index page
</title>
</head>
<body bgcolor="#ffffff">
<%
String login=(String)session.getAttribute("login");
String username=(String)session.getAttribute("name");
String pow=(String)session.getAttribute("pow");
String pow1="1";
if(login==null || pow.trim().equals(pow1))
{
%>
<script language="javascript">
alert("您未登录或权限不够");
window.location.href="../index.jsp";
</script>
<%
}
%>
<jsp:include page="mtop.jsp" flush="true"></jsp:include>

<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" background="../image/bg-8.jpg" >
  <tr>
    <td><div align="center"><img src="../image/bg-7.jpg" width="793" height="493"><%=pow%></div></td>
  </tr>
</table>
</body>
</html>
