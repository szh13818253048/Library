package com.sxt.dao;

import com.sxt.pojo.User;


public interface UserDao {
	/**
	 * 根据用户名和密码查询用户信息
	 * @author szh13
	 *
	 */
	//用户登录
	User getUserInfoDao(String uname, String pwd);
	//用户注册
	int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday);
	//修改密码
	int changePwdInfoDao(int uid, int pwd);

}
