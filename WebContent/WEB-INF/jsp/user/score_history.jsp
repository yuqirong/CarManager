<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>我的积分</h4>
	积分：${requestScope.user.score }
	<br>
	<h4>积分变更记录</h4>
	<table cellpadding="0" border="1" cellspacing="0">
		<tr>
			<th>操作</th>
			<th>积分变更</th>
			<th>详情</th>
			<th>变更时间</th>
		</tr>
		<tbody>
			<c:forEach items="${requestScope.records }" var="r">
				<tr>
					<td>${r.operation }</td>
					<td><c:if test="${r.change>0 }">+${r.change }</c:if> <c:if
							test="${r.change<0 }">${r.change }</c:if></td>
					<td>${r.details }</td>
					<td>${r.changeTime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>