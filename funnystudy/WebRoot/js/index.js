$(document).ready(function()
{
	//初始的时候的样式变动   
    $("div#indexFont2").animate({	opacity:'0.5',	});
  
    //鼠标经过的事件。注意，只执行一次.
    $("div#indexFont2").one("mouseover",function()
    {
    	//欢迎文字的变化
    	$("div#indexFont1").animate({ 	left:'+=100px'	,				});
		//链接图片的变化
	    $("div#indexFont2").animate({ 	left:'+=100px'	,opacity:'1',	});
	    
	    $("div#indexStar1").animate({ 	opacity:'0'		,				});
	    $("div#indexStar1").animate({ 	left:'+=975px'	,top:'130px'	,	});
	    $("div#indexStar1").animate({ 	opacity:'1'		,				});
	    
	    $("div#indexStar2").animate({ 	opacity:'0'		,				});
	    $("div#indexStar2").animate({ 	left:'+=975px'	,top:'260px',	});
	    $("div#indexStar2").animate({ 	opacity:'1'		,				});
	    
	    $("div#indexStar3").animate({ 	opacity:'0'		,				});
	    $("div#indexStar3").animate({ 	left:'+=500px'	,top:'260px',	});
	    $("div#indexStar3").animate({ 	opacity:'1'		,				});
	    
	    $("div#indexStar4").animate({ 	opacity:'0'		,				});
	    $("div#indexStar4").animate({ 	left:'+=500px'	,top:'130px',	});
	    $("div#indexStar4").animate({ 	opacity:'1'		,				});
	    
	    //中间图片的变化
	    $("div#indexCentre").animate({	opacity:'0',	});	
	    
	    $("div#indexCentre").animate({	display:'none',	});	
    });

    
    //小鬼和 ufo图片的变化
    $("div#indexStar1").one("click",function()
    {  
	    $("div#indexGhost").animate({	left	:'+=1000px'	,						},5000);
	    $("div#indexGhost").animate({	opacity	:'0'		,						},"fast");
	    
	    $("div#indexUFO").animate({	opacity	:'0'								},"fast");
	    $("div#indexUFO").animate({	opacity	:'1'		,	},"fast");
	    $("div#indexUFO").animate({	left	:'+=1000px'	,						},5200);
	    $("div#indexUFO").animate({	opacity	:'0'		,						},"fast");
	    
	    $("div#indexUFO").animate({		top	:'0px'	,	left:'-50px',		},"fast");
	    $("div#indexGhost").animate({	top	:'0px'	,	left:'-50px',		},"fast");
	    
    });
    
    
    
    //鼠标移出事件
    $("div#indexFont2").mouseover(function()
    {
		//欢迎文字的变化
		//$("div#indexFont1").animate({ 	left:'-=100px',	});  
		//链接图片的变化
	    $("div#indexFont2").animate({	opacity:'1',	});
	    //中间图片的变化
	    //$("div#indexCentre").animate({	opacity:'0.8',	});
    });
    //鼠标移出事件
    $("div#indexFont2").mouseleave(function()
    {
		//欢迎文字的变化
		//$("div#indexFont1").animate({ 	left:'-=100px',	});  
		//链接图片的变化
	    $("div#indexFont2").animate({	opacity:'0.5',	});
	    //中间图片的变化
	    //$("div#indexCentre").animate({	opacity:'0.8',	});
    });
});

//


