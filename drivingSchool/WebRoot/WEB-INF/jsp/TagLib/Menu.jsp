<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>${jx_chineseName }</title>
<div class="header">
	<div class=" clearfix">
		<div class="col-md-3 column header_left">
			<img style="width:88px;height:88px;cursor:pointer;" src="<c:if test='${not empty jxlogo}'>${path}${jxlogo}</c:if>" onclick="javascript:window.location='${path}'">
			<div class="logo_letter" style="margin-top:8px;">
				<span class="hanzi">${jx_chineseName }</span>
				<span class="pingyin">${jx_englishName }</span>
			</div>
		</div>
		<div class="col-md-9 column  header_right">
			<div class="row clearfix">
				<div class="col-md-12 column header_top f12">
					<ul class="grey sitemap_ul">
						<li class="sitemap_li" ><a class=""  href="${path}/stu/stuIndex?sign=/stu/editStudentInfo">个人中心</a></li>
		                <li class="sitemap_gap">|</li>
		               	<li class="sitemap_li" ><a class=""  href="${path}/stu/stuIndex?sign=/stu/lessonHistoryManage">我的课程</a></li>
		                <li class="sitemap_gap">|</li>
		                <li class="sitemap_li" ><a class=""  href="">帮助中心</a></li>
		                <li class="sitemap_gap">|</li>
		                <li class="sitemap_li" ><a class=""  href="" >平台客服</a></li>
		                 <c:if test="${loginInfo ne null}">
		                 <li class="sitemap_gap">|</li>
		                 <li class="sitemap_li" ><a class="" id="logout" href="javascript:void(0);" >退出</a></li>
		                </c:if>
		            </ul>
				</div>
			</div>
			<div class="row clearfix">
				<div class="header_bottom">
					<form class="form-search search_box" action="${path }/stu/redirectCoachshow">
						<input class="input-medium search-query" type="text" id="cx_teachername" name="cx_teachername" value="  教 练" onfocus="if(this.value == this.defaultValue) this.value = '';"
							onblur="if(this.value == '') this.value = this.defaultValue;"/>
						<input type="hidden" id="signs" name="signs" value="1"/>
						<input type="submit" class="f14 white yahei submit_button" value="搜 索">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="topnav f16">
	<div class="ll">
		<ul class="menu_top" id="menu_top">
			<li id="indx" class=" active"><a href="${path }/froIndex" >首 &nbsp;&nbsp;&nbsp;页</a></li>
           	<li><a class="dynamic"  href="${path }/pageMessage/profile">公司简介</a></li>
            <li><a class="dynamic"  href="${path}/pageMessage/profile" >培训介绍</a></li>
            <li id="teacherFc"><a class="dynamic"  href="${path }/coachshow/redirectCoachshow">教练风采</a></li>
            <li><a class="dynamic"  href="${path }/pageMessage/profile">操作指南</a></li>
            <li><a href="${path }/queryCampus" class="dynamic">驾校地图</a></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
$.get("${path}/queryMenu",function(data){
	data = $.parseJSON(data);
	$(".dynamic").each(function(){
		var _menu1 = $(this).parent();
		var txt = _menu1.text().trim();
		$.each(data,function(index,item){
			if(item.kindName == txt){//--找到对应的一级菜单"公司简介"
				var href = _menu1.children("a").attr("href");
				_menu1.children("a").attr("href","javascript:void(0);");
				var menu2_box = $('<ul class="sub-menu"></ul>');
				$.each(item.children,function(index,item2){
					var menu2 = $('<li><a href="javascript:void(0);">'+item2.traiName+'</a></li>');
					if(item2.seperateSchoolId==0){
						menu2.children("a").html(item2.title);
						menu2.children("a").attr("href",href+"?kindId="+item2.kindId+"&id="+item2.id);
						menu2_box.append(menu2);
						return true;
					}
					menu2_box.append(menu2);
					var menu3_box = $("<ul></ul>");
					menu2.children("a").append("<span></span>");
					menu2.append(menu3_box);
					$.each(item2.children,function(index,item3){
						var menu3 = $('<li><a href="'+href+'?kindId='+item3.kindId+'&id='+item3.id+'">'+item3.title+'</a></li>');
						menu3_box.append(menu3);
					});
				});
				_menu1.append(menu2_box);
				return false;
			}
		});
	});
	
	$("#logout").click(function(){
		$.post("${path}/logout",function(){
			window.location = "${path}/stu/login";
		});
	});
		
});
</script>