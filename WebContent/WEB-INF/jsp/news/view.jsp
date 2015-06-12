<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-process");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>实时新闻</title>
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
		<h4 class="title">新闻详情</h4>
		</header>
		<table width="100%">
			<tr>
				<td align="center">
					<h4>${requestScope.news.title }</h4>
				</td>
			</tr>
			<tr>
				<td style="font-size: 14px">作者：${requestScope.news.author }&nbsp;&nbsp;来源：${requestScope.news.source }&nbsp;&nbsp;
					发布时间：<fmt:formatDate value="${requestScope.news.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;阅读量：${requestScope.news.count }</td>
			</tr>
			<tr>
				<td>${requestScope.news.content }</td>
			</tr>
		</table>
		</article>
		 <article>
		<div class="m-clear"></div>
		</article> </section>
		<!-- end of main -->
	</div>
</body>
</html>
