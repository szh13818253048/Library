package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;


public interface BorrowDao {

	//�����ݿ��л�ȡ�����¼
	List<Borrow> deleteBookInfoDao(String uname);

	//�黹ͼ��
	int returnBookInfoDao(int id);

	//����ͼ��
	int borrowBookInfoDao(int uid, String uname, int bid, String bname);
			

}
