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
	//从数据库中获取数据 创建Dao层对象
	BookDao bd = new BookDaoImpl();

	@Override
	public List<Book> getBookInfoService() {
		// TODO Auto-generated method stub
		return bd.getBookInfoDao();
	}
	
	//删除图书信息
	@Override
	public int DeleteBook(int id) {
		// TODO Auto-generated method stub
		return bd.deleteBookInfoDao(id);
	}

	//添加图书信息
	@Override
	public int addBookInfoService(String bid, String bname) {
		// TODO Auto-generated method stub
		return bd.addBookInfoDao(bid,bname);
	}

	//关键字搜索
	@Override
	public List<Book> SearchLikeInfoService(String key) {
		// TODO Auto-generated method stub
		return bd.searchlikeInfoDao(key);
	}

}
