<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<title>
register
</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css" rel="stylesheet">
</head>
<script language="javascript">
      function check(){
		if(form1.name.value==""){
			alert("����������û���");
			form1.name.focus();
			return false;
		}
				if(form1.password.value==""){
			alert("��������ע�������");
			form1.password.focus();
			return false;
		}
		if(form1.repassword.value==""){
			alert("������ȷ������");
			form1.repassword.focus();
			return false;
		}
		if(form1.password.value!=form1.repassword.value){
			alert("��������������벻һ��");
			return false;
		}
		if(form1.email.value==""){
			alert("���������Emailַ");
			form1.email.focus();
			return false;
		}


		if(form1.phone.value==""){
			alert("�����������ϵ�绰");
			form1.phone.focus();
			return false;
		}
		if(form1.question.value==""){
			alert("����������ʾ�������ȡ������");
			form1.question.focus;
			return false;
		}
		if(form1.result.value==""){
			alert("������ش�����Ĵ�");
			form1.result.focus();
			return false;
		}
	}
</script>
<body ><center>
<form method="POST" action="regist_config.jsp" name="form1">
 
 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td  height="80" align="center" background="image/1.jpg">
	
      <table height="80" border="0" cellpadding="0" cellspacing="0" background="image/2.jpg">
        <tr>
          <td width="787"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="100%" height="75">
    <param name="movie" value="top.swf" />
    <param name="quality" value="high" />
    <param name="wmode" value="transparent" />
    <embed src="image/top.swf" width="100%" height="75" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="transparent"></embed>
  </object></td>
        </tr>
      </table>
	  
 	</td>
  </tr>
</table>

<table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" background="image/20.jpg">
  <tr>
    <td valign="bottom"><table width="100" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="image/21.jpg" width="791" height="35"></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="791" border="0" cellpadding="0" cellspacing="0" background="image/22.jpg">
  <tr>
    <td height="63"><div align="center">
      <p><b>��Աע��</b></p>
      </div></td>
  </tr>
</table>
<table width="791" height="205" border="0" cellpadding="0" cellspacing="0" background="image/23.jpg">
  <tr>
    <td width="46%" align="left" height="27"><div align="right">�û�����</div></td>
    <td width="54%" align="left"><input type="text" name="name" size="20"></td>
  </tr>
  <tr>
    <td width="46%" height="27">
      <p align="right">���룺</p>    </td>
    <td width="54%"><input type="password" name="password" size="20"></td>
  </tr>
  <tr>
    <td width="46%" height="27">
      <p align="right">ȷ�����룺</p>    </td>
    <td width="54%"><input name="repassword" type="password" size="20" maxlength="16"></td>
  </tr>
  <tr>
<td width="46%" height="27">
      <div align="right">�Ա� </div></td>
  <td width="54%">&nbsp; ��
    <input type="radio" value="man" checked name="sex">
    &nbsp; Ů
    <input type="radio" name="sex" value="moman"></td>
  </tr>
  <tr>
    <td width="46%" height="27">
      <p align="right">�绰��</p>    </td>
    <td width="54%"><input type="text" name="phone" size="20"></td>
  </tr>
  <tr>
    <td width="46%" height="27">
      <p align="right">Email��</p>    </td>
    <td width="54%"><input type="text" name="email" size="20"></td>
  </tr>
  <tr>
    <td width="46%" height="27">
    <p align="right">�һ��������⣺</p>    </td>
    <td width="54%"><input type="text" name="question" size="20"></td>
  </tr>
  <tr>
    <td width="46%" height="27"><div align="right">����𰸣�   </div></td>
    <td width="54%"><input type="text" name="result" size="20"></td>
  </tr>
  <tr>
    <td height="16" colspan="2">
      <div align="center">
          <input type="submit" value="ע��"  name="Submit"onClick="return check()"> ��
          <input type="reset" value="����">
        &nbsp;&nbsp;<a href="index.jsp">����</a>
      </div></td>
    </tr>
</table>
<table width="100" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="image/24.jpg" width="791" height="203"></td>
  </tr>
</table></form>
</center>
</body>
</html>
