<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/header.css">
<style type="text/css">
	a{text-decoration: none;color:#666666}
	a:hover {color:black}
</style>
</head>
<body>
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
					<li><img src="${pageContext.request.contextPath}/img/other/icon_3.png"><a href="<%=request.getContextPath()%>/cart?user_id=${sessionScope.user.user_id}" style="color:red">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="留言" src="${pageContext.request.contextPath}/img/other/icon_2.png"><a href="<%=request.getContextPath()%>/viewmessage">留言</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="首页" src="${pageContext.request.contextPath}/img/other/icon_1.png"><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
				</ul>
			</div>
		</div>
		<div class="hm">
			<div class="logo"><img src="<%=request.getContextPath()%>/img/other/手机简单购.jpg" width="144px" height="45px"></div>
			<div class="search">
				<form class="form" action="index.jsp" method="get">
					<input id="gname" type="text" name="gname" placeholder="输入宝贝" style="height: 30px">
					<input id="search" type="submit" value="搜索">
					<input type="hidden" id="path" value="<%=request.getContextPath()%>">
				</form>
			</div>
		</div>
		<div class="hb">
			<div class="text">
				<span class="wel">欢迎光临手机简单购,在这里放心购物,放心花钱</span>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	<script type="text/javascript">
		var flag=${empty sessionScope.user}
		//alert("1111");	
		if(flag){
			jQuery("a:contains('购物车')").click(function() {
				var f=window.confirm("未登录,请先登录");
				var path=$("#path").val();
				if(f){
					window.location.href=path+"/view/login.jsp";
					return false;
				}else{
					return false;
				}
				
				
			});
		}
		jQuery("#search").click(function() {
			var value=jQuery("[name='gname']").val();
			//var b=value==""?true:false;
			//alert(b);
			if(value.length<=0){
				return false;
			}
		});
		
	</script>
</body>
</html>