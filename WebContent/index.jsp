<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/index.css">
<style type="text/css">
	li{list-style: none}
	.middle,.foot{width: 960px;margin: 0px auto;}
	.middle{overflow: hidden;}
	.goods{float: left;text-align: center;border: 1px dash black;width: 110px;height: 150px;margin-left: 15px;margin-top: 5px;margin-bottom: 10px;border: 1px dotted #cccccc;padding-bottom: 3px}
	li{list-style: none}
	.pagination li{float: left;margin-left: 5px}
	a{text-decoration: none;}
	.ldiv dd{margin-left: 40px}
	/* .nav dt{background: #fafafa;padding: 10px 20px;font-weight: bold;color: black}
	.nav dd{padding: 3px 0px} */
	.nav{background: #fafafa;}
	.category{margin-bottom: 5px;border: 1px solid #c3c3c3;}
	.history{margin-top: 5px;border: 1px solid #c3c3c3;}
	.history li img{border: 1px solid #c3c3c3;}
	.history dl{margin: 5px 0px 3px 5px}
	.glist{text-align: center;margin: 10px 0px;}
	span{font-size: 16px}
	.news{border: 1px solid #c3c3c3;margin-bottom: 10px;}
	.news li{margin-left: 5px;padding: 3px 0px}
	.hot{border: 1px solid #c3c3c3;}
	.hot li img{border: 1px solid #c3c3c3;}
	.hot dl{margin: 5px 0px 3px 5px}
	.rdiv span{border-bottom: 1px solid #c3c3c3;width: 230px;display: block;}
	.container{margin-bottom: 10px}
	.foot{clear: both;text-align: center;margin-top: 20px;margin-bottom: 10px}
	
	
	
		*{margin:0px;padding:0px}/*ul默认有padding值*/
	 img{border:0px}/*ie超链接的图片默认有边框*/
	 ul,li{list-style-type:none;}
	 /*wrapper主要作用就是水平居中，高度可以省略,因为根据内部内容自适应*/
	 #wrapper{width:520px;height:280px;margin:0px auto;}
	 /*内部的ul会相对focus左右移动,超过部分隐藏,左右图标,span都也参照此放*/
	 #focus{width:520px;height:280px;position:relative;overflow:hidden}
	 /*长度应该是多张图片的宽度，后续设置,设置position:absolute，目的是参照focus层左右移动,看是否加float:left*/
	 #focus ul{height:280px;position:absolute;}
	 /*左浮动，图片在一行上显示*/
	 #focus ul li{float:left;}
	 /**********************后续设置**********************/
	 /*放在focus的底部*/
	 #focus .icon{width:520px;height:20px;position:absolute;left:0px;top:260px;text-align:center;padding:2px 0px}
	 /*设置小方块display:inline-block;一行显示，当块级标签使用，可以设置高和宽*/
	 #focus span{display:inline-block;width:25px;height:12px;cursor:pointer;background:orange;margin-left:5px}
	 /*设置手移到span上时候的样式，用到的时候再设置*/
	 #focus span.on{background:blue;}
	 /*左右按钮共性的内容,宽度和高度，相对focus定位，手势*/
	 #focus .prenext{width:180px;height:280px;position:absolute;top:0px;cursor:pointer}
	 /*设置背景图片，不重复，靠左中*/
	 #focus .pre{left:0px;background:url("img/other/spritel.png") no-repeat left center}
	  /*设置背景图片，不重复，靠右中*/
	 #focus .next{right:0px;background:url("img/other/spriter.png") no-repeat right center}
	 .wyhsb{padding-top: -5px;padding-bottom: -5px}
	.wwww{list-style: none}
	
	
	
</style>

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
		/**$(".news").load(
				"view/news.jsp",
				function(data) {
					//alert("111");
					$(".news").html(data);
				}
			);
		$(".hot").load(
			"view/hot.jsp",
			function(data) {
				//alert("111");
				$(".hot").html(data);
			}
		);
		*/
		
		var fwidth=$("#focus").width();//获得外层容器的宽度
		var adv_count=$("#focus ul li").length;//得到广告的数量
		var index=0;//当前显示的广告
		var picTimer;//设置控制图片切换的定时器
		//每个广告都对应其一个span
		var btn="<div class='icon'>";
		for(var i=0;i<adv_count;i++){
			btn+="<span></span>";

		}
		//左右移动的按钮
		btn+="</div><div class='prenext pre'></div><div class='prenext next'></div>";
		//添加btn元素到focus
		$("#focus").append(btn);

		//本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度
		$("#focus ul").css("width",fwidth * (adv_count));
		$("#focus .icon span").css("opacity",0.6).mouseover(function(){
			index=$("#focus .icon span").index(this);//获取移动到span所在span数组的下标
			showPics(index);
		}).eq(0).trigger("mouseover");//让程序模拟操作
		
		//显示图片函数，根据接收的index值显示相应的内容
		function showPics(index){
			var nowLeft = -index*fwidth; //根据index值计算ul元素的left值
			$("#focus ul").stop(true,false).animate({"left":nowLeft},300); //通过animate()调整ul元素滚动到计算出的position,true:代表清空未执行完的动画队列，false代表是否直接将正在执行的动画跳转到末状态。
			$("#focus .icon span").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
			$("#focus .icon span").stop(true,false).animate({"opacity":"0.6"},300).eq(index).stop(true,false).animate({"opacity":"1"},300); //为当前的按钮切换到选中的效果设置为不透明
		}

		//上一页、下一页按钮透明度处理
		$("#focus .prenext").css("opacity","0").hover(function() {
			$(this).stop(true,false).animate({"opacity":"0.6"},300);
		},function() {
			$(this).stop(true,false).animate({"opacity":"0"},300);
		});
		
		//上一页按钮
		$("#focus .pre").click(function() {
			index -= 1;
			if(index == -1) {index = adv_count - 1;}
			showPics(index);
		});

		//下一页按钮
		$("#focus .next").click(function() {
			index += 1;
			if(index == adv_count) {index = 0;}
			showPics(index);
		});

		//鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
		$("#focus").hover(function() {
			clearInterval(picTimer);
		},function() {
			picTimer = setInterval(function() {
				showPics(index);
				index++;
				if(index == adv_count) {index = 0;}
			},3000); //此3000代表自动播放的间隔，单位：毫秒
		}).trigger("mouseleave");
		
		
		
	});
</script>



</head>
<body>

	<jsp:include page="view/top.jsp"></jsp:include>
	
	

	<div class="middle" style="width: 970px;margin: 0px auto;margin-top: 10px;margin-bottom: 10px">
		<div class="ldiv" style="width: 190px;float: left;">	
			<div class="category">
				
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
			
			
			<div class="history" style="margin-top: 10px">
			<div style="background: red;padding: 5px 0px"><h3 style="font-size: 16px;text-align: center;color: white;">最近浏览</h3></div>
			<div>
				
				<ul>
					<c:forEach items="${hlist}" var="goods">
						<li style="margin: 0px;padding: 0px">
							<dl class="hotdl" style="overflow: hidden;">
								<dt style="float: left;"><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="75px" height="75px"></a></dt>
								<dd style="margin-top: 20px"><a href="goodsInfo?goods_id=${goods.goods_id}">${goods.gname}</a></dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
				
				
				
			</div>
			</div>
		</div>
		<div class="mdiv" style="width: 520px;float: left;margin: 0px 10px">
			
			<div id="wrapper">
				<div id="focus">
					<ul>
						<li><a href="goodsInfo?goods_id=17"><img src="img/other/img1.png" width="520px" height="280px"/></a></li>
						<li><a href="goodsInfo?goods_id=55"><img src="img/other/img2.jpg" width="520px" height="280px"/></a></li>
						<li><a href="goodsInfo?goods_id=19"><img src="img/other/img3.jpg" width="520px" height="280px"/></a></li>
						<li><a href="goodsInfo?goods_id=48"><img src="img/other/img4.jpg" width="520px" height="280px"/></a></li>
						<li><a href="goodsInfo?goods_id=41"><img src="img/other/img5.jpg" width="520px" height="280px"/></a></li>
					</ul>
				</div>
			</div>
			
			
			<!-- <div class="banner">
				<img id="img" src="img/other/T1.jpg" width="520px">
			</div> -->
			<div class="glist"><img src="img/other/icon_sale.png"><span>商品列表</span></div>
			<div class="chanpin">
			
				<ul class="product">
					<c:forEach items="${glist}" var="goods">
					<li class="goods">
						<dl>
							<dt><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="100px" height="100px"></a></dt>
							<dd style="height: 33px;"><a href="goodsInfo?goods_id=${goods.goods_id}" style="height: 25px;">${goods.gname}</a></dd>
							<dd style="color:red"> ￥${goods.price}</dd>
						</dl>
					</li>
					</c:forEach>
				</ul>
				<div class="container" style="clear: left;">
					<ul class="pagination">
						<li><a href="index.jsp?pageNum=${page.pageNum-1}&category_id=${category_id}&child_id=${child_id}&gname=${gname}">上一页</a></li>
						<c:forEach begin="1" end="${page.allPage}" var="pg">
							<li class="l${pg}"><a href="index.jsp?pageNum=${pg}&category_id=${category_id}&child_id=${child_id}&gname=${gname}">${pg}</a></li>
						</c:forEach>
						<li><a href="index.jsp?pageNum=${page.pageNum+1}&category_id=${category_id}&child_id=${child_id}&gname=${gname}">下一页</a></li>
						<li>
							<form action="index.jsp" style="float: left">
								<input type="hidden" name="category_id" value="${category_id}">
								<input type="hidden" name="child_id" value="${child_id}">
								<input type="hidden" name="gname" value="${gname}">
								<label>跳至</label><input type="text" name="pageNum" style="width: 20px"><label>页</label>
								<input type="submit" value="GO" class="btn btn-primary">
							</form>
						</li>
					</ul>
				</div>
				
			
			</div>
			
			
		</div>
		<div class="rdiv" style="width: 230px;float: left;">
			<div style="width: 230px">
				<div class="news">
					<span><img src="img/other/icon_news.png">新闻动态</span>
						<ul class="nu">
							<c:forEach items="${nlist}" var="news">
								<li><img src="img/other/icon_sj.png">&nbsp;&nbsp;<a href="newsinfo?news_id=${news.news_id}">${news.news_title}</a></li>
							</c:forEach>
						</ul>
				</div>
				<div class="hot">
					<span><img src="img/other/icon_Recommend.png">热卖推荐</span>
						<ul>
							<c:forEach items="${hotlist}" var="goods">
								<li style="margin: 0px;padding: 0px">
									<dl class="hotdl" style="overflow: hidden;">
										<dt style="float: left;"><a href="goodsInfo?goods_id=${goods.goods_id}"><img src="${goods.url}" width="75px" height="75px"></a></dt>
										<dd style="margin-top: 20px"><a href="goodsInfo?goods_id=${goods.goods_id}">${goods.gname}</a></dd>
										<dd style="color:red"> ￥${goods.price}</dd>
									</dl>
								</li>
							</c:forEach>
						</ul>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="foot">
	<hr style="margin-top: 10px;margin-bottom: 10px">
		Copyright © 2017手机简单购 All Rights Reserved.
	</div>
	
	
	
	
	
</body>
</html>