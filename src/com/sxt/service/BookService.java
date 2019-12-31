package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Book;
import com.sxt.pojo.User;

public interface BookService {
	//获取图书资料
	List<Book> getBookInfoService();
	//删除图书信息
	int DeleteBook(int id);
	//添加图书信息
	int addBookInfoService(String bid, String bname);
	//关键字搜索
	List<Book> SearchLikeInfoService(String key);
}
