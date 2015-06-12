<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-delegate");
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
<title>详情介绍</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/bpm-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/bpm-workspace.jsp"%>
		<!-- start of main -->
		<section id="m-main" class="span10" style="float:right">

		<div>
			<article class="m-widget"> <header class="header">
			<h4 class="title">${requestScope.car.carType.brand }</h4>
			</header>
			<div class="content content-inner">
				<table>
					<tr style="float: left;">
						<td><img alt=""
							src="${pageContext.request.contextPath}${requestScope.car.picture}"
							width="240px" height="180px"></td>
					</tr>
					<tr style="float: left;">
						<td>
							<div>
								<dl style="display: block;">
									<dt style="float: left;"></dt>
									<dd style="float: left;">
										<b></b>
										<ul>
											<li class="point"><b>${requestScope.car.carName }</b></li>
											<li class="point">指导价：${requestScope.car.guidePrice }</li>
											<li class="point">本店报价：<font color="red">${requestScope.car.salePrice }</font></li>
											<li class="point">上市时间：${requestScope.car.listTime }</li>
										</ul>
									</dd>
								</dl>
							</div>
						</td>
					</tr>
				</table>
			</div>
			</article>
		</div>
		<div class="row-fluid">
			<div class="page-header">
				<h4>参数配置</h4>
			</div>
			<table>
				<tr>
					<td>品牌：${requestScope.car.carType.brand }</td>
				</tr>
				<tr>
					<td>排量：${requestScope.car.displacement }</td>
				</tr>
				<tr>
					<td>级别：${requestScope.car.type }</td>
				</tr>
				<tr>
					<td>上市时间：${requestScope.car.listTime }</td>
				</tr>
			</table>
		</div>
		</section>
	</div>
</body>
</html>