<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="navbar navbar-inverse">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a href="${pageContext.request.contextPath}/" class="brand">汽车4S店管理系统</a>
			<div class="nav-collapse collapse navbar-responsive-collapse">
				<ul class="nav">
					<li class="divider-vertical"></li>
					<!--  -->
					<li class="dropdown "><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">调查问卷<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href=""> <i
									class="icon-user"></i>口碑评价
							</a></li>
							<li class="divider"></li>
							<li><a
								href="${pageContext.request.contextPath}/user/review/1"> <i
									class="icon-user"></i>使用感受
							</a></li>
						</ul></li>
					
					<li class="dropdown "><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">相关答疑<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/about/help"> <i
									class="icon-user"></i>常见问题
							</a></li>
							<li class="divider"></li>
							<li><a
								href="${pageContext.request.contextPath}/about/help"> <i
									class="icon-user"></i>在线互动
							</a></li>
						</ul></li>
					<li class="dropdown "><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">关于我们<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/about/comp_info"><i
									class="icon-user"></i>公司介绍</a></li>
							<li class="divider"></li>
							<li><a
								href="${pageContext.request.contextPath}/about/lianxi"> <i
									class="icon-user"></i>联系我们
							</a></li>
						</ul></li>
				</ul>
				<ul class="nav pull-right">
				<shiro:guest>
				<li class="dropdown"><a
						class="dropdown-toggle" href="${pageContext.request.contextPath }/user/login">请登录</a></li>
				</shiro:guest>
				<shiro:user>
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="javascript:void(0)">您好，${user.username }<b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/user/myzone">
									<i class="icon-user"></i>我的空间
							</a></li>
							<li class="divider"></li>
							<li><a href=""> <i class="icon-user"></i>修改密码
							</a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/logout">
									<i class="icon-user"></i>退出
							</a></li>
						</ul></li>
					</shiro:user>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
	</div>
	<!-- /navbar-inner -->
</div>
<!-- end of header bar -->
