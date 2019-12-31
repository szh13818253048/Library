package com.sxt.dao;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;


public interface BookDao {
	/**
	 * 根据用户名和密码查询用户信息
	 * @author szh13
	 *
	 */
	//从数据库获取图书信息
	List<Book> getBookInfoDao();
	
	//删除图书信息
	int deleteBookInfoDao(int id);

	//添加图书信息
	int addBookInfoDao(String bid, String bname);

	//关键字搜索
	List<Book> searchlikeInfoDao(String key);
	

}
