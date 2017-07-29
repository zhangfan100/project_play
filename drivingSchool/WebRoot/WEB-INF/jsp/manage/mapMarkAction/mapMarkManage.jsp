<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>

<body>
<!--  <style type="text/css">
   body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
    #allmap{width:100%;height: 100%}
  </style> -->
  
<style type="text/css">
        body, html, #allmap {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        #bar {
        width:380px; position:absolute; background:#000000; left:50%; height:25px; border:solid 1px #808080; top:20px; background:#f5f5f5; padding:10px; margin-left:-195px;
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=PoWIF48YzVUOkxuHd9Ctt3hN"></script>
    
<!-- <div id="container"></div>  -->

 <div id="allmap"></div>
    <div id="bar">
        输入需定位城市：<input type="text" id="city" value="成都" /> 
               <input type="button" id="begin" value="定位" />
               <input type="button" id="save" value="保存" onclick="save()" />
    </div>
<script type="text/javascript">

var isFirst = true;//第一次进来的时候转态都设置为true 

function addMarker(id, name, x, y) {
    var p = new BMap.Point(x, y);
    var marker = new BMap.Marker(p);
    M.addOverlay(marker);
    marker.enableDragging();
    marker.setTitle(id);
    var label = new BMap.Label(name, { offset: new BMap.Size(25, 0) });
    
    label.setStyle({
        border: "solid 1px #00f",
        color: "#00f",
        padding: "0 5px"
    });
    label.setTitle(name);
    marker.setLabel(label);
    var markerMenu = new BMap.ContextMenu();
    var ci = config.marker.index;
    markerMenu.addItem(new BMap.MenuItem('重命名', function () {
        var win = new BMap.InfoWindow(
        		getSceneInfoWindow(ci,label.getTitle())
        		);
        marker.openInfoWindow(win);
    }, 100));
    markerMenu.addItem(new BMap.MenuItem('移除', function () {
        if(parseInt(id)>0){
            $.ajax({
                url:'${path}/mag/deleteMapMarkInfo',
                type:"post",
                data:"id="+id,
                success:function(data){
                  config.marker.remove(ci);
                }
            });
        }else{
            config.marker.remove(ci);
        }
    }, 100))
    ;
    marker.addContextMenu(markerMenu);

    config.marker.add(marker);
}

function getSceneInfoWindow(ci,title){
	var str = null;
	 $.ajax({
         url:'${path}/mag/getAllScenes',
         type:"post",
         async: false, //不是异步 同步
         success:function(data){
           data = eval("("+data+")");
	       str = '<select style="width: 200px;" name="sceneId" id="txt_rename_' + ci + '">';
           for(var i = 0; i < data.length;i++){
        	   var data1 = data[i];
        	   str += '<option value="'+data1.id+'">'+data1.title+'</option>';
           }
           str += '</select>';
           str += '<input type="text" disabled="disabled"  value="' + title + '" id="txt_rename_' + ci + '" maxlength="20" style="width:100px" />';
           str += '<input type="button" onclick="rename(' + ci + ')" value="确定" />';
         }
     });
    return str;
}

var config = {
    runn: false, //是否开始拾取坐标
    marker: {
        list: [],
        status:[],//保存对应的坐标是否已经保存 true保存 false没有保存
        add: function (data) {
        	if(isFirst){
        		config.marker.index++;
                config.marker.list.push(data);
                config.marker.status.push(true);
                config.save = true;
                isFirst = false;
        	}else{
        		config.marker.index++;
                config.marker.list.push(data);
                config.marker.status.push(false);
                config.save = false;
        	}
        },
        remove: function (i) {
            config.marker.list[i].remove();
            config.marker.list[i] = null;
            config.marker.status[i].remove();
            config.marker.status[i] = null;
        	//init();
        },
        index:0
    },
    save: true //当前设置是否已保存
};

function save() {
    var data = [];
    for (var i = 0; i < config.marker.list.length; i++) {
        var marker = config.marker.list[i];
        var status = config.marker.status[i];
        if (marker && !status) {
            data.push({
            	id: marker.getTitle(),
                title: marker.getLabel().getTitle(),
                lng: marker.getPosition().lng,
                lat: marker.getPosition().lat
            });
            config.marker.status[i]=true;
        }
    }
    
    if(!config.save && (data.length > 0)){
	    $.ajax({
	        url:'${path}/mag/saveMapMarkInfo',
	        type:"post",
	        data:"param="+JSON.stringify(data),
	        success:function(data){
	            if(data==1){
	                config.save = true;
	                init();
	                alert("保存成功!");
	            }else{
	                alert("保存失败!");
	            }
	        }
	    });
    }
}


function rename(i) { //重命名
    if (config.marker.list[i]) {
        var t = $("#txt_rename_" + i+" option[value='"+$("#txt_rename_" + i).val()+"']").text();
        config.marker.list[i].getLabel().setTitle(t);
        config.marker.list[i].getLabel().setContent(t);
        config.marker.status[i]=false;
        M.closeInfoWindow(M.getInfoWindow());
        config.save = false;
    }
}

$(function () {

    var map = new BMap.Map("allmap");                        // 创建Map实例
    map.centerAndZoom($("#city").val(), 13);     // 初始化地图,设置中心点坐标和地图级别
    map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
    map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
    map.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
    map.enableScrollWheelZoom();                            //启用滚轮放大缩小
    map.addControl(new BMap.MapTypeControl());          //添加地图类型控件
    var contextMenu = new BMap.ContextMenu();//添加右键菜单
    var txtMenuItem = [
      {
          text: '在此添加标注',
          callback: function (p) {
              addMarker('0', '直线行驶', p.lng, p.lat);
          }
      }
    ];

    for (var i = 0; i < txtMenuItem.length; i++) {
        contextMenu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
        if (i == 1 || i == 3) {
            contextMenu.addSeparator();
        }
    } 
    
    map.addContextMenu(contextMenu);

    $('#begin').click(function () {
        if (!document.getElementById('begin').disabled) {
            map.centerAndZoom($("#city").val(), 13);
        }
    });


    window.M = map;
    
    //加载数据库中保存的数据
    init();

});

function init(){
	$.ajax({
        url:'${path}/mag/queryMapMarkInfo',
        type:"post",
        success:function(json){
        	data = $.parseJSON(json);
			$.each(data, function(index, item) {
				isFirst = true;
				addMarker(item.id,item.title, item.lng,item.lat);
			});
        }
    });
}
// 百度地图API功能

</script>

</body>
