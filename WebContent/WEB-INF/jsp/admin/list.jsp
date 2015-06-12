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
					<h4 class="title">栏目信息列表</h4>
				</header>
				<div class="content">
					<table id="demoGrid" class="m-table table-hover">
						<thead>
							<tr>
								<th class="sorting">序号</th>
								<th class="sorting">用户名</th>
								<th class="sorting">是否启用</th>
								<th class="sorting">锁定时间</th>
								<th class="sorting">创建时间</th>
								<th class="sorting">修改</th>
								<th class="sorting">删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.admins }" var="a"
								varStatus="status">
								<tr>
									<td>${status.count }</td>
									<td>${a.username }</td>
									<td><c:if test="${a.enabled == true }">是</c:if>
									<c:if test="${a.enabled == false }">否</c:if></td>
									<td><c:if test="${a.lockedTime == null }">未锁定</c:if>
									<c:if test="${! empty a.lockedTime }">
									<fmt:formatDate value="${a.lockedTime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></c:if></td>
									<td><fmt:formatDate value="${a.createTime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><a href="">修改</a></td>
									<td><a href="" class="delete">删除</a></td>
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
