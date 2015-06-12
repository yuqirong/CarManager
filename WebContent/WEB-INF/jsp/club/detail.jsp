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
<title>俱乐部详情</title>
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
				<h3>${requestScope.club.clubName }</h3>
			</div>
			<div class="well span10">
				<h4>成立时间：</h4>
				<p><fmt:formatDate value="${requestScope.club.createTime }"  pattern="yyyy-MM-dd"/></p>
				<h4>俱乐部介绍：</h4>
				<p>${requestScope.club.introduction }</p>
				<h4>俱乐部章程：</h4>
				<p>${requestScope.club.constitution }</p>
				<div class="control-group" align="center">
					<div class="controls">
					<button type="button" class="btn">申请加入</button>
					&nbsp;
					<button type="button" onclick="history.back();" class="btn">返回</button>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>