<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
.form-control{width: 300px}
.font{font-size: 20px}

.t{width: 600px;margin: 0px auto;margin-top: 10px}
.table{width: 600px;margin-top: 20px}
.form-control{width: 200px;display: inline;height: 35px}
.iim{margin-left: 150px}
</style>
<title>Insert title here</title>

</head>
<body>
	<%
		String status = request.getParameter("status");
		boolean flag = status != null && status.equals("success");
	%>
	<c:if test="<%=flag%>">
		<script type="text/javascript">
			$(function() {
				alert("添加成功");
			});
		</script>
	</c:if>
	<div class="page t">
	<form action="Upload" enctype="multipart/form-data" method="post">
		<table class="table">
			<tr>
				<td colspan="2"><span class="font" style="color: #438eb9;font-size: 30px">添加商品</span></td>
				
			</tr>
			<tr>
				<td><span class="font">商品名:</span></td>
				<td><input class="form-control" type="text" name="gname"></td>
			</tr>
			<tr>
				<td><span class="font">类别:</span></td>
				<td>
					<select class="form-control" name="catagory_id">
						<c:forEach items="${clist }" var="category">
							<option value="${category.category_id }">${category.category_name }
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><span class="font">详情:</span></td>
				<td><input class="form-control" type="text" name="info"></td>
			</tr>
			<tr>
				<td><span class="font">价格:</span></td>
				<td><input class="form-control" type="text" name="price"></td>
			</tr>
			<tr>
				<td><span class="font">库存:</span></td>
				<td><input class="form-control" type="text" name="count"> </td>
			</tr>
			<tr>
				<td><span class="font">图片:</span></td>
				<td><input type="file" name="f1" class="iim"></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-primary" type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>