<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>用户注册</title>
<%@include file="/common/s.jsp"%>
</head>
<script>
	$(function() {
		$(".jcaptcha-btn").click(
				function() {
					$(".jcaptcha-img").attr(
							"src",
							'${pageContext.request.contextPath}/jcaptcha.jpg?'
									+ new Date().getTime());
				});
	});
	function checkAgree() {
		var state = $('#agree').is(":checked");
		if (state) {
			$("#reg").submit();
		} else {
			$("#agreeError").html("请阅读CarManager注册协议！");
		}
		return false;
	}
</script>
<style>
.required {
	color: red;
}
</style>
</head>
<body>

	<!-- start of header bar -->
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a href="${pageContext.request.contextPath}/" class="brand">汽车4S店管理系统</a>
			</div>
		</div>
		<!-- /navbar-inner -->
	</div>
	<!-- end of header bar -->

	<div class="row-fluid">
		<div class="span3"></div>

		<!-- start of main -->
		<section class="span6">
		<div class="alert m-alert-error"
			${! empty error ? '' : 'style="display:none"'}>
			<strong>注册失败</strong> &nbsp; ${error}
		</div>
		<br>

		<article class="m-widget"> 
			<header class="header">
				<h4 class="title">用户注册</h4>
		</header>

		<div class="content content-inner">

			<form:form id="reg" action="${pageContext.request.contextPath }/user/reg"
				method="post" modelAttribute="user" cssClass="form-horizontal">
				
				<div class="control-group">
					<label class="control-label" for="username">用户名</label>
					<div class="controls">
						<form:input path="username" />
						<form:errors path="username" cssClass="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">密码</label>
					<div class="controls">
						<form:password path="password" />
						<form:errors path="password" cssClass="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">确认密码</label>
					<div class="controls">
						<form:password path="confirmPassword" />
						<form:errors path="confirmPassword" cssClass="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">性别</label>
					<div class="controls">
						<nobr><form:radiobutton path="gender" value="1" />男
						<form:radiobutton path="gender" value="0" />女</nobr>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">电子邮箱</label>
					<div class="controls">
						<form:input path="email" />
						<form:errors path="email" cssClass="required" />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">手机</label>
					<div class="controls">
						<form:input path="phone" />
						<form:errors path="phone" cssClass="required" />
					</div>
				</div>
				<c:if test="${jcaptchaEbabled}">
					<div class="control-group">
						<label class="control-label">验证码</label>
						<div class="controls">
							<input type="text" name="jcaptchaCode"> <img
								class="jcaptcha-btn jcaptcha-img"
								src="${pageContext.request.contextPath}/jcaptcha.jpg"
								title="点击更换验证码"> <a class="jcaptcha-btn"
								href="javascript:void(0);">换一张</a>
						</div>
					</div>
				</c:if>
				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<h5><input type="checkbox" id="agree" checked="checked">
						已同意<a href="agreement">汽车4S管理系统注册协议</a>&nbsp;&nbsp;<span class="required" id="agreeError"></span></h5>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<h5><input class="btn" type="button" value="注册" onclick="checkAgree()"/>&nbsp;&nbsp;
						已有账号？<a href="${pageContext.request.contextPath }/user/login">现在登录</a></h5>
					</div>
				</div>
			</form:form>
		</div>
		</article>
		<div class="m-spacer"></div>
		</section>
		<!-- end of main -->
		<div class="span3"></div>
	</div>
</body>
</html>