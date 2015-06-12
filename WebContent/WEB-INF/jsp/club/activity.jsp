<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-task");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>俱乐部活动</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/bpm-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/bpm-workspace.jsp"%>
		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">
		<div class="row-fluid">
			<div class="page-header">
				<h3>最新俱乐部活动</h3>
			</div>
			<c:forEach items="${requestScope.clubActivities }" var="c">
				<div class="well span4">
					<h4>活动名称：</h4>
					<p>${c.activityName }</p>
					<h4>创建时间：</h4>
					<p><fmt:formatDate value="${c.createTime }"  pattern="yyyy-MM-dd"/></p>
					<h4>截止时间：</h4>
					<p><fmt:formatDate value="${c.deadline }"  pattern="yyyy-MM-dd"/></p>
					<h4>开始时间：</h4>
					<p><fmt:formatDate value="${c.startTime }"  pattern="yyyy-MM-dd"/></p>
					<h4>活动内容：</h4>
					<p>${c.content }</p>
					<div class="control-group" align="center">
						<div class="controls">
							<input class="btn" type="button" value="申请加入" />&nbsp;&nbsp;
							<input class="btn" type="button" value="更多介绍" 
							onclick="window.location.href=''"/>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</section>
	</div>
</body>
</html>