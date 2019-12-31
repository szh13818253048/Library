package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;

public interface BorrowService {

	//从数据库中读取借书信息
	List<Borrow> getBorrowListInfoService(String uname);

	//从数据库中删除借阅信息，并修改图书借阅状态
	int returnBook(int id);

	//从数据库中添加借阅信息 ,并修改图书借阅状态
	int BorrowBook(int uid, String uname, int bid, String bname);
}
