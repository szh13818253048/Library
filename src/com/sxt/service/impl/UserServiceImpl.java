package com.sxt.service.impl;

import com.sxt.service.UserService;
import com.sxt.dao.UserDao;
import com.sxt.dao.Impl.UserDaoImpl;
import com.sxt.pojo.User;

public class UserServiceImpl implements UserService {
	//从数据库中获取数据 创建Dao层对象
	UserDao ud = new UserDaoImpl();
	@Override
	public User getUserInfoService(String uname, String pwd) {
		//处理登录业务
		return ud.getUserInfoDao(uname,pwd);
	}
	
	//用户注册
	@Override
	public int regUserInfoService(String uname, String pwd, String sex,
			int age, String birthday) {
		//处理注册
		return ud.regUserInfoDao(uname,pwd,sex,age,birthday);
	}

	//修改密码
	@Override
	public int changePwdInfoService(int uid, int pwd) {
		// TODO Auto-generated method stub
		return ud.changePwdInfoDao(uid,pwd);
	}

	

}
