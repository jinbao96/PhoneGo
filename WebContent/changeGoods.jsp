<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
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

.t{width: 600px;margin: 0px auto;margin-top: 10px}
.table{width: 600px;margin-top: 20px}
.form-control{width: 200px;display: inline;height: 35px}
.table td {text-align: center;vertical-align: middle!important;}  
</style>
</head>
<body>
	<div class="page t">
	<form action="changeGoods" method="post" id="form1">
		<table class="table">
			<tbody>
			
				<tr><td colspan="2"><span class="font" style="color: #438eb9;font-size: 30px">修改商品信息</span></td></tr>
				<tr>
					<td><span class="font">商品名称:</span></td>
					<td><input class="form-control" type="text" name="gname" value="${goods.gname }"></td>
				</tr>
				<tr>
					<td><span class="font">商品类别:</span></td>
					<td><input class="form-control" type="text" name="category_name" value="${goods.category_name }" disabled="disabled"></td>
				</tr>
				<tr>
					<td><span class="font">商品价格:</span></td>
					<td><input class="form-control" type="text" name="price" value="${goods.price }"></td>
				</tr>
				<tr>
					<td><span class="font">商品库存:</span></td>
					<td><input class="form-control" type="text" name="count" value="${goods.count }"></td>
				</tr>
				<tr>
					<td><span class="font">商品详情:</span></td>
					<td>
						<textarea class="form-control" rows="2" cols="10"  name="info">${goods.info }</textarea>
					
					</td>
				</tr>
				<tr>
				<td colspan="2">
				<input type="hidden" name="goods_id" value="${goods.goods_id }">
				<input id="sub" class="btn btn-primary" type="button" value="提交"></td>
				
			</tr>
			</tbody>
		</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#sub").click(function() {
				$.ajax({  
	                type: "POST",
	                datetype: "text",
	                url:"changeGoods",  
	                data:$("#form1").serialize(),// 序列化表单值  
	                async: false,  
	                error: function(request) {  
	                    alert("Connection error");  
	                },  
	                success: function(data) {
	                	if(data=1){
	                		alert("修改成功");
			                window.location.href="goodsInfo?f=2&goods_id=${goods.goods_id }"; 
	                	}else{
	                		alert("修改失败");
			                window.location.href="goodsInfo?f=2&goods_id=${goods.goods_id }"; 
	                	}
	                	
	                }  
	            });  
			});
		});
	</script>
</body>
</html>