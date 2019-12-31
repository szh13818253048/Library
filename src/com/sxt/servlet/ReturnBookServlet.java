package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.service.BookService;
import com.sxt.service.BorrowService;
import com.sxt.service.impl.BookServiceImpl;
import com.sxt.service.impl.BorrowServiceImpl;

public class ReturnBookServlet extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {
			//������������ʽ
			req.setCharacterEncoding("utf-8");
			//������Ӧ�����ʽ
			resp.setContentType("text.html;charset=utf-8");
			//��ȡ������Ϣ
			//����������Ϣ
				//����ҵ������	        
		        String returnResult = "";
		        int id = Integer.valueOf(req.getParameter("id"));
		        BorrowService bs = new BorrowServiceImpl();
		        int result = bs.returnBook(id);
		        if (result > 0) {
		            returnResult = "�黹�ɹ�";
		        } else {
		            returnResult = "�黹ʧ��";
//		            req.setAttribute("message", returnResult);
		        }
	            System.out.println(returnResult);
		        resp.sendRedirect("/Pro/hostborrowshow");
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doGet(req, resp);
	    }
}