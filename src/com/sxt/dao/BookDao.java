package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;


public interface BookDao {
	/**
	 * �����û����������ѯ�û���Ϣ
	 * @author szh13
	 *
	 */
	//�����ݿ��ȡͼ����Ϣ
	List<Book> getBookInfoDao();
	
	//ɾ��ͼ����Ϣ
	int deleteBookInfoDao(int id);

	//���ͼ����Ϣ
	int addBookInfoDao(String bid, String bname);

	//�ؼ�������
	List<Book> searchlikeInfoDao(String key);
	

}
