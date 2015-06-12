<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="navbar navbar-inverse">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a href="${pageContext.request.contextPath}/admin" class="brand">后台管理</a>
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<!--  -->
					<li class="dropdown "><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">返回前台<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath }"> <i
									class="icon-user"></i>前台首页
							</a></li>
						</ul></li>
					
					<li class="dropdown "><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">系统管理 <b
							class="caret"></b></a>
						<ul class="dropdown-menu">

							<li><a href="${pageContext.request.contextPath }/about/config">
									<i class="icon-user"></i>系统配置</a></li>
						</ul></li>
				</ul>
				<ul class="nav pull-right">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">您好，${user.username }<b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href=""> <i class="icon-user"></i>修改密码
							</a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/logout">
									<i class="icon-user"></i>退出
							</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
	</div>
	<!-- /navbar-inner -->
</div>
<!-- end of header bar -->
