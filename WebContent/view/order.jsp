<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-订单</title>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">
<style type="text/css">
th{text-align: center;}
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
						<li><a href="<%=request.getContextPath()%>/view/login.jsp"  style="color:red">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
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
				<form class="form" action="<%=request.getContextPath()%>/index.jsp" method="get">
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
	
	
	
	<div style="width: 960px;margin: 0px auto;padding-top: 5px;padding-bottom: 5px">
		<span>你现在的位置:<a href="index.jsp">手机简单购</a>&gt;订单信息</span>
	</div>
	
	
	
	
	
	<div style="width: 960px;margin: 0px auto"><table class="table table-hover">
		<thead>
			<tr>
				<th>商品名称</th>
				<th>单价</th>
				<th>数量</th>
				<th>总额</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${olist}" var="order">
				<tr>
					<td><img src="${order.url}" width="100px" height="100px"><a href="<%=request.getContextPath()%>/goodsInfoAction.action?goods_id=${order.goods_id}&f=0">${order.gname}</a></td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${order.price}</td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${order.quantity}</td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${order.total}</td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${order.test }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><h4>订单时间:${date}</h4></td>
			</tr>
			<tr>
				<td colspan="5"><h4>订单编号:${order_number}</h4></td>
			</tr>
			<tr>
				<td colspan="5"><h4>订单总额:${all}</h4></td>
			</tr>
			<tr>
				<td colspan="5"><h4>收货地址:${address}</h4></td>
			</tr>
		</tbody>
		
	</table>
	</div>
</body>
</html>