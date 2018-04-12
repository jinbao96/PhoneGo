<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
.form-control{width: 300px}
.font{font-size: 20px}

.t{width: 600px;margin: 0px auto;margin-top: 50px}
.table{width: 600px;margin-top: 20px}
.form-control{width: 200px;display: inline;height: 35px}
.iim{margin-left: 150px}
.table td {text-align: center;vertical-align: middle!important;}  
</style>
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
		<form action="AddNews" method="post">
			<table class="table">
				<tr>
					<td colspan="2"><span class="font" style="color: #438eb9;font-size: 30px">添加新闻</span></td>
				</tr>
				<tr>
					<td><span class="font">新闻标题:</span></td>
					<td><input class="form-control" type="text" name="news_title"></td>
				</tr>
				<tr>
					<td><span class="font">新闻内容:</span></td>
					<td>
						<textarea class="form-control" rows="10" cols="10"  name="news_text"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn btn-primary" type="submit" value="提交"></td>
				</tr>
			</table>
			
			
		</form>
	</div>
</body>
</html>


