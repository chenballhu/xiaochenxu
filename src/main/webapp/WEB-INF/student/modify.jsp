<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改学生信息</title>
	</head>
	<body>
		<form action="modify.do?id=${student.studentId }">
			<p>学号:<input type="text" name="id" value="${student.studentId }"></p>
			<p>姓名:<input type="text" name="studentName" value="${student.studentName }"></p>
			<p>宿舍栋号:<input type="text" name="dormNum" value="${student.dormNum }"></p>
			<p>房间号:<input type="text" name="roomNum" value="${student.roomNum }"></p>
			<p>
				<input type="submit" value="保存"/>
				<input type="button" value="返回" onclick="history.back();"/>
			</p>
		</form>
	</body>
</html>