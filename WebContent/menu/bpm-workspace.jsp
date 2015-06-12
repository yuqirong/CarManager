<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- start of sidebar -->
	<aside id="m-sidebar" class="accordion span2" data-spy="affix"
		data-offset-top="100">

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-process"> <i
					class="icon-user"></i> <span class="title">活动</span>
				</a>
			</div>
			<div id="collapse-bpm-process" class="accordion-body collapse ${currentMenu == 'bpm-process' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath}/activity/discount/1">
							<i class="icon-user"></i>优惠促销</a></li>
					<li><a href="${pageContext.request.contextPath}/activity/tour/1">
							<i class="icon-user"></i>自驾游</a></li>
					<li><a href="-------">
							<i class="icon-user"></i>联合商户折扣</a></li>
					<li><a href="-------">
							<i class="icon-user"></i>电子优惠券</a></li>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-task"> <i
					class="icon-user"></i> <span class="title">俱乐部</span>
				</a>
			</div>
			<div id="collapse-bpm-task" class="accordion-body collapse ${currentMenu == 'bpm-task' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="${pageContext.request.contextPath}/club/browse">
							<i class="icon-user"></i>加入俱乐部</a></li>
					<li><a href="${pageContext.request.contextPath}/club/activity">
							<i class="icon-user"></i>俱乐部活动</a></li>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-bpm-delegate"> <i
					class="icon-user"></i> <span class="title">车型介绍</span>
				</a>
			</div>
			<div id="collapse-bpm-delegate" class="accordion-body collapse ${currentMenu == 'bpm-delegate' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
				<c:forEach items="${applicationScope.initCarTypes }" var="c">
					<li><a href="${pageContext.request.contextPath}/cartype/${c.id}">
							<i class="icon-user"></i>${c.typeName }</a></li>
				</c:forEach>
				</ul>
			</div>
		</div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-cal"> <i
					class="icon-user"></i> <span class="title">车况</span>
				</a>
			</div>
			<div id="collapse-cal" class="accordion-body collapse ${currentMenu == 'cal' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="">
							<i class="icon-user"></i>总里程</a></li>
					<li><a href="">
							<i class="icon-user"></i>油量</a></li>
					<li><a href="">
							<i class="icon-user"></i>电压</a></li>
					<li><a href="">
							<i class="icon-user"></i>机油</a></li>
					<li><a href="">
							<i class="icon-user"></i>健康检查</a></li>	
				</ul>
			</div>
		</div>
		
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#m-sidebar" href="#collapse-doc"> <i
					class="icon-user"></i> <span class="title">预约</span>
				</a>
			</div>
			<div id="collapse-doc" class="accordion-body collapse ${currentMenu == 'doc' ? 'in' : ''}">
				<ul class="accordion-inner nav nav-list">
					<li><a href="">
							<i class="icon-user"></i>汽车养护</a></li>
							
				</ul>
			</div>
		</div>

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