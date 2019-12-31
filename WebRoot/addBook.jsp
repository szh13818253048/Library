<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加图书</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/Pro/addBook">    
    <!-- 图书编号 -->
      <div class="form-group">
        <div class="label">
          <label for="sitename">图书编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="bid" size="50" placeholder="请输入图书编号" data-validate="required:请输入图书编号" />       
        </div>
      </div>      
     <!-- 图书名称 -->
     <div class="form-group">
        <div class="label">
          <label for="sitename">图书名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="bname" size="50" placeholder="请输入图书名称" data-validate="required:请输入图书名称" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>