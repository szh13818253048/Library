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
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;
import com.sxt.service.BookService;
import com.sxt.service.BorrowService;
import com.sxt.service.UserService;
import com.sxt.service.impl.BookServiceImpl;
import com.sxt.service.impl.BorrowServiceImpl;
import com.sxt.service.impl.UserServiceImpl;
import com.sxt.util.DBUtil;

public class HostBorrowShowServlet extends HttpServlet {
	//��ѯ�û���Ϣ
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text.html;charset=utf-8");
		//��ȡ������Ϣ
		//����������Ϣ
			//�������ȡsession����
			HttpSession hs = req.getSession();
			//��ȡ�û���
			String uname = (String) hs.getAttribute("uname");
			//����ҵ������
			BorrowService us = new BorrowServiceImpl();
			List<Borrow> BorrowList = us.getBorrowListInfoService(uname);
			for (Borrow borrow : BorrowList) {
				System.out.println(borrow);
			}
			if(BorrowList == null){
				hs.setAttribute("borrowflag", "NULL");
			}
		//��Ӧ�������
			//�ض���
			if(BorrowList!=null){//����ȡ�����ݷ��õ�Session��				
				//��ͼ��������ӵ�req��
				req.setAttribute("list", BorrowList);
				//����ת����show.jsp		        
		        req.getRequestDispatcher("/hostborrowshow.jsp").forward(req, resp);
			}
	}

//        req.setCharacterEncoding("utf-8");
//        Studen person = new StudentImpl();
//        List<Student> list = person.getAll();



}
