<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<head>
<style type="text/css">
.file_input_tip {
	margin-top: 10px;
	width: 80px;
	height: 20px;
	display: block;
	border: 1px #AAAAAA solid;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	-khtml-border-radius: 10px;
	-border-radius: 10px;
}

#image_file {
	width: 80px;
	height: 20px;
	opacity: 0;
	margin-top: -20px;
	margin-bottom: 10px;
}
</style>
</head>

<body>
<div>

<div>
			<img alt="" src="/project/avatar/${project.id }?thumb=true" width=120
				height=120>
			<form action="/project/avatar/${project.id }" id="image_form" name="form" method="post" enctype="multipart/form-data" target="hidden_frame">
				<span class="file_input_tip">选择图片 </span> 
				<input type="file" id="image_file" name="avatar" style="">
				<iframe name="hidden_frame" id="hidden_frame" style="display: none"></iframe>
			</form>
			<script type="text/javascript">
				document.getElementById("image_file").onchange = function() {
					document.getElementById("image_form").submit();
				}
			</script>
		</div>

<form action="/project/${project.id }" method="post" id="">

<div>
<input type="hidden" name="project.id" value="${project.id }" >
</div>

<div >
<label>项目名：</label>
<input type="text" name="project.name" value="${project.name }" >
</div>

<div>
<label>简介：</label>
<textarea rows="4" cols="20" name="project.detail" >${project.detail }</textarea>
</div>

<div>
<input type="hidden" name="" value="" >
<input type="submit" value="提交" >
</div>

</form>

</div>

</body>
</html>