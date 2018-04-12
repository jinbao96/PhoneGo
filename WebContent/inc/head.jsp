<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/public.js"></script>
<style type="text/css">
	.p2{color:white;}
	.headLogo{margin-bottom: 5px;margin-right: 20px}
</style>
<script type="text/javascript">
	$(function() {
		setInterval(getTime,1000); //每隔一秒执行一次 
		//取得系统当前时间 
		function getTime(){ 
		var myDate = new Date(); 
		var date = myDate.toLocaleDateString(); 
		var hours = "a";
		if(myDate.getHours()<10){
			hours = "0" + myDate.getHours();
		}else{
			hours = myDate.getHours()
		}
		var minutes = "b"; 
		if(myDate.getMinutes()<10){
			minutes = "0" + myDate.getMinutes();
		}else{
			minutes = myDate.getMinutes();
		}
		var seconds = "c"; 
		if(myDate.getSeconds()<10){
			seconds = "0" + myDate.getSeconds();
		}else{
			seconds = myDate.getSeconds();
		}
		$(".p2").html(date+" "+hours+":"+minutes+":"+seconds);
		}
	});
</script>
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL" style="margin-top: -30px">
			<!-- <img class="bd" src="../img/bd3.png" width="70px" height="70px"/> -->
			<img class="headLogo" src="../img/phonego.png" height="100px"/>
			<!-- <img alt="crm" src="../img/crm.png" class="headLogo" width="100px" height="70px"> -->
		</div>
		<div class="headR">
			<p class="p1">
				欢迎,
				${sessionScope.adminuser.name}
				
			</p>
			<p>
				<a href="../adminexit" style="color: white;font-size: 18px" target="_parent">退出</a>
			</p>
			<p class="p2">
				
			</p>
		</div>
		<!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
	</div>

	<!-- <div class="closeOut">
		<div class="coDiv">
			<p class="p1">
				<span>X</span>
			</p>
			<p class="p2">确定退出当前用户？</p>
			<P class="p3">
				<a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
			</p>
		</div>
	</div> -->



</body>
</html>