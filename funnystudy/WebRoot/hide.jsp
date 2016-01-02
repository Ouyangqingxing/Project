<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>隐藏关卡</title> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
	
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/hide.css"/>
  </head>
  
  <body style="background-image:url(images/starNight.jpg);background-repeat:no-repeat;background-size:cover;"> 
  		<div>
		  	<img src= "images/face/boy8.jpg"  id="hideHero" class="hideHero"  alt="hideHero" width="100px" height="100px"/>
		</div>
		
		<div id="jbox" class="jbox">
		  	<a href="<%=basePath%>GetWuGong.action"><img src= "images/jbox.png"  id="jbox"  alt="jbox"/></a>	   
		</div>
		
		<!-- =======================================剧情对话======================================= --> 
  		<div class="text">
  			<img src= "images/face/boy8.jpg" class="person1"  width="100px" height="100px"/>
  			<img src= "images/face/boy3.jpg" class="person2"  width="100px" height="100px" style="displaye:none;"/>
  			<img src= "images/face/boy6.jpg" class="person3"  width="100px" height="100px" style="displaye:none;"/> 
  			<img src= "images/dhk.jpg" style="position: absolute;left: 140px;border-radius: 10px;margin: 0px;width: 358px;"  width="400px" height="120px"/> 
  			
  			<p id="p1">少年的梦呓：<br>
  				<span style="color:red">寒修</span>……你真不够哥们……	
  			</p>		 
  			<p id="p2">少侠：<br>
 				 你醒了？
  			</p>	
  			<p id="p3">欧阳辰：<br>
  				我叫<span style="color:red">欧阳辰</span>，那日见你受伤在地，就将你带到府上了。
  			</p> 			
  			<p id="p4">墨青玄：<br>
  				咳……多谢，在下<span style="color:red">墨青玄</span>。欧阳兄，当日伤我那位黑衣少侠……
  			</p> 			
  			<p id="p5">欧阳辰：<br>
  				你们应该认识吧？他见你被他手下的人误伤后，给你运气疗伤后就走了……看起来，你们应该是……
  			</p>  			
   			<p id="p6">墨青玄：<br>
  				…………都是过去的事了。不过他那黑色长袍上绣着的“邪”，似乎是某种帮派的服饰。欧阳兄可知道？
  			</p> 			
  			 <p id="p7">欧阳辰：<br>
  				嗯，自然是<span style="color:red">黯邪</span>的<span style="color:red">魅邪教</span>了。
  			</p>			
  			<p id="p8">墨青玄：<br>
  				魅邪教？
  			</p>		
  			<p id="p9">欧阳辰：<br>
  				是的。我对这个黯邪的底细尚未了解透彻。
  			</p> 		 
  			<p id="p10">欧阳辰：<br>
  				不过此人心狠手辣，武功上又非等闲之辈，现在已经笼络了一群江湖恶人，俨然有种妄一统江湖之势。
  			</p>
  			<p id="p11">欧阳辰：<br>
  				我等最近也在号召江湖中正道中人，希望能够建立联盟……
  			</p> 
   			<p id="p12">墨青玄：<br>
  				我愿意加入你们联盟！
  			</p> 			
  			<p id="p13">欧阳辰：<br>
  				……嗯，自然是不错，那日也见识过少侠的武功。不过就目前看来我盟和邪教实力仍太悬殊，可惜，如果<span style="color:red">浣月宫</span>能和我们联手就好了……
  			</p> 
  			<p id="p14">墨青玄：<br>
  				浣月宫!
  			</p> 
  			<p id="p15">欧阳辰：<br>
  				怎么？青玄兄有所了解吗？
  			</p> 
  			<p id="p16">墨青玄：<br>
  				没……没(噫，差点就说出来了……不知道祈小玉回宫没有……)
  			</p> 
  			<p id="p17">欧阳青星：<br>
  				…………
  			</p> 
  			<p id="p18">欧阳青星：<br>
  				小站还在测试中，目前就讲到这儿啦！用↑↓←→控制小人拿到宝箱吧！登陆后可以领取一个武功哦！
  			</p>
  			
  			<span style="color: #666;position: absolute;top: 96px;left: 450px;">click~</span>
  			
  		</div>
 		
 		<script type="text/javascript">
        
        	$(function(){
        	    $('.text p:not(:first)').hide();
        	    var num = $(".text p").length;
        	    console.log(num);
        	    var index=num;
        	    $(".jbox").click(function(){
        	    	alert("真机智!现在把你传送回主页咯，记得去查看获得的武功~");
        	    });
				$(".text").click(function(){
					index--; 
					$(this).find('p').hide().eq(num-index).show();

					if(index==17||index==16||index==14||index==12||index==10||index==9||index==8||index==6||index==4)
					{
						$('.person1').hide();
						$('.person2').show();
					}
					else if(index==18 || index==15 || index==13 || index==11 || index==7 ||index==5 ||index==3)
					{
						$('.person1').show();
						$('.person2').hide();
					}
					else if(index==1 || index ==2)
					{
						$('.person3').show();
						$('.person1').hide();
						$('.person2').hide();
					}
					else if(index==0)
					{
						$('.text').hide(); 
					} 
				});
			});
         
        //获取键盘ascII码;
        //$(document).keydown(function (event) 
        //{
        //    alert(console.log(event.keyCode));
        //    alert(event.keyCode);
        //});
        $(document).keydown(function (event) 
        {  
            if (event.keyCode == 38 && parseInt($(".hideHero").css('top'))>201) 
            { 
                $(".hideHero").animate({ 	top:'-=100px'	,				},"fast");
            } 
            if (event.keyCode == 40 && parseInt($(".hideHero").css('top'))<499) 
            { 
                $(".hideHero").animate({ 	top:'+=100px'	,				},"fast");
            } 
            
            if (event.keyCode == 37 && parseInt($(".hideHero").css('left'))>501) 
            { 
                $(".hideHero").animate({ 	left:'-=100px'	,				},"fast");
            }
            
            if (event.keyCode == 39 && parseInt($(".hideHero").css('left'))<699) 
            { 
                $(".hideHero").animate({ 	left:'+=100px'	,				},"fast");
            }

        	});
    </script>
 		 
  </body>
  
</html>
