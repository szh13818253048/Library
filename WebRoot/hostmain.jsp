<%@ page language="java" import="java.util.*,com.sxt.pojo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>上海海洋大学图书馆</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
    <!--声明js代码域-->
    <script type="text/javascript">
    	$(function(){
    		//给退出登录添加单击事件
    		$("#out").click(function(){
    			return window.confirm("你真的要退出码?");
    		})
    		//
    	})
    </script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />上海海洋大学图书馆</h1>
  </div>
  <div class="head-l" style="position: relative;left: 930px;"><span style="font-size:15px;color:white; position: relative;top: 3px;" >当前用户:<%=((User)session.getAttribute("user")).getUname()%></span>&nbsp;&nbsp;<a id = "out"class="button button-little bg-red" href="out"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="search.jsp" target="right"><span class="icon-caret-right"></span>搜索图书</a></li>
    <li><a href="hostborrowshow" target="right"><span class="icon-caret-right"></span>借书记录</a></li>
    <li><a href="hostshow" target="right"><span class="icon-caret-right"></span>所有图书</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>账号管理</h2>
  <ul>
    <li><a href="hostpass.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li> 
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a target="right" class="icon-home"> 首页</a></li>
  <li><a id="a_leader_txt">所有图书</a></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="hostshow" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>