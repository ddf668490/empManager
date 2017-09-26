var endPageplus;
var pageNum;
$(function() {
	ajaxEmp(1);
	addEmp();
	showEditEmp();
	check();
});
function deleteAllEmp(){
	$("deleteAllBtn").click(function(){
		
	});
}
/**
 * 复选框选中
 */
function check() {
	// 复选框事件
	// 全选、取消全选的事件
	$("#selectAll").click(
			function() {
				$("#empTable :checkbox").prop("checked",
						$("#selectAll").prop("checked"));
			});
	// 子复选框的事件
	// 当没有选中某个子复选框时，SelectAll取消选中
	$(document)
			.on(
					"click",
					"#subcheck",
					function() {
						if (!$("#subcheck").checked) {
							$("#selectAll").prop("checked", false);
						}
						var chsub = $("input[type='checkbox'][id='subcheck']").length; // 获取subcheck的个数
						var checkedsub = $("input[type='checkbox'][id='subcheck']:checked").length; // 获取选中的subcheck的个数
						if (checkedsub == chsub) {
							$("#selectAll").prop("checked", true);
						}
					});
}
/**
 * 显示编辑员工页面
 */
function showEditEmp() {
	$(document).on(
			"click",
			"#editEmpBtn",
			function() {
				$("#editModal select").empty();
				$("#saveEditEmpBtn").attr("empId", $(this).attr("edit_id"));
				$.get("/mavenWep/editEmp", {
					"emp_id" : $(this).attr("edit_id")
				}, function(result) {
					var depts = result.data.depts;
					$.each(depts, function(index, item) {
						$("<option></option>").attr("value", item.did).append(
								item.dname).appendTo("#editModal select");
					});
					var emp = result.data.emp;
					$("#editModal #inputName3").html(emp.empName);
					$("#editModal #inputEmail3").val(emp.email);
					$("#editModal input:radio").val([ emp.gender ]);
					$("#editModal select").val([ emp.deptId ]);
					$("#editModal").modal();
				}, "json");
			});
	$("#saveEditEmpBtn").click(function() {
		$.ajax({
			url : "/mavenWep/updateEmp/" + $(this).attr("empId"),
			data : $("#editModal form").serialize(),
			type : "PUT",
			success : function() {
				ajaxEmp(pageNum);
				$('#editModal').modal('hide');
			}
		});
	});

};
/**
 * 验证表单输入信息
 * 
 * @returns {Boolean}
 */
function validationEmp() {
	var empName = $("#myModal #inputName3").val();
	var regName = /^[a-zA-Z0-9_-]{6,12}$/;
	if (!regName.test(empName)) {
		judge("#myModal #inputName3", "error", "用户名由6-12位数字及英文字母组成")
		return false;
	} else {
		judge("#myModal #inputName3", "success", "")
	}
	var email = $("#myModal #inputEmail3").val();
	var regEmail = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
	if (!regEmail.test(email)) {
		judge("#myModal #inputEmail3", "error", "邮箱格式不正确")
		return false;
	} else {
		judge("#myModal #inputEmail3", "success", "")
	}
	return true;
}
/**
 * 添加表单验证提示信息
 * 
 * @param item
 * @param state
 * @param msg
 * @returns {Boolean}
 */
function judge(item, state, msg) {
	$(item).parent().removeClass("has-error has-success");
	$(item).next("span").html("");
	if (state == "error") {
		$(item).parent().addClass("has-error");
		$(item).next("span").html(msg);
		return false;
	} else {
		$(item).parent().addClass("has-success");
	}
}
/**
 * 员工添加页面
 */
function addEmp() {
	$("#addEmp").click(function() {
		$('#myModal').modal();
	});
	$.post("/mavenWep/listDept", function(result) {
		$.each(result.data.depts, function(index, item) {
			$("<option></option>").attr("value", item.did).append(item.dname)
					.appendTo("#myModal select");
		});
	}, "json");
	$("#addEmpBtn").click(
			function() {
				if (validationEmp()) {
					$.post("/mavenWep/addEmp", $("#myModal form").serialize(),
							function() {
								$('#myModal').modal('hide');
								ajaxEmp(endPageplus);
							}, "json");
				}
				;
			})
}
/**
 * 数据记录刷新
 * 
 * @param pn
 */
function ajaxEmp(pn) {
	$.post("/mavenWep/list", {
		"pn" : pn
	}, function(result) {
		showEmps(result);
		showPageInfo(result);
		showPageNav(result);
	}, "json");
}
/**
 * 显示员工表格
 * 
 * @param result
 */
function showEmps(result) {
	$("#empTable tbody").empty();
	$
			.each(
					result.data.page.list,
					function(index, item) {
						var $td1 = $("<td><input type='checkbox' id='subcheck'/></td>");
						var $td2 = $("<td></td>").append(item.empId);
						var $td3 = $("<td></td>").append(item.empName);
						var $td4 = $("<td></td>").append(item.email);
						var $td5 = $("<td></td>").append(
								item.gender == 'M' ? '男' : '女');
						var $td6 = $("<td></td>").append(item.dept.dname);
						var $td7 = $("<td></td>");
						var $editBtn = $(
								"<button class='btn btn-primary' id='editEmpBtn'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>编辑</button>")
								.attr("edit_id", item.empId);
						var $delBtn = $("<button onclick='delEmp("
								+ item.empId
								+ ","
								+ result.data.page.pageNum
								+ ")' class='btn btn-danger'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span>删除</button>");
						$td7.append($editBtn).append("&nbsp;").append($delBtn);
						$("<tr></tr>").append($td1).append($td2).append($td3)
								.append($td4).append($td5).append($td6).append(
										$td7).appendTo("#empTable tbody")
					})
}
/**
 * 显示员工数据数量信息
 * 
 * @param result
 */
function showPageInfo(result) {
	var pageInfo = result.data.page;
	endPageplus = pageInfo.pages + 1;
	pageNum = pageInfo.pageNum;
	$("#pageinfo").html(
			"当前页" + pageInfo.pageNum + "页 总共" + pageInfo.pages + "页 总共"
					+ pageInfo.total + "条");
}
/**
 * 显示页面跳转
 * 
 * @param result
 */
function showPageNav(result) {
	$("#topage").empty();
	var pageInfo = result.data.page;
	var $nav = $("<nav aria-label='Page navigation'></nav>");
	var $ul = $("<ul class='pagination'></ul>");
	var $fistpage = $("<li><a onclick='ajaxEmp(1)'>首页</a></li>");
	$ul.append($fistpage);
	var $pre = $("<li><a onclick='ajaxEmp("
			+ pageInfo.prePage
			+ ")' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li>")
	if (pageInfo.hasPreviousPage) {
		$ul.append($pre);
	}
	$.each(pageInfo.navigatepageNums, function(index, item) {
		if (item == pageInfo.pageNum) {
			var $li = $("<li class='active'><a onclick='ajaxEmp(" + item
					+ ")'>" + item + "</a></li>");
		} else {
			var $li = $("<li><a onclick='ajaxEmp(" + item + ")'>" + item
					+ "</a></li>");
		}
		$ul.append($li);
	})
	var $next = $("<li><a onclick='ajaxEmp("
			+ pageInfo.nextPage
			+ ")'aria-label='Next'> <span aria-hidden='true'>&raquo;</span> </a></li>");
	if (pageInfo.hasNextPage) {
		$ul.append($next);
	}
	var $lastpage = $("<li><a onclick='ajaxEmp(" + pageInfo.pages
			+ ")'>末页</a></li>");
	$ul.append($lastpage);
	$nav.append($ul);
	$("#topage").append($nav);

}
/**
 * 删除员工
 * 
 * @param id
 * @param pn
 */
function delEmp(id, pn) {
	$.post("/mavenWep/delEmp", {
		"empId" : id
	}, function(msg) {
		ajaxEmp(pn);
	}, "json")
}