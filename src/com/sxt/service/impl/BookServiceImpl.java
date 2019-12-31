package com.sxt.service.impl;

import java.util.List;

import com.sxt.service.BookService;
import com.sxt.service.UserService;
import com.sxt.dao.BookDao;
import com.sxt.dao.UserDao;
import com.sxt.dao.Impl.BookDaoImpl;
import com.sxt.dao.Impl.UserDaoImpl;
import com.sxt.pojo.Book;
import com.sxt.pojo.User;

public class BookServiceImpl implements BookService {
	//�����ݿ��л�ȡ���� ����Dao�����
	BookDao bd = new BookDaoImpl();

	@Override
	public List<Book> getBookInfoService() {
		// TODO Auto-generated method stub
		return bd.getBookInfoDao();
	}
	
	//ɾ��ͼ����Ϣ
	@Override
	public int DeleteBook(int id) {
		// TODO Auto-generated method stub
		return bd.deleteBookInfoDao(id);
	}

	//���ͼ����Ϣ
	@Override
	public int addBookInfoService(String bid, String bname) {
		// TODO Auto-generated method stub
		return bd.addBookInfoDao(bid,bname);
	}

	//�ؼ�������
	@Override
	public List<Book> SearchLikeInfoService(String key) {
		// TODO Auto-generated method stub
		return bd.searchlikeInfoDao(key);
	}

}
