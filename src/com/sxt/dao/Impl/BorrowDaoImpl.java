package com.sxt.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sxt.dao.BookDao;
import com.sxt.dao.BorrowDao;
import com.sxt.dao.UserDao;
import com.sxt.pojo.Book;
import com.sxt.pojo.Borrow;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;

public class BorrowDaoImpl implements BorrowDao {

	//获取借书记录
	@Override
	public List<Borrow> deleteBookInfoDao(String uname) {
		// TODO Auto-generated method stub
		 String sql = "select * from t_borrow where uname=?";
		    Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    List<Borrow> BorrowList = new ArrayList<>();
		    
		    try {
		        conn= DBUtil.getConnection();
		        stmt = conn.prepareStatement(sql);
		        stmt.setString(1, uname);
		        rs = stmt.executeQuery();		       
		        while (rs.next()) {
		            Borrow borrow = new Borrow(rs.getInt("uid"),
		                    rs.getString("uname"),
		                    rs.getInt("bid"),
		                    rs.getString("bname"),
		                    rs.getString("borrowtime"),
		                    rs.getString("returntime"));
		            BorrowList.add(borrow);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        return BorrowList;
		    }finally {
		        DBUtil.closeAll(rs, stmt, conn);
		    }
		    return BorrowList;
	}

	//还书 删除记录 修改借阅状态
	@Override
	public int returnBookInfoDao(int id) {
		// TODO Auto-generated method stub
		String sql1 = "delete from t_borrow where bid = " + id;
		String sql2 = "update t_book set status='未借阅' where bid = "+id;
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		    conn= DBUtil.getConnection();
		    stmt1 = conn.prepareStatement(sql1);
		    stmt2 = conn.prepareStatement(sql2);
		    stmt2.executeUpdate();
		    result = (int)stmt1.executeUpdate();
		} catch (Exception e) {
		    e.printStackTrace();
		    return -1;
		}finally {
		    DBUtil.closeAll(rs, stmt1, conn);
		}
		System.out.println("已归还图书 图书ID="+id);
		return result;
	}

	//借书 添加记录 修改图书状态
	@Override
	public int borrowBookInfoDao(int uid, String uname, int bid, String bname) {
		// TODO Auto-generated method stub
		//获取当时时间
		Date dNow = new Date();   //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(Calendar.MONTH, +2);  //设置为后两个月
		dBefore = calendar.getTime();   //得到后两个月的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
		String btime = sdf.format(dNow); //格式化当前时间
		String rtime = sdf.format(dBefore);    //格式化后两个月的时间
		
		//创建SQL语句
		String sql1 = "insert into t_borrow values(?,?,?,?,?,?)";
		String sql2 = "update t_book set status='已借阅' where bid = "+bid;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
		    conn= DBUtil.getConnection();
		    stmt = conn.prepareStatement(sql2);
		    stmt.executeUpdate();
		    result = (int)stmt.executeUpdate();
		    DBUtil.executeDML(sql1,uid,uname,bid,bname,btime,rtime);
		} catch (Exception e) {
		    e.printStackTrace();
		    return -1;
		}finally {
		    DBUtil.closeAll(rs, stmt, conn);
		}
		System.out.println("已借阅图书 图书ID="+bid);
		return result;
		
	}
	
}
