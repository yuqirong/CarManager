<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "bpm-task");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>栏目信息</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<section id="m-main" class="span10" style="float:right"> <article
			class="m-widget"> <header class="header">
		<h4 class="title">编辑栏目</h4>
		</header>

		<div class="content content-inner">

			<form method="post" action="${pageContext.request.contextPath }/admin/newstype/save"
				class="form-horizontal">
				<input type="hidden" name="_method" value="PUT" />
				<div class="control-group">
					<label class="control-label">栏目ID：</label>
					<div class="controls">
						<div class="input-append">
							<input type="text" name="id" value="${requestScope.newsType.id }" readonly="readonly" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">栏目名：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="typeName" value="${requestScope.newsType.typeName }" >
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">创建时间：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="createTime" value='<fmt:formatDate value="${requestScope.newsType.createTime }"
											pattern="yyyy-MM-dd HH:mm:ss" />' readonly="readonly">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">栏目介绍：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<textarea name="introduction" cols="15" rows="10">${requestScope.newsType.introduction }</textarea>
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
