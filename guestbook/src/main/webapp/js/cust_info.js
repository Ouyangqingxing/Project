function cust_info(pageNum){
	var userId = location.search.substring(1);
	userId = userId.replace('uid=','');
	var url = "/guestbook/rs/topicpost/selecttopicpostbyuserid";
	var obj = {
			userId:userId,
			pageNum:pageNum
	};
	var json = JSON.stringify(obj);
	$.ajax ({
		url:url,
	    type:'POST', //GET
		async:false,
		data:json,
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
	    	
	    	var cust_topicpost_page = "<li><a onclick='cust_info(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
			  	+"<li><a onclick='cust_info("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
			  	+"<li><a onclick='cust_info("+firstNum+")'>"+firstNum+"</a></li>" ;
			  	if(secondNum <= data.pages){
			  		cust_topicpost_page = cust_topicpost_page + "<li><a onclick='cust_info("+secondNum+")'>"+secondNum+"</a></li>";
			  	}
			  	if(thirdNum <= data.pages){
			  		cust_topicpost_page = cust_topicpost_page + "<li><a onclick='cust_info("+thirdNum+")'>"+thirdNum+"</a></li>";
			  	}
			  	if(fourthNum <= data.pages){
			  		cust_topicpost_page = cust_topicpost_page + "<li><a onclick='cust_info("+fourthNum+")'>"+fourthNum+"</a></li>";
			  	}
			  	if(fifthNum <= data.pages){
			  		cust_topicpost_page = cust_topicpost_page + "<li><a onclick='cust_info("+fifthNum+")'>"+fifthNum+"</a></li>";
			  	}
			  	cust_topicpost_page = cust_topicpost_page+"<li><a onclick='cust_info("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
			  	+"<li><a onclick='cust_info("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#cust_topicpost_page").html(cust_topicpost_page);
	    	
	    	var txt = "";
	    	var name = "";
	    	jQuery.each(data.list,function(i,item){
	    		i = i+1;
	    		txt = txt + "<div class='row' >"
				+"<div class='col-lg-1'>"+i+"</div>"
				+"<div class='col-lg-4'>"
				+"<a href='/guestbook/contents.html?topicPostId="
	            +item.id
	            +"' target='_blank'>"+item.title+"</a>"
				+"</div>"
				+"<div class='col-lg-2'>"+item.keyword+"</div>"
				+"<div class='col-lg-2'>"+new Date(item.time).toLocaleString()+"</div>"
				+"<div class='col-lg-1'>"+item.replyNumber+"</div>"
			+"</div><hr />";
	    		name = item.userName;
	    	});
	    	$("#info_uname").html(name);
	    	$("#topic_info_list").html(txt);
	    	if(txt == ""){
	    		txt = "<div class='col-lg-4'>找不到他的主题帖。</div>";
				$("#topic_info_null").html(txt);
			}
	    }
	})
}

function cust_info_reply(pageNum){
	var userId = location.search.substring(1);
	userId = userId.replace('uid=','');
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
	    success:function(data,textStatus,jqXHR){console.log(data);
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
	    	
	    	var cust_replypost_page = "<li><a onclick='cust_info_reply(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
			  	+"<li><a onclick='cust_info_reply("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
			  	+"<li><a onclick='cust_info_reply("+firstNum+")'>"+firstNum+"</a></li>";
			  	if(secondNum <= data.pages){
			  		cust_replypost_page = cust_replypost_page + "<li><a onclick='cust_info_reply("+secondNum+")'>"+secondNum+"</a></li>";
			  	}
			  	if(thirdNum <= data.pages){
			  		cust_replypost_page = cust_replypost_page + "<li><a onclick='cust_info_reply("+thirdNum+")'>"+thirdNum+"</a></li>";
			  	}
			  	if(fourthNum <= data.pages){
			  		cust_replypost_page = cust_replypost_page + "<li><a onclick='cust_info_reply("+fourthNum+")'>"+fourthNum+"</a></li>";
			  	}
			  	if(fifthNum <= data.pages){
			  		cust_replypost_page = cust_replypost_page + "<li><a onclick='cust_info_reply("+fifthNum+")'>"+fifthNum+"</a></li>";
			  	}
			  	cust_replypost_page = cust_replypost_page + "<li><a onclick='cust_info_reply("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
			  	+"<li><a onclick='cust_info_reply("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#cust_replypost_page").html(cust_replypost_page);
	    	
	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
	        	i = i+1;
	        	cust = cust + "<div class='row' >"+
	        	"<div class='col-lg-1'>"+i+"</div>"+
	        	"<div class='col-lg-4'>" +
	        	"<a href='/guestbook/contents.html?topicPostId="+item.topicPostId+"' target='_blank'>"+item.topicPostTitle+"</a>"+
	        	"</div>"+
	        	"<div class='col-lg-4'>"+getStrFromHtmlStr(item.content)+"</div>"+
	        	"<div class='col-lg-2'>"+new Date(item.time).toLocaleString()+"</div>"+
		        "</div>"+
		        "<hr />";
            });
	        $("#reply_info_list").html(cust);  
	        
	        if(cust == ""){
				cust = "<div class='col-lg-4'>找不到他的回复帖。</div>";
				$("#reply_list_null").html(cust);
			}
	    }
	})
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