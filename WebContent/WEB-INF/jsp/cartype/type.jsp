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
<title>车型介绍</title>
<%@include file="/common/s.jsp"%>
</head>
<%@include file="/header/bpm-workspace.jsp"%>
<div class="row-fluid">
	<%@include file="/menu/bpm-workspace.jsp"%>
	<!-- start of main -->
	<section id="m-main" class="span10" style="float:right">

	<div>
		<article class="m-widget"> <header class="header">
		<h4 class="title">查询</h4>
		<div class="ctrl">
			<a class="btn"><i id="cal-infoSearchIcon" class="icon-chevron-up"></i></a>
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

	<div>
		<article class="m-widget"> <header class="header">
		<h4 class="title">${requestScope.carType.brand }</h4>
		</header>
		<div class="content content-inner">
			<table>
				<tr style="float: left;">
					<td><img alt=""
						src="${pageContext.request.contextPath}${carType.picture}"
						width="160px" height="120px"></td>
				</tr>
				<tr style="float: left;">
					<td>
						<div>
							<dl style="display: block;">
								<dt style="float: left;"></dt>
								<dd style="float: left;">
									<b></b>
									<ul>
										<li class="point"><b>${carType.typeName }</b><span style="padding-left: 20px"><a href="http://www.xgo.com.cn/3856/items.html">[参数配置]</a>&nbsp;&nbsp;<a href="http://product.xgo.com.cn/pic_list/3856/">[图片]</a></span></li>
										<li class="point">指导价：${carType.guidePrice }</li>
										<li class="point">本店报价：<font color="red">${carType.salePrice }</font></li>
										<li class="point">库存：${carType.stock }</li>
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

	<article class="m-widget"> <header class="header">
	<h4 class="title">车型列表<span style="padding-left: 20px">共有 ${fn:length(requestScope.cars) } 款符合条件的车型</span></h4>
	</header>
	<div class="content">
		<table id="demoGrid" class="m-table table-hover">
			<thead>
				<tr>
					<th class="sorting">上市时间</th>
					<th class="sorting">车型</th>
					<th class="sorting">排量</th>
					<th class="sorting">本店报价</th>
					<th class="sorting">厂商指导价</th>
					<th class="sorting">报价时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.cars }" var="c">
					<tr>
						<td>${c.listTime }</td>
						<td><a href="${pageContext.request.contextPath}/car/detail/${c.id}">${c.carName }</a></td>
						<td>${c.displacement }</td>
						<td>${c.salePrice }</td>
						<td>${c.guidePrice }</td>
						<td>${c.priceTime }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</article> </section>
	<!-- end of main -->
</div>
</body>
</html>
