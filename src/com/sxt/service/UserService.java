package com.sxt.service;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;

public interface UserService {
	//用户登录接口
	User getUserInfoService(String uname, String pwd);
	//用户注册接口
	int regUserInfoService(String uname, String pwd, String sex,
			int age, String birthday);
	
	//用户修改密码接口
	int changePwdInfoService(int uid, int pwd);
	

}
