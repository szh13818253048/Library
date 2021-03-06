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
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder">图书列表</strong></div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">图书ID</th>     
      <th>图书名称</th>  
      <th>状态</th>     
      <th width="250">借阅</th>
    </tr>
    <!-- 消除SearchOrign的印记 避免借书来源判断错误 -->
	<%
	session.setAttribute("SearchOrign",null);
	%>
    <c:forEach items="${list}" var="Book">
				<tr>
					<td>${Book.bId}</td>
					<td>${Book.bname}</td>
					<td>${Book.status}</td>
					<td>
						<div class="button-group">
<!-- 							<a type="button" class="button border-main" href="#">
							<span class="icon-edit"></span>修改</a> -->
							<c:if test="${Book.status == '未借阅'}">
								<a class="button border-red" href="borrowbook?bid=${Book.bId}&bname=${Book.bname}" onclick="return del(${Book.bId})">
								<span	class=""></span>借阅图书</a>
							</c:if>
							<c:if test="${Book.status == '已借阅'}">
								<a class="button border-red">
								<span	class=""></span>已被借阅，无法借阅</a>
							</c:if> 
						</div>
					</td>
				</tr>
<%--                 <td style="width: 50px;height: 50px"><a href="update?flag=1&id=${user.id}" style="color: chocolate">编辑</a></td>
                <td style="width: 50px;height: 50px"><a href="delete?id=${user.id}" style="color: red">删除</a></td> --%>
    </c:forEach>
  </table>
</div>
	<script>
		function del(id){
			if(confirm("您确定要借阅图书编号"+id+"吗?")){
				
			}
		}
	</script>
</body></html>