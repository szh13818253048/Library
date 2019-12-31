package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.service.BookService;
import com.sxt.service.BorrowService;
import com.sxt.service.impl.BookServiceImpl;
import com.sxt.service.impl.BorrowServiceImpl;

public class BorrowBookServlet extends HttpServlet {
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
	        HttpSession hs = req.getSession();
	        int uid = (int) hs.getAttribute("uid");
	        String uname = (String) hs.getAttribute("uname");
	        int bid = Integer.valueOf(req.getParameter("bid"));
	        String bname = (String) (req.getParameter("bname"));
	        BorrowService bs = new BorrowServiceImpl();
	        int result = bs.BorrowBook(uid,uname,bid,bname);
	        if (result > 0) {
	            returnResult = "借阅成功";
	        } else {
	            returnResult = "借阅失败";
//	            req.setAttribute("message", returnResult);
	        }
            System.out.println(returnResult);
         //响应处理结果
            if(hs.getAttribute("SearchOrign") != null){
            	hs.setAttribute("SearchOrign", null);
            	resp.sendRedirect("/Pro/search.jsp");
            }else{
            	resp.sendRedirect("/Pro/hostshow");
            }
	        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
