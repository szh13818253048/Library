package com.sxt.service.impl;

import com.sxt.service.UserService;
import com.sxt.dao.UserDao;
import com.sxt.dao.Impl.UserDaoImpl;
import com.sxt.pojo.User;

public class UserServiceImpl implements UserService {
	//�����ݿ��л�ȡ���� ����Dao�����
	UserDao ud = new UserDaoImpl();
	@Override
	public User getUserInfoService(String uname, String pwd) {
		//�����¼ҵ��
		return ud.getUserInfoDao(uname,pwd);
	}
	
	//�û�ע��
	@Override
	public int regUserInfoService(String uname, String pwd, String sex,
			int age, String birthday) {
		//����ע��
		return ud.regUserInfoDao(uname,pwd,sex,age,birthday);
	}

	//�޸�����
	@Override
	public int changePwdInfoService(int uid, int pwd) {
		// TODO Auto-generated method stub
		return ud.changePwdInfoDao(uid,pwd);
	}

	

}
