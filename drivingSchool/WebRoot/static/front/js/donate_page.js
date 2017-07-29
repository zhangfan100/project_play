$(document).ready(function() {
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
		/*prevCell:"#focus-prev_0",
		nextCell:"#focus-next_0",*/
		effect:"left",
		easing:"easeInOutCirc",
		autoPlay:true,
		delayTime:500
	});
});