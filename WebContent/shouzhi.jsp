<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/css/index.css">
<link type="text/css" rel="stylesheet"
	href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<style type="text/css">
th, td {text-align: center;}
</style>
</head>
<body>
<div
		style="width: 800px; margin-top: 20px; margin-left: 150px;">
	<table class="table table-hover" style="border: 1px solid #C1C1C1;">
		<thead>
			<tr>
				<th>订单号</th>
				<th>订单总额</th>
				<th>订单日期</th>
				<th>订单状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${olist }" var="query">
				<tr>
					<td>${query.order_num }</td>
					<td>${query.total }</td>
					<td>${query.order_date }</td>
					<td>${query.test }</td>
					<td><a href="#">修改状态</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>



