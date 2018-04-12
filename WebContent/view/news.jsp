<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="../resource/css/bootstrap.min.css">
<script type="text/javascript" src="../resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="../resource/css/header.css">
<title>Insert title here</title>
<script type="text/javascript">
	/**jQuery(function() {
		//alert("1");
		jQuery.post(
			"../news",
			{},
			function(data,textStatus) {
				//alert(data);
				var nlist=data;
				var text=jQuery(".nu").html();
				jQuery.each(nlist,function(i,news) {
					//alert(news.news_id);
					var str="<li><a href='../newsinfo?news_id="+news.news_id+"'>"+news.news_title+"</a></li>";
					text+=str;
				});
				jQuery(".nu").html(text);
			},
			"json"
		);
	});*/
</script>
</head>
<body>

	<div>	
		<h3>新闻</h3>
		<ul class="nu">
			<c:forEach items="${nlist}" var="news">
				<li><a href="newsinfo?news_id=${news.news_id}">${news.news_title}</a></li>
			</c:forEach>
		</ul>
	</div>

	
</body>
</html>