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
			//设置请求编码格式
			req.setCharacterEncoding("utf-8");
			//设置响应编码格式
			resp.setContentType("text.html;charset=utf-8");
			//获取请求信息
			//处理请求信息
				//创建业务层对象	        
		        String returnResult = "";
		        int id = Integer.valueOf(req.getParameter("id"));
		        BookService bs = new BookServiceImpl();
		        int result = bs.DeleteBook(id);
		        if (result > 0) {
		            returnResult = "删除成功";
		        } else {
		            returnResult = "删除失败";
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
