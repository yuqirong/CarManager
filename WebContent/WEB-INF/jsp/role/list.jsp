<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "doc");
%>
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>员工信息列表</title>
<%@include file="/common/s.jsp"%>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	});
</script>
</head>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<!-- start of main -->
		<section id="m-main" class="span10" style="float: right">
			<article class="m-widget">
				<header class="header">
					<h4 class="title">角色信息列表</h4>
				</header>
				<div class="content">
					<table id="demoGrid" class="m-table table-hover">
						<thead>
							<tr>
								<th class="sorting">序号</th>
								<th class="sorting">角色名</th>
								<th class="sorting">描述</th>
								<th class="sorting">是否内置</th>
								<th class="sorting">是否启用</th>
								<th class="sorting">修改</th>
								<th class="sorting">删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.roles }" var="r"
								varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${r.role }</td>
									<td>${r.description }</td>
									<td><c:if test="${r.inherent == true }">是</c:if> <c:if
											test="${r.inherent == false }">否</c:if></td>
									<td><c:if test="${r.available == true }">是</c:if> <c:if
											test="${r.available == false }">否</c:if></td>
									<td><c:if test="${r.inherent == true }">不可修改</c:if> <c:if
											test="${r.inherent == false }">
											<a
												href="${pageContext.request.contextPath }/admin/role/edit/${r.id}">修改</a>
										</c:if></td>
									<td><c:if test="${r.inherent == true }">不可删除</c:if> <c:if
											test="${r.inherent == false }">
											<a href="${pageContext.request.contextPath }/admin/role/delete/${r.id}" class="delete">删除</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</article>
			<form action="" method="post">
				<input type="hidden" name="_method" value="DELETE">
			</form>
		</section>
		<!-- end of main -->
	</div>
</body>
</html>
