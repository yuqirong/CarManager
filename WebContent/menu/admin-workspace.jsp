<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
	<!-- start of sidebar -->
	<aside id="m-sidebar" class="accordion span2" data-spy="affix"
		data-offset-top="100">

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-process"> <i
					class="icon-user"></i> <span class="title">新闻管理</span>
				</a>
			</div>
			<div id="collapse-bpm-process" class="accordion-body collapse ${currentMenu == 'bpm-process' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/news/list/1">
							<i class="icon-user"></i>新闻列表</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/news/add">
							<i class="icon-user"></i>添加新闻</a></li>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-task"> <i
					class="icon-user"></i> <span class="title">栏目管理</span>
				</a>
			</div>
			<div id="collapse-bpm-task" class="accordion-body collapse ${currentMenu == 'bpm-task' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/newstype/list">
							<i class="icon-user"></i>栏目列表</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/newstype/add">
							<i class="icon-user"></i>添加栏目</a></li>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-delegate"> <i
					class="icon-user"></i> <span class="title">车型管理</span>
				</a>
			</div>
			<div id="collapse-bpm-delegate" class="accordion-body collapse ${currentMenu == 'bpm-delegate' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/cartype/list">
							<i class="icon-user"></i>车型列表</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/cartype/add">
							<i class="icon-user"></i>添加车型</a></li>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-cal"> <i
					class="icon-user"></i> <span class="title">故障管理</span>
				</a>
			</div>
			<div id="collapse-cal" class="accordion-body collapse ${currentMenu == 'cal' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/faultcode/list/1">
							<i class="icon-user"></i>故障码对照表</a></li>
					<li><a href="">
							<i class="icon-user"></i>车况异常信息</a></li>
				</ul>
			</div>
		</div>
		<shiro:hasRole name="superadmin">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-doc"> <i
					class="icon-user"></i> <span class="title">员工管理</span>
				</a>
			</div>
			<div id="collapse-doc" class="accordion-body collapse ${currentMenu == 'doc' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/role/list">
							<i class="icon-user"></i>角色管理</a></li>	
					<li><a href="${pageContext.request.contextPath }/admin/role/add">
							<i class="icon-user"></i>添加角色</a></li>	
					<li><a href="${pageContext.request.contextPath }/admin/employee/list">
							<i class="icon-user"></i>员工账号管理</a></li>
					<li><a href="">
							<i class="icon-user"></i>员工组配置</a></li>		
				</ul>
			</div>
		</div>
		</shiro:hasRole>
		<shiro:hasRole name="superadmin">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-address-list"> <i
					class="icon-user"></i> <span class="title">会员管理</span>
				</a>
			</div>
			<div id="collapse-address-list" class="accordion-body collapse ${currentMenu == 'address-list' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath }/admin/user/grade/1">
							<i class="icon-user"></i>会员等级管理</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/user/score/1">
							<i class="icon-user"></i>会员积分管理</a></li>		
				</ul>
			</div>
		</div>
	    </shiro:hasRole>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-msg "> <i
					class="icon-user"></i> <span class="title">站内消息</span>
				</a>
			</div>
		<div id="collapse-msg" class="accordion-body collapse ${currentMenu == 'msg' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="">
							<i class="icon-user"></i>收件箱</a></li>
					<li><a href="">
							<i class="icon-user"></i>发件箱</a></li>
					<li><a href="">
							<i class="icon-user"></i>新建消息</a></li>
				</ul>
			</div>
		</div>

		<footer id="m-footer" class="text-center">
			<hr>
			<span style="font-family: Arial, Helvetica, sans-serif;">Copyright
				&copy; 2015 版权所有<br> All Rights Reserved
			</span>
		</footer>
	</aside>
	<!-- end of sidebar -->