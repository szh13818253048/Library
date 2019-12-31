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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		int age = Integer.parseInt(req.getParameter("age"));
		String birthday = req.getParameter("birthday");
		//����������Ϣ
			//��ȡҵ������
			UserServiceImpl us = new UserServiceImpl();
			//����ע��
			int f = us.regUserInfoService(uname,pwd,sex,age,birthday);
		//��Ӧ������
			//�ض��򵽵�¼ҳ��
			if(f>0) {
				HttpSession hs = req.getSession();
				hs.setAttribute("flag", "RegSuccess");
				resp.sendRedirect("/Pro/Login.jsp");
			}else{
				resp.sendRedirect("/Pro/Login.jsp");
			}
		
	}
}
