<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-商品详情</title>
<style type="text/css">
	.ldiv dd{margin-left: 40px}
	.ldiv{border: 1px solid #c3c3c3;margin-right: 10px;width: 190px}
	/* .nav dt{background: #fafafa;padding: 10px 20px;font-weight: bold;color: black}
	.nav dd{padding: 5px 0px} */
	.nav{background: #fafafa;}
	.wwww{list-style: none}
	.middle{width: 960px;margin: 0px auto;margin-top: 10px;overflow: hidden;}
	.rdiv{width: 750px;}
	.rdiv p{padding-bottom: 5px}
	.rdiv span{font-weight:bolder;font-size: 24px}
	.foot{clear: both;text-align: center;margin-top: 20px}
	.wel{font-size: 16px}
</style>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="resource/css/header.css">
<script type="text/javascript">
	jQuery(function() {
		
		var price=${goods.price};
		var goods_id=${goods.goods_id};
		//alert(l);
		//点击-按钮触发  文本框数字减一事件
		jQuery("[name='minus']").click(function() {
			var c=jQuery("[name='quantity']").val();
			if(c<=1){
				jQuery("[name='quantity']").val(1);
			}else{
				jQuery("[name='quantity']").val(parseInt(c)-1);
			}
		});
		//点击+号触发  文本框数字加一事件
		jQuery("[name='add']").click(function() {
			var c=jQuery("[name='quantity']").val();
			if(c>=${goods.count}){
				alert("超出库存");
				return false;
			}else{
				jQuery("[name='quantity']").val(parseInt(c)+1);
			}
		});
		//
		/**jQuery("[name='toCart']").click(function() {
			var c=jQuery("[name='quantity']").val();
			$.get(
					"addcart",
					{"goods_id":goods_id,"quantity":c,"price":price},
					function(data,textStatus) {
						alert(data);
					},
					"text"
				);
			return false;
			//alert(c);
			//alert(${sessionScope.user.username});
			//window.location.href="addcart?user_id="+l+"&goods_id="+${goods.goods_id}+"&quantity="+c+"&price="+${goods.price};
			
		});*/
		jQuery("[name='nowBuy']").click(function() {
			jQuery(this).submit();
			//var c=jQuery("[name='quantity']").val();
			//window.location.href="view/nowbuy.jsp?user_id="+user_id+"&goods_id="+goods_id+"&quantity="+c+"&price="+price;
		});
		
		var flag=${empty sessionScope.user}
		
		if(flag){
			jQuery("[name='nowBuy']").click(function() {
				var flag=window.confirm("未登录,请先登录");
				if(flag){
					window.location.href="view/login.jsp";
					return false;
				}else{
					return false;
				}
				
				
			});
		}
		
		//购买数量大于库存 阻止提交
		jQuery("[name='toCart']").click(function() {
				var count=${goods.count};
				var quantity=jQuery("[name='quantity']").val();
				//alert("库存:"+count);
				//alert("购买数量:"+quantity);
				//alert(quantity.length);
				if(quantity<=count&&quantity>=1&&quantity.length>0){
					//alert("该执行ajax了");
					
					//alert("xxx");
					
					if(flag){
							var b=window.confirm("未登录,请先登录");
							if(b){
								window.location.href="view/login.jsp";
								return false;
							}else{
								return false;
							}
					}else{
						jQuery.get(
								"addcart",
								{"goods_id":goods_id,"quantity":quantity,"price":price},
								function(data,textStatus) {
									alert(data);
								},
								"text"
							);
					}
					
					
					
					//alert("111");
					return false;
				}else{
					alert("请输入正确的库存数");
					return false;
				}
		});
		jQuery("[name='nowBuy']").click(function() {
				var count=${goods.count};
				var quantity=jQuery("[name='quantity']").val();
				//alert(count);
				//alert(quantity);
				if(quantity>count||quantity<1||quantity.length<=0){
					alert("请输入正确的库存数");
					return false;
				}
		});	
	});
</script>
</head>
<body>
	
	<jsp:include page="top.jsp"></jsp:include>
	<div style="width: 960px;margin: 0px auto;padding-top: 5px;padding-bottom: 5px">
		<span>你现在的位置:<a href="index.jsp">手机简单购</a>&gt;<a href="index.jsp?category_id=${goods.category_id}">${goods.category_name}</a></span>
	</div>
	<div class="middle">
		
		<div class="ldiv" style="width: 190px;float: left;">	
			<div style="background: red;padding: 5px 0px"><h3 style="font-size: 16px;text-align: center;color: white;">商品分类</h3></div>
			<div class="nav">	
						<ul class="wwww">
							<c:forEach items="${catelist}" var="category">
								<%-- <dl>
									<dt style="padding-top: -5px"><a href="index.jsp?category_id=${category.category_id}" style="font-size: 10px">${category.category_name}</a></dt>
								</dl> --%>
								<li style="padding-left: 30px;padding-top: 5px;padding-bottom: 5px"><a href="index.jsp?category_id=${category.category_id}" style="font-size: 15px"><img src="img/other/${category.url }" width="15px" height="15px">${category.category_name}</a></li>
								
							</c:forEach>
						</ul>
				</div>
		</div>
		<div class="rdiv" style="float: left;">		
				<h3 style="font-size: 16px">商品名称:${goods.gname}</h3>
				<hr>
				<div style="float: left;width: 300px;text-align: center;">
					<img src="${goods.url}" width="150px" height="150px">
				</div>
				<p style="padding-top: 10px">商城价:<span  style="color: red">￥${goods.price}</span></p>
				<p>库存:${goods.count}件</p>
				
				<form action="goodsInfo" method="post">
					<div>
						<input type="button" name="minus" value="-">
						<input type="text" name="quantity" value="1" style="width: 20px;text-align: center">
						<input type="button" name="add" value="+">
						<input type="hidden" name="goods_id" value="${goods.goods_id}">
						<input type="hidden" name="f" value="1">
					</div>
					
					<div style="margin-top: 20px;width: 440px;margin-left: 300px">
						<input type="image" name="nowBuy" src="img/other/an_gw.png">
						<input type="image" name="toCart" src="img/other/an_gwc.png">
					</div>
				</form>
				<hr>
				<div>
					<h3 style="font-size: 25px;margin-bottom: 10px;margin-top: 5px">商品详情</h3>
					<p style="font-size: 20px;">商品名称:${goods.gname}</p>
					<p style="font-size: 20px;">商品描述:${goods.info}</p>
					<p style="font-size: 20px;">商品价格:${goods.price}</p>
					<p style="font-size: 20px;">商品库存:${goods.count}</p>
				</div>	
						
			
		</div>
		
		
	</div>
	
	
	<div class="foot">Copyright © 2017手机简单购 All Rights Reserved.</div>
	
	
</body>
</html>