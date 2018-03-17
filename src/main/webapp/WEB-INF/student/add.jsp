<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增学生</title>
	</head>
	<body>
		<form action="addStudent.do" method="post" >
			<div>
				<div>学生学号:<input type="text" name="studentId"/></div>
				<div>学生名字:<input type="text" name="studentName"/></div>
				<div>宿舍栋号:<input type="text" name="dormNum"/></div>
				<div>房号<input type="text" name="roomNum"/></div>
				<input type="submit" value="保存"/>
				<input type="button" value="取消" onclick="location.href='find.do'"/>
			</div>
		</form>
	</body>
	
</html>