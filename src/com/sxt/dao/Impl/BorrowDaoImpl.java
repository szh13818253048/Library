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

	//��ȡ�����¼
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

	//���� ɾ����¼ �޸Ľ���״̬
	@Override
	public int returnBookInfoDao(int id) {
		// TODO Auto-generated method stub
		String sql1 = "delete from t_borrow where bid = " + id;
		String sql2 = "update t_book set status='δ����' where bid = "+id;
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
		System.out.println("�ѹ黹ͼ�� ͼ��ID="+id);
		return result;
	}

	//���� ��Ӽ�¼ �޸�ͼ��״̬
	@Override
	public int borrowBookInfoDao(int uid, String uname, int bid, String bname) {
		// TODO Auto-generated method stub
		//��ȡ��ʱʱ��
		Date dNow = new Date();   //��ǰʱ��
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //�õ�����
		calendar.setTime(dNow);//�ѵ�ǰʱ�丳������
		calendar.add(Calendar.MONTH, +2);  //����Ϊ��������
		dBefore = calendar.getTime();   //�õ��������µ�ʱ��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //����ʱ���ʽ
		String btime = sdf.format(dNow); //��ʽ����ǰʱ��
		String rtime = sdf.format(dBefore);    //��ʽ���������µ�ʱ��
		
		//����SQL���
		String sql1 = "insert into t_borrow values(?,?,?,?,?,?)";
		String sql2 = "update t_book set status='�ѽ���' where bid = "+bid;
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
		System.out.println("�ѽ���ͼ�� ͼ��ID="+bid);
		return result;
		
	}
	
}
