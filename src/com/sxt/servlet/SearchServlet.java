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
	    	//设置请求格式
	        req.setCharacterEncoding("utf-8");
	        //设置响应格式
	        resp.setContentType("text.html;charset=utf-8");
	        //获取请求信息
	        String key = req.getParameter("keywords");
			//处理请求信息
	        BookService bs = new BookServiceImpl();
	        List<Book> books = bs.SearchLikeInfoService(key);
	        req.setAttribute("list", books);
	        for (Book book : books) {
				System.out.println(book);
			}
	        //获取Session
	        HttpSession hs = req.getSession();
	        //给Session放置标记
	        if(books != null && !books.equals("")){
	        	hs.setAttribute("Search", "Success");
	        }
	        //响应处理请求
	        req.getRequestDispatcher("/search.jsp").forward(req, resp);

	    }

}
