<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">
<style type="text/css">
	a{text-decoration: none;}
	ul{list-style: none;}
	.main{width: 960px;margin: 0px auto;margin-top: 10px;overflow: hidden;}
	.news span{font-size: 16px;border-bottom: 1px solid #c3c3c3;width: 230px;display: block;}
	.news{border: 1px solid #c3c3c3;margin-bottom: 10px;}
	.news li{margin-left: 5px;padding: 3px 0px}
	.ldiv{width: 230px;float: left;margin-right: 10px}
	.rdiv{width: 700px;float: right;}
	.rdiv h3{font-size: 16px;margin-top: 5px;margin-bottom: 5px}
	.time{float: right;}
	.text{clear: right;margin-top: 20px;font-size: 20px}
	.foot{clear: both;text-align: center;margin-top: 20px}
	.wel{font-size: 16px;position: relative;top: 0px;}
</style>

<title>手机简单购-新闻资讯</title>
</head>
<body>	
	<%@ include file="top.jsp" %>
	
	
	<div style="width: 960px;margin: 0px auto;padding-top: 5px;padding-bottom: 5px">
		<span>你现在的位置:<a href="index.jsp">手机简单购</a>&gt;新闻阅读</span>
	</div>
	
	
	<div class="main">
		<div class="ldiv">
		<div class="news">
					<span><img src="img/other/icon_news.png">新闻动态</span>
						<ul class="nu">
							<c:forEach items="${nlist}" var="news">
								<li><img src="img/other/icon_sj.png">&nbsp;&nbsp;<a href="newsinfo?news_id=${news.news_id}">${news.news_title}</a></li>
							</c:forEach>
						</ul>
				</div>
		</div>
		<div class="rdiv">
			<h3>${news.news_title}</h3>
			<hr>
			<p class="time">发布时间:${news.news_date}</p>
			<p class="text">${news.news_text}</p>
		</div>
		<hr style="clear: both;">
	</div>
	
	<div class="foot">
		Copyright © 2017手机简单购 All Rights Reserved.
	</div>
	
	
	
</body>
</html>