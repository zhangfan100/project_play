<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="addMes_Form" action="${path }/mag/addMessageSubmit" method="post" style="padding-left:40px;">
		<br/>
		<span>消息类别:</span>
		<select id="messageKind" name="kindID"  style="width:200px;height:25px;" editable="false"  ></select>&nbsp;&nbsp;
		
		<c:if test="${param.flag}">
			<span >
				<input type="checkbox" name="isDisplay" id="c1" value="1" ${record.isDisplay==1?'checked':'' }/><label for="c1">隐藏</label>	&nbsp;&nbsp;&nbsp;
				<input type="checkbox" name="isTop" id="c2" value="1" ${record.isTop==1?'checked':'' }/><label for="c2">置顶</label>	&nbsp;&nbsp;&nbsp;		
				<input type="checkbox" name="isHot" id="c3" value="1" ${record.isHot==1?'checked':'' }/><label for="c3">热贴</label>	&nbsp;&nbsp;&nbsp;
			</span>
		</c:if>
		
		<c:if test="${!param.flag}">
			<input type="checkbox" name="schoolSeptFlag" value="1" class="easyui-textbox" id="schoolSeptFlag"><label for="schoolSeptFlag">区分校区</label>
			<span style="display:none;">&nbsp;&nbsp;分校：
				<select id="seperateSchool" name="seperateSchoolId" style="width:200px;" editable="false"></select>
			</span>
		</c:if>
		<br/>
		<br/>
		<div>标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="input" name="title" id="title" size="80" placeholder="在此处填写标题、用于检索 最长30个字符" maxlength="30"/><span></div>
		<br/>
		<div>
			<textarea name="content" id="txtarea" style="width:95%;height:350px;"></textarea>
		</div>
	</form>
	<link rel="stylesheet" href="${path }/static/scripts/kindeditor-4.1.10/themes/default/default.css" />
	<script charset="utf-8" src="${path }/static/scripts/kindeditor-4.1.10/kindeditor-all.js"></script>
	<script charset="utf-8" src="${path }/static/scripts/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript">
	var editor;
	$("#addMes_Form #messageKind").combobox({
		url: "${path }/mag/queryMessageKind",
		valueField: 'kindKey',
		textField: 'kindName',
		panelHeight:'auto',
		onLoadSuccess:function(data){
			if(currMessageKind!=""){
				$(this).combobox("select",currMessageKind);
			}else if(data.length>0){
				$(this).combobox("select",data[0].id);
			}
		}
	});
	$("#addMes_Form #seperateSchool").combobox({
		url: "${path }/mag/queryschoolSept",
		valueField: 'id',
		textField: 'title',
		panelHeight:'auto',
		onLoadSuccess:function(data){
			if(data.length>0){
				$(this).combobox("select",data[0].id);
			}
		}
	});

	$("#addMes_Form").form({
		onSubmit: function(){
			var title = $("#title").val().trim();
			var content = editor.html().trim();
			if(content == "" || title == ""){
				AlterMessage("消息填写不完整!");
				return false;
			}
			return true;
		},success:function(data){
			if(data==0){
				ShowMessage("添加消息成功!")
				closeAddMsgDialog();
			}
		}
	});
		
	$("#addMes_Form #schoolSeptFlag").click(function(){
		if($(this).attr("checked")){
			$("#addMes_Form #seperateSchool").parent().show();
		}else{
			$("#addMes_Form #seperateSchool").parent().hide();
		}
		
	});
	
	
	editor = KindEditor.create('#addMes_Form textarea[name="content"]', {
		uploadJson : '${path }/upload/img?mode=root&savePath=messageImg',
			  basePath:'${path }/static/scripts/kindeditor-4.1.10/',
              allowFileManager : false,
              afterUpload :function(data){
            	  return "${path}"+data;
              },
              afterBlur: function(){this.sync();},
              items:[
                     'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                     'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                     'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                     'superscript', 'clearhtml', 'quickformat', 'selectall', '|', '/',
                     'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                     'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'multiimage',
                     'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                     'anchor', 'link', 'unlink', '|', 'about'
             ]
	});
		
	</script>
</body>