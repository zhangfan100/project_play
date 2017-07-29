$(document).ready(function() {
	$('#right_panel').panel({  
		  cache:"true",
		  doSize:"true",
		  noheader:true,
		  border:false
		});   
	$(".person_nav_li ul li").click(function(){
			$(".selected_li").removeClass("selected_li");
			$(this).addClass("selected_li");
			
		});
});
function jumpPage(url,obj){
	$(".left_content .selected").removeClass("selected");
	$(obj).addClass("selected");
	url += ("?sign="+$(obj).attr("url")+"&_"+Math.random());
	$('#right_panel').panel('refresh',url);
}

