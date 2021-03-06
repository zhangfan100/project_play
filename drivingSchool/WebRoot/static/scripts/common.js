var GV = {
	title:"消息提示"
};
/**
 * 用户类型定义
 * eg:userType['1'] == 学生
 */
var userType = {
		1:'学生',
		2:'老师',
		3:'管理员'
};
//统一ajax异步请求处理
$.ajaxSetup({
	complete:function(XMLHttpRequest, textStatus, errorThrown){
		if(XMLHttpRequest.status==403){
			AlterMessage("权限不足!");
		}else if(XMLHttpRequest.status==404){
			AlterMessage("权限不足!");
			//window.location = webPath +"/404";
		}
	}
});

String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }

function currentDate(py,pm,pd){
	var curr_time = new Date();
	var y = curr_time.getFullYear()+(py?py:0);
	var m = curr_time.getMonth()+1+(pm?pm:0);
	var d = curr_time.getDate()+(pd?pd:0);

	m = m<10?("0"+m):m;
	d = d<10?("0"+d):d;
	
	return y+"-"+m+"-"+d;
}


/**
 * 
 * 弹出框显示
 * @param title
 * @param msg
 * @param icon
 */
function AlterMessage(msg,title,icon){
	$.messager.alert(title?title:GV.title,msg,icon?icon:'warning');
	$(".messager-window").addClass("zIndexTop1").next(".window-shadow").addClass("zIndexTop2").next(".window-mask").addClass("zIndexTop3");
} 

function ShowMessage(msg,title){
	$.messager.show({
		title:title?title:GV.title,
		msg:msg,
		timeout:5000,
		showType:'slide'
	});
}
function formToJson(_target){
	AlterMessage('sdf');
	var arr =$(_target).serializeArray();
	var param = {};
	$.each(arr,function(index,item){
		param[item.name] = item.value;
	});
	return param;
}

function parseDate(value){
	var year = value.substring(0,4);
	var month = value.substring(4,6);
	var day = value.substring(6.8)
	return year+"-"+month+"-"+day
}
