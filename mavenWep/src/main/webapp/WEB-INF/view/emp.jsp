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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h1>SSM_CRUD</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" /></th>
							<th>#</th>
							<th>姓名</th>
							<th>邮箱</th>
							<th>性别</th>
							<th>部门</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfo.list }" var="emp">
							<tr>
								<td><input type="checkbox" /></td>
								<td>${emp.empId }</td>
								<td>${emp.empName }</td>
								<td>${emp.email }</td>
								<td>${emp.gender=="M"?"男":"女" }</td>
								<td>${emp.dept }</td>
								<td>
									<button class="btn btn-primary">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
									</button>
									<button class="btn btn-danger">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 ">当前页${pageInfo.pageNum }页
				总共${pageInfo.pages }页 总共${pageInfo.total }条</div>
			<div class="col-md-6 col-md-offset-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href='<c:url value="/emp?pn=1"/>'>首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href='<c:url value="/emp?pn=${pageInfo.pageNum-1 }"/>'
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums }" var="n">
						<c:if test="${n==pageInfo.pageNum }">
							<li class="active"><a href='<c:url value="/emp?pn=${n }"/>'>${n }</a></li>
						</c:if>
						<c:if test="${n!=pageInfo.pageNum }">
							<li><a href='<c:url value="/emp?pn=${n }"/>'>${n }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href='<c:url value="/emp?pn=${pageInfo.pageNum+1 }"/>'
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href='<c:url value="/emp?pn=${pageInfo.pages }"/>'>末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>