package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;

public interface BookService {
	//��ȡͼ������
	List<Book> getBookInfoService();
	//ɾ��ͼ����Ϣ
	int DeleteBook(int id);
	//���ͼ����Ϣ
	int addBookInfoService(String bid, String bname);
	//�ؼ�������
	List<Book> SearchLikeInfoService(String key);
}
