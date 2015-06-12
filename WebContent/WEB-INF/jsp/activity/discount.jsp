<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-process");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>优惠促销</title>
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
		<h4 class="title">优惠促销</h4>
		</header>
		
		<div class="content">
		<c:choose>
			<c:when test="${empty requestScope.page.list }">
			<center><h5>暂无优惠促销</h5></center>
			</c:when>
			<c:otherwise>
				<br>
				<c:forEach items="${requestScope.page.list }" var="n">
					<ul>
						<li style="list-style-type:none;"><a href="${pageContext.request.contextPath}/news/view/${n.id }">${n.title }</a>&nbsp;&nbsp;<fmt:formatDate value="${n.createTime }"  pattern="yyyy-MM-dd"/></li>
					</ul>
				</c:forEach>
				<br>
			</c:otherwise>
		</c:choose>
		</div>
		</article>
		
		<article>
		<div class="m-page-info pull-left">
			共 ${requestScope.page.totalCount } 条记录
		</div>
		<div class="m-pagination pull-right">
			<a href="${pageContext.request.contextPath}/activity/discount/1">首页</a>
			<c:if test="${requestScope.page.currentPage != 1 }">
				<a href="${pageContext.request.contextPath}/activity/discount/${requestScope.page.currentPage -1}">上一页</a>
			</c:if>
			<c:if test="${requestScope.page.currentPage != requestScope.page.pageCount }">
				<a href="${pageContext.request.contextPath}/activity/discount/${requestScope.page.currentPage +1}">下一页</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/activity/discount/${requestScope.page.pageCount }">尾页</a>
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