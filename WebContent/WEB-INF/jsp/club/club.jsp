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
<title>俱乐部</title>
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
				<h3>俱乐部</h3>
			</div>
			<c:forEach items="${requestScope.clubs }" var="c">
				<div class="well span4">
					<h4>俱乐部名称：</h4>
					<p>${c.clubName }</p>
					<h4>成立时间：</h4>
					<p><fmt:formatDate value="${c.createTime }"  pattern="yyyy-MM-dd"/></p>
					<h4>俱乐部介绍：</h4>
					<p>${c.introduction }</p>
					<div class="control-group" align="center">
						<div class="controls">
							<input class="btn" type="button" value="申请加入" />&nbsp;&nbsp;
							<input class="btn" type="button" value="更多介绍" 
							onclick="window.location.href='${pageContext.request.contextPath}/club/${c.id }/detail'"/>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		</section>
	</div>
</body>
</html>