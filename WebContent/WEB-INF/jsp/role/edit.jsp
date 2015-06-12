<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("currentMenu", "doc");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>添加角色</title>
<%@include file="/common/s.jsp"%>
</head>
<body>
<body>
	<%@include file="/header/admin-workspace.jsp"%>
	<div class="row-fluid">
		<%@include file="/menu/admin-workspace.jsp"%>

		<section id="m-main" class="span10" style="float:right"> <article
			class="m-widget"> <header class="header">
		<h4 class="title">编辑角色</h4>
		</header>

		<div class="content content-inner">

			<form:form method="post"
				action="${pageContext.request.contextPath }/admin/role/save"
				class="form-horizontal" modelAttribute="role">
				<input type="hidden" name="_method" value="PUT">
				<div class="control-group">
					<label class="control-label">角色ID：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="id" readonly="readonly"
								value="${requestScope.role.id }">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">角色名：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="role" value="${requestScope.role.role }">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">角色介绍：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<input type="text" name="description"
								value="${requestScope.role.description }">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否启用：</label>
					<div class="controls">
						<div class="input-append" style="padding-left: 0px;">
							<c:if test="${requestScope.role.available == true }">
								<input type="checkbox" name="available"
									value="${requestScope.role.available }" checked="checked">
							</c:if>
							<c:if test="${requestScope.role.available == false }">
								<input type="checkbox" name="available"
									value="${requestScope.role.available }">
							</c:if>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">权限：</label>
					<ul>
						<c:forEach items="${requestScope.permissions }" var="p">
							<li
								style="float: left; padding-left: 20px; list-style-type: none;">
								<div class="input-append" style="padding-left: 0px;">
									<input type="checkbox" name="permissions" value="${p.id }">
								</div>${p.name }
							</li>
						</c:forEach>
					</ul>
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
