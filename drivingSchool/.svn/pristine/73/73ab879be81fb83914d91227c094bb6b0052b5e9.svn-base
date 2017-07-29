<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<div class="right_content train_detail" id="lessonHistoryManage">
	<h2>培训详细</h2>
	<div class="right_box_0">
		<div class="train_detail_0">
			<ul>
				<li id="all"><a href="javascript:void(0)" style="color:black" onclick="queryCourse(0);">所有课程</a></li>
				<li><a href="javascript:void(0)" style="color:black" onclick="queryCourse(1);">科目二 <span class="gold" id="course2">${subCount.s1}</span></a></li>
				<li><a href="javascript:void(0)" style="color:black" onclick="queryCourse(2);">科目三 <span class="gold" id="course3">${subCount.s2}</span></a></li>
				<li></li>
			</ul>
		</div>
		<div class="train_detail_1" >
			<ul>
				<li></li>
				<li>培训时间</li>
				<li>课程</li>
				<li>教练 </li>
				<li>培训代码</li>
				<li>培训状态</li>
				<li></li>
			</ul>
			<div class="train_detail_2" id="train_detail_2">
			
			</div>
		</div>
	</div>
		<div class="holder"></div>
	</div>
	<script type="text/javascript">
	//查看明细
	function detailView(id){
		$('#right_panel').panel('refresh','${path}/stu/toTrainDetail?trainCode='+id);
	}
	
	//评价
	function evaluation(id,teacherName,lessonType,lessonCode){
		$('#right_panel').panel('refresh',"${path}/stu/addComment?lessonInfoId="+id);
	}
	
	function queryCourse(lessonType){
		$.ajax({
			type:'POST',
			url:'${path}/stu/qureyStuLessonTrainInfo',
			data:{
				subject:lessonType
			},
			dataType:'json',
			success:function(data){
				$("#train_detail_2 ul").remove();
				var html='';
				for(var i=0;i<data.length;i++){
					var row=data[i];
					html+='<ul><li><span>'+eval(i+1)+'</span></li>';
					html+='<li><span style="width:150px">'+row.beginTime+'</span></li>';
					if(row.subject=='1'){
						html+='<li><span>科目二</span></li>';
					}else{
						html+='<li><span>科目三</span></li>';
					}
					if(row.lessonStatus==2){
						row.lessonStatus='已完成';
					}else{
						row.lessonStatus='培训异常';
					}
					html+='<li>'+row.cohName+'</li>';
					html+='<li>'+row.lessonCode+'</li>';
					html+='<li><span class="light_green">'+row.lessonStatus+'</span></li>';
					if(row.lessonStatus!='培训异常'){
						html+='<li><a href="javascript:void(0)" class="gold" onclick="detailView('+row.id+')">查看明细</a>';
					}else{
						html+='<li><a href="javascript:void(0)" class="gold" onclick="detailView('+row.id+')"></a>';
					}
					if(row.count==0){
						html+='<a href="javascript:void(0)" class="grey" onclick="evaluation('+row.id+')">评价</a>';
					}
					html+='</li></ul>';
				}
				$("#train_detail_2").html(html);
				
				//分页
				paging();
			}
		});
	}
	queryCourse(0);
	
	
	function paging(){
		 $("#lessonHistoryManage .holder").jPages({
			containerID : "train_detail_2",
			previous : "",
			next : "",
			perPage : 8,
			delay : 20,
			callback : function(page, itemRange, pageInterval) {
			}
		}); 
	}
	</script>
</body>
