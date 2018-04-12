<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-商品购买</title>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/bootstrap.min.css">
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">

<style type="text/css">
	th{text-align: center;}
	a{text-decoration: none;color:#666666}
	a:hover {color:black}
	.wel{font-size: 16px;}
</style>
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
					<li><img src="<%=request.getContextPath()%>/img/other/icon_3.png"><a href="<%=request.getContextPath()%>/cart?user_id=${sessionScope.user.user_id}" style="color: red">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="留言" src="<%=request.getContextPath()%>/img/other/icon_2.png"><a href="<%=request.getContextPath()%>/viewmessage">留言</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
					<li><img alt="首页" src="<%=request.getContextPath()%>/img/other/icon_1.png"><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
				</ul>
			</div>
		</div>
		<div class="hm">
			<div class="logo"><img src="<%=request.getContextPath()%>/img/other/手机简单购.jpg" width="144px" height="45px"></div>
			<div class="search">
				<form class="form" action="dim" method="get">
					<input id="gname" type="text" name="gname" placeholder="输入宝贝" style="height: 36px">
					<input id="search" type="submit" value="搜索">
				</form>
			</div>
		</div>
		<div class="hb">
			<div class="text">
				<span class="wel">欢迎光临手机简单购,在这里放心购物,放心花钱</span>
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

	<div style="width: 960px;margin: 0px auto;padding-top: 5px;padding-bottom: 5px">
		<span>你现在的位置:<a href="index.jsp">手机简单购</a>&gt;立即购买</span>
	</div>


	<div style="width: 960px;margin: 0px auto">
		
		<form action="noworder">
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>商品数量</th>
				<th>库存</th>

			</tr>
		</thead>
		<tbody>
			<tr>
					<td><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="100px" height="100px"></a><a href="goodsInfo?goods_id=${goods.goods_id}">${goods.gname}</a></td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${goods.price}</td>
					<td style="height: 100px;padding-top:45px;text-align: center;">
					<input type="hidden" name="user_id" value="${user.user_id}">
					<input type="hidden" name="goods_id" value="${goods.goods_id}">
					<input type="button" name="minus1" value="-" onclick="minus(${goods.goods_id})" height="25px">
					<input type="text" id="q${goods.goods_id}" name="quantity" value="${quantity}" style="width: 30px;text-align: center;height: 25px">
					<input type="button" name="add1" value="+" onclick="add(${goods.goods_id},${goods.count})" height="25px">
					</td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${goods.count}</td>
				</tr>
		</tbody>
	</table>
	<div style="float: right;">请输入收货地址:<input type="text" name="address"></div>
	<div style="float: right;clear: right;margin-top: 10px"><input type="image" src="img/other/an_js.png"></div>
	<input type="hidden" name="b" value="1">
</form>
		
	</div>
	
	
	
	
	<script type="text/javascript">
		function minus(id){
			var s="#q"+id;
			var c=jQuery(s).val();
			if(c<=1){
				return false;
			}else{
				jQuery(s).val(parseInt(c)-1);				
			}
		}
		function add(id,count){
			var s="#q"+id;
			var c=jQuery(s).val();
			if(c>=count){
				alert("库存不够");
				return false;
			}else{
				jQuery(s).val(parseInt(c)+1);
			}
		}
		jQuery("[type='image']").click(function() {
			var l=jQuery("[name='address']").val().length;
			if(l==0){
				alert("请输入收货地址");	
				return false;
			}
			
		});
		jQuery("[type='image']").click(function() {
			var count=${goods.count};
			var quantity=jQuery("[name='quantity']").val();
			//alert("库存:"+count);
			//alert("购买数量:"+quantity);
			//alert(quantity.length);
			if(quantity<=count&&quantity>=1&&quantity.length>0){

			}else{
				alert("请输入正确的库存数");
				return false;
			}
	});
	</script>

</body>
</html>



