/**为最后提交时整体判断（是否能将注册信息给后台）的函数
 * 包括（1不能为空、2用户名未注册、3密码一致、4验证码正确）
 * @returns {Boolean}
 */
function checkAll()
{
	//拿到表单中的所有信息  包括（用户名、密码、重复密码、签名、验证码、隐藏框的值）
	var username =document.getElementById("username").value;
	var password =document.getElementById("password").value;
	var password2=document.getElementById("password2").value;
	var remark	 =document.getElementById("remark").value;
	var checkcode=document.getElementById("checkcode").value;
	var userHide1=document.getElementById("userHide1").value;
	
    if( username == "" ||  password == "" || password2 == ""|| remark == ""|| checkcode == "")
    {
		alert("你还有信息未填完哦！");
		
		return false;
    }
	else if(userHide1 == "usernameNo")
	{
		alert("这个用户名已经被注册了，开动脑筋再想一个吧！");
		return false;
	}
	else if(userHide1 == "usernameNo2")
	{
		alert("用户名不能为空哦！");
		return false;
	}
	else if(userHide1 == "usernameNo3")
	{
		alert("用户名中不能有空格哦！");
		return false;
	}
	else if(password!=password2)
	{
		alert("两次密码不一致哦！");
		return false;
	}
	else
	{
		return true;
	}
}

/**判断用户名是否可用 并在输入框后面给出提示
 */
function checkUsername()
{
	var username = document.getElementById("username").value;
	$.ajax
	({		
		url:"CheckName.action",//url，表示需要请求的地址。
		data:{userName:username},//data，使用JSON格式，向后台传数据，userName为数据名，username为值		
		//data:{userName : encodeURI(encodeURI(username))},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		type:'post',
		
		dataType:"text",//dataType，后台回传给前台时使用的数据格式		
		async:true,//async，表示是否为异步请求，一般为true 
		
		
		//success和error，两个回调方法，只调用一个，成功success，失败error
		success:function(data)
		{
			if(data=="usernameYes")
			{
				document.getElementById("span").innerHTML ="可以使用的用户名";
				document.getElementById("userHide1").value="usernameYes";
			}
			else if(data=="usernameNo2")
			{
				document.getElementById("span").innerHTML ="用户名不能为空哦";
				document.getElementById("userHide1").value="usernameNo2";
			}
			else if(data=="usernameNo3")
			{
				document.getElementById("span").innerHTML ="用户名中不能有空格哦";
				document.getElementById("userHide1").value="usernameNo3";
			}
			else
			{
				document.getElementById("span").innerHTML ="该用户名已存在";
				document.getElementById("userHide1").value="usernameNo";
			}
		}
	});
}

/**判断密码的强度 并给出提示
 * @param obj
 */
function checkPassword(obj)
{
	var t=obj.value;
	var id=getResult(t);
	
	//定义对应的消息提示
	var msg=new Array(4);
	msg[0]="密码过短。";
	msg[1]="密码强度差。";
	msg[2]="密码强度良好。";
	msg[3]="密码强度高。";
	  
	var sty=new Array(4);
	sty[0]=-45;
	sty[1]=-30;
	sty[2]=-15;
	sty[3]=0;
	  
	var col=new Array(4);
	col[0]="gray";
	col[1]="red";
	col[2]="EEEE00";
	col[3]="Green";
	  
	//设置显示效果
	//var bImg="img/password.gif";//一张显示用的图片
	var sWidth=300;
	var sHeight=15;
	var Bobj=document.getElementById("span2");

	Bobj.style.fontSize="12px";
	Bobj.style.color=col[id];
	Bobj.style.width=sWidth + "px";
	Bobj.style.height=sHeight + "px";
	Bobj.style.lineHeight=sHeight + "px";
	Bobj.style.textIndent="20px";
	Bobj.innerHTML="     "+"检测提示：" + msg[id];
}
function getResult(s)
{
	//定义检测函数,返回0/1/2/3分别代表无效/差/一般/强
	if(s.length < 4)
	{
		return 0;
	}
	var ls = 0;
	if (s.match(/[a-z]/ig))
	{
		ls++;
	}
	if (s.match(/[0-9]/ig))
	{ 
		ls++;
	}
	if (s.match(/(.[^a-z0-9])/ig))
	{
	    ls++;
	}
	if (s.length < 6 && ls > 0)
	{
	    ls--;
	}
	return ls;
}

/**判断两次密码是否一致
 */
function checkPassword2() 
{        
	var sWidth=300;
	var sHeight=15;
    var password=document.register.password.value;  
    var password2=document.register.password2.value;
       
    if (password == password2)
    {	
       	var Bobj=document.getElementById("span3");
       	Bobj.style.fontSize="12px";
       	Bobj.style.color="green";
       	Bobj.style.width=sWidth + "px";
       	Bobj.style.height=sHeight + "px";
       	Bobj.style.lineHeight=sHeight + "px";
       	Bobj.style.textIndent="20px";
       	Bobj.innerHTML="    "+"两次密码一致"; 
    } 
    else
    {
       	var Bobj=document.getElementById("span3");
       	Bobj.style.fontSize="12px";
       	Bobj.style.color="red";
       	Bobj.style.width=sWidth + "px";
       	Bobj.style.height=sHeight + "px";
       	Bobj.style.lineHeight=sHeight + "px";
       	Bobj.style.textIndent="20px";
       	Bobj.innerHTML="    "+"两次密码不一致!"; 
    }
}  

/**验证码的点击换图
 * @param img
 */
function changeImage(img)
{
    img.src = img.src + "?" + new Date().getTime();
}
