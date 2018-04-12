<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机简单购-用户注册</title>
<script type="text/javascript" src="../resource/js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="../resource/css/header.css">
<link type="text/css" rel="stylesheet" href="../resource/css/bootstrap.min.css">
<style type="text/css">
	.regist{width: 500px;margin: auto;border: 1px solid #eaeaea;padding: 2px;margin-top: 20px}
	.regist p{font-size: 24px;line-height: 54px;background: #e6f5e8;color:#4c4d4b;padding-left: 10px;margin-bottom: 20px}
	.lc{text-align: right;width: 150px}
	td{padding: 5px;width: 200px}
	.button{margin-left: 120px}
	.button input{background:#98c286 ;line-height: 32px;width: 100px;border: 1px solid #68a54c;margin-left: 5px}
	.green{color:green}
	.red{color:red}
	.code{font-family:Arial;font-style:italic;color:blue;font-size:25px;letter-spacing:3px;font-weight:bolder;float:left;width:150px;margin-left: 180px;}
	.wel{font-size: 16px;}
	
	
	*{margin: 0px;padding: 0px;font-size: 14px;}
	.login{width: 960px;margin: 0px auto;}
	.header ul{list-style: none;}
	.ht{overflow: hidden;background: rgba(0, 0, 0, 0.07);height: 30px}
	.hm{width: 960px;margin: 0px auto;overflow: hidden;}
	.hb{background: #ff4c11;height: 30px;margin-top: 15px}
	.text{width: 960px;margin: 0px auto;}
	.login li{float: left;}
	.left{float: left;position: relative;top:5px;margin-left: 30px}
	.right{float: right;position: relative;top:5px;margin-right: 30px}
	.logo{float: left;margin-top: 30px}
	.search{}
	.form{margin-top: 30px;position: relative;left: 100px}
	#gname{ border: #f00 3px solid;width: 440px;height: 30px;float: left;padding: 0 10px;}
	#search{width: 140px;height: 36px;background: #ff0000;border: 0;color: white;font-size: 20px;font-weight: bold;}
	.wel{color: #ffffff;position: relative;top: 5px;}
	a{text-decoration: none;color:#666666}
	a:hover {color:black}
</style>
<script type="text/javascript">
	$(function() {
		var regEmail = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
		var regIdnumber = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
		var regPhone = /^1\d{10}$/;
		var regPwd = /^[a-zA-Z0-9]{4,10}$/;
		var regUser=/^[a-zA-Z0-9]{4,10}$/;
		var flag=new Array();
		//检测用户名是否重复,是否不为空
		$("[name='username']").blur(function() {
			username=$(this).val();
			if(regUser.test(username)){
				$.get(
						"../checkuser",
						{"username":username},
						function(data,textStatus) {
							$(".username").html(data);
							if(data=="√√"){
								$(".username").removeClass("red").addClass("green");
								flag[0]=true;
							}else{
								$(".username").addClass("red");
								flag[0]=false;
							}
						},
						"html"
					);
			}else{
				$(".username").html("××用户名不合法").addClass("red");
				flag[0]=false;
			}
		});
		//检测密码
		$("[name='pwd']").blur(function() {
			var pwd=$(this).val();
			if(regPwd.test(pwd)){
				$(".pwd").html("√√").removeClass("red").addClass("green");
				flag[1]=true;
			}else{
				$(".pwd").html("××请输入大于4位的数字字母").addClass("red");
				flag[1]=false;
			}
		});
		//检测第二次密码是否与第一次一致
		$("[name='repwd']").blur(function() {
			var pwd=$("[name='pwd']").val();
			var repwd=$(this).val();
			if(pwd==repwd){
				$(".repwd").html("√√").removeClass("red").addClass("green");
				flag[2]=true;
			}else{
				$(".repwd").html("××密码不一致,请重新输入").addClass("red");
				flag[2]=false;
			}
		});
		//检测身份证号
		$("[name='id_card']").blur(function() {
			var idnum=$(this).val();
			if(regIdnumber.test(idnum)){
				$.get(
						"../checkid",
						{"idnum":idnum},
						function(data,textStatus) {
							if(data=="√√"){
								$(".id").html(data);
								$(".id").removeClass("red").addClass("green");
								flag[3]=true;
							}else{
								$(".id").html(data);
								$(".id").addClass("red");
								flag[3]=false;
							}
						},
						"html"
					);
			}else{
				$(".id").html("××请输入有效的18位身份证号").addClass("red");
				flag[3]=false;
			}
		});
		//检测邮箱
		$("[name='email']").blur(function() {
			var email=$(this).val();
			if(regEmail.test(email)){
				$(".email").html("√√").removeClass("red").addClass("green");
				flag[4]=true;
			}else{
				$(".email").html("××请输入正确邮箱账号").addClass("red");
				flag[4]=false;
			}
		});
		//检查电话
		$("[name='tel']").blur(function() {
			var tel=$(this).val();
			if(regPhone.test(tel)){
				$.get(
					"../checktel",
					{"tel":tel},
					function(data,textStatus) {
						if(data=="√√"){
							$(".tel").html(data);
							$(".tel").removeClass("red").addClass("green");
							flag[5]=true;
						}else{
							$(".tel").html(data);
							$(".tel").addClass("red");
							flag[5]=false;
						}
					},
					"html"
				);
			}else{
				$(".tel").html("××请输入正确手机号").addClass("red");
				flag[5]=false;
			}
		});
		//地址
		$("[name='address']").blur(function() {
			if($(this).val().length>0){
				$(".address").html("√√").removeClass("red").addClass("green");
				flag[6]=true;
			}else{
				$(".address").html("××请输入正确地址").addClass("red");
				flag[6]=false;
			}
		});
		
		 
		//验证码
		//alert("111");
		var code;
		function createCode() {
			 code = "";
			 var codeLength = 6; //验证码的长度
			 var checkCode = $("#checkCode");
			 var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
			 for(var i = 0; i < codeLength; i++) {
			  var charNum = Math.floor(Math.random() * 62);
			  code += codeChars[charNum];
			 }
			  checkCode.text(code);
			 }
		createCode();
		$("#checkCode").click(function() {
			createCode();
		});
		
		//验证码检测
		$("#inputCode").blur(function() {
			var inputCode=$(this).val();
			if(inputCode.length==0){
				$(".inputCode").html("××请输入验证码").addClass("red");
				flag[7]=false;
			}else if(inputCode.toUpperCase() != code.toUpperCase()){
				$(".inputCode").html("××验证码错误").addClass("red");
				createCode();
				flag[7]=false;
			}else{
				$(".inputCode").html("√√").removeClass("red").addClass("green");
				flag[7]=true;
			}
		});
		
		
		//有不正确的表单就阻止默认事件
		$("[type='submit']").click(function() {
			if(flag[0]==true&&flag[1]==true&&flag[2]==true&&flag[3]==true&&flag[4]==true&&flag[5]==true&&flag[6]==true&&flag[7]==true){
				$("[type='submit']").submit();
			}else{
				return false;
			}
		});
	});
</script>
</head>
<body>

	<%-- <jsp:include page="top.jsp"></jsp:include>	 --%>
	
	
	
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
	
	

	<%  String status=request.getParameter("status");
		boolean flag=status!=null&&status.equals("error");
	%>
	<c:if test="<%=flag %>">
		<h3>注册失败</h3>
	</c:if>
	<div class="regist">
		<p>欢迎注册手机简单购</p>
		
		<form action="../regist" method="post">
		<table>
			<tr>
				<td class="lc">用户名:</td>
				<td><input type="text" name="username" class="form-control"></td>
				<td><span class="username"></span></td>
			</tr>
			<tr>
				<td class="lc">密码:</td>
				<td><input type="password" name="pwd" class="form-control"></td>
				<td><span class="pwd"></span></td>
			</tr>
			<tr>
				<td class="lc">确认密码:</td>
				<td><input type="password" name="repwd" class="form-control"></td>
				<td><span class="repwd"></span></td>
			</tr>
			<tr>
				<td class="lc">性别:</td>
				<td style="padding-left: 20px">
					男<input type="radio" name="sex" value="1">
					女<input type="radio" name="sex" value="0">
				</td>
			</tr>
			<tr>
				<td class="lc">出生日期:</td>
				<td><input type="date" name="birthday" class="form-control"></td>
			</tr>
			<tr>
				<td class="lc">身份证号:</td>
				<td><input type="text" name="id_card" class="form-control"></td>
				<td><span class="id"></span></td>
			</tr>
			<tr>
				<td class="lc">Email:</td>
				<td><input type="text" name="email" class="form-control"></td>
				<td><span class="email"></span></td>
			</tr>
			<tr>
				<td class="lc">电话:</td>
				<td><input type="text" name="tel" class="form-control"></td>
				<td><span class="tel"></span></td>
			</tr>
			<tr>
				<td class="lc">地址:</td>
				<td><input type="text" name="address" class="form-control"></td>
				<td><span class="address"></span></td>
			</tr>
			<tr>
				<td colspan="2">
					<div class="code" id="checkCode"></div>
				
				</td>
			</tr>			
			<tr>
				<td class="lc">验证码:</td>
				<td><input type="text" id="inputCode"  class="form-control"></td>
				<td><span class="inputCode"></span></td>
			</tr>
			<tr>
				<td colspan="2"><div class="button"><input type="submit" value="注册"><input type="reset" value="重置"></div></td>
			</tr>
		</table>
		</form>
		
		
	</div>
	<script type="text/javascript">
		
	
					
			
			
			
			
	
	
	</script>
	
	
	
	<div></div>
</body>
</html>