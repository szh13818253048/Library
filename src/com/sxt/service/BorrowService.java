package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;

public interface BorrowService {

	//�����ݿ��ж�ȡ������Ϣ
	List<Borrow> getBorrowListInfoService(String uname);

	//�����ݿ���ɾ��������Ϣ�����޸�ͼ�����״̬
	int returnBook(int id);

	//�����ݿ�����ӽ�����Ϣ ,���޸�ͼ�����״̬
	int BorrowBook(int uid, String uname, int bid, String bname);
}
