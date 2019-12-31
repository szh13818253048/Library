package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.service.BookService;
import com.sxt.service.impl.BookServiceImpl;
import com.sxt.service.impl.UserServiceImpl;

public class addBookServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//设置请求编码格式
			req.setCharacterEncoding("utf-8");
			//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
			//获取请求信息
			String bid = req.getParameter("bid");
			String bname = req.getParameter("bname");
			//处理请求信息
				//获取业务层对象
				BookService us = new BookServiceImpl();
				//处理注册
				int f = us.addBookInfoService(bid,bname);
			//响应处理结果
				//重定向到登录页面
				if(f>0) {
					HttpSession hs = req.getSession();
					hs.setAttribute("flag", "AddBookSuccess");
					resp.sendRedirect("/Pro/show");
				}else{
					resp.sendRedirect("/Pro/show");
				}
	}
}
