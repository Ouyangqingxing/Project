//搜索用户
function searchUser(pageNum){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	var searchUserNameUrl = "/guestbook/rs/user/content";
	searchContent = decodeURI(searchContent);
	var obj = {
			pageNum:pageNum,
			searchContent:searchContent
	};
	var json = JSON.stringify(obj);
	$.ajax({
		url:searchUserNameUrl,
	    type:'POST',
	    async:false,
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	var prePage = parseInt(pageNum) - 1;
	    	var nextPage = parseInt(pageNum) + 1;
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}

			var cust = "";
			jQuery.each(data.list,function(i,item){
				cust = cust + "<div class='col-lg-4'><a href='/guestbook/cust_info.html?uid=" 
							+item.id
							+"' target='_blank'>"
							+item.name
							+"</a></div><div class='col-lg-4'>"
							+item.postNumber
							+"</div><br/>";
			});
			$("#search_user_list").html(cust);
								
			if(cust == ""){
				cust = "<div class='col-lg-4' target='_blank'>找不到关于 <b>" 
					+searchContent 
					+"</b> 的用户。</div><br/><br/><hr/><br/><br/>";
				$("#search_user_null").html(cust);
			}
			else{
				var user_page = "<ul class='pagination'>"
					+"<li><a onclick=searchUser('" + prePage + "') aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
					+"<li><a onclick=searchUser('" + nextPage + "') aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
					+"</ul>";
				$("#user_page").html(user_page);
			}
	    }
	})
}

//搜索主题帖标题
function searchTitle(pageNum){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	var searchTitleUrl = "/guestbook/rs/topicpost/selecttopicpostbysearchtitle";
	searchContent = decodeURI(searchContent);
	var obj = {
			pageNum:pageNum,
			searchContent:searchContent
	};
	var json = JSON.stringify(obj);
	$.ajax({
		url:searchTitleUrl,
	    type:'POST',
	    async:false,  
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	var prePage = parseInt(pageNum) - 1;
	    	var nextPage = parseInt(pageNum) + 1;
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}
	    	
			var title = "";
			jQuery.each(data.list,function(i,item){
				title = title + "<div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
							+item.id 
							+"' target='_blank'>"
							+item.title
							+"</a></div><div class='col-lg-3'>"
							+item.keyword
							+"</div><div class='col-lg-2'><a href='/guestbook/cust_info.html?uid=" 
							+item.userId
							+"' target='_blank'>"
							+item.userName
							+"</a></div><div class='col-lg-2'>" 
							+new Date(item.time).toLocaleString()
							+"</div><div class='col-lg-1'>"
							+item.replyNumber
							+"</div><br/>";
			});
			$("#search_title_list").html(title);
			if(title == ""){
				title = "<div class='col-lg-4' target='_blank'>找不到标题关于 <b>" 
						+searchContent 
						+"</b> 的帖子。</div><br/><hr/><br/><br/>";
				$("#search_title_null").html(title);
			}
			else{
				var title_page = "<ul class='pagination'>"
					+"<li><a onclick=searchTitle('" + prePage + "') aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
					+"<li><a onclick=searchTitle('" + nextPage + "') aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
					+"</ul>";
				$("#title_page").html(title_page);
			}
	    }
	})
}

//搜索主题帖内容
function searchContent(pageNum){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	var searchContentUrl = "/guestbook/rs/topicpost/selecttopicpostbysearchcontent";
	searchContent = decodeURI(searchContent);
	var obj = {
			pageNum:pageNum,
			searchContent:searchContent
	};
	var json = JSON.stringify(obj);
	$.ajax({
		url:searchContentUrl,
	    type:'POST',
	    async:false,  
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	console.log(data.list);
	    	var prePage = parseInt(pageNum) - 1;
	    	var nextPage = parseInt(pageNum) + 1;
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}
			var content = "";
			jQuery.each(data.list,function(i,item){
				content = content + "<div class='col-lg-4'>"
							+item.content
							+"</div><div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
							+item.id 
							+"' target='_blank'>"
							+item.title
							+"</a></div><div class='col-lg-1'><a href='/guestbook/cust_info.html?uid=" 
							+item.userId
							+"' target='_blank'>"
							+item.userName
							+"</a></div><div class='col-lg-2'>" 
							+new Date(item.time).toLocaleString()
							+"</div><div class='col-lg-1'>"
							+item.replyNumber
							+"</div><br/>";
			});
			$("#search_content_list").html(content);
			if(content == ""){
				content = "<div class='col-lg-4' target='_blank'>找不到内容关于 <b>" 
						+searchContent 
						+"</b> 的帖子。</div><br/><hr/><br/><br/>";
				$("#search_content_null").html(content);
			}
			else{
				var content_page = "<ul class='pagination'>"
					+"<li><a onclick=searchContent('" + prePage + "') aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
					+"<li><a onclick=searchContent('" + nextPage + "') aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
					+"</ul>";
				$("#content_page").html(content_page);
			}
	    }
	})
}

//搜索回复贴内容
function searchReplyContent(pageNum){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	var searchReplyPostContentUrl = "/guestbook/rs/topicpost/selecttopicpostbysearchreplypostcontent";
	searchContent = decodeURI(searchContent);
	var obj = {
			pageNum:pageNum,
			searchContent:searchContent
	};
	var json = JSON.stringify(obj);
	$.ajax({
		url:searchReplyPostContentUrl,
	    type:'POST',
	    async:false,  
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	var prePage = parseInt(pageNum) - 1;
	    	var nextPage = parseInt(pageNum) + 1;
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}
			var replycontent = "";
			jQuery.each(data.list,function(i,item){
				replycontent = replycontent + "<div class='col-lg-4'>"
							+item.replyContent
							+"</div><div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
							+item.topicPostId 
							+"' target='_blank'>"
							+item.topicPostTitle
							+"</a></div><div class='col-lg-1'><a href='/guestbook/cust_info.html?uid=" 
							+item.userId
							+"' target='_blank'>"
							+item.userName
							+"</a></div><div class='col-lg-2'>" 
							+new Date(item.time).toLocaleString()
							+"</div><div class='col-lg-1'>"
							+item.floor
							+"</div><br/>";
			});
			$("#search_replycontent_list").html(replycontent);
			if(replycontent == ""){
				replycontent = "<div class='col-lg-4' target='_blank'>找不到回复内容关于  <b>" 
						+searchContent 
						+"</b> 的回复贴。</div><br/><hr/><br/><br/>";
				$("#search_replycontent_null").html(replycontent);
			}
			else{
				var replycontent_page = "<ul class='pagination'>"
					+"<li><a onclick=searchReplyContent('" + prePage + "') aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
					+"<li><a onclick=searchReplyContent('" + nextPage + "') aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
					+"</ul>";
				$("#replycontent_page").html(replycontent_page);
			}
	    }
	})
}

//搜索关键字
function searchKeyword(pageNum){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	searchContent = decodeURI(searchContent);
	var searchKeywordContentUrl = "/guestbook/rs/topicpost/selecttopicpostbysearchkeywordcontent";
	
	var obj = {
			pageNum:pageNum,
			searchContent:searchContent
	};
	var json = JSON.stringify(obj);
	$.ajax({
		url:searchKeywordContentUrl,
	    type:'POST',
	    async:false,  
	    data: json,
	    contentType:"application/json",
	    dataType:'json',
	    success:function(data,textStatus,jqXHR){
	    	var prePage = parseInt(pageNum) - 1;
	    	var nextPage = parseInt(pageNum) + 1;
	    	if(data.isFirstPage){
	    		prePage = 1;
	    	}
	    	if(data.isLastPage ){
	    		nextPage = data.pages;
	    	}
			var keyword = "";
			jQuery.each(data.list,function(i,item){
				keyword = keyword + "<div class='col-lg-3'>"
				                +item.keyword
				                +"</div><div class='col-lg-4'><a href='/guestbook/contents.html?topicPostId="
				             	+item.id
				                +"' target='_blank'>"
				                +item.title
				                +"</a></div><div class='col-lg-2'><a href='/guestbook/cust_info.html?uid=" 
				                +item.userId
				                +"' target='_blank'>"
				                +item.userName
				                +"</a></div><div class='col-lg-2'>"
				                +new Date(item.time).toLocaleString()
				                +"</div><div class='col-lg-1'>"
				                +item.replyNumber
				                +"<br/><br/></div>";
			});
			$("#search_keyword_list").html(keyword);
			if(keyword == ""){
				keyword = "<div class='col-lg-4'>找不到关键字关于 <b>" 
						+searchContent 
						+"</b> 的帖子。</div><br/><hr/><br/><br/>";
				$("#search_keyword_null").html(keyword);
			}
			else{
				var keyword_page = "<ul class='pagination'>"
					+"<li><a onclick=searchKeyword('" + prePage + "') aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
					+"<li><a onclick=searchKeyword('" + nextPage + "') aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"
					+"</ul>";
				$("#keyword_page").html(keyword_page);
			}
	    }
	})
}

//高亮搜索内容
function highlightKeyword(){
	var searchContent = location.search.substring(1);;
	searchContent = searchContent.replace('searchContent=','');
	searchContent = decodeURI(searchContent);
	$("#search_user_list").highlight(searchContent);
	$("#search_title_list").highlight(searchContent);
	$("#search_content_list").highlight(searchContent);
	$("#search_replycontent_list").highlight(searchContent);
	$("#search_keyword_list").highlight(searchContent);
}

//数字模糊化
function vagueNumber(number){
	var remainder = number % 10;
	if(remainder == 0 || number < 10){
		return number;
	}
	else{
		return (number - remainder) + "+";
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