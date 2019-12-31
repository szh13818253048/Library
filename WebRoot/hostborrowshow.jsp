<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
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
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder">图书列表</strong></div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">用户ID</th>     
      <th>用户名称</th>  
      <th>图书ID</th> 
      <th>图书名称</th> 
      <th>始借日期</th>     
      <th>归还日期</th> 
      <th width="250">还书</th>
    </tr>
    <c:forEach items="${list}" var="Borrow">
				<tr>
					<td>${Borrow.uid}</td>
					<td>${Borrow.uname}</td>
					<td>${Borrow.bid}</td>
					<td>${Borrow.bname}</td>
					<td>${Borrow.borrowtime}</td>
					<td>${Borrow.returntime}</td>
					<td>
						<div class="button-group">
<!-- 							<a type="button" class="button border-main" href="#">
							<span class="icon-edit"></span>修改</a> -->
							<a class="button border-red" href="return?id=${Borrow.bid}" onclick="return ret(${Borrow.bid})">
							<span	class=""></span>归还图书</a>
						</div>
					</td>
				</tr>
<%--                 <td style="width: 50px;height: 50px"><a href="update?flag=1&id=${user.id}" style="color: chocolate">编辑</a></td>
                <td style="width: 50px;height: 50px"><a href="delete?id=${user.id}" style="color: red">删除</a></td> --%>
    </c:forEach>
  </table>
  	<%
		if(session.getAttribute("borrowflag")!= null){
	%>
		<div>暂无借阅记录</div>
	<%
		}
	%>
</div>
	<script>
		function ret(id){
			if(confirm("您确定要归还图书编号"+id+"吗?")){
				
			}
		}
	</script>
</body></html>