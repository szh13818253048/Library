package com.sxt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;
import com.sxt.service.BookService;
import com.sxt.service.UserService;
import com.sxt.service.impl.BookServiceImpl;
import com.sxt.service.impl.UserServiceImpl;
import com.sxt.util.DBUtil;

public class HostShowServlet extends HttpServlet {
	//������ͼ������ʾ����ͼ����Ϣ
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text.html;charset=utf-8");
		//��ȡ������Ϣ
		//����������Ϣ
			//����ҵ������
			BookService us = new BookServiceImpl();
			List<Book> books = us.getBookInfoService();
			for (Book book : books) {
				System.out.println(book);
			}
		//��Ӧ�������
			//�ض���
			//�������ȡsession����
			HttpSession hs = req.getSession();
			if(books!=null){//����ȡ�����ݷ��õ�Session��				
				//��ͼ��������ӵ�req��
				req.setAttribute("list", books);
				//����ת����show.jsp		        
		        req.getRequestDispatcher("/hostshow.jsp").forward(req, resp);
			}
	}

//        req.setCharacterEncoding("utf-8");
//        Studen person = new StudentImpl();
//        List<Student> list = person.getAll();



}
