<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-留言</title>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">

<style type="text/css">
	.main{width: 960px;margin: 0px auto;margin-top: 10px}
	.ldiv dd{margin-left: 40px}
	.ldiv{border: 1px solid #c3c3c3;margin-right: 10px}
	/* .nav dt{background: #fafafa;padding: 10px 20px;font-weight: bold;color: black}
	.nav dd{padding: 3px 0px} */
	.nav{background: #fafafa;}
	.rdiv{width: 700px;float: left;}
	.rdiv dd{margin-left: 20px}
	.wwww{list-style: none}
	.text{font-size: 20px}
	#input{background:#98c286 ;line-height: 32px;width: 100px;border: 1px solid #68a54c;margin-left: 5px}
	input{width: 300px}
	.wel{font-size: 16px;position: relative;top: 0px;}
</style>

</head>
<body>
	
	<jsp:include page="top.jsp"></jsp:include>
	
	<div class="main">
	
	<div class="ldiv" style="width: 190px;float: left;">	
			<div style="background: red;padding: 5px 0px"><h3 style="font-size: 16px;text-align: center;color: white;">商品分类</h3></div>
			<div class="nav">	
						<ul class="wwww">
							<c:forEach items="${catelist}" var="category">
								<%-- <dl>
									<dt style="padding-top: -5px"><a href="index.jsp?category_id=${category.category_id}" style="font-size: 10px">${category.category_name}</a></dt>
								</dl> --%>
								<li style="padding-left: 50px;padding-top: 5px;padding-bottom: 5px"><a href="index.jsp?category_id=${category.category_id}" style="font-size: 18px">${category.category_name}</a></li>
								
							</c:forEach>
						</ul>
				</div>
		</div>
	
		<div class="rdiv">
			
			<c:forEach items="${messlist}" var="message">
				<dl>
					<dt style="margin-top: 5px;margin-bottom: 5px">留言标题:${message.message_title}</dt>
					<dd style="margin-top: 5px;margin-bottom: 5px">
					留言时间:<fmt:formatDate value="${message.message_date}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
					<dd class="text" style="margin-top: 5px;margin-bottom: 5px">留言内容:${message.message_text}</dd>
				</dl>
				<hr>
			</c:forEach>
			
		
		<form action="message">
			<input type="hidden" name="user_id" value="${user.user_id}">
			<table>
			<tr><td>留言标题:</td><td><input type="text" name="message_title"></td></tr>
			<tr><td>留言内容:</td><td><textarea rows="5" cols="60" name="message_text"></textarea></td></tr>
			<tr><td colspan="2" style="text-align: center;"><input id="input" type="submit" value="留言"></td></tr>
			
			
			</table>
		</form>
		</div>
		
		<script type="text/javascript">
			var flag=${empty sessionScope.user};
			if(flag){
				jQuery("#input").click(function() {
					var f=window.confirm("未登录,请先登录");
					if(f){
						window.location.href="view/login.jsp";
						return false;
					}else{
						return false;
					}
				});
			}else{
				
				jQuery("#input").click(function() {
					var title=jQuery("[name='message_title']").val();
					var text=jQuery("[name='message_text']").val();
					if(title.length<=0||text.length<=0){
						alert("请输入留言内容");
						return false;
					}
				});
			}
			
			
		</script>
		
		
	</div>
</body>
</html>




