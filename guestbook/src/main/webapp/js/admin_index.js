//查看所有通过审核的主题帖
function selectAllTopicPost(pageNum){
	var url = "/guestbook/rs/topicpost/admin/selectalltopicpost"; 
	var json = JSON.stringify(pageNum);
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
	    	var adminIndex_topicpost_page = "<li><a onclick='selectAllTopicPost(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllTopicPost("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllTopicPost("+firstNum+")'>"+firstNum+"</a></li>";
		    			  	if(secondNum <= data.pages){
		    			  		adminIndex_topicpost_page = adminIndex_topicpost_page + "<li><a onclick='selectAllTopicPost("+secondNum+")'>"+secondNum+"</a></li>";
		    			  	}
		    			  	if(thirdNum <= data.pages){
		    			  		adminIndex_topicpost_page = adminIndex_topicpost_page + "<li><a onclick='selectAllTopicPost("+thirdNum+")'>"+thirdNum+"</a></li>";
		    			  	}
		    			  	if(fourthNum <= data.pages){
		    			  		adminIndex_topicpost_page = adminIndex_topicpost_page + "<li><a onclick='selectAllTopicPost("+fourthNum+")'>"+fourthNum+"</a></li>";
		    			  	}
		    			  	if(fifthNum <= data.pages){
		    			  		adminIndex_topicpost_page = adminIndex_topicpost_page + "<li><a onclick='selectAllTopicPost("+fifthNum+")'>"+fifthNum+"</a></li>";
		    			  	}
		    			  	adminIndex_topicpost_page = adminIndex_topicpost_page +"<li><a onclick='selectAllTopicPost("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllTopicPost("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#adminIndex_topicpost_page").html(adminIndex_topicpost_page);
	    	var cust = "";
	        jQuery.each(data.list,function(i,item){
	        	var checkShield = "屏蔽";
	        	var newState = 0;
	        	var color = "btn btn-warning btn-xs";
	        	if(item.state == 0){
	        		color = "btn btn-success btn-xs";
	        		checkShield = "恢复";
	        		newState = 1;
	        	}
	        	 
                cust = cust + "<div class='col-lg-4'><a href='/guestbook/contents_admin.html?topicPostId="
                	+item.id 
	                +"' target='_blank'>"
	                +item.title
	                +"</a></div><div class='col-lg-2'>"
	                +item.keyword
	                +"</div><div class='col-lg-2'>"
	                +new Date(item.time).toLocaleString()
	                +"</div><div class='col-lg-1'><a href='/guestbook/cust_info.html?uid=" 
	                +item.userId
	                +"' target='_blank'>"
	                +item.userName
	                +"</a></div><div class='col-lg-1'>&nbsp&nbsp&nbsp&nbsp&nbsp"
	                +item.replyNumber
	                +"</div><div class='col-lg-2'><input type='button' onclick='deleteTopicPost(&apos;" 
	                +item.id
	                +"&apos;)' value='删除' class='btn btn-danger btn-xs'/>&nbsp"
	                +"<input type='button' value='" 
	                +checkShield 
	                +"' class='" 
	                +color 
	                +"' onclick='updateTopicPostState(&apos;"
	                +item.id
	                +"&apos;,&apos;"
	                +newState
	                +"&apos;)'/></div><br/><br/>";
            });
	        $("#audit_list").html(cust);       
	    }
	})
}

//待审核的主题贴
function selectAllExamineTopicPost(pageNum){
	var url = "/guestbook/rs/topicpost/admin/selectallexaminetopicpost";
	var json = JSON.stringify(pageNum);
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
	    	var adminIndex_replypost_page = "<li><a onclick='selectAllExamineTopicPost(1)' aria-label='Previous'><span aria-hidden='true'>&lt;&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllExamineTopicPost("+prePage+")' aria-label='Previous'><span aria-hidden='true'>&lt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllExamineTopicPost("+firstNum+")'>"+firstNum+"</a></li>";
		    			  	if(secondNum <= data.pages){
		    			  		adminIndex_replypost_page = adminIndex_replypost_page + "<li><a onclick='selectAllExamineTopicPost("+secondNum+")'>"+secondNum+"</a></li>";
		    			  	}
		    			  	if(thirdNum <= data.pages){
		    			  		adminIndex_replypost_page = adminIndex_replypost_page + "<li><a onclick='selectAllExamineTopicPost("+thirdNum+")'>"+thirdNum+"</a></li>";
		    			  	}
		    			  	if(fourthNum <= data.pages){
		    			  		adminIndex_replypost_page = adminIndex_replypost_page + "<li><a onclick='selectAllExamineTopicPost("+fourthNum+")'>"+fourthNum+"</a></li>";
		    			  	}
		    			  	if(fifthNum <= data.pages){
		    			  		adminIndex_replypost_page = adminIndex_replypost_page + "<li><a onclick='selectAllExamineTopicPost("+fifthNum+")'>"+fifthNum+"</a></li>";
		    			  	}
		    			  	adminIndex_replypost_page = adminIndex_replypost_page +"<li><a onclick='selectAllExamineTopicPost("+nextPage+")' aria-label='Next'><span aria-hidden='true'>&gt;</span></a></li>"
		    			  	+"<li><a onclick='selectAllExamineTopicPost("+data.pages+")' aria-label='Next'><span aria-hidden='true'>&gt;&gt;</span></a></li>";
	    	$("#adminIndex_replypost_page").html(adminIndex_replypost_page);
	    	
	    	var newState = 1;
	    	var unaudit_list = "";
	        jQuery.each(data.list,function(i,item){
	        	unaudit_list = unaudit_list + "<div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
                	+item.id
	                +"' target='_blank'>"
	                +item.title
	                +"</a></div><div class='col-lg-2'>"
	                +item.keyword
	                +"</div><div class='col-lg-2'>"
	                +new Date(item.time).toLocaleString()
	                +"</div><div class='col-lg-2'><a href='/guestbook/cust_info.html?uid=" 
	                +item.userId
	                +"' target='_blank'>"
	                +item.userName
	                +"</a></div><div class='col-lg-2'><input type='button' onclick='updateTopicPostState(&apos;"
	                +item.id
	                +"&apos;,&apos;"
	                +newState
	                +"&apos;)' value='通过' class='btn btn-success btn-xs'/>&nbsp"
	                +"</div><br/><br/>";
            });
	        $("#unaudit_list").html(unaudit_list);    
	        
	        if(unaudit_list == ""){
	        	unaudit_list = "<div class='col-lg-4'>没有待审核的帖子。</div>";
				$("#unaudit_list_null").html(unaudit_list);
			}
	        else{
	        	var adoptAllButton = "<input type='button' onclick='adoptAllTopicPost()' value='一键通过' class='btn btn-success btn-xs'/>";
	        	$("#row").html(adoptAllButton);
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

//修改主题帖状态
function updateTopicPostState(topicPostId,state){ 
	var info = "确定要屏蔽该贴子吗？";
	if(state == 1){
		info = "确定要执行此操作吗？";
	}
	if (confirm(info)) {
		var url = "/guestbook/rs/topicpost/admin/updatestate";
		var obj = {
				topicPostId:topicPostId,
				state:state
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
		        window.location.reload();
		    }
		})
	}
}

//一键通过审核
function adoptAllTopicPost(){
	if (confirm("确认要全部通过审核？")) {
		var url = "/guestbook/rs/topicpost/admin/adoptalltopicpost";
		$.ajax({
		    url:url,
		    type:'POST',
		    async:false,  
		    contentType:"application/json",
		    dataType:'json',
		    success:function(data,textStatus,jqXHR){
		        window.location.reload();
		    }
		})
	}
}