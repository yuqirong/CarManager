<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>使用感受</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/bpm-workspace.jsp"%>
	<div class="row-fluid">
	<%@include file="/menu/bpm-workspace.jsp"%>
		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">
		<article class="m-widget"> 
		<header class="header">
		<h4 class="title">使用感受</h4>
		</header>
		
		<div class="content">
		<c:choose>
			<c:when test="${empty requestScope.page.list }">
			<center><h5>暂无使用感受</h5></center>
			</c:when>
			<c:otherwise>
				<table width="30%">
			<tr id="res">
				<td>已有 <span id="count">${requestScope.page.totalCount }</span> 条感受 </td>
			</tr>
			<c:forEach items="${requestScope.page.list }" var="n" varStatus="s">
				<tr>
					<td>${s.count }楼</td>
				</tr>
				<tr>
					<td>用户名：<b>${n.user.username }</b></td>
					<td><span style="float: right">发表时间：
					<fmt:formatDate value="${n.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"/></span></td>
				</tr>
				<tr>
					<td colspan="2">内容：${n.content }</td>
				</tr>
			</c:forEach>
		</table>
			</c:otherwise>
		</c:choose>
		</div>
		</article>
		
		<article>
		<div class="m-page-info pull-left">
			共 ${requestScope.page.totalCount } 条感受
		</div>
		<div class="m-pagination pull-right">
			<a href="${pageContext.request.contextPath}/user/review/1">首页</a>
			<c:if test="${requestScope.page.currentPage != 1 }">
				<a href="${pageContext.request.contextPath}/user/review/${requestScope.page.currentPage }-1">上一页</a>
			</c:if>
			<c:if test="${requestScope.page.currentPage != requestScope.page.pageCount }">
				<a href="${pageContext.request.contextPath}/user/review/${requestScope.page.currentPage }+1">下一页</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/user/review/${requestScope.page.pageCount }">尾页</a>
			当前第
			${requestScope.page.currentPage }
			页,总共
			${requestScope.page.pageCount }
			页
		</div>
		<div class="m-clear"></div>
		</article>
		
		</section></div>
</body>
</html>