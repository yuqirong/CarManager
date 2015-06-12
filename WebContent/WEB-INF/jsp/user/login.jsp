<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>用户登录</title>
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
</script>
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
				<strong>登陆失败</strong> &nbsp; ${error}
			</div>
			<div class="alert m-alert-error"
				${ not empty param.kickout ? '' : 'style="display:none"'}>
				<strong>抱歉</strong> &nbsp; 您被踢出登录。
			</div>
			<br>

			<article class="m-widget">
				<header class="header">
					<h4 class="title">用户登录</h4>
				</header>

				<div class="content content-inner">

					<form action="" method="post" class="form-horizontal" style="width: 100%">
						<div class="control-group">
							<label class="control-label" for="username">用户名</label>
							<div class="controls">
								<input type="text" name="username" value="<shiro:principal/>">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="password">密码</label>
							<div class="controls">
								<input type="password" name="password">
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
							<label class="control-label" for="password">自动登录</label>
							<div class="controls">
								<input type="checkbox" name="rememberMe" checked="checked">
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<input class="btn" type="submit" value="登录" />&nbsp; <input
									class="btn" type="button" value="注册"
									onclick="window.location.href='${pageContext.request.contextPath}/user/reg'" />
							</div>
						</div>
					</form>
					</div>
			</article>

			<div class="m-spacer"></div>
		</section>
		<!-- end of main -->

		<div class="span3"></div>
	</div>

</body>
</html>