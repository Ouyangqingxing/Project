//加载主题帖
function selectTopicPostByUserId(pageNum){
	var userId = location.search.substring(1);;
	userId = userId.replace('userId=','');
	var url = "/guestbook/rs/topicpost/selecttopicpostbyuserid"; 
	var obj = {
			userId:userId,
			pageNum:pageNum
	};
	var json = JSON.stringify(obj);
	$.ajax({
	    url:url,
	    type:'POST',
	    async:false,
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
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
	    	var myinfo_topicpost_page = "<li><a onclick='selectTopicPostByUserId(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
			  	+"<li><a onclick='selectTopicPostByUserId("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
			  	+"<li><a onclick='selectTopicPostByUserId("+firstNum+")'>"+firstNum+"</a></li>"
			  	if(secondNum <= data.pages){
			  		myinfo_topicpost_page = myinfo_topicpost_page + "<li><a onclick='selectTopicPostByUserId("+secondNum+")'>"+secondNum+"</a></li>";
			  	}
			  	if(thirdNum <= data.pages){
			  		myinfo_topicpost_page = myinfo_topicpost_page + "<li><a onclick='selectTopicPostByUserId("+thirdNum+")'>"+thirdNum+"</a></li>";
			  	}
			  	if(fourthNum <= data.pages){
			  		myinfo_topicpost_page = myinfo_topicpost_page + "<li><a onclick='selectTopicPostByUserId("+fourthNum+")'>"+fourthNum+"</a></li>";
			  	}
			  	if(fifthNum <= data.pages){
			  		myinfo_topicpost_page = myinfo_topicpost_page + "<li><a onclick='selectTopicPostByUserId("+fifthNum+")'>"+fifthNum+"</a></li>";
			  	}
			  	myinfo_topicpost_page = myinfo_topicpost_page +"<li><a onclick='selectTopicPostByUserId("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
			  	+"<li><a onclick='selectTopicPostByUserId("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#myinfo_topicpost_page").html(myinfo_topicpost_page);

	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
                 cust = cust + "<div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
	             	+item.id 
	                +"' target='_blank'>"
	                +item.title
	                +"</a></div><div class='col-lg-2'>"
	                +item.keyword
	                +"</div><div class='col-lg-2'>"
	                +new Date(item.time).toLocaleString()
	                +"</div><div class='col-lg-1'>"
	                +item.replyNumber
	                +"</div><div class='col-lg-2'><input type='button' onclick='deleteTopicPost(&apos;" 
	                +item.id
	                +"&apos;)' value='删除' class='btn btn-danger btn-xs' />"
	                +"</div><br/><br/>";
            });
	        $("#topic_info_list").html(cust); 
	        
	        if(cust == ""){
				cust = "<div class='col-lg-4'>我还没有发过主题帖。</div>";
				$("#topic_info_null").html(cust);
			}
	    }
	})
}

//加载回复贴
function selectReplyPostByUserId(pageNum){
	var userId = location.search.substring(1);;
	userId = userId.replace('userId=','');
	var url = "/guestbook/rs/replypost/selectreplypostbyuserid";
	var obj = {
			userId:userId,
			pageNum:pageNum
	};
	var json = JSON.stringify(obj);
	$.ajax({
	    url:url,
	    type:'POST',
	    async:false,
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
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
	    	
	    	var myinfo_replypost_page = "<li><a onclick='cust_info_reply(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByUserId("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByUserId("+firstNum+")'>"+firstNum+"</a></li>";
			  	if(secondNum <= data.pages){
			  		myinfo_replypost_page = myinfo_replypost_page + "<li><a onclick='selectReplyPostByUserId("+secondNum+")'>"+secondNum+"</a></li>";
			  	}
			  	if(thirdNum <= data.pages){
			  		myinfo_replypost_page = myinfo_replypost_page + "<li><a onclick='selectReplyPostByUserId("+thirdNum+")'>"+thirdNum+"</a></li>";
			  	}
			  	if(fourthNum <= data.pages){
			  		myinfo_replypost_page = myinfo_replypost_page + "<li><a onclick='selectReplyPostByUserId("+fourthNum+")'>"+fourthNum+"</a></li>";
			  	}
			  	if(fifthNum <= data.pages){
			  		myinfo_replypost_page = myinfo_replypost_page + "<li><a onclick='selectReplyPostByUserId("+fifthNum+")'>"+fifthNum+"</a></li>";
			  	}
			  	myinfo_replypost_page = myinfo_replypost_page +"<li><a onclick='selectReplyPostByUserId("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByUserId("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#myinfo_replypost_page").html(myinfo_replypost_page);

	    	
	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
	        	cust = cust + "<div class='col-lg-3'><a href='/guestbook/contents.html?topicPostId="
	        		+item.topicPostId
	        		+"' target='_blank'>"
	                +item.topicPostTitle
	                +"</a></div><div class='col-lg-4'>"
	                +getStrFromHtmlStr(item.content)
	                +"</div><div class='col-lg-2'>"
	                +new Date(item.time).toLocaleString()
	                +"</div><div class='col-lg-2'><input type='button' onclick='deleteReplyPost(&apos;" 
	                +item.replyPostId
	                +"&apos;)' value='删除' class='btn btn-danger btn-xs' />"
	                +"</div><br/><br/>";
            });
	        $("#reply_info_list").html(cust);
	        
	        if(cust == ""){
				cust = "<div class='col-lg-4'>我还没有发过回复帖。</div>";
				$("#reply_list_null").html(cust);
			}
	    }
	})
}

//删除主题帖
function deleteTopicPost(topicPostId){ 
	if (confirm("确认要删除？")) {
		var url = "/guestbook/rs/topicpost/user/delete"; 
		var json = JSON.stringify(topicPostId);
		$.ajax({
		    url:url,
		    type:'POST',
		    async:false,  
		    data: json,
		    contentType:"application/json",
		    dataType:'json',
		    success:function(data,textStatus,jqXHR){
		        window.location.reload();
		    }
		})
	}
}

//删除回复帖
function deleteReplyPost(replyPostId){ 
	if (confirm("确认要删除？")) {
		var url = "/guestbook/rs/replypost/delete"; 
		var json = JSON.stringify(replyPostId);
		$.ajax({
		    url:url,
		    type:'POST',
		    async:false,  
		    data: json,
		    contentType:"application/json",
		    dataType:'json',
		    success:function(data,textStatus,jqXHR){
		    	window.location.reload();
		    }
		})
	}
}

//更新密码
function updatepwd(){
    //解决中文乱码问题的方法1,页面端发出的数据作一次encodeURI，服务端使用new String(old.getBytes("iso8859-1"),"UTF-8");  
    //解决中文乱码问题的方法2,页面端发出的数据作两次encodeURI,服务端使用String name = URLDecoder.decode(old,"UTF-8");  
   
	var url = "/guestbook/rs/user/update"; 
	var old_pwd = $("#old_pwd").val();
	var new_pwd = $("#new_pwd").val();
	var result = (!old_pwd=="")&(!new_pwd=="");
	if(result){
		var obj = {
				oldPwd:old_pwd,
				newPwd:new_pwd
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
		    	if(data == false){
		    		alert("修改失败，可能是原密码错误");
		    		return false;
		    	}
		    	alert("修改成功");
		    	window.location.reload();
		       
		    }
		})
	}else {
		alert("用户名密码不能为空");
	}
}  

//将带html标签的回复内容转为纯文本
function getStrFromHtmlStr(content){
	content = content.replace(/\&nbsp;/g, "");
	content = content.replace(/\s+/g,"");
	
	var result = "";
	var check = false;	
	for(var i = 0 ; i < content.length ; i++){
		if('>' == content.charAt(i)){
			check = true;
			continue;
		}
		if('<' == content.charAt(i)){
			check = false;
			continue;
		}
		if(check){
			result = result + content.charAt(i);
		}
	}
	return result;
}