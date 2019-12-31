package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		int age = Integer.parseInt(req.getParameter("age"));
		String birthday = req.getParameter("birthday");
		//处理请求信息
			//获取业务层对象
			UserServiceImpl us = new UserServiceImpl();
			//处理注册
			int f = us.regUserInfoService(uname,pwd,sex,age,birthday);
		//响应处理结果
			//重定向到登录页面
			if(f>0) {
				HttpSession hs = req.getSession();
				hs.setAttribute("flag", "RegSuccess");
				resp.sendRedirect("/Pro/Login.jsp");
			}else{
				resp.sendRedirect("/Pro/Login.jsp");
			}
		
	}
}
