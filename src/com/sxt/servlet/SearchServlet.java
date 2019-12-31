package com.sxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.Book;
import com.sxt.service.BookService;
import com.sxt.service.impl.BookServiceImpl;

public class SearchServlet extends HttpServlet {
	   @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {
	        doPost(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {
	    	//���������ʽ
	        req.setCharacterEncoding("utf-8");
	        //������Ӧ��ʽ
	        resp.setContentType("text.html;charset=utf-8");
	        //��ȡ������Ϣ
	        String key = req.getParameter("keywords");
			//����������Ϣ
	        BookService bs = new BookServiceImpl();
	        List<Book> books = bs.SearchLikeInfoService(key);
	        req.setAttribute("list", books);
	        for (Book book : books) {
				System.out.println(book);
			}
	        //��ȡSession
	        HttpSession hs = req.getSession();
	        //��Session���ñ��
	        if(books != null && !books.equals("")){
	        	hs.setAttribute("Search", "Success");
	        }
	        //��Ӧ��������
	        req.getRequestDispatcher("/search.jsp").forward(req, resp);

	    }

}
