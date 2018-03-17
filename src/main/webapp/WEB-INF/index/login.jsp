<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8">
	<title>login</title>
</head>
<body>
	<form action="toLogin.do" method="post">
		<div style="margin: auto auto;">
			<p>账号:<input type="text" name="userName"/><span style="margin-left: 8px;">${error }</span></p>
			<p>密码:<input type="password" name="pwd"/></p>
			<p>
				<input type="submit" value="管理员登陆" />
				<input type="button" value="游客登陆" onclick="location.href='find.do'">
			</p>
		</div>
	</form>
</body>
</html>



