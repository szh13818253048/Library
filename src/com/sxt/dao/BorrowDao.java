package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;


public interface BorrowDao {

	//从数据库中获取借书记录
	List<Borrow> deleteBookInfoDao(String uname);

	//归还图书
	int returnBookInfoDao(int id);

	//借阅图书
	int borrowBookInfoDao(int uid, String uname, int bid, String bname);
			

}
