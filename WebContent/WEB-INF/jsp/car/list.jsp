<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-delegate");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.point {
	list-style-type: none;
}
</style>
<%@include file="/common/meta.jsp"%>
<title>车型介绍</title>
<%@include file="/common/s.jsp"%>
</head>
<%@include file="/header/admin-workspace.jsp"%>
<div class="row-fluid">
	<%@include file="/menu/admin-workspace.jsp"%>
	<!-- start of main -->
	<section id="m-main" class="span10" style="float:right">

	<div>
		<article class="m-widget"> <header class="header">
		<h4 class="title">${requestScope.carType.brand }</h4>
		</header>
		<div class="content content-inner">
			<table>
				<tr style="float: left;">
					<td><img alt=""
						src="${pageContext.request.contextPath}${requestScope.carType.picture}"
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
										<li class="point"><b>${carType.typeName }</b><span
											style="padding-left: 20px"><a
												href="http://www.xgo.com.cn/3856/items.html">[参数配置]</a>&nbsp;&nbsp;<a
												href="http://product.xgo.com.cn/pic_list/3856/">[图片]</a></span></li>
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
	<h4 class="title">
		车型列表<span style="padding-left: 20px">共有
			${fn:length(requestScope.cars) } 款符合条件的车型</span>
	</h4>
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
					<th class="sorting">修改</th>
					<th class="sorting">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.cars }" var="c">
					<tr>
						<td>${c.listTime }</td>
						<td><a href="">${c.carName }</a></td>
						<td>${c.displacement }</td>
						<td>${c.salePrice }</td>
						<td>${c.guidePrice }</td>
						<td>${c.priceTime }</td>
						<td><a href="">修改</a></td>
						<td><a href="">删除</a></td>
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
