package com.sxt.service.impl;

import java.util.List;

import com.sxt.service.BookService;
import com.sxt.service.BorrowService;
import com.sxt.service.UserService;
import com.sxt.dao.BookDao;
import com.sxt.dao.BorrowDao;
import com.sxt.dao.UserDao;
import com.sxt.dao.Impl.BookDaoImpl;
import com.sxt.dao.Impl.BorrowDaoImpl;
import com.sxt.dao.Impl.UserDaoImpl;
import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;

public class BorrowServiceImpl implements BorrowService {
	//从数据库中获取数据 创建Dao层对象
	BorrowDao bd = new BorrowDaoImpl();

	@Override
	public List<Borrow> getBorrowListInfoService(String uname) {
		// TODO Auto-generated method stub
		return bd.deleteBookInfoDao(uname);
	}

	//归还图书
	@Override
	public int returnBook(int id) {
		// TODO Auto-generated method stub
		return bd.returnBookInfoDao(id);
	}

	@Override
	public int BorrowBook(int uid, String uname, int bid, String bname) {
		// TODO Auto-generated method stub
		return bd.borrowBookInfoDao(uid,uname,bid,bname);
	}


}
