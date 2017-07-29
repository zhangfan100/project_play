<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../TagLib/TagLib.jsp"%>
<body>
	<form id="editMes_Form" action="${path }/mag/editMessageSubmit" enctype="multipart/form-data" method="post" style="padding-left:40px;">
		<input type="hidden" id="id" name="id" value="${record.id }" />
		<br/>
		<span>消息类别:</span>
		<select id="messageKind" name="kindID"  style="width:200px;" editable="false"  ></select>&nbsp;&nbsp;&nbsp;
		
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
		<div>标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input type="input" name="title" id="title" value="${record.title }" size="80" placeholder="在此处填写标题、用于检索 最长30个字符" maxlength="30"/>
			<span style="color:gray;margin-left:10px;">Time：<fmt:formatDate value="${record.messageDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
		</div>
		<br/>
		<div>
			<textarea name="content" id="txtarea" style="width:95%;height:350px;">${record. content}</textarea>
		</div>
		
	</form>
	<link rel="stylesheet" href="${path }/static/scripts/kindeditor-4.1.10/themes/default/default.css" />
	<script charset="utf-8" src="${path }/static/scripts/kindeditor-4.1.10/kindeditor-all.js"></script>
	<script charset="utf-8" src="${path }/static/scripts/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript">
	var editor;
	
	$("#editMes_Form #messageKind").combobox({
		url: "${path }/mag/queryMessageKind",
		valueField: 'kindKey',
		textField: 'kindName',
		panelHeight:'auto',
		onLoadSuccess:function(data){
			$(this).combobox("select",currMessageKind);
		}
	});
	$("#editMes_Form #seperateSchool").combobox({
		url: "${path }/mag/queryschoolSept",
		valueField: 'id',
		textField: 'title',
		panelHeight:'auto',
		onLoadSuccess:function(data){
			if(${record.seperateSchoolId>0}){
				$(this).combobox("select",${record.seperateSchoolId});
			}else if(data.length>0){
				$(this).combobox("select",data[0].id);
			}
		}
	});
	
	$("#editMes_Form").form({
		onSubmit: function(){
			var title = $("#editMes_Form #title").val().trim();
			var content = editor.html();
			if(content == "" || title == ""){
				AlterMessage("消息填写不完整!");
				return false;
			}
			return true;
		},success:function(data){
			if(data==0){
				ShowMessage("修改消息成功!")
				closeEditMsgDialog();
			}else{
				AlterMessage("修改异常!")
			}
		}
	});
		
	$("#editMes_Form #schoolSeptFlag").click(function(){
		if($(this).attr("checked")){
			$("#editMes_Form #seperateSchool").parent().show();
		}else{
			$("#editMes_Form #seperateSchool").parent().hide();
		}
		
	});
	
		
	editor = KindEditor.create('#editMes_Form textarea[name="content"]', {
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
	
	if(${record.seperateSchoolId==0}){
		$("#editMes_Form #schoolSeptFlag").prop("checked", false);
	}else{
		$("#editMes_Form #schoolSeptFlag").prop("checked", true);
		$("#editMes_Form #seperateSchool").parent().show();
	}
		
	</script>
</body>