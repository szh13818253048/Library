package com.sxt.service;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;

public interface UserService {
	//�û���¼�ӿ�
	User getUserInfoService(String uname, String pwd);
	//�û�ע��ӿ�
	int regUserInfoService(String uname, String pwd, String sex,
			int age, String birthday);
	
	//�û��޸�����ӿ�
	int changePwdInfoService(int uid, int pwd);
	

}
