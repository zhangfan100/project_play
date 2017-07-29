<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<script type="text/javascript" src="${path }/static/front/js/train_value.js"></script>
	<div class="right_content" id="editComment">
		<div class="right_box_0">
			<div class="main_box">
				<div class="value_0">
					<div class="value_title">评价内容</div>
					<div class="value_0_left">
						<ul>
							<li>教练：${currLessonInfo.name }</li>
							${currLessonInfo.subject==1?'课程：科目二':currLessonInfo.subject==2?'课程：科目三':'' }
							<li>培训代码：${currLessonInfo.lessonCode }</li>
						</ul>
					</div>
					<div class="value_0_right">
						<span>评论</span>
						<textarea rows="3" id="content" name="content"
							style="width:430px;height: 113px;color:rgb( 148, 140, 140 )"
							onfocus="if(this.value=='限250字以内') {this.value='';this.style.color='rgb( 54, 53, 53 )';};"
							onblur="if(this.value=='') {this.value='限250字以内';this.style.color=' rgb( 148, 140, 140 )';}">限250字以内</textarea>
						<div class="radio_group">
							<input type="radio" name="isHide" value="1" id="isHide-1" /> <label for="radiobutton_0">匿名</label> 
							<input type="radio" checked="checked" name="isHide" value="0" id="isHide-2" /> <label for="radiobutton_1">公开</label>
						</div>
					</div>
				</div>
				<div class="value_1">
					<div class="value_title">评分</div>
					<div class="compose-rating rating-quality">
						<div class="rating-title">教学质量</div>
						<div class="xzw_starSys">
							<div class="xzw_starBox">
								<ul class="star" id="star_0">
									<li><a href="javascript:void(0)" title="1"
										class="one-star">1</a></li>
									<li><a href="javascript:void(0)" title="2"
										class="two-stars">2</a></li>
									<li><a href="javascript:void(0)" title="3"
										class="three-stars">3</a></li>
									<li><a href="javascript:void(0)" title="4"
										class="four-stars">4</a></li>
									<li><a href="javascript:void(0)" title="5"
										class="five-stars">5</a></li>
								</ul>
								<div class="current-rating" id="showb_0"></div>
							</div>
							<!--评价文字-->
							<div class="score" id="score_0"></div>
							<div class="description" id="description_0"></div>
						</div>
					</div>
					<div class="compose-rating rating-atitude">
						<div class="rating-title">教学态度</div>
						<div class="xzw_starSys">
							<div class="xzw_starBox">
								<ul class="star" id="star_1">
									<li><a href="javascript:void(0)" title="1"
										class="one-star">1</a></li>
									<li><a href="javascript:void(0)" title="2"
										class="two-stars">2</a></li>
									<li><a href="javascript:void(0)" title="3"
										class="three-stars">3</a></li>
									<li><a href="javascript:void(0)" title="4"
										class="four-stars">4</a></li>
									<li><a href="javascript:void(0)" title="5"
										class="five-stars">5</a></li>
								</ul>
								<div class="current-rating" id="showb_1"></div>
							</div>
							<!--评价文字-->
							<div class="score" id="score_1"></div>
							<div class="description" id="description_1"></div>

						</div>
					</div>
					<div class="compose-rating rating-rule">
						<div class="rating-title">教学规范</div>
						<div class="xzw_starSys">
							<div class="xzw_starBox">
								<ul class="star" id="star_2">
									<li><a href="javascript:void(0)" title="1"
										class="one-star">1</a></li>
									<li><a href="javascript:void(0)" title="2"
										class="two-stars">2</a></li>
									<li><a href="javascript:void(0)" title="3"
										class="three-stars">3</a></li>
									<li><a href="javascript:void(0)" title="4"
										class="four-stars">4</a></li>
									<li><a href="javascript:void(0)" title="5"
										class="five-stars">5</a></li>
								</ul>
								<div class="current-rating" id="showb_2"></div>
							</div>
							<!--评价文字-->
							<div class="score" id="score_2"></div>
							<div class="description" id="description_2"></div>
						</div>
					</div>
				</div>
				<input type="button" value="发表评论" class="value_submit">
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(".value_submit").click(function(){
			var content = $("#editComment #content").val()=="限250字以内"?"":$("#editComment #content").val();
			if(content=="" || content == null){
				return;
			}
			var lessonInfoId="${currLessonInfo.id}";
			var isHide = $('input[name="isHide"]:checked').val();
			var qualityScore = $("#editComment #score_0").text();
			qualityScore = qualityScore.substr(0,qualityScore.length - 1);
			var serviceScore = $("#editComment #score_1").text();
			serviceScore = serviceScore.substr(0,serviceScore.length - 1);
			var ruleScore = $("#editComment #score_2").text();
			ruleScore = ruleScore.substr(0,ruleScore.length - 1);
			var data={
				lessonInfoId:lessonInfoId,
				content:content,
				isHide:isHide,
				qualityScore:qualityScore,
				serviceScore:serviceScore,
				ruleScore:ruleScore
			};
			$.ajax({
				type : "post",
				url : "${path}/stu/addCommentSubmit",
				data :data,
				success : function(data) {
					if(data=="1"){
						var random= Math.random();
						$('#right_panel').panel('refresh',"${path}/stu/lessonHistoryManage?random="+random);
					}
				}
			});
		});
	
	</script>
</body>