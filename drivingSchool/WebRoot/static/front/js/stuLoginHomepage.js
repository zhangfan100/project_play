$(document).ready(function() {
	$(".left_part_two h1 span").click(function(){
		$(this).siblings().removeClass("selected");
		$(this).addClass("selected");
		if($(this).text()=="南山校区"){
			$(".nsxqjl").css("display","block");
			$(".lqxqjl").css("display","none");
		}else{
			$(".lqxqjl").css("display","block");
			$(".nsxqjl").css("display","none");
		}
		
		});
	$(".left_part_three h1 span").click(function(){
		$(this).siblings().removeClass("selected");
		$(this).addClass("selected");
		if($(this).text()=="南山校区"){
			$(".nsxqxy").css("display","block");
			$(".lqxqxy").css("display","none");
		}else{
			$(".lqxqxy").css("display","block");
			$(".nsxqxy").css("display","none");
		}
		
		});
	$(".rank_head ul li").hover(function(){
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		},
		function(){
			$(this).removeClass("active");
			$(".rank_head .first").addClass("active");
		}) ;
});