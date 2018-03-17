<%@page pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta/>
		<script type="text/javascript">
			var timer;
			//启动定时器
			function sttartTimes(){
				timer = window.setInterval(showSecondes,1000);
			}
			
			var i =5;
			
			function showSecondes(){
				if(i>0){
					i--;
					document.getElementById("secondes").innerHTML = i;
				}else{
					window.clearInterval(timer);
					location.href = "login.do"
				}
			}
			
			//取消转跳
			function resetTimer(){
				if(timer!=null && timer!=undefined){
					window.clearInterval(timer);
					location.href = "login.do";
				}
			}
		</script>
		<title>转跳</title>
	</head>
	<body>
		<div style="margin: auto auto">
			<h1 id="error">转跳到登陆页</h1>
			<span id="secondes">5</span>&nbsp;秒后将自动跳转,立即跳转请点击&nbsp;
			<a href="javascript:resetTimer();">马上跳转</a>
		</div>
	</body>
</html>