<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入Bootstrap css -->
<link
	href="<c:url value='static/bootstrap-3.3.7-dist/css/bootstrap.min.css' />"
	rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="static/bootstrap-3.3.7-dist/js/jquery.min.js"></script> -->
<script src="<c:url value='static/jquery/jquery-3.1.1.min.js' />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="<c:url value='static/bootstrap-3.3.7-dist/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src='<c:url value="static/js/emp.js" />'></script>
</head>
<body>
<!-- 员工修改页面 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="editModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">员工修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputName3" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="inputName3" name="empName"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">邮箱：</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="Email" name="email">
									<span id="helpBlock2" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									 id="inputGender3" value="M" name="gender" checked="checked">
									男
								</label> <label class="radio-inline"> <input type="radio"
									 id="inputGender3" value="F" name="gender">
									女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">部门：</label>
							<div class="col-sm-4">
								<select class="form-control" name="deptId">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveEditEmpBtn">保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
<!-- 	员工添加页面 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">员工添加</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputName3" class="col-sm-2 control-label">姓名：</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputName3"
									placeholder="Name" name="empName">
									<span id="helpBlock2" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">邮箱：</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="Email" name="email">
									<span id="helpBlock2" class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									 id="inputGender3" value="M" name="gender" checked="checked">
									男
								</label> <label class="radio-inline"> <input type="radio"
									 id="inputGender3" value="F" name="gender">
									女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">部门：</label>
							<div class="col-sm-4">
								<select class="form-control" name="deptId">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addEmpBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
<!-- 	员工显示页面 -->
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h1>SSM_CRUD</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="addEmp">新增</button>
				<button class="btn btn-danger" id="deleteAllBtn">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="empTable">
					<thead>
						<tr>
							<th><input type="checkbox" id = "selectAll"/></th>
							<th>#</th>
							<th>姓名</th>
							<th>邮箱</th>
							<th>性别</th>
							<th>部门</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6" id="pageinfo"></div>
			<div class="col-md-6 col-md-offset-6" id="topage"></div>
		</div>
	</div>
</body>
</html>