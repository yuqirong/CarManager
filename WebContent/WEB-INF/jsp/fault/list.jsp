<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "cal");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>故障码信息列表</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">

		<article class="m-widget"> <header class="header">
		<h4 class="title">故障码信息列表</h4>
		</header>
		<div class="content">

			<table id="demoGrid" class="m-table table-hover">
				<thead>
					<tr>
						<th class="sorting">序号</th>
						<th class="sorting">故障码</th>
						<th class="sorting">信息</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.page.list }" var="n" varStatus="s">
						<tr>
							<td>${s.count }</td>
							<td>${n.code }</td>
							<td>${n.information }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</article> <article>
		<div class="m-page-info pull-left">共
			${requestScope.page.totalCount } 条记录</div>
		<div class="m-pagination pull-right">
			<a href="${pageContext.request.contextPath}/admin/faultcode/list/1">首页</a>
			<c:if test="${requestScope.page.currentPage != 1 }">
				<a
					href="${pageContext.request.contextPath}/admin/faultcode/list/${requestScope.page.currentPage -1}">上一页</a>
			</c:if>
			<c:if
				test="${requestScope.page.currentPage != requestScope.page.pageCount }">
				<a
					href="${pageContext.request.contextPath}/admin/faultcode/list/${requestScope.page.currentPage +1}">下一页</a>
			</c:if>
			<a
				href="${pageContext.request.contextPath}/admin/faultcode/list/${requestScope.page.pageCount }">尾页</a>
			当前第 ${requestScope.page.currentPage } 页,总共
			${requestScope.page.pageCount } 页
		</div>
		<div class="m-clear"></div>
		</article> 
		</section>
		<!-- end of main -->
	</div>
</body>
</html>
