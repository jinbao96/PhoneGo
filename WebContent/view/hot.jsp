<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">

<style type="text/css">
	th{text-align: center;}
</style>
</head>
<body>

	<div style="width: 230px">
	<h3>热卖推荐</h3>
			<ul>
				<c:forEach items="${hotlist}" var="goods">
					<li style="margin: 0px;padding: 0px">
						<dl class="hotdl" style="overflow: hidden;">
							<dt style="float: left;"><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="75px" height="75px"></a></dt>
							<dd style="margin-top: 20px"><a href="goodsInfo?goods_id=${goods.goods_id}">${goods.gname}</a></dd>
							<dd>${goods.price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			
			
			
	</div>
	


</body>
</html>



