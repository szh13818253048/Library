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
			//������������ʽ
			req.setCharacterEncoding("utf-8");
			//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
			//��ȡ������Ϣ
			String bid = req.getParameter("bid");
			String bname = req.getParameter("bname");
			//����������Ϣ
				//��ȡҵ������
				BookService us = new BookServiceImpl();
				//����ע��
				int f = us.addBookInfoService(bid,bname);
			//��Ӧ������
				//�ض��򵽵�¼ҳ��
				if(f>0) {
					HttpSession hs = req.getSession();
					hs.setAttribute("flag", "AddBookSuccess");
					resp.sendRedirect("/Pro/show");
				}else{
					resp.sendRedirect("/Pro/show");
				}
	}
}
