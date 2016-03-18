<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
 <script type="text/javascript">
 function showquestion(str){
			var xmlhttp;
			if(str.length==0){
				document.getElementById("question").value="";
				return;
			}
			if(window.XMLHttpRequest){
				xmlhttp=new XMLHttpRequest();
			}else{
				xmlhttp=new ActiveXobject("Mricrosoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange=function(){
				if(xmlhttp.readystate==4&&xmlhttp.status==200){
					document.getElementById("question").value=xmlhttp.responseText;
					document.getElementById("ques").innerHTML=xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET","question.jsp?name="+str,true);
			xmlhttp.send();
}
</script>
<script type="text/javascript">
      function check(){
		if(form1.name.value==""){
			alert("请输入你要找回密码的用户名");
			form1.name.focus();
			return false;
		}
		

	}
</script>

</script>
<title>
register
</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="CSS/style.css" type="text/css" rel="stylesheet">
</head>

 
  
  <body>
    <center>
<form method="POST" action="found_config.jsp" name="form1">
 
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
      <p><b>密码找回</b></p>
      </div></td>
  </tr>
</table>
<table width="791" height="205" border="0" cellpadding="0" cellspacing="0" background="image/23.jpg">
  <tr>
    <td width="46%" align="left" height="27"><div align="right">请输入你要找回密码的用户名：</div></td>
    <td width="54%" align="left"><input type="text" name="name" size="20"  onkeyup="showquestion(this.value)"></td>
  </tr>
 <tr>
    <td width="46%" align="left" height="27"><div align="right">email：</div></td>
    <td width="54%" align="left"><input type="text" name="name" size="20"></td>
  </tr>
  <tr>
    <td width="46%" align="left" height="27"><div align="right">密码提示问题:</div></td><span id="ques">aaa</span>
    <td width="54%" align="left"><input type="text" name="name" size="20" id="question"></td>
  </tr>
  <tr>
    <td width="46%" align="left" height="27"><div align="right">答案：</div></td>
    <td width="54%" align="left"><input type="text" name="name" size="20"></td>
  </tr>
 
  <tr>
    <td height="16" colspan="2">
      <div align="center">
          <input type="submit" value="找回"  name="Submit"onClick="return check()"> 　
          <input type="reset" value="重置">
        &nbsp;&nbsp;<a href="index.jsp">返回</a>
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
