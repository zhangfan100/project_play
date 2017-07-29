$(document).ready(function() {
	
	$("#place_bar a").colorbox({rel:'group1',maxHeight:'600px',maxWidth:'800px'});
	$("#honor_bar a").colorbox({rel:'group2',maxHeight:'600px',maxWidth:'800px'});
	$("#focus").hover(function(){$("#focus-prev,#focus-next").show();},function(){$("#focus-prev,#focus-next").hide();});
	$("#focus").slide({ 
		mainCell:"#focus-bar-box ul",
		targetCell:"#focus-title a",
		titCell:"#focus-num a",
		prevCell:"#focus-prev",
		nextCell:"#focus-next",
		effect:"left",
		easing:"easeInOutCirc",
		autoPlay:true,
		delayTime:500
	});
	$("#focus_0").hover(function(){$("#focus-prev_0,#focus-next_0").show();},function(){$("#focus-prev_0,#focus-next_0").hide();});
	$("#focus_0").slide({ 
		mainCell:"#place_bar",
		targetCell:"#focus-title_0 a",
		titCell:"#focus-num_0 a",
		prevCell:"#focus-prev_0",
		nextCell:"#focus-next_0",
		effect:"left",
		easing:"easeInOutCirc",
		autoPlay:true,
		delayTime:1000
	});
	$("#focus_1").slide({ 
		mainCell:"#honor_bar",
		targetCell:"#focus-title_1 a",
		titCell:"#focus-num_1 a",
		prevCell:"#focus-prev_1",
		nextCell:"#focus-next_1",
		effect:"left",
		easing:"easeInOutCirc",
		autoPlay:true,
		delayTime:1000
	});
	
	$(".left_part_three h1 span").click(function(){
		$(this).siblings().removeClass("selected");
		$(this).addClass("selected");
		$(".left_part_three_box ul:not(.xy_head)").remove();
		var schoolId = $(this).attr("schoolId");
		loadStuData(schoolId);
		});
	loadStuData($(".left_part_three h1 span[class='f16 selected']").attr("schoolId"));
	
	$(".rank_head ul li").hover(function(){
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		},
		function(){
			$(this).removeClass("active");
			$(".rank_head .first").addClass("active");
		}) ;
});