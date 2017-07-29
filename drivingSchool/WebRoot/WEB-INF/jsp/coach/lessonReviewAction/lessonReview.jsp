<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>
<body style="overflow:hidden;">

	<!-- 评论统计 -->
	<div id="center-comment_statistic" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center',border:false" >
			<div id="" class="easyui-layout" data-options="fit:true" style="max-width:900px;"> 
				<div class="comment_statistic_title" data-options="region:'north',border:false" >
					
					<span>评分统计</span>
				</div>
				<div data-options="region:'center',border:false" style="">
					<div class="comment_statistic_detail" >
						<ul class="clearfix">
							<li>
								<span style="color:#ff8400;" class="s1">0</span><span class="article">分</span><br/>
								<span class="description">综合评分<span>
							</li>
							<li>
								<span class="number s2">0</span><span class="article">条</span><br/>
								<span class="description">5分评价<span>
							</li>
							<li>
								<span class="number s3">0</span><span class="article">条</span><br/>
								<span class="description">4分评价<span>
							</li>
							<li>
								<span class="number s4">0</span><span class="article">条</span><br/>
								<span class="description">3分评价<span>
							</li>
							<li>
								<span class="number s5">0</span><span class="article">条</span><br/>
								<span class="description">2分评价<span>
							</li>
							<li>
								<span class="number s6">0</span><span class="article">条</span><br/>
								<span class="description">1分评价<span>
							</li>
							
						</ul>
						
					</div>
				</div>
			</div>

		</div>
	</div>
	<script type="text/javascript">
	
		//获取评分统计信息
		$.post("${path}/coh/querylessonReview",function(data){
			data = $.parseJSON(data);
			$(".s1").text(data['compositeScore']);
			$(".s2").text(data['5.0']);
			$(".s3").text(data['4.0']);
			$(".s4").text(data['3.0']);
			$(".s5").text(data['2.0']);
			$(".s6").text(data['1.0']);
		});
	</script>
</body>
