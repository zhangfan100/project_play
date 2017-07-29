<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/JSLib.jsp"%>

<body>
			<div class="right_content train_statistics">
				<h2>培训统计</h2>
				<div class="right_box_0">
					<div class="train_hour_cal" id="container1">
						<h4>学时统计</h4>
						<ul>
							<li>
								<div class="train_hour_head">
								科目一学时统计
								</div>
								<div class="train_hour_content">
								<span class="gold m1"></span>
								</div>
							</li>
							<li>
								<div class="train_hour_head">
								科目二学时统计
								</div>
								<div class="train_hour_content">
								<span class="gold m2"></span>
								</div>
							</li>
							<li>
								<div class="train_hour_head">
								科目三学时统计
								</div>
								<div class="train_hour_content">
								<span class="gold m3"></span>
								</div>
							</li>
							<li>
								<div class="train_hour_head">
								科目四学时统计
								</div>
								<div class="train_hour_content">
								<span class="gold m4"></span>
								</div>
							</li>
						
						</ul>
					
					</div>
					<div class="train_hour_detail" id="train_hour_detail">
						<ul>
							<li></li>
							<li>单项总次数</li>
							<li>单项通过次数</li>
							<li>单项通过率</li>
						</ul>
					</div>
					<div class="train_chart" style="margin-top:30px;">
						<h4>最近7次培训趋势图</h4>
						<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
					</div>
				</div>
				
			</div>
			
			<!-- template -->
			<ul id="templateTraiItem" class="train_item" style="display:none;">
				<li class="t1"></li>
				<li class="t2"></li>
				<li class="t3"></li>
				<li class="t4"></li>
			</ul>
	
	<script type="text/javascript">
	var set = {
			title : {
				text : '最近7次培训趋势图',
				x : -20
			},
			credits : {
				text : '培训统计'
			},
			xAxis : {
				categories : [ '第一次', '第二次', '第三次', '第四次', '第五次', '第六次', '第七次' ]
			},
			yAxis : {
				title : {
					text : '培训通过率'
				},
				labels : {
					formatter : function() {
						return this.value + '33%';
					}
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ],
				min: 0,
				max: 100
			},
			tooltip : {
				valueSuffix : '%'
			},
			legend : {
				layout : 'horizontal',
				align : 'center',
				verticalAlign : 'bottom',
				borderWidth : 0
			}
		};
	
	
	//0-基础培训,1-倒车入库,2-坡道停车和起步,3-侧方位停车,4-直角转弯,5-曲线行驶,6-单边桥
	var traiItem = ["基础培训","倒车入库","坡道停车和起步","侧方位停车","直角转弯","曲线行驶","单边桥"];
	
	//学员学时统计
	function queryPeriodStatistics(){
		var con = $("#container1"); 
		$.post("${path}/stu/queryPeriodStatistics", function(data) {
			data = $.parseJSON(data);
			$.each(data,function(index,item){
				switch(item.subject){
					case 0:con.find(".m1").text(item.total);break;
					case 1:con.find(".m2").text(item.total);break;
					case 2:con.find(".m3").text(item.total);break;
					case 3:con.find(".m4").text(item.total);break;
				}
			});
		});
	}
	
	
	//学员培训统计数据
	function queryTrainStatistics(){
		$.post("${path}/stu/queryTrainStatistics", function(data) {
			data = $.parseJSON(data);
			
			$.each(data.series, function(index, item) {
				item['name'] = traiItem[item.name];
			});
			set.series = data.series;
			set.xAxis = {categories: data.times};
			$('#container').highcharts(set);
		});
	};
	
	//加载表格数据
	function queryTrainStatisticsTable(){
		$.post("${path}/stu/queryTrainStatisticsTable",function(data){
			data = $.parseJSON(data);
			$("#train_hour_detail .train_item").remove();
			var _con = $("#train_hour_detail");
			
			$.each(traiItem,function(index1,item1){
				var obj = $("#templateTraiItem").clone(true).show().removeAttr("id");
				_con.append(obj);
				obj.find(".t1").text(item1);
				//没有数据直接设置为0
				if(data.length<1){
					obj.find(".t2").text("0");
					obj.find(".t3").text("0");
					obj.find(".t4").text("0%");
					return;
				}
				$.each(data,function(index,item){
					if(index1 == item.traiItem){
						obj.find(".t2").text(item.total);
						obj.find(".t3").text(item.pass);
						obj.find(".t4").text(item.passRate+"%");
					}
				});
			});
		});
	}
	
	queryPeriodStatistics();
	queryTrainStatisticsTable();
	queryTrainStatistics();
	</script>
</body>

