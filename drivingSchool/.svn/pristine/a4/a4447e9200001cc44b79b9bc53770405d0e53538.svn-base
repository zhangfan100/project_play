<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<%@include file="../../TagLib/JSLib.jsp"%>
  <body>
	<style type="text/css">
	  .dat1{
	   letter-spacing:2px;
	   color:white;
	   margin:7px 0 0 525px;
       border-style: solid;
       border-width: 2px;
       border-color: rgb( 69, 94, 152 );
       border-radius: 5px;
       background-color: #7b97d9;
       box-shadow: 0px 1px 0px 0px #526494;
       width: 90px;
       height: 30px;
       font-size: 15px;
       font-weight: bold;
	  }
	  #statisticalData-container{
	    margin-top: 100px;
	  }
	  #statisticalData-Grid-Div{
	   top:350px;
	   width:80%;
	   height:156px;
	   position:fixed;
	   /*height:117px;*/
	  }
	  .detail_div{
	   top:140px; 
	   left:900px;
	   position:fixed;
	  }
	  .container_data{
	   letter-spacing:2px;
	   color:white;
	   margin:7px 0 0 415px;
       border-style: solid;
       border-width: 2px;
       border-color: rgb( 69, 94, 152 );
       border-radius: 5px;
       background-color: #7b97d9;
       box-shadow: 0px 1px 0px 0px #526494;
       width: 80px;
       height: 30px;
       font-size: 1px;
       font-weight: bold;
	  }
	  .detail_data{
	   letter-spacing:2px;
	   color:white;
	   margin:7px 0 0 405px;
       border-style: solid;
       border-width: 2px;
       border-color: rgb( 69, 94, 152 );
       border-radius: 5px;
       background-color: #7b97d9;
       box-shadow: 0px 1px 0px 0px #526494;
       width: 110px;
       height: 30px;
       font-size: 1px;
       font-weight: bold;
	  }
	  .txt{
	   color:#D3D3D3;
	   margin-left:10px;
       font-size: 5px;
       font-weight: bold;
	  }
	  .error{
	   color:red;
       font-size: 10px;
       font-weight: bold;
	  }
	  .date{
	   letter-spacing:2px;
	   color:black;
	   margin-left:10px;
       width: 70px;
       height: 20px;
       font-size: 15px;
       font-weight: bold;
       line-height: 20px;
	  }
	  .year{
	   letter-spacing:2px;
	   color:black;
	   margin:0px 0 0 25px;
       width: 85px;
       height: 20px;
       border-radius: 5px;
       font-size: 15px;
       font-weight: bold;
	  }
	  .month{
	   letter-spacing:2px;
	   color:black;
	   margin:0px 0 0 25px;
       width: 65px;
       height: 20px;
       border-radius: 5px;
       font-size: 15px;
       font-weight: bold;
	  }
	</style>
	<div id="statisticalDataPage" class="easyui-layout" data-options="fit:true" >
				<div class="center-filter clearfix" data-options="region:'north',border:false">
					<a href="javascript:void(0)" id="days" class="filter_button" style="font-size: 15px;font-weight: bold;">日统计</a>   
                    <div id="days_menus" style="width:80px">
                      <div id=1_1>收入</div>   
                      <div id=1_2>支出</div>  
                     </div>
					<a href="javascript:void(0)" id="weeks" class="filter_button" style="font-size: 15px;font-weight: bold;">周统计</a>   
                    <div id="weeks_menus" style="width:80px">
                      <div id=2_1>收入</div>   
                      <div id=2_2>支出</div>  
                    </div>  
					<a href="javascript:void(0)" id="months" class="filter_button" style="font-size: 15px;font-weight: bold;">月统计</a>   
                    <div id="months_menus" style="width:80px">
                      <div id=3_1>收入</div>   
                      <div id=3_2>支出</div>  
                    </div>  
					<a href="javascript:void(0)" id="quarters" class="filter_button" style="font-size: 15px;font-weight: bold;">季度统计</a>   
                    <div id="quarters_menus" style="width:80px">
                      <div id=4_1>收入</div>   
                      <div id=4_2>支出</div>  
                    </div>  
					<a href="javascript:void(0)" id="years" class="filter_button" style="font-size: 15px;font-weight: bold;">年统计</a>   
                    <div id="years_menus" style="width:80px">
                      <div id=5_1>收入</div>   
                      <div id=5_2>支出</div>  
                    </div> 
                    <button  type="button" onclick="downLoadData()" class="dat1">导出数据</button>
			   </div>
				
				<div data-options="region:'center',border:false" >
			     	<table style="margin-top: 10px;" id="selectDate">
			     	  <tr>
			     	    <td><span class="date">请选择时间</span></td>
			     	    <td><select class="year"  id="year">
							    <option value="2008">2008年</option>
							    <option value="2009">2009年</option>
							    <option value="2010">2010年</option>
							    <option value="2011">2011年</option>
							    <option value="2012">2012年</option>
							    <option value="2013">2013年</option>
							    <option value="2014">2014年</option>
							    <option value="2015">2015年</option>
							    <option value="2016">2016年</option>
							    <option value="2017">2017年</option>
							    <option value="2018">2018年</option>
							    <option value="2019">2019年</option>
							    <option value="2020">2020年</option>
							    <option value="2021">2021年</option>
							    <option value="2022">2022年</option>
							    <option value="2023">2023年</option>
							  </select>
					    </td>
			     	    <td style="display:none;"><select class="year"  id="year1">
							    <option value="2008">2008年</option>
							    <option value="2009">2009年</option>
							    <option value="2010">2010年</option>
							    <option value="2011">2011年</option>
							    <option value="2012">2012年</option>
							    <option value="2013">2013年</option>
							    <option value="2014">2014年</option>
							    <option value="2015">2015年</option>
							    <option value="2016">2016年</option>
							    <option value="2017">2017年</option>
							    <option value="2018">2018年</option>
							    <option value="2019">2019年</option>
							    <option value="2020">2020年</option>
							    <option value="2021">2021年</option>
							    <option value="2022">2022年</option>
							    <option value="2023">2023年</option>
							  </select>
					    </td>
			     	    <td></td>
			     	    <td>
			     	      <select class="month" id="month">
						    <option value="1">1月</option>
						    <option value="2">2月</option>
						    <option value="3">3月</option>
						    <option value="4">4月</option>
						    <option value="5">5月</option>
						    <option value="6">6月</option>
						    <option value="7">7月</option>
						    <option value="8">8月</option>
						    <option value="9">9月</option>
						    <option value="10">10月</option>
						    <option value="11">11月</option>
						    <option value="12">12月</option>
						  </select>
                        </td>
                        <td style="display:none;"> <span class="date">至</span></td>
                        <td style="display:none;">
			     	      <select class="month" id="month1">
						    <option value="1">1月</option>
						    <option value="2">2月</option>
						    <option value="3">3月</option>
						    <option value="4">4月</option>
						    <option value="5">5月</option>
						    <option value="6">6月</option>
						    <option value="7">7月</option>
						    <option value="8">8月</option>
						    <option value="9">9月</option>
						    <option value="10">10月</option>
						    <option value="11">11月</option>
						    <option value="12">12月</option>
						  </select>
                        </td>
                        <td style="display:none;"><span class="txt">*可支持3个月</span></td>
			     	    <td style="display:none;"><span class="error" id="for_month"></span></td>
			     	  </tr>
			     	  <tr>
			     	    <td><span class="date">统计日长</span> </td>
			     	    <td><select class="month" id="beginDay">
						    <option value="1">1日</option>
						    <option value="2">2日</option>
						    <option value="3">3日</option>
						    <option value="4">4日</option>
						    <option value="5">5日</option>
						    <option value="6">6日</option>
						    <option value="7">7日</option>
						    <option value="8">8日</option>
						    <option value="9">9日</option>
						    <option value="10">10日</option>
						    <option value="11">11日</option>
						    <option value="12">12日</option>
						    <option value="13">13日</option>
						    <option value="14">14日</option>
						    <option value="15">15日</option>
						    <option value="16">16日</option>
						    <option value="17">17日</option>
						    <option value="18">18日</option>
						    <option value="19">19日</option>
						    <option value="20">20日</option>
						    <option value="21">21日</option>
						    <option value="22">22日</option>
						    <option value="23">23日</option>
						    <option value="24">24日</option>
						    <option value="25">25日</option>
						    <option value="26">26日</option>
						    <option value="27">27日</option>
						    <option value="28">28日</option>
						    <option value="29">29日</option>
						    <option value="30">30日</option>
						    <option value="31">31日</option>
						  </select></td>
			     	    <td> <span class="date" >至</span></td>
			     	    <td> <select class="month" id="endDay">
						    <option value="1">1日</option>
						    <option value="2">2日</option>
						    <option value="3">3日</option>
						    <option value="4">4日</option>
						    <option value="5">5日</option>
						    <option value="6">6日</option>
						    <option value="7">7日</option>
						    <option value="8">8日</option>
						    <option value="9">9日</option>
						    <option value="10">10日</option>
						    <option value="11">11日</option>
						    <option value="12">12日</option>
						    <option value="13">13日</option>
						    <option value="14">14日</option>
						    <option value="15">15日</option>
						    <option value="16">16日</option>
						    <option value="17">17日</option>
						    <option value="18">18日</option>
						    <option value="19">19日</option>
						    <option value="20">20日</option>
						    <option value="21">21日</option>
						    <option value="22">22日</option>
						    <option value="23">23日</option>
						    <option value="24">24日</option>
						    <option value="25">25日</option>
						    <option value="26">26日</option>
						    <option value="27">27日</option>
						    <option value="28">28日</option>
						    <option value="29">29日</option>
						    <option value="30">30日</option>
						    <option value="31">31日</option>
						  </select>
			     	    </td>
			     	    <td><span class="txt">*可支持12日</span></td>
			     	    <td><span class="error" id="for_day"></span></td>
			     	  </tr>
			     	</table>
			     	
			      <!-- 显示详细信息 -->
			     <div id="detail_show" class="detail_div" >
			     	<button  type="button" onclick="show_Grid()" class="detail_data" >查看表格数据</button>
			     	<button  type="button" onclick="show_container()" class="container_data" style="display:none;">查看图表</button>
			     </div>
				  <!--  统计图  -->
				  <div id="statisticalData-container" ></div>
				   <!--  统计表 -->
				   <div id="statisticalData-Grid-Div" style="display:none;">
				     <table id="statisticalData-Grid" ></table> 
				   </div>  
		        </div>
	</div> 
	<script type="text/javascript">
	
	var selectBeginDate = null;                             //开始日期
	var selectEndDate = null;                               //结束日期
	var statisticType = 1;                                  //默认类型是日统计
	var type = null;                                        //收入统计还是支出统计
	var gridData = null;
	
	//控制图表状态和表格状态
	function control_div(containerStatus,gridStatus){
		$("#statisticalData-container").attr("style","display:"+containerStatus+";"); 
		$("#statisticalData-Grid-Div").attr("style","display:"+gridStatus+";");      
	}
	
	//查看表格数据
	function show_Grid(){
		control_div("none","");
		$(".detail_data").attr("style","display:none;"); 
		$(".container_data").attr("style","display:;"); 
		fillDatagrid(selectBeginDate,selectEndDate,type,"${path}/mag/getStatisticalData",gridData);
	}
	
	//查看图表
	function show_container(){
		control_div("","none");
		$(".detail_data").attr("style","display:;"); 
		$(".container_data").attr("style","display:none;"); 
		fillDatagrid(selectBeginDate,selectEndDate,type,"${path}/mag/getStatisticalData",gridData);
	}
	
    /**
     * 对于日统计的选择时间判断
     */
	function validateDate(){
		$("#for_day").html("");
		var year = $("#year").val();
		var month = $("#month").val();
		var beginDay = parseInt($("#beginDay").val());
		var endDay = parseInt($("#endDay").val());
		if(beginDay > endDay){
			$("#for_day").html("请选择正确的日期！");
			return false;
		}
		if(endDay-beginDay >= 12){                            //间隔不能超过12天
			$("#for_day").html("间隔不能超过12天！");
			return false;
		}
		selectBeginDate = year+"-"+month+"-"+beginDay;
		selectEndDate = year+"-"+month+"-"+endDay;
		var endDate = new Date(selectEndDate);
		var currentDate = new Date();
		if(endDate > currentDate){
			$("#for_day").html("日期不能超过今天！");
			return false;
		}
		$("#for_day").html("");
		return true;
	}
    
	//对应时间的判断
	function validateWeek(){
		$("#for_month").html("");
		var year = parseInt($("#year").val());
		if(statisticType==5){                                  //说明是年统计 那么只能选择5年)
			var year1 = parseInt($("#year1").val());
			if(year1 > getFullYear() || year > year1){
				$("#for_month").html("请选择正确的年份！");
				return false;
			}
			if(year1 - year > 4){
				$("#for_month").html("只能统计5年以内！");
				return false;
			}
			selectBeginDate = year+"-01-01";
			selectEndDate = (year1+1)+"-01-01";                 //设置为次年的第一天便于后台判断
			return true;
		}
		if(year > getFullYear()){
			$("#for_month").html("请选择正确的年份！");
			return false;
		}
		if(statisticType==4){//说明是季度统计 那么只有年的限制
			selectBeginDate = year+"-01-01";
			selectEndDate = (year+1)+"-01-01";//设置为次年的第一天
			return true;
		}
		var month = parseInt($("#month").val());
		var month1 = parseInt($("#month1").val());
		if(month > month1){
			$("#for_month").html("请选择正确的月份！");
			return false;
		}
		if(statisticType==3){//说明是月统计 那么月份间隔没限制
			selectBeginDate = year+"-"+month+"-01";
			var temp=new Date(year,month1,0);
			selectEndDate = year+"-"+month1+"-"+temp.getDate();//设置为选择月的最后一天
			return true;
		}
		if(year == getFullYear() && month1 > getMonth()){//月份不能超过现在年份对于的月份
			$("#for_month").html("不能超过现在的时间");
			return false;
		}
		if(month1 - month >= 3){//最多支持3个月
			$("#for_month").html("最多支持3个月");
			return false;
		}
		selectBeginDate = year+"-"+month+"-01";
		var temp=new Date(year,month1,0);
		selectEndDate = year+"-"+month1+"-"+temp.getDate();//设置为选择月的最后一天
		$("#for_month").html("");
		return true;
	}
	
	  $("#year1").change(function(){
		  if(!validateWeek()){
	    		return;
	    	}
		    init(); 
			var url = "${path }/mag/getYearStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
	  });
	
    $("#year").change(function(){
    	init(); 
    	switch (statisticType) {
		case 1:
			if(!validateDate()){
	    		return;
	    	}
	    	var url = "${path}/mag/getStatisticalData";
	    	getChart(selectBeginDate, selectEndDate, type, url);
			break;
		case 2:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getWeekStatisticalData";
	    	getChart(selectBeginDate, selectEndDate, null, url);
			break;
		case 3:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getMonthStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
			break;
		case 4:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getQuarterStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
			break;
		case 5:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getYearStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
			break;

		default:
			break;
		}
    	
    });
    
    $("#month").change(function(){
    	init(); 
    	switch (statisticType) {
		case 1:
			if(!validateDate()){
	    		return;
	    	}
	    	var url = "${path}/mag/getStatisticalData";
	    	getChart(selectBeginDate, selectEndDate, type, url);
			break;
		case 2:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getWeekStatisticalData";
	    	getChart(selectBeginDate, selectEndDate, null, url);
			break;
		case 3:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getMonthStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
		default:
			break;
		}
    	
    });
    
    $("#month1").change(function(){
    	init(); 
    	switch (statisticType) {
		case 2:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getWeekStatisticalData";
	    	getChart(selectBeginDate, selectEndDate, null, url);
			break;
		case 3:
			if(!validateWeek()){
	    		return;
	    	}
			var url = "${path }/mag/getMonthStatisticalData";
			getChart(selectBeginDate, selectEndDate, null, url);
		default:
			break;
		}
    	
    });
    
    $("#beginDay").change(function(){
    	init(); 
    	if(!validateDate()){
    		return;
    	}
    	var url = "${path}/mag/getStatisticalData";
    	getChart(selectBeginDate, selectEndDate, type, url);
    });
    
    $("#endDay").change(function(){
    	init(); 
    	if(!validateDate()){
    		return;
    	}
    	var url = "${path}/mag/getStatisticalData";
    	getChart(selectBeginDate, selectEndDate, type, url);
    });

	function downLoadData (){
		var url;
		if(type == null){
		   url = "${path}/mag/downLoadData?statisticType="+statisticType+"&beginTime="+selectBeginDate+"&endTime="+selectEndDate;
		}else{
		   url = "${path}/mag/downLoadData?statisticType="+statisticType+"&beginTime="+selectBeginDate+"&endTime="+selectEndDate+"&type="+type;
		}
		window.location.href=url;
	}
	
	//动态加载列
	function fillDatagrid(beginTime,endTime,type,url,data){
		 if(data.categories.length<1){
			 $("#statisticalData-Grid").datagrid('loadData', { total: 0, rows: [] });
			 return;	
		 }
		   var columns="[[";
		   columns += "{field:'name',title:'项目',width:30,align:'center'},";
	       for(var i=0;i<data.categories.length;i++){
	           columns += "{field:'data"+i+"',title:'明细',width:80,align:'center'},";
	        }
	       columns = columns.substring(0, columns.lastIndexOf(","));
	       columns += "]]";
	       columns = eval("("+columns+")");
		  $("#statisticalData-Grid").datagrid({  
			    queryParams:{
			    	beginTime:beginTime,
	        		endTime:endTime,
			    	type:type,
			    	statisticType:statisticType
			    },
			    url:"${path }/mag/fillStatisticalData",
			    method:'post',
				autoRowHeight:true,
				fit:true,
				fitColumns:true,
				collapsible:true,
			    columns:columns
			});
	}
	
	
	function init(){
		control_div("","none");
		$(".detail_data").attr("style","display:;"); 
		$(".container_data").attr("style","display:none;"); 
	}
	
	$("#days").click(function(){
		init(); 
		$("#selectDate").attr("style","display:;margin-top: 10px;");//让table显示
		$("#selectDate tr").eq(1).attr("style","display:;");//显示第二行数据
		$("#selectDate tr td[style]").attr("style","display:none;");//隐藏第一行的后面数据
		$("#selectDate tr td").eq(4).attr("style","display:;");//显示月
		statisticType = 1;
		selectCurrentDate();
		validateDate();
		var url = "${path }/mag/getStatisticalData";
    	getChart(selectBeginDate, selectEndDate, null, url);
	});
	
	$("#weeks").click(function(){
		init(); 
		statisticType = 2;
		$("#year option[value='"+getFullYear()+"']").attr("selected","selected");
		$("#month option[value='"+(getMonth()-2)+"']").attr("selected","selected");
		$("#month1 option[value='"+getMonth()+"']").attr("selected","selected");
		validateWeek();//先设置日期 在判断
		$("#selectDate").attr("style","display:;margin-top: 10px;");//让table显示
		$("#selectDate tr").eq(1).attr("style","display:none;");//隐藏第二行数据
		$("#selectDate tr td[style]").attr("style","display:;");//显示第一行的完整数据
		$("#selectDate tr td").eq(2).attr("style","display:none;");    //隐藏第二个年
		var url = "${path }/mag/getWeekStatisticalData";
    	getChart(selectBeginDate, selectEndDate, null, url);
	});
	
	$("#months").click(function(){
		init();  
		statisticType = 3;
		$("#year option[value='"+getFullYear()+"']").attr("selected","selected");
		$("#month option[value='1']").attr("selected","selected");
		$("#month1 option[value='"+getMonth()+"']").attr("selected","selected");
		validateWeek();                                                //先设置日期 在判断
		$("#selectDate").attr("style","display:;margin-top: 10px;");   //让table显示
		$("#selectDate tr").eq(1).attr("style","display:none;");       //隐藏第二行数据
		$("#selectDate tr td[style]").attr("style","display:;");       //显示第一行的完整数据
		$("#selectDate tr td").eq(7).attr("style","display:none;");    //隐藏提示
		$("#selectDate tr td").eq(2).attr("style","display:none;");    //隐藏第二个年
		var url = "${path }/mag/getMonthStatisticalData";
		getChart(selectBeginDate, selectEndDate, null, url);
	});
	
    //点击季度统计
	$("#quarters").click(function(){
		init();  
		statisticType = 4;
		$("#year option[value='"+getFullYear()+"']").attr("selected","selected");
		validateWeek();  
		$("#selectDate").attr("style","display:;margin-top: 10px;");//让table显示
		$("#selectDate tr").eq(1).attr("style","display:none;");//隐藏第二行数据
		$("#selectDate tr td[style]").attr("style","display:none;");//隐藏第一行后边的完整数据
		$("#selectDate tr td").eq(4).attr("style","display:none;");//隐藏月
		$("#selectDate tr td").eq(8).attr("style","display:;");    //显示提示
		var url = "${path }/mag/getQuarterStatisticalData";
		getChart(selectBeginDate, selectEndDate, null, url);
	});
	
	$("#years").click(function(){
		init();  
		statisticType =5;
		$("#year option[value='"+(getFullYear()-4)+"']").attr("selected","selected");
		$("#selectDate").attr("style","display:;margin-top: 10px;");//让table显示
		$("#selectDate tr").eq(1).attr("style","display:none;");//隐藏第二行数据
		$("#selectDate tr td[style]").attr("style","display:none;");//隐藏第一行后边的完整数据
		$("#selectDate tr td").eq(4).attr("style","display:none;");//隐藏月
		$("#selectDate tr td").eq(2).attr("style","display:;");    //显示第二个年
		$("#selectDate tr td").eq(8).attr("style","display:;");    //显示提示
		$("#year1 option[value='"+getFullYear()+"']").attr("selected","selected");
		validateWeek();  
		var url = "${path }/mag/getYearStatisticalData";
		getChart(selectBeginDate, selectEndDate, null, url);
	});
	
	$($('#days').menubutton({    
	    menu: '#days_menus'
	}).menubutton('options').menu).menu({
		onClick: function (item) {
			init(); 
		    $("#selectDate").attr("style","display:none;");//让table隐藏
			statisticType = 1;
			type = item.id.split("_")[1];
			getLineChart(selectBeginDate, selectEndDate, type, "${path }/mag/getStatisticalData");
        }
	});


	$($('#weeks').menubutton({    
	    menu: '#weeks_menus'
	}).menubutton('options').menu).menu({
		onClick: function (item) { 
			init(); 
			statisticType = 2;
			$("#selectDate").attr("style","display:none;");//让table隐藏
			type = item.id.split("_")[1];
			var url = "${path }/mag/getWeekStatisticalData";
			getLineChart(selectBeginDate, selectEndDate, type, url);
        }
	});
	
	
	$($('#months').menubutton({    
	    menu: '#months_menus'
	}).menubutton('options').menu).menu({
		onClick: function (item) { 
			statisticType = 3;
			init();  
			$("#selectDate").attr("style","display:none;");//让table隐藏
			type = item.id.split("_")[1];
			var url = "${path }/mag/getMonthStatisticalData";
			getLineChart(selectBeginDate, selectEndDate, type, url);
        }
	});
	
	$($('#quarters').menubutton({    
	    menu: '#quarters_menus'
	}).menubutton('options').menu).menu({
		onClick: function (item) { 
			statisticType = 4;
			init();  
			$("#selectDate").attr("style","display:none;");//让table隐藏
			type = item.id.split("_")[1];
			var url = "${path }/mag/getQuarterStatisticalData";
			getLineChart(selectBeginDate, selectEndDate, type, url);
        }
	});
	
	$($('#years').menubutton({    
	    menu: '#years_menus'
	}).menubutton('options').menu).menu({
		onClick: function (item) { 
			statisticType = 5;
			init(); 
			$("#selectDate").attr("style","display:none;");//让table隐藏
			type = item.id.split("_")[1];
			var url = "${path }/mag/getYearStatisticalData";
			getLineChart(selectBeginDate, selectEndDate, type, url);
        }
	});
	
	//柱状图
	function getChart(beginTime,endTime,type,url){
		$.ajax({
        	type:"post",
        	url:url,
        	data:{
        		beginTime:beginTime,
        		endTime:endTime,
        		type:type
        	},
        	success:function(data){
        	 	data = eval("("+data+")"); 
        	 	gridData = data;
    			chart.series=data.series;
    			chart.chart.type = 'column';
    			chart.xAxis.categories = data.categories;
        	 	$('#statisticalData-container').highcharts(chart);
        	 	if(data.categories.length==0){//说明没数据 不显示导出数据 不显示表格
        	 		$(".dat1").attr("style","display:none;");
        	 	}else{
        	 		$(".dat1").attr("style","display:;");
        	 	}
        	 	//fillDatagrid(beginTime,endTime,type,url,data);
        	}
        });
	}
	
	//折线图
	function getLineChart(beginTime,endTime,type,url){
		$.ajax({
        	type:"post",
        	url:url,
        	data:{
        		beginTime:beginTime,
        		endTime:endTime,
        		type:type
        	},
        	success:function(data){
        	 	data = eval("("+data+")"); 
        	 	gridData = data;
        	 	//chart.chart.type = 'line';//折线图
        	 	chart.chart.type = 'spline';//曲线图
    			chart.series=data.series;
    			chart.xAxis.categories = data.categories;
        	 	$('#statisticalData-container').highcharts(chart);
        	 	if(data.categories.length==0){//说明没数据 不显示导出数据
        	 		$(".dat1").attr("style","display:none;");
        	 	}else{
        	 		$(".dat1").attr("style","display:;");
        	 	}
        	 	//fillDatagrid(beginTime,endTime,type,url,data);
        	}
        });
	}
	
	var chart = {
            chart: {
            	width: 1100,
                height:300
            },
            noDate:{
            },
            credits:{
            	enabled:false
            },
            title: {
                text: '统计'
            },
            subtitle: {
               
            },
            xAxis: {
            },
            yAxis: {
                allowDecimals:true,
                title: {
                    text: '单位 (元)'
                },
                labels : {
                    formatter : function () {
                        var strVal = this.value + '';
                        if (strVal.indexOf('.') == -1) {
                            return strVal + '.00';
                        } else {
                            var arr = strVal.split('.');
                            if (arr[1].length == 2) {
                                return strVal;
                            } else {
                                return strVal + '0';
                            }
                        }
                    }
                }
            },
            plotOptions: {
                column: {
                	dataLabels: {
                         enabled: true
                    },
                    enableMouseTracking: false,
	               	pointPadding: 0,
	               	borderWidth: 0,
	               	groupPadding:0.09,
	               	pointWidth: 30
                }
            }
	};
		
	//返回现在的年
	function getFullYear(){
		var date = new Date();
		return date.getFullYear();
	}
	
	//返回现在的月
	function getMonth(){
		var date = new Date();
		return (date.getMonth()+1);
	}
	//返回现在的日
	function getDay(){
		var date = new Date();
		return date.getDate();
	}

	//让时间选择到对应的今天 默认12天差距 
	function selectCurrentDate(){
		$("#year option[value='"+getFullYear()+"']").attr("selected","selected");
		$("#month option[value='"+getMonth()+"']").attr("selected","selected");
		$("#beginDay option[value='"+(getDay()-11)+"']").attr("selected","selected");
		$("#endDay option[value='"+getDay()+"']").attr("selected","selected");
	}
	
	$(function(){
		statisticType = 1;
		selectCurrentDate();
		validateDate();
		var url = "${path}/mag/getStatisticalData";
    	getChart(selectBeginDate, selectEndDate, type, url);
	});
	
	</script>
  </body>