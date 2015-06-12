<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-process");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>新闻信息列表</title>
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
		<section id="m-main" class="span10" style="float:right">
		<div>
			<article class="m-widget"> <header class="header">
			<h4 class="title">查询</h4>
			<div class="ctrl">
				<a class="btn"><i id="cal-infoSearchIcon"
					class="icon-chevron-up"></i></a>
			</div>
			</header>
			<div id="cal-infoSearch" class="content content-inner">

				<form method="post" action="" class="form-inline">
					<label for="cal-info_name">搜索:</label> <input type="text"
						id="cal-info_name" name="keywords" placeholder="请输入关键词查询">
					<button class="btn btn-small a-search" type="submit">查询</button>
				</form>
			</div>
			</article>
		</div>

		<article class="m-widget"> <header class="header">
		<h4 class="title">新闻信息列表</h4>
		</header>
		<div class="content">

			<table id="demoGrid" class="m-table table-hover">
				<thead>
					<tr>
						<th class="sorting">序号</th>
						<th class="sorting">标题</th>
						<th class="sorting">作者</th>
						<th class="sorting">来源</th>
						<th class="sorting">发布时间</th>
						<th class="sorting">栏目</th>
						<th class="sorting">修改</th>
						<th class="sorting">删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.page.list }" var="n" varStatus="s">
						<tr>
							<td>${s.count }</td>
							<td><a href="${pageContext.request.contextPath }/admin/news/views/${n.id }">${n.title }</a></td>
							<td>${n.author }</td>
							<td>${n.source }</td>
							<td><fmt:formatDate value="${n.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${n.newsType.typeName }</td>
							<td><a
								href="${pageContext.request.contextPath }/admin/news/edit/${n.id }">修改</a></td>
							<td><a
								href="${pageContext.request.contextPath }/admin/news/delete/${n.id }" class="delete">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</article> <article>
		<div class="m-page-info pull-left">共
			${requestScope.page.totalCount } 条记录</div>
		<div class="m-pagination pull-right">
			<a href="${pageContext.request.contextPath}/admin/news/list/1">首页</a>
			<c:if test="${requestScope.page.currentPage != 1 }">
				<a
					href="${pageContext.request.contextPath}/admin/news/list/${requestScope.page.currentPage -1}">上一页</a>
			</c:if>
			<c:if
				test="${requestScope.page.currentPage != requestScope.page.pageCount }">
				<a
					href="${pageContext.request.contextPath}/admin/news/list/${requestScope.page.currentPage +1}">下一页</a>
			</c:if>
			<a
				href="${pageContext.request.contextPath}/admin/news/list/${requestScope.page.pageCount }">尾页</a>
			当前第 ${requestScope.page.currentPage } 页,总共
			${requestScope.page.pageCount } 页
		</div>
		<div class="m-clear"></div>
		</article> 
		<form action="" method="post">
			<input type="hidden" name="_method" value="DELETE">
		</form>
		</section>
		<!-- end of main -->
	</div>
</body>
</html>
