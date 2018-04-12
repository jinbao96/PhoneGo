<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-后台管理</title>
</head>

<frameset rows="100,*" cols="*" framespacing="0"
	frameborder="no" border="0">
	<frame src="inc/head.jsp" name="headmenu" id="mainFrame"
		title="mainFrame">
	<!-- 引用头部 -->
<!-- 引用左边和主体部分 --> 
	<frameset rows="100*" cols="220,*" framespacing="0"
		frameborder="no" border="0"> 
		<frame src="inc/left.jsp" name="leftmenu" id="mainFrame"
			title="mainFrame">
		<frame src="main.jsp" name="main" scrolling="yes" noresize="noresize"
			id="rightFrame" title="rightFrame">
	</frameset>
</frameset>


</html>