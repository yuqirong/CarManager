<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>我的空间</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/bpm-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/bpm-workspace.jsp"%>
		<!-- start of main -->

		<!-- start of main -->
		<section class="span4"> <article class="m-widget">
		<header class="header">
		<h4 class="title">个人资料</h4>
		<div class="ctrl">
			<a href="">编辑资料</a>
		</div>
		</header>

		<div class="content content-inner">

				<table>
				<tr>
					<td><label class="control-label">性别：</label></td>
					<td><c:if test="${requestScope.user.gender == 1 }">男</c:if>
						<c:if test="${requestScope.user.gender == 0 }">女</c:if>
					</td>
				</tr>
				<tr>
					<td><label class="control-label">电子邮箱：</label></td>
					<td>${requestScope.user.email }</td>
				</tr>
				<tr>
					<td><label class="control-label">手机：</label></td>
					<td>${requestScope.user.phone }</td>
				</tr>
				<tr>
					<td><label class="control-label">个人介绍：</label></td>
					<td><c:if test="${ empty requestScope.user.description }">无</c:if>
						${requestScope.user.description }</td>
				</tr>
				</table>
			</div>
				
		</article>

		<div class="m-spacer"></div>
		</section>
		
		<section class="span4"> <article class="m-widget">
		<header class="header">
		<h4 class="title">等级及积分</h4>
		<div class="ctrl">
		<a href="${pageContext.request.contextPath}/user/scorehistory">获取积分历史</a>
		</div>
		</header>

		<div class="content content-inner">

			<table>
				<tr>
					<td><label class="control-label">等级：</label></td>
					<td>${requestScope.user.grade.gradeName }</td>
				</tr>
				<tr>
					<td><label class="control-label">积分：</label></td>
					<td>${requestScope.user.score }</td>
				</tr>
			</table>
		</div>
				
		</article>

		<div class="m-spacer"></div>
		</section>
	</div>
</body>
</html>