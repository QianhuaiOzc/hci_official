<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
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
			<img alt="" src="/member/avatar/${member.studentId }?thumb=true" width=120
				height=120>
			<form action="/member/avatar/${member.studentId }" id="image_form" name="form" method="post" enctype="multipart/form-data" target="hidden_frame">
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

		<form action="/member/${member.id }" method="post">
			<div>
				<label>学号：</label> <input type="text" name="member.studentId"
					value="${member.studentId }">
			</div>

			<div>
				<label>姓名：</label> <input type="text" name="member.name"
					value="${member.name} ">
			</div>

			<div>
				<label>性别：</label> 男<input type="radio" name="extend.sex" value="0"
					${extend.sex==0 ?"checked='checked'":"" }  >&nbsp; 女<input
					type="radio" name="extend.sex" value="1" ${extend.sex==0
					?"checked='checked'":"" }  >
			</div>

			<div>
				<label>类型：</label> <select name="member.type">
					<option value="1" ${member.type== 1 ?"selected=\"selected\"":"" }  >教师</option>
					<option value="2" ${member.type== 2 ?"selected=\"selected\"":"" } >研究生</option>
					<option value="3" ${member.type== 3 ?"selected=\"selected\"":"" } >本科生</option>

				</select>
			</div>

			<div>
				<label>权限：</label> <select name="member.role">
					<option value="2" ${member.role== 2 ?"selected=\"selected\"":"" } >普通成员</option>
					<option value="1" ${member.role== 1 ?"selected=\"selected\"":"" } >管理员</option>
				</select>
			</div>

			<div>
				<label>状态：</label> <select name="member.state">
					<option value="1">在职</option>
					<option value="2">已毕业</option>
					<option value="3">见习生</option>
					<option value="4">退出</option>
				</select>
			</div>

			<div>
				<label>年级：</label> <input type="text" name="extend.grade"
					value="${extend.grade }">
			</div>

			<div>
				<label>学院：</label> <input type="text" name="extend.academy"
					value="${extend.academy }">
			</div>

			<div>
				<label>专业：</label> <input type="text" name="extend.major"
					value="${extend.major }">
			</div>


			<div>
				<label>手机：</label> <input type="text" name="extend.mobile"
					value="${extend.mobile }">
			</div>

			<div>
				<label>短号：</label> <input type="text" name="extend.mobileshort"
					value="${extend.mobileshort }">
			</div>

			<div>
				<label>邮箱：</label> <input type="text" name="extend.email"
					value="${extedn.email }">
			</div>

			<div>
				<label>生日：</label> <input type="text" name="extend.birthday"
					value="${extend.birthday }">
			</div>

			<div>
				<label>个人主页：</label> <input type="text" name="extend.homepage"
					value="${extend.homepage }">
			</div>

			<div>
				<input type="hidden" name="" value=""> <input type="submit"
					value="提交">
			</div>

		</form>

	</div>

</body>
</html>