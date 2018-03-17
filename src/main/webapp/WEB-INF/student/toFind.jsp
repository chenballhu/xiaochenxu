<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta content="utf-8">
		<title>搜索</title>
	</head>
	<body>
		<table cellspacing="0" border="1">
			<tr>
				<td>学号</td>
				<td>名字</td>
				<td>宿舍栋号</td>
				<td>房号</td>
			</tr>
			<tr>
				<td>${student.studentId }</td>
				<td>${student.studentName }</td>
				<td>${student.dormNum }</td>
				<td>${student.roomNum }</td>
			</tr>
		</table>
		<input type="button" value="返回" onclick="location.href='find.do'">
	</body>
</html>