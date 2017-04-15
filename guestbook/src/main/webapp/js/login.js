//注册
function login(){
	var url = "/guestbook/rs/user/checklogin";
	var loginName = $("#loginName").val();
	var loginPwd = $("#loginPwd").val();
	var result = (!loginName=="")&(!loginPwd=="");
//	alert(checkEmpty(loginName));
//	alert(checkEmpty(loginPwd));
//	alert(containSpecial(loginName));
//	alert(containSpecial(loginPwd));
//	var result = (!checkEmpty(loginName))&(!checkEmpty(loginPwd))&(containSpecial(loginName))&(containSpecial(loginPwd));
	if(result)	{
		var obj = {
				userName:loginName,
				pwd:loginPwd
		};
		var Jobj = JSON.stringify(obj);
		$.ajax({
		    url:url,
		    type:'POST', //GET
		    async:false,    //或false,是否异步
		    data: Jobj,
		    contentType:"application/json",
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	if (data == true) {
		    		sessionStorage.setItem("islogin",true);
		    		window.location.replace("/guestbook/success.html");
		    	} else{
		    		alert("密码错误");
		    	}
		    }
		})
	}else{
		alert("用户名密码不能为空");
	}
} 
//注销
function logout1(){
	var url = "/guestbook/rs/user/logout"; 

	$.ajax({
	    url:url,
	    type:'POST', //GET
	    async:false,    //或false,是否异步
	    contentType:"application/json",
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	    	if (data == true) {
	    		sessionStorage.removeItem("islogin");
	    		window.location.replace("/guestbook/index.html");
	    	} else{
	    		alert("注销失败");
	    	}
	    }
	})
}

//登陆后显示myinfo按钮和logout按钮
function hiden_btn(){
	$("#myinfo").css("display","none"); 
	$("#logout").css("display","none"); 
	$("#loginBtn").css("display","inline-block"); 
	$("#registBtn").css("display","inline-block"); 
}
//没登录显示登陆和注册按钮
function show_btn(){
	$("#myinfo").css("display","inline-block"); 
	$("#logout").css("display","inline-block"); 
	$("#loginBtn").css("display","none"); 
	$("#registBtn").css("display","none"); 
}

