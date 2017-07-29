$(document).ready(function() {
	/*分页,分页大小perpage*/
	var perpage = 6;
	/**$("div.holder").jPages({
	      containerID : "rank_content_ul",
	      previous : "",
	      next : "",
	      perPage : perpage,
	      delay : 20
	    });*/
	
	$(".sx_list ul li span:not(.sx_title)").click(function(){
		
		$(this).siblings().removeClass("back");
		$(this).addClass("back");
		
	});
    $(".sx_list ul li span:not(.sx_title)").hover(function () {  
        /*$(this).addClass("in");  */
       }, //mouseenter  
         function () {  
            if(!$(this).parent().children().hasClass("back")){
               $(this).siblings(".no_request").addClass("back");
            } 
        });//mouseleave  
});