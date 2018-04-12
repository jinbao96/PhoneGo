<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-购物车</title>
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
						<li><a href="<%=request.getContextPath()%>/view/login.jsp" style="color:red">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
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
					<li><img src="<%=request.getContextPath()%>/img/other/icon_3.png"><a href="<%=request.getContextPath()%>/cart?user_id=${sessionScope.user.user_id}" style="color:red">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
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
		if(flag==true){
			jQuery("a:contains('购物车')").click(function() {
				var flag=window.confirm("未登录,请先登录");
				if(flag){
					window.location.href="view/login.jsp";
					return false;
				}else{
					return false;
				}			});
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
		<span>你现在的位置:<a href="index.jsp">手机简单购</a>&gt;购物车</span>
	</div>


	<div style="width: 960px;margin: 0px auto">
		
		<form action="order">
		<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th><input id="all" type="checkbox"></th>
				<th>商品名称</th>
				<th>商品单价</th>
				<th>商品数量</th>
				<th>库存</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clist}" var="cart">
				<tr>
					<td style="text-align: center;line-height: 100px;"><input type="checkbox" name="cart" value="${cart.goods_id},${cart.cart_id}"></td>
					<td><a href="goodsInfo?goods_id=${cart.goods_id}"><img src="${cart.url}" width="100px" height="100px"></a><a href="goodsInfo?goods_id=${cart.goods_id}">${cart.goods_name}</a></td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${cart.price}</td>
					<td style="height: 100px;text-align: center;padding-top: 45px">
					<input type="hidden" name="user_id" value="${cart.user_id}">
					<input type="hidden" name="cart_id" value="${cart.cart_id}">
					<input type="hidden" name="goods_id" value="${cart.goods_id}">
					<input type="button" name="minus1" value="-" onclick="minus(${cart.cart_id})">
					<input type="text" id="q${cart.cart_id}" name="quantity" value="${cart.quantity}" style="width: 30px;text-align: center;height: 25px">
					<input type="button" name="add1" value="+" onclick="add(${cart.cart_id},${cart.count})">
					</td>
					<td style="height: 100px;line-height: 100px;text-align: center;">${cart.count}</td>
					<td style="display: none">${cart.total}</td>
					<td style="height: 100px;line-height: 100px;text-align: center;"><a href="delCart?user_id=${cart.user_id}&cart_id=${cart.cart_id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="float: right;">请输入收货地址:<input type="text" name="address"></div>
	<div style="float: right;clear: right;margin-top: 10px"><input type="image" src="img/other/an_js.png"></div>
	<input type="hidden" name="b" value="2">
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
			if(${clist.size()}==0||l==0){
				if(l==0){
					alert("请输入收货地址");
					return false;
				}
				return false;
			}
			var cart=document.getElementsByName("cart");
			var flag=false;
			for(var i=0;i<cart.length;i++){
				if(cart[i].checked){
					flag=true;
					break;
				}
			}
			if(!flag){
				alert("未选择商品");
				return false;
			}
		});
		jQuery("#all").click(function() {
			var cart=jQuery("[name='cart']");
			var status=jQuery(this)[0].checked;
			 for(var i in cart){
				 cart[i].checked=status;
             }
		});
		
		
	</script>

</body>
</html>



