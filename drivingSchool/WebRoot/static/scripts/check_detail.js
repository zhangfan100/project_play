$(document).ready(function() {
	
	$(document).on('click', '.check_grade', function() {
		window.onmousewheel=function(){return false}; 
		$.blockUI({ 
	            message: $('.check_points'), 
	            css: { 
	            	position:'fixed',
	            	top: (document.body.clientHeight - 1200) /2 + 'px', 
	                left:(document.body.clientWidth - 838) /2 +'px', 
	                width: '838px',
	                cursor:'auto'
	                /*top:  ($(window).height() - 117) /2 + 'px', 
	                left: ($(window).width() - 421) /2 + 'px', 
	                width: '421px' */
	            } 
	        }); 
	  }); 
	
	
	
	$(".close_points").click(function(){
		window.onmousewheel=function(){return true};
		$.unblockUI();
		
	});
});