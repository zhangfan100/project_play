var pagesize = 10;//每页条数
$(document).ready(function() {
 	$.ajax({							//获取总页数，设置pagesize
		type:"POST",
		url:"/school_notice.do",		//后台action，
		data: {page:1},	
		dataType:"json",
		success:function(notice){
			$("#notice_ul").html();
			for(var i=0;i<notice.total;i++){
				$("#notice_ul").('<li></li>');
			}
			pagesize = notice.pageSize;	//每页条数
			
			$("div.holder").jPages({
				containerID : "notice_ul",
				previous : "",
				next : "",
				perPage : pagesize,
				delay : 20,
				callback : pageAjax
			});	
		};
    });
	
});

//分页回调
function pageAjax( pages, items ) { 
	//alert(pages.current);  				//获取被选中的页数
	$.ajax({
		type:"POST",
		url:"/school_notice.do",			//后台action
		data: {page:pages.current},			//请求 第pages.current页 的公告
		dataType:"json",
		success:function(notice){
			for(var i=0;i<pagesize;i++){
				var content = '<span class="arrow">></span>'
							+ '<a id=' + notice.rows[i].id + '>'
							+ 	'<span class="notice_title">' + notice.rows[i].title + '</span>'
							+ 	'<span class="notice_time">' + notice.rows[i].time + '</span>'
							+ '</a>';
				//放入内容
				$("#notice_ul").find("li").eq( (pages.current-1)*pagesize+i ).html(content);
			}
		};
	});
};
	