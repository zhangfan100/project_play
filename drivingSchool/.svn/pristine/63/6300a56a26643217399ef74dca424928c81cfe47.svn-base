$(document).ready(function() {
	$("div.holder").jPages({
	      containerID : "rank_content_ul",
	      previous : "",
	      next : "",
	      perPage :5,
	      delay : 20
	    });
	
	$(document).on('click', '.check_grade', function() {
		$.blockUI({ 
	            message: $('.check_points'), 
	            css: { 
	            	position:'fixed',
	            	top: (document.body.clientHeight - 900) /2 + 'px', 
	                left:(document.body.clientWidth - 688) /2 +'px', 
	                width: '688px'
	
	                /*top:  ($(window).height() - 117) /2 + 'px', 
	                left: ($(window).width() - 421) /2 + 'px', 
	                width: '421px' */
	            } 
	        }); 
	  }); 
	
	
	
	$(".close_points").click(function(){
		
		$.unblockUI();
		
	});
});