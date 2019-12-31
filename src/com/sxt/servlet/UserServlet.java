package com.sxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxt.pojo.User;
import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text.html;charset=utf-8");
		//��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//����������Ϣ
			System.out.println(uname+":"+pwd);
			//����ҵ������
			UserService us = new UserServiceImpl();
			User u = us.getUserInfoService(uname,pwd);
			System.out.println("�û���¼��ѯ���Ϊ��"+u);
		//��Ӧ�������
			//�ض���
			//�������ȡsession����
			HttpSession hs = req.getSession();
			if(u!=null && uname.equals("����")){//��¼�ɹ�
				resp.sendRedirect("/Pro/adminmain.jsp");
				hs.setAttribute("user",u);//����û���Session
			}else if(u!=null){
				resp.sendRedirect("/Pro/hostmain.jsp");
				hs.setAttribute("user",u);//����û���Session
				hs.setAttribute("uname", uname);
				hs.setAttribute("uid", u.getUid());
			}else{//��¼ʧ��
				
				//����¼ʧ�ܵı����ӵ�session��
				hs.setAttribute("flag","LoginFalse");
				//�ض���login.jsp
				resp.sendRedirect("/Pro/Login.jsp");
			}
			
	}
}
