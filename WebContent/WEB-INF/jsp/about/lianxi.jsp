<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>联系我们</title>
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
				<h3>分店详情</h3>
			</div>

			<c:forEach items="${requestScope.companys }" var="c">
				<div class="well span10">
					<h4>分店名称：</h4>
					<p>${c.companyName }</p>
					<h4>分店介绍：</h4>
					<p>${c.description }</p>
					<h4>分店地址：</h4>
					<p>${c.address }</p>
					<p>${c.map }</p>
				</div>
			</c:forEach>
		</div>
		</section>
	</div>

</body>
</html>