<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-process");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>后台管理</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>
		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">
		<div class="row-fluid">
			<div class="page-header">
				<h3>${requestScope.user.username }，欢迎来到后台管理：</h3>
			</div>

			<div class="well span2">
				<h4>登录IP:</h4>
				<p>${requestScope.user.ipAddress}</p>
			</div>

			<div class="well span2">
				<h4>登录时间:</h4>
				<p>
					<fmt:formatDate value="${requestScope.user.loginTime }"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</p>
			</div>

		</div>

		</section>
	</div>
</body>
</html>