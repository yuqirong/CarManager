<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-process");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.point{
list-style-type: none;
}
</style>
<%@include file="/common/meta.jsp"%>
<title>CarManager</title>
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
				<h3>${user.username }，欢迎来到汽车4S管理系统：</h3>
			</div>
		
			<div style="width: 100%; float: left;">
			<div style="float: left;display: inline-block;width: 33%">
				<h4>资讯<span style="padding-left: 20px"><a href="${pageContext.request.contextPath }/newstype/column/1/1">更多</a></span></h4>
				<c:forEach items="${requestScope.zixun }" var="n">
					<li class="point"><a href="${pageContext.request.contextPath }/news/view/${n.id }">${n.title }</a></li>
				</c:forEach>
				<br>
			</div>
			
			<div style="float: left;display: inline-block;width: 33%">
				<h4>新闻<span style="padding-left: 20px"><a href="${pageContext.request.contextPath }/newstype/column/2/1">更多</a></span></h4>
				<c:forEach items="${requestScope.xinwen }" var="n">
					<li class="point"><a href="${pageContext.request.contextPath }/news/view/${n.id }">${n.title }</a></li>
				</c:forEach>
				<br>
			</div>
			
			<div style="float: left;display: inline-block;width: 33%">
				<h4>导购<span style="padding-left: 20px"><a href="${pageContext.request.contextPath }/newstype/column/3/1">更多</a></span></h4>
				<c:forEach items="${requestScope.daogou }" var="n">
					<li class="point"><a href="${pageContext.request.contextPath }/news/view/${n.id }">${n.title }</a></li>
				</c:forEach>
				<br>
			</div>
			</div>
			<div>
				<h4>车系图片</h4>
				<ul style="display: block;">
				<c:forEach items="${requestScope.carTypes }" var="ct">
					<li style="float: left;padding: 20px;" class="point">
						<a href="${pageContext.request.contextPath }/cartype/${ct.id}">
							<img alt="${ct.typeName }" src="${pageContext.request.contextPath }${ct.picture }" width="160" height="120">
						</a>
						<p align="center">
							<a href="${pageContext.request.contextPath }/cartype/${ct.id}">${ct.typeName }</a>
						</p>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<p><a href="${pageContext.request.contextPath }/about/comp_info">浙江韩通汽车有限公司</a></p>
		<p>咨询电话：0571-860159990    地址:浙江省杭州市江干区艮山东路196号</p>
		</section>
	</div>
</body>
</html>