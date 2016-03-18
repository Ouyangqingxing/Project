<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ page import="java.util.Date,java.sql.*"%>
<jsp:directive.page import="com.wy.CountTime"/>
<jsp:useBean id="connection" scope="page" class="com.wy.JDBConnection"/>
<html>
<head>
<title>
regist_config
</title>
</head>
<% request.setCharacterEncoding("gb2312"); %>
<body bgcolor="#ffffff">
<%
	Date date=new Date();
        String name=request.getParameter("name");
        String password=request.getParameter("password");
	String email=request.getParameter("email");
	String sex=request.getParameter("sex");
	String phone=request.getParameter("phone");
	String result=request.getParameter("result");
	String question=request.getParameter("question");
    CountTime time=new CountTime();
       String str="select Name from tb_customar where Name='"+name+"'";
	ResultSet rs=connection.executeQuery(str);
	if(rs.next()){
%>
<script language="javascript">
	alert("此用户已经被占用请重新注册");
	history.back();
</script>
<%
	}else{
		String sql="insert into tb_Customar values('"+name+"','"+password+"','1','"+email+"','"+sex+"','"+phone+"','"+question+"','"+result+"','"+time.currentlyTime()+"')";
		boolean sert=connection.executeUpdata(sql);
            if(sert)
{%>
<script language="javascript">
	alert("注册成功");
	window.location.href="index.jsp";
	</script>
<%
}else 
{
%>
<script language="javascript">
	alert("注册失败！！");
        history.back();</script>
<%
}
}
%>
</body>
</html>
