<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.goods{float: left}
	li{list-style: none}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/header.css">
<script type="text/javascript">
	jQuery(function() {
		//alert("1111");
		//页码在第一页的时候禁用上一页
		if(${page.pageNum}<=1){
			jQuery("li:contains('上一页')").click(function() {
				return false;
			}).addClass("disabled");			
		}
		if(${page.pageNum}>=${page.allPage}){
			jQuery("li:contains('下一页')").click(function() {
				return false;
			}).addClass("disabled");
		}
		jQuery(".l${page.pageNum}").addClass("active");
		
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

	
	<div class="header">
		<div class="ht">
			<div class="login">
				<c:if test="${sessionScope.user==null}">
					<ul class="left">
						<li><a href="<%=request.getContextPath()%>/view/login.jsp">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li><a href="<%=request.getContextPath()%>/view/regist.jsp">注册</a></li>
					</ul>					
				</c:if>
				<c:if test="${sessionScope.user!=null}">
					<ul class="left">
						<li>${user.username}&nbsp;&nbsp;&nbsp;&nbsp;</li>
						<li><a href="exit">退出</a></li>
					</ul>
				</c:if>
				<ul class="right">
					<li><img src="<%=request.getContextPath()%>/img/other/icon_3.png"><a href="../cart?user_id=${sessionScope.user.user_id}">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="留言" src="<%=request.getContextPath()%>/img/other/icon_2.png"><a href="../viewmessage">留言</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="首页" src="<%=request.getContextPath()%>/img/other/icon_1.png"><a href="../goodsPage">首页</a></li>
				</ul>
			</div>
		</div>
		<div class="hm">
			<div class="logo"><img src="<%=request.getContextPath()%>/img/other/LOGO.png"></div>
			<div class="search">
				<form class="form" action="dim" method="get">
					<input id="gname" type="text" name="gname" placeholder="输入宝贝">
					<input id="search" type="submit" value="搜索">
				</form>
			</div>
		</div>
		<div class="hb">
			<div class="text">
				<span class="wel">欢迎光临亚马逊商城,在这里放心购物,放心花钱</span>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	<script type="text/javascript">
		var flag=${empty sessionScope.user}
		if(flag){
			jQuery("a:contains('购物车')").click(function() {
				alert("未登录,请先登录");
				return false;
			});
		}
		jQuery("#search").click(function() {
			var value=jQuery("[name='gname']").val();
			var b=value==""?true:false;
			//alert(b);
			if(b){
				return false;
			}
		});
		
	</script>
	
	
		
	<ul class="product">
		<c:forEach items="${glist}" var="goods">
		<li class="goods">
			<dl>
				<dt><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="100px" height="100px"></a></dt>
				<dd><a href="goodsInfo?goods_id=${goods.goods_id}">${goods.gname}</a></dd>
				<dd>${goods.price}</dd>
			</dl>
		</li>
		</c:forEach>
	</ul>
	<div class="container">
		<ul class="pagination">
			<li><a href="child?pageNum=${page.pageNum-1}&child_id=${child_id}">上一页</a></li>
			<c:forEach begin="1" end="${page.allPage}" var="pg">
				<li class="l${pg}"><a href="child?pageNum=${pg}&child_id=${child_id}">${pg}</a></li>
			</c:forEach>
			<li><a href="child?pageNum=${page.pageNum+1}&child_id=${child_id}">下一页</a></li>
			<li>
				<form action="parent" style="float: left">
					<label>跳至</label><input type="text" name="pageNum" style="width: 20px"><label>页</label>
					<input type="hidden" name="child_id" value="${child_id}">
					<input type="submit" value="GO" class="btn btn-primary">
				</form>
			</li>
		</ul>
	</div>
</body>
</html>