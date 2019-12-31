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
	//在所有图书中显示所有图书信息
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text.html;charset=utf-8");
		//获取请求信息
		//处理请求信息
			//创建业务层对象
			BookService us = new BookServiceImpl();
			List<Book> books = us.getBookInfoService();
			for (Book book : books) {
				System.out.println(book);
			}
		//响应处理对象
			//重定向
			//创建或获取session对象
			HttpSession hs = req.getSession();
			if(books!=null){//将获取的数据放置到Session中				
				//将图书内容添加到req中
				req.setAttribute("list", books);
				//请求转发到show.jsp		        
		        req.getRequestDispatcher("/hostshow.jsp").forward(req, resp);
			}
	}

//        req.setCharacterEncoding("utf-8");
//        Studen person = new StudentImpl();
//        List<Student> list = person.getAll();



}
