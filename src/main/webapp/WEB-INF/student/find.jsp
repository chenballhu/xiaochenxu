<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta content="text/html;charset=utf-8">
		<title>查询</title>
		<script type="text/javascript">
			function delect(btn){
						var r = window.confirm("确定要删除吗?");
						var v = btn.parentNode.parentNode;
						var td = v.getElementsByTagName("td");
						var num = td[0].innerHTML;
						if(r){
							location.href="deleteStudent.do?id="+num;	
						}
			}
			function f1(btn){
				var v = btn.parentNode.parentNode;
				var td = v.getElementsByTagName("td");
				var num = td[0].innerHTML;
				location.href="toModify.do?id="+num;	
			}
			
			
		</script>
	</head>
	<body>
		<h5>
			欢迎你,<c:choose >
				<c:when test="${empty userName}">游客</c:when>
				<c:otherwise>${userName }</c:otherwise>
			</c:choose>
		</h5>
		<form action="toFind.do">
			<div>
				学号:<input type="text" name="input"/>
				<input type="submit" value="搜索">
			</div>
		</form>
		
		<form >
			<table cellspacing="0" border="1">
				<tr>
					<th>学号</th>
					<th>名字</th>
					<th>宿舍栋号</th>
					<th>房间号</th>
					<th>功能按钮</th>
				</tr>
				<c:forEach items="${students }" var="c">
				<tr>
					<td>${c.studentId }</td>
					<td>${c.studentName }</td>
					<td>${c.dormNum }</td>
					<td>${c.roomNum}</td>
					<td>
						<c:choose>
							<c:when test="${empty userName }"></c:when>
							<c:otherwise>
								<input type="button" id="a1" value="修改" onclick="f1(this);"/>
							</c:otherwise>
						</c:choose>
						<c:if test="${userName =='admin'}" >
							<input type="button" id="a2" value="删除" onclick="delect(this);"/>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</form>
		<c:choose>
			<c:when test="${empty userName}"></c:when>
			<c:otherwise>
				<div><input type="button" value="添加学生" onclick="location.href='toAddStudent.do'"></div>
			</c:otherwise>
		</c:choose>
	</body>
</html>