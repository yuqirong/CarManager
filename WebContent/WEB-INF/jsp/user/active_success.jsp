<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function countDown(secs, surl) {
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			location.href = surl;
		}
	}
</script>
<body>
	<h4>恭喜，操作成功！</h4>
	<h4>账号激活成功!因为有你，我们会更加努力!</h4>
	<span id="jumpTo">5</span> 秒钟后自动跳转，如果不跳转，请点击下面链接:
	<br>
	<a href="${pageContext.request.contextPath}/home">点击跳转到首页</a>
	<script type="text/javascript">
		countDown(5, '${pageContext.request.contextPath}/home');
	</script>
</body>
</html>