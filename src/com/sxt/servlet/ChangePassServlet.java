package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;

public class ChangePassServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text.html;charset=utf-8");
		//获取请求信息		
		HttpSession hs = req.getSession();
		int uid = (int)hs.getAttribute("uid");
		int pwd = Integer.valueOf(req.getParameter("pwd"));
		//处理请求信息
		UserService us = new UserServiceImpl();
		int result = us.changePwdInfoService(uid,pwd);
		hs.setAttribute("flag", "ChangePwdSuccess");
		//响应请求结果
		resp.sendRedirect("/Pro/Login.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	
}
