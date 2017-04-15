//查看所有状态正常的主题帖
function selectAllPublicTopicPost(pageNum){
	var url = "/guestbook/rs/topicpost/selectallpublictopicpost"; 
	var json = JSON.stringify(pageNum);
	$.ajax({
	    url:url,
	    type:'POST',
	    async:true,
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
	    	var index_page = "<li><a onclick='selectAllPublicTopicPost(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllPublicTopicPost("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllPublicTopicPost("+firstNum+")'>"+firstNum+"</a></li>";
		    			  	if(secondNum <= data.pages){
		    			  		index_page = index_page + "<li><a onclick='selectAllPublicTopicPost("+secondNum+")'>"+secondNum+"</a></li>";
		    			  	}
		    			  	if(thirdNum <= data.pages){
		    			  		index_page = index_page + "<li><a onclick='selectAllPublicTopicPost("+thirdNum+")'>"+thirdNum+"</a></li>";
		    			  	}
		    			  	if(fourthNum <= data.pages){
		    			  		index_page = index_page + "<li><a onclick='selectAllPublicTopicPost("+fourthNum+")'>"+fourthNum+"</a></li>";
		    			  	}
		    			  	if(fifthNum <= data.pages){
		    			  		index_page = index_page + "<li><a onclick='selectAllPublicTopicPost("+fifthNum+")'>"+fifthNum+"</a></li>";
		    			  	}
		    			  	index_page = index_page +"<li><a onclick='selectAllPublicTopicPost("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllPublicTopicPost("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#index_page").html(index_page);
	    	
	    	var tp = "";
	        jQuery.each( data.list,function(i,item){
	        	tp = tp + "<div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
	             	+item.id
	                +"' target='_blank'>"
	                +item.title
	                +"</a></div><div class='col-lg-2'>"
	                +item.keyword
	                +"</div><div class='col-lg-2'>"
	                +vagueTime(new Date(item.time).toLocaleString())
	                +"</div><div class='col-lg-2'><a href='/guestbook/cust_info.html?uid=" 
	                +item.userId
	                +"' target='_blank'>"
	                +item.userName
	                +"</a></div><div class='col-lg-1'>"
	                +item.replyNumber
	                +"<br/><br/></div>";
            });
	        $("#topic_list").html(tp);       
	    }
	})
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
	if(postTime.substring(9,11) == "下午" && postHour != 12){
		postHour = parseInt(postHour) + 12;
	}
	if(isYesterday){
		return "昨天"+postHour+":"+postMin;
	}
	return ""+postHour+":"+postMin;
}

//新增主题帖
function addTopicPost(){ 
	var islogin = sessionStorage.getItem("islogin");
	if(islogin != "true"){
		alert("你还没有登陆");
		return ;
	}
	var url = "/guestbook/rs/topicpost/user/add";
	var title = $("#publishTitle").val();
	var keywordStr = $("#publishKeyword").val();
	var content = UM.getEditor('content_edit').getContent();
	if(content.length > 2000){
		alert("内容超过2000字(当前"+content.length+"字)");
		return ;
	}
	if(title.length > 50){
		alert("标题超过50字(当前"+content.title+"字)");
		return ;
	}
	if(checkTopicPost(title,keywordStr,content)){
		var obj = {
				title:title,
				keywordStr:keywordStr,
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
		    	if(data == true){
		    		alert("发帖成功，请等待管理员审核");
		    	}
		    	else{
		    		alert("发帖失败，请检查登录状态和发帖格式");
		    	}
		    	window.location.reload();
		    }
		})
	}
} 

//判断主题帖是否合法
function checkTopicPost(title,keywordStr,content){
	keywordStr = keywordStr.replace(" ","SPACE");
	if(title.match(/^[ ]*$/) || keywordStr.match(/^[ ]*$/) || content.match(/^[ ]*$/)){
		alert("标题关键字不能全是空格");
		return false;
	}
	return true;
}

//取到查询内容并跳转页面
function openSearchWindow(){
	var searchContent = $("#search_text").val();
	if(checkSearch(searchContent)){
		window.open("/guestbook/search.html?searchContent="+searchContent);
	} 
}

//判断查询内容
function checkSearch(content){
	var result = true;
	content = content.replace(/\s+/g, ' ');
	if(content.length == 1 && content == " "){
		result = false;
	}
	content = content.replace(" ","SPACE");
	if(containSpecial( content )){
		result = false;
	}
	content = content.replace("SPACE"," ");
	return result;
}