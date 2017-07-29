String.prototype.trim=function() {  
    return this.replace(/(^\s*)|(\s*$)/g,'');  
};  

$(function(){
	$(".item").click(function(){
		$(".select_item").removeClass("select_item");
		$(this).addClass("select_item");
		
		//是否带有url参数，有则执行加载页面操作
		var url = $(this).attr("url");
		if(url && url.trim()!=""){
			jumpPage(url);
		}
	});
	
	$(".title").click(function(){
		var _this = $(this);
		var selected = $(this).hasClass("select_title");
		
		//如果当前title为选中
		if(selected && $(this).next("ul").length>0){
			_this.removeClass("select_title").next().slideToggle(200);
		}else{
			$(".select_title").not(this).removeClass("select_title").next().slideToggle(200);
			_this.addClass("select_title").next().slideToggle(200);
			
			if(_this.next().children(".select_item").length==0){
				_this.next().children("li:first").click();
			}
		}
		
		//是否带有url参数，有则执行加载页面操作
		var url = _this.attr("url");
		if(url && url.trim()!=""){
			jumpPage(url);
		}
	});
	
	//初始化menu
	$("#cLeft .title").eq(0).click();
});

/**
 * 加载页面
 * @param url
 */
function jumpPage(url){
	try{
		swfu1.destroy();
	}catch(ex){
	}
	try{
		swfu2.destroy();
	}catch(ex){
	}
	try{
		swfu_editCohInfo.destroy();
	}catch(ex){
	}
	$("#body").layout("panel","center").panel("refresh",url);
}

