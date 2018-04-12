<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
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
th, td {text-align: center;font-size: 20px;}
.product-buyer-name {max-width: 110px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
body{font-size: 20px;}
.form-control{width: 200px;display: inline;height: 35px}
</style>
</head>
<body>
	<div style="width: 800px; margin-top: 20px; margin-left: 150px;">
	<form action="queryMoney" method="post">
		<table class="table" style=" border: 1px solid #C1C1C1">
			<tbody>
				<tr>
					<td style="border-right: 1px solid #C1C1C1;font-size: 20px;">本年营业额:${money.yearMoney }元</td>
					<td>
						<input id="date" name="date" type="text" value="${date }" class="form-control" placeholder="如'2018-01-01'"> 
						<input id="sub" type="submit" class="btn btn-primary" value="查询">
					</td>
				</tr>
				<tr>
					<td style="border-right: 1px solid #C1C1C1;font-size: 20px;">本月营业额:${money.monthMoney }元</td>
					<td rowspan="2" >
						<c:if test="${query!=null }">
							${date }的营业额为:<br>${query }元
						</c:if>
					</td>
				</tr>
				<tr>
					<td style="border-right: 1px solid #C1C1C1">今日营业额:${money.dayMoney }元</td>
					
				</tr>
			</tbody>
		</table>
		
	</form>
	</div>
	 
	
	
	<script type="text/javascript">
		$(function() {
			$("#sub").click(function() {
				if ($("#date").val() == "") {
					return false;
				}
			});
		});
	</script>
</body>
</html>




