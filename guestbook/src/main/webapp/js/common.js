function button_show_hide(){
window.onload=function(){
			var islogin = sessionStorage.getItem("islogin");
			if(islogin=="true"){
				show_btn();
			}else{
				hiden_btn();
			}
		};
}