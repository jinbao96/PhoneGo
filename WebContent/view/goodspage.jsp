<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.goods{float: left;text-align: center;border: 1px dash black;width: 110px;height: 150px;margin-left: 15px}
	li{list-style: none}
</style>
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">
<script type="text/javascript">
	jQuery(function() {
		//页码在第一页的时候禁用上一页
		//window.location.href="goodsPage";
		if(${page.pageNum}<=1){
			jQuery("li:contains('上一页')").click(function() {
				return false;
			}).addClass("disabled");
		}
		//页码处于最后一页时禁用下一页
		if(${page.pageNum}>=${page.allPage}){
			jQuery("li:contains('下一页')").click(function() {
				return false;
			}).addClass("disabled");
		}
		//给所在页码 添加样式
		jQuery(".l${page.pageNum}").addClass("active");
		//不在页码范围内的页码   阻止默认行为
		jQuery("input[value='GO']").click(function() {
			var p=jQuery("input[name='pageNum']").val();
			if(p<1||p>${page.allPage}){
				return false;
			}
		});	
		
	});
</script>
</head>
<body>
	
</body>
</html>