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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text.html;charset=utf-8");
		//��ȡ������Ϣ
		//����������Ϣ
			//����ҵ������	        
	        String returnResult = "";
	        HttpSession hs = req.getSession();
	        int uid = (int) hs.getAttribute("uid");
	        String uname = (String) hs.getAttribute("uname");
	        int bid = Integer.valueOf(req.getParameter("bid"));
	        String bname = (String) (req.getParameter("bname"));
	        BorrowService bs = new BorrowServiceImpl();
	        int result = bs.BorrowBook(uid,uname,bid,bname);
	        if (result > 0) {
	            returnResult = "���ĳɹ�";
	        } else {
	            returnResult = "����ʧ��";
//	            req.setAttribute("message", returnResult);
	        }
            System.out.println(returnResult);
         //��Ӧ������
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
