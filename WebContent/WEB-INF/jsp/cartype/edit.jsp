<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-delegate");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>车型信息</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<section id="m-main" class="span10" style="float:right"> <article
			class="m-widget"> <header class="header">
		<h4 class="title">编辑车型</h4>
		</header>

		<div class="content content-inner">

			<form method="post" action="${pageContext.request.contextPath }/admin/cartype/save"
				class="form-horizontal" enctype="multipart/form-data">
				<input type="hidden" name="picture" value="${requestScope.carType.picture }">
				<div class="control-group">
					<label class="control-label">车型ID：</label>
					<div class="controls">
						<div class="input-append">
							<input type="text" name="id" value="${requestScope.carType.id }" readonly="readonly" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">车型：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="typeName" value="${requestScope.carType.typeName }" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">车型图片：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="file" name="file">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">指导价：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="guidePrice" value="${requestScope.carType.guidePrice }" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">本店报价：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="salePrice" value="${requestScope.carType.salePrice }" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">库存：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="stock" value="${requestScope.carType.stock }" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">车型介绍：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
						<textarea name="introduction" cols="15" rows="10">${requestScope.carType.introduction }</textarea>
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button id="submitButton" type="submit" class="btn">保存</button>
						&nbsp;
						<button type="button" onclick="history.back();" class="btn">返回</button>
					</div>
				</div>
			</form>
		</div>
		</article> </section>
		<!-- end of main -->
	</div>
</body>
</html>
