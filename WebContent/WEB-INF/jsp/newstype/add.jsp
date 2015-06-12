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
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<section id="m-main" class="span10" style="float:right"> <article
			class="m-widget"> <header class="header">
		<h4 class="title">添加栏目</h4>
		</header>

		<div class="content content-inner">

			<form:form method="post" action="${pageContext.request.contextPath }/admin/newstype/save"
				class="form-horizontal" modelAttribute="newsType">
				<div class="control-group">
					<label class="control-label">栏目名：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<form:input path="typeName"/>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">栏目介绍：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<form:textarea path="introduction"  placeholder="介绍一下你的栏目吧" cols="15" rows="10"/>
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
			</form:form>
		</div>
		</article> </section>
		<!-- end of main -->
	</div>
</body>
</body>
</html>
