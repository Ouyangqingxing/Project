//注册
function regist(){
    //解决中文乱码问题的方法1,页面端发出的数据作一次encodeURI，服务端使用new String(old.getBytes("iso8859-1"),"UTF-8");  
    //解决中文乱码问题的方法2,页面端发出的数据作两次encodeURI,服务端使用String name = URLDecoder.decode(old,"UTF-8");  
   
	var url = "/guestbook/rs/user/regist"; 
	var inputEmail = $("#inputEmail").val();
	var inputPassword = $("#inputPassword").val();
	var result = (!inputEmail=="")&(!inputPassword=="");
	if(result){
		var obj = {
				userName:inputEmail,
				pwd:inputPassword
		};
	//    url = convertURL(url);  
		
		var Jobj = JSON.stringify(obj);
		$.ajax({
		    url:url,
		    type:'POST', //GET
		    async:false,    //或false,是否异步
		    data: Jobj,
		    contentType:"application/json",
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	if(data == false){
		    		alert("注册失败，可能是该用户名已经被注册");
		    		return false;
		    	}
		    	alert("注册成功");
		    	window.location.replace('/guestbook/index.html');
		       
		    }
		})
	}else {
		alert("用户名密码不能为空");
	}
//    $.get(url,function(data){  
//    	$("#result").html(data);
//    });  
}  
/**
 * 跳转用户管理界面
 */
function cust_admin(pageNum){
	var url = "/guestbook/rs/user/alluser"; 
	var json = JSON.stringify(pageNum);
	$.ajax({
	    url:url,
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data: json,
	    contentType:"application/json",
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	    	var firstNum = pageNum - 2;
	    	var secondNum = pageNum -1;
	    	var thirdNum = pageNum;
	    	var fourthNum = pageNum + 1;
	    	var fifthNum = pageNum + 2;
	    	var prePage = pageNum - 1;
	    	var nextPage = pageNum + 1;
	    	
	    	if(pageNum < 4 || data.pages < 6){
	    		firstNum = 1;
		    	secondNum = 2;
		    	thirdNum = 3;
		    	fourthNum = 4;
		    	fifthNum = 5;
	    	}
	    	else if(pageNum > data.pages-2){
	    		firstNum = data.pages-4;
		    	secondNum = data.pages-3;
		    	thirdNum = data.pages-2;
		    	fourthNum = data.pages-1;
		    	fifthNum = data.pages;
	    	}
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}
	    	var cust_admin_page = "<li><a onclick='cust_admin(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
		    			  	+"<li><a onclick='cust_admin("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
		    			  	+"<li><a onclick='cust_admin("+firstNum+")'>"+firstNum+"</a></li>"
		    			  	if(secondNum <= data.pages){
		    			  		cust_admin_page = cust_admin_page + "<li><a onclick='cust_admin("+secondNum+")'>"+secondNum+"</a></li>";
		    			  	}
		    			  	if(thirdNum <= data.pages){
		    			  		cust_admin_page = cust_admin_page + "<li><a onclick='cust_admin("+thirdNum+")'>"+thirdNum+"</a></li>";
		    			  	}
		    			  	if(fourthNum <= data.pages){
		    			  		cust_admin_page = cust_admin_page + "<li><a onclick='cust_admin("+fourthNum+")'>"+fourthNum+"</a></li>";
		    			  	}
		    			  	if(fifthNum <= data.pages){
		    			  		cust_admin_page = cust_admin_page + "<li><a onclick='cust_admin("+fifthNum+")'>"+fifthNum+"</a></li>";
		    			  	}
		    			  	cust_admin_page = cust_admin_page +"<li><a onclick='cust_admin("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
		    			  	+"<li><a onclick='cust_admin("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#cust_admin_page").html(cust_admin_page);
	    	
	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
	        	var uid = item.id;
	        	var state = item.state;
	        	var roleName = item.roleName;
	        	var adminBtn = "";
	        	if(roleName == "普通用户"){
	        		adminBtn = "<input type='button' value='设为管理员' class='btn btn-default btn-xs' onclick='updateadmin(\""+uid+"\")'/>";
	        	}else{
	        		adminBtn = "<input type='button' value='取消管理员' class='btn btn-warning btn-xs' onclick='updateadmin(\""+uid+"\")'/>";
	        	}
	        	var stateWord;
	        	if (state == 0) {
	        		stateWord = "屏蔽"
	        	}else if(state == 1){
	        		stateWord = "正常";
	        	}
                 cust = cust + "<div class='row'><div class='col-lg-2'><a href='/guestbook/cust_info.html?uid="+uid+"' target='_blank'>"
	                +item.name+
	                "</a></div><div class='col-lg-2'>"
	                +item.postNumber
	                +"</div><div class='col-lg-2'>" + item.replyNumber +"</div><div class='col-lg-2'>"
	                +stateWord+
	                "</div>"
	                +"<div class='col-lg-2'><input type='button' value='屏蔽' class='btn btn-danger btn-xs' onclick='hide(\""+uid+"\")'/>"
	                +"&nbsp<input type='button' value='恢复' class='btn btn-success btn-xs' onclick='recover(\""+uid+"\")'/>"
	                +"&nbsp"+adminBtn+"</div>"
	                +"</div><hr/>";
			   
            });
	         $("#cust_list").html(cust);
	    }
	})
}

//判断是否包含特殊字符
function containSpecial(str){ 
	var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#) (\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=) (\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/) (\<)(\>)(\ )(\)]+/); 
	return ( containSpecial.test(str) ); 
}

//判断是否为空
function checkEmpty(str){
	var result =true;
	if(containSpecial( str )){
		result = false;
	}
	if(str.match(/^[ ]*$/)){
		result = false;
	}
	return result;
}