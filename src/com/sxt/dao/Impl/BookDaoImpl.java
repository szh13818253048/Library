package com.sxt.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sxt.dao.BookDao;
import com.sxt.dao.UserDao;
import com.sxt.pojo.Book;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;
public class BookDaoImpl implements BookDao {
	//�����ݿ��ȡͼ����Ϣ
	@Override
	public List<Book> getBookInfoDao(){
	    String sql = "select * from t_book";
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<Book> list = new ArrayList<>();
	
	    try {
	        conn= DBUtil.getConnection();
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            Book user = new Book(rs.getInt("bid"),
	                    rs.getString("bname"),
	                    rs.getString("status"));
	            list.add(user);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return list;
	    }finally {
	        DBUtil.closeAll(rs, stmt, conn);;
	    }
	
	    return list;
	}

	//ɾ��ͼ����Ϣ
	@Override
	public int deleteBookInfoDao(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_book where bid = " + id;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		    conn= DBUtil.getConnection();
		    stmt = conn.prepareStatement(sql);
		    result = (int)stmt.executeUpdate();
		} catch (Exception e) {
		    e.printStackTrace();
		    return -1;
		}finally {
		    DBUtil.closeAll(rs, stmt, conn);
		}
		System.out.println("��ɾ��ͼ��ID="+id);
		return result;
	}

	//���ͼ����Ϣ
	@Override
	public int addBookInfoDao(String bid, String bname) {
		// TODO Auto-generated method stub
		//����SQL���
		String sql = "insert into t_book values(?,?,?)";
		return DBUtil.executeDML(sql,bid,bname,"δ����");
	
	}

	//�ؼ�������
	@Override
	public List<Book> searchlikeInfoDao(String key) {
		// TODO Auto-generated method stub
        String sql = "select * from t_book where bid like '%" + key + "%' or bname like '%" + key + "%'";
        //�������ݿ�����
        Connection conn = null;
        //����SQL������
        PreparedStatement stmt = null;
        //����SQL���ִ�ж���
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();

        try {
	        conn= DBUtil.getConnection();
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();
	        while (rs.next()) {
	            Book user = new Book(rs.getInt("bid"),
	                    rs.getString("bname"),
	                    rs.getString("status"));
	            books.add(user);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return books;
	    }finally {
	        DBUtil.closeAll(rs, stmt, conn);;
	    }
        return books;
    }

}
