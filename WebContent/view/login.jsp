<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-登录</title>
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="../resource/css/header.css">
<link type="text/css" rel="stylesheet" href="../resource/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../resource/css/header.css">
<style type="text/css">
	.box{width: 500px;height: 300px;border: 1px solid #eaeaea;margin: 0px auto;padding: 2px;margin-top: 120px}
	.box p{font-size: 24px;line-height: 54px;background: #e6f5e8;color:#4c4d4b;padding-left: 10px;margin-bottom: 20px}
	.login{margin-top:20px;margin-left: 10px }
	td{padding: 5px}
	
	
	
	*{margin: 0px;padding: 0px;font-size: 14px;}
	.login{width: 960px;margin: 0px auto;}
	.header ul{list-style: none;}
	.ht{overflow: hidden;background: rgba(0, 0, 0, 0.07);height: 30px}
	.hm{width: 960px;margin: 0px auto;overflow: hidden;}
	.hb{background: #ff4c11;height: 30px;margin-top: 15px}
	.text{width: 960px;margin: 0px auto;}
	.login li{float: left;}
	.left{float: left;position: relative;top:5px;margin-left: 30px}
	.right{float: right;position: relative;top:5px;margin-right: 30px}
	.logo{float: left;margin-top: 30px}
	.search{}
	.form{margin-top: 30px;position: relative;left: 100px}
	#gname{ border: #f00 3px solid;width: 440px;height: 30px;float: left;padding: 0 10px;}
	#search{width: 140px;height: 36px;background: #ff0000;border: 0;color: white;font-size: 20px;font-weight: bold;}
	.wel{color: #ffffff;position: relative;top: 5px;}
	a{text-decoration: none;color:#666666}
	a:hover {color:black}
</style>

</head>
<body>

	<%-- <jsp:include page="top.jsp"></jsp:include> --%>
	
	
	<div class="header">
		<div class="ht">
			<div class="login">
				<c:if test="${sessionScope.user==null}">
					<ul class="left">
						<li><a href="<%=request.getContextPath()%>/view/login.jsp" style="color:red">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li><a href="<%=request.getContextPath()%>/view/regist.jsp">注册</a></li>
					</ul>					
				</c:if>
				<c:if test="${sessionScope.user!=null}">
					<ul class="left">
						<li>${user.username}&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li><a href="exit">退出</a></li>
					</ul>
				</c:if>
				<ul class="right">
					<li><img src="<%=request.getContextPath()%>/img/other/icon_3.png"><a href="<%=request.getContextPath()%>/cart?user_id=${sessionScope.user.user_id}" style="color:red">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="留言" src="<%=request.getContextPath()%>/img/other/icon_2.png"><a href="<%=request.getContextPath()%>/viewmessage">留言</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="首页" src="<%=request.getContextPath()%>/img/other/icon_1.png"><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
				</ul>
			</div>
		</div>
		<div class="hm">
			<div class="logo"><img src="<%=request.getContextPath()%>/img/other/手机简单购.jpg" width="144px" height="45px"></div>
			<div class="search">
				<form class="form" action="dim" method="get">
					<input id="gname" type="text" name="gname" placeholder="输入宝贝" style="height: 36px">
					<input id="search" type="submit" value="搜索">
				</form>
			</div>
		</div>
		<div class="hb">
			<div class="text">
				<span class="wel">欢迎光临手机简单购,在这里放心购物,放心花钱</span>
			</div>
		</div>
	</div>
	

	<%  String status=request.getParameter("status");
		boolean flag=status!=null&&status.equals("error");
	%>
	<div class="box">
		<p>欢迎回到手机简单购</p>
		<c:if test="<%=flag %>">
		<h3>用户名或密码错误,请重新登录</h3>
		</c:if>
		<c:if test="${sessionScope.user==null}">
		<div class="login">
			<form action="../login" method="get">
			<table>
				<tr>
					<td style="font-size: 20px;padding-left: 100px;padding-top: 10px">用户名:</td>
					<td style="padding-top: 10px"><input type="text" name="username" class="form-control" placeholder="体验账号:admin"></td>
				</tr>
				<tr>
					<td style="font-size: 20px;padding-left: 100px;padding-top: 20px">密码:</td>
					<td style="padding-top: 20px"><input type="password" name="pwd" class="form-control" placeholder="体验密码:123456"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;padding-left: 100px;padding-top: 25px"><input type="image" src="../img/other/an_ljdr.png"></td>
				</tr>
			</table>
			</form>
		</div>
		</c:if>
	</div>
	
	
	<script type="text/javascript">
		
		$("[type='image']").click(function() {
			var username=$("[name='username']").val();
			var pwd=$("[name='pwd']").val();
			if(username.length==0&&pwd.length==0){
				alert("请填写用户名和密码");
				return false;
			}else if(username.length==0&&pwd.length!=0){
				alert("请填写用户名");
				return false;
			}else if(username.length!=0&&pwd.length==0){
				alert("请填写密码");
				return false;
			}
		});
	</script>
</body>
</html>




