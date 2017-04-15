function hide(userid){
	var url = "/guestbook/rs/user/state"; 
	var obj = {
			id:userid,
			state:0
	};
	var Jobj = JSON.stringify(obj);
	$.ajax({
	    url:url,
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data: Jobj,
	    contentType:"application/json",
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	    	window.location.reload();
	    }
	})
}

function recover(userid){
	var url = "/guestbook/rs/user/state"; 
	var obj = {
			id:userid,
			state:1
	};
	var Jobj = JSON.stringify(obj);
	$.ajax({
	    url:url,
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data: Jobj,
	    contentType:"application/json",
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	    	window.location.reload();
	    }
	})
}
//设为管理员
function updateadmin(userid){
	var url = "/guestbook/rs/user/beadmin"; 
	
	var Jobj = JSON.stringify(userid);
	$.ajax({
	    url:url,
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data: Jobj,
	    contentType:"application/json",
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    success:function(data,textStatus,jqXHR){
	    	if (data) {
				window.location.reload();
			}else{
				alert("失败")
			}
	    }
	})
}
