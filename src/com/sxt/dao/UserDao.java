package com.sxt.dao;

import com.sxt.pojo.User;


public interface UserDao {
	/**
	 * �����û����������ѯ�û���Ϣ
	 * @author szh13
	 *
	 */
	//�û���¼
	User getUserInfoDao(String uname, String pwd);
	//�û�ע��
	int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday);
	//�޸�����
	int changePwdInfoDao(int uid, int pwd);

}
