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
    <title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
<!--     不是最外层 则跳转到最外层
    <script type="text/javascript">
	    if (window != top) 
	    	top.location.href = location.href; 
    </script> -->
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="user" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>上海海洋大学图书馆</h1></div>
               	<!--声明java代码块-->
               		<%
						//获取Session中的标记
						Object obj = session.getAttribute("flag");
               			if(obj!=null){
               				if("LoginFalse".equals((Object)obj)){
					%>
					<div style="text-align:center; color:red;">用户名或密码错误</div>
					<%							
               				}else if("RegSuccess".equals((Object)obj)){
               		%>
               		<div style="text-align:center; color:red;">用户注册成功</div>		
               		<%			
               				}else if("ChangePwdSuccess".equals((Object)obj)){
               		%>
               		<div style="text-align:center; color:red;">用户密码修改成功</div>		
               		<%			
               				}
               			}
               				session.invalidate();           			
					%>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="uname" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="pwd" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">  
                                                   
                        </div>
                    </div>
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
                <div style="font-size: 15px; position: relative;left: 300px; top: -20px"><a href="reg.jsp">注册</a></div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>