package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.User;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text.html;charset=utf-8");
		//获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//处理请求信息
			System.out.println(uname+":"+pwd);
			//创建业务层对象
			UserService us = new UserServiceImpl();
			User u = us.getUserInfoService(uname,pwd);
			System.out.println("用户登录查询结果为："+u);
		//响应处理对象
			//重定向
			//创建或获取session对象
			HttpSession hs = req.getSession();
			if(u!=null && uname.equals("李四")){//登录成功
				resp.sendRedirect("/Pro/adminmain.jsp");
				hs.setAttribute("user",u);//添加用户到Session
			}else if(u!=null){
				resp.sendRedirect("/Pro/hostmain.jsp");
				hs.setAttribute("user",u);//添加用户到Session
				hs.setAttribute("uname", uname);
				hs.setAttribute("uid", u.getUid());
			}else{//登录失败
				
				//将登录失败的标记添加到session中
				hs.setAttribute("flag","LoginFalse");
				//重定向到login.jsp
				resp.sendRedirect("/Pro/Login.jsp");
			}
			
	}
}
