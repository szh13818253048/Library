package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.service.BookService;
import com.sxt.service.impl.BookServiceImpl;

public class DeleteBookServlet extends HttpServlet {
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
		        BookService bs = new BookServiceImpl();
		        int result = bs.DeleteBook(id);
		        if (result > 0) {
		            returnResult = "ɾ���ɹ�";
		        } else {
		            returnResult = "ɾ��ʧ��";
//		            req.setAttribute("message", returnResult);
		        }
	            System.out.println(returnResult);
		        resp.sendRedirect("/Pro/adminshow.jsp");
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doGet(req, resp);
	    }
}
