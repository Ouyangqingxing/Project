//查看指定id的主题帖
function selectTopicPostById(){
	var topicPostId = location.search.substring(1);;
	topicPostId = topicPostId.replace('topicPostId=','');
	var url = "/guestbook/rs/topicpost/selecttopicpostbyid";
	var json = JSON.stringify(topicPostId);
	$.ajax({
	    url:url,
	    type:'POST',
	    async:false,
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	var cust = "<br/><h1>"
	        	+data.title
	            +"</h1><hr/><h3><a href='/guestbook/cust_info.html?uid=" 
	            +data.userId
	            +"' target='_blank'>"
	            +data.userName
	            +"</a></h3><br/>"
	            +data.content
	            +"<br/>"
	            +new Date(data.time).toLocaleString()
	            +"<br/><br/>";
           $("#topic_post").html(cust);       
	    }
	})
}

//查看指定主题帖id的回复贴
function selectReplyPostByTopicPostId(pageNum){
	var topicPostId = location.search.substring(1);;
	topicPostId = topicPostId.replace('topicPostId=','');
	var url = "/guestbook/rs/replypost/selectreplypostbytopicpostid";
	var obj = {
			topicPostId:topicPostId,
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
	    	
	    	var contents_page = "<li><a onclick='selectReplyPostByTopicPostId(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByTopicPostId("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByTopicPostId("+firstNum+")'>"+firstNum+"</a></li>";
			  	if(secondNum <= data.pages){
			  		contents_page = contents_page + "<li><a onclick='selectReplyPostByTopicPostId("+secondNum+")'>"+secondNum+"</a></li>";
			  	}
			  	if(thirdNum <= data.pages){
			  		contents_page = contents_page + "<li><a onclick='selectReplyPostByTopicPostId("+thirdNum+")'>"+thirdNum+"</a></li>";
			  	}
			  	if(fourthNum <= data.pages){
			  		contents_page = contents_page + "<li><a onclick='selectReplyPostByTopicPostId("+fourthNum+")'>"+fourthNum+"</a></li>";
			  	}
			  	if(fifthNum <= data.pages){
			  		contents_page = contents_page + "<li><a onclick='selectReplyPostByTopicPostId("+fifthNum+")'>"+fifthNum+"</a></li>";
			  	}
			  	contents_page = contents_page + "<li><a onclick='selectReplyPostByTopicPostId("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
			  	+"<li><a onclick='selectReplyPostByTopicPostId("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#contents_page").html(contents_page);
	    	
	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
	        	var content = item.content;
	        	if(item.state == 0){
	        		content = "<B style='color:red'>(该内容已被屏蔽)</B>";
	        	}
                 cust = cust + "<br/><div class='col-lg-1'>"
	             	+item.floor
	             	+"楼"
	                +"</div><div class='col-lg-1'><a href='/guestbook/cust_info.html?uid=" 
	                +item.userId
	                +"' target='_blank'>"
	                +item.userName
	                +":</a></div><div class='col-lg-8'>"
	                +content
	                +"</div><div class='col-lg-2'>"
	                +vagueTime(new Date(item.time).toLocaleString())
	                +"</div><br/><br/>";
            });
	        $("#reply_post").html(cust);       
	    }
	})
}

//新增回复帖
function addReplyPost(){ 
	var islogin = sessionStorage.getItem("islogin");
	if(islogin != "true"){
		alert("你还没有登陆");
		return false;
	}
	var topicPostId = location.search.substring(1);
	topicPostId = topicPostId.replace('topicPostId=','');
	content = UM.getEditor('content_edit').getContent();
	if(content.length > 1499){
		alert("内容超过1500字(当前"+content.length+"字)");
		return ;
	}
	var pureContent = getStrFromHtmlStr(content);
	if(pureContent.length > 3){
		var url = "/guestbook/rs/replypost/user/add";
		var obj = {
				topicPostId:topicPostId,
				content:content
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
		    	if(data == false){
		    		alert("发帖失败，请检查登录状态和回帖格式");
		    	}
		    	window.location.reload();
		    }
		})
	}
	else{
		alert("内容太短，至少输入4个字");
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

//时间模糊化
function vagueTime(postTime){
	//2017/3/31 下午7:01:52
	var now = new Date();
	var postYear = postTime.substring(0,4);
	var postMonth = postTime.charAt(5);
	var postDay = postTime.substring(7,9);
	var isToday = false;
	var isYesterday = false;
	if(postYear == now.getFullYear() && postMonth == now.getMonth() + 1 && postDay == now.getDate()){
		isToday = true;
	}
	else if(postDay == now.getDate() - 1){
		isYesterday = true;
	}
	//如果发帖日期不是今天和昨天，则返回（月-日）
	if(!isToday){
		return postMonth+"-"+postDay;
	}
	//如果发帖日期不是今年，则返回（年-月-日）
	if(postYear != now.getFullYear()){
		return postYear+"-"+postMonth+"-"+postDay;
	}
	
	var postHour = postTime.substring(11,postTime.length-6);
	var postMin = postTime.substring(postTime.length-5,postTime.length-3);
	if(postTime.substring(10,12) == "下午"){
		postHour = postHour + 12;
	}
	if(isYesterday){
		return "昨天"+postHour+":"+postMin;
	}
	return ""+postHour+":"+postMin;
}