<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.product-buyer-name {max-width: 110px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
body{font-size: 20px;/**background: url("img/other/网站logo.png") no-repeat 4px 4px;*/}
</style>
</head>
<body>
	<div style="width: 800px; margin-top: 20px; margin-left: 150px;">
		<table class="table table-hover" style=" border: 1px solid #C1C1C1">
			<thead>
				<tr>
					<th>新闻标题</th>
					<th>新闻摘要</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allNews }" var="news">
					<tr>
						<td style="max-width: 110px">${news.news_title }</td>
						<td class="product-buyer-name">${news.news_text }</td>
						<td><a href="#" title="删除" onclick="del(${news.news_id})"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
	function del(news_id) {
		
		$.post(
				"delNews",
				{"news_id":news_id},
				function (data,textStatus) {
					if(data=1){
						alert("删除成功");
						window.location.href="queryNews";
					}else{
						alert("删除失败");
						window.location.href="queryNews";
					}
				},
				"text"
				);
	}
	</script>
</body>
</html>