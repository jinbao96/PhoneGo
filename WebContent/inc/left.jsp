<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页左侧导航</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/public.js"></script>
</head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			
				<div class="line" onclick="window.open('<%=request.getContextPath() %>/index','_parent')">
					<img src="../img/coin01.png" />&nbsp;&nbsp;首页
				</div>
			

			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin03.png" /><img class="icon2"
						src="../img/coin04.png" /> 商品管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a class="cks" href="../allGoods"
						target="main">全部商品</a><img class="icon5" src="../img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a class="cks" href="../queryCate"
						target="main">添加商品</a><img class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin05.png" /><img class="icon2"
						src="../img/coin06.png" /> 新闻管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a class="cks" href="../queryNews"
						target="main">全部新闻</a><img class="icon5" src="../img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a class="cks" href="../addNews.jsp"
						target="main">添加新闻</a><img class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin07.png" /><img class="icon2"
						src="../img/coin08.png" /> 会员管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../vip.html" target="main"
						class="cks">会员管理</a><img class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin11.png" /><img class="icon2"
						src="../img/coin12.png" /> 留言管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../connoisseur.html"
						target="main" class="cks">留言管理</a><img class="icon5"
						src="../img/coin21.png" />
				</dd>
			</dl>
			<!-- 
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin10.png" /><img class="icon2"
						src="../img/coin09.png" /> 话题管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../topic.html" target="main"
						class="cks">话题管理</a><img class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin14.png" /><img class="icon2"
						src="../img/coin13.png" /> 心愿管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../wish.html" target="main"
						class="cks">心愿管理</a><img class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin15.png" /><img class="icon2"
						src="../img/coin16.png" /> 约见管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../appointment.html"
						target="main" class="cks">约见管理</a><img class="icon5"
						src="../img/coin21.png" />
				</dd>
			</dl>
			 -->
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coin17.png" /><img class="icon2"
						src="../img/coin18.png" /> 订单管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../queryAllOrder"
						target="main" class="cks">订单管理</a><img class="icon5"
						src="../img/coin21.png" />
				</dd>
			</dl>
			<dl class="system_log">
				<dt>
					<img class="icon1" src="../img/coinL1.png" /><img class="icon2"
						src="../img/coinL2.png" /> 系统管理<img class="icon3"
						src="../img/coin19.png" /><img class="icon4"
						src="../img/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a href="../changepwd.html"
						target="main" class="cks">修改密码</a><img class="icon5"
						src="../img/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="../img/coin111.png" /><img class="coin22"
						src="../img/coin222.png" /><a class="cks" href="../adminexit">退出</a><img
						class="icon5" src="../img/coin21.png" />
				</dd>
			</dl>

		</div>

	</div>
</body>
</html>
