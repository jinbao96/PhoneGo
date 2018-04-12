<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
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
</style>
<script type="text/javascript">
jQuery(function() {
	//页码在第一页的时候禁用上一页
	//window.location.href="goodsPage";
	if(${page.pageNum}<=1){
		jQuery("li:contains('上一页')").click(function() {
			alert("aaaa");
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
	<div
		style="width: 800px; margin-top: 20px; margin-left: 150px;">
		<table class="table table-hover" style=" border: 1px solid #C1C1C1">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品数量</th>
					<th>商品详情</th>
					<th>总销量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${glist }" var="goods">
					<tr>
						<td style="text-align: left;"><img src="${goods.url }" style="border: dashed 1px #C1C1C1;"
							width="100px" height="100px">&nbsp;&nbsp;&nbsp;&nbsp;${goods.gname }</td>
						<td style="height: 100px; line-height: 100px;">${goods.price }</td>
						<td style="height: 100px; line-height: 100px;">${goods.count }</td>
						<td style="height: 100px; line-height: 100px;">${goods.info }</td>
						<td style="height: 100px; line-height: 100px;">${goods.status }</td>
						<td style="height: 100px; line-height: 100px;"><a href="goodsInfo?f=2&goods_id=${goods.goods_id }" title="修改"><span
								class="glyphicon glyphicon-pencil"></span></a> &nbsp;
								<a href="#" title="删除" onclick="del(${goods.goods_id})"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
		<div style="width: 600px;margin: 0px auto">
		<ul class="pagination">
			<li><a href="allGoods?pageNum=${page.pageNum-1}">上一页</a></li>
			<c:forEach begin="1" end="${page.allPage}" var="pg">
				<li class="l${pg}"><a href="allGoods?pageNum=${pg}">${pg}</a></li>
			</c:forEach>
			<li><a href="allGoods?pageNum=${page.pageNum+1}">下一页</a></li>
			<li>
				<form action="allGoods" style="float: left">
					<label>跳至</label><input type="text" name="pageNum"
						style="width: 20px"><label>页</label> <input type="submit"
						value="GO" class="btn btn-primary">
				</form>
			</li>
		</ul>
		</div>
	<script type="text/javascript">
	function del(goods_id) {
		
		$.post(
				"del",
				{"goods_id":goods_id},
				function (data,textStatus) {
					if(data=1){
						alert("删除成功");
						window.location.href="allGoods";
					}else{
						alert("删除失败");
						window.location.href="allGoods";
					}
				},
				"text"
				);
	}
	</script>
</body>
</html>