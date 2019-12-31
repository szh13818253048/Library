package com.sxt.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sxt.dao.UserDao;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {
	//��ѯ�û���Ϣ
	@Override
	public User getUserInfoDao(String uname, String pwd) {
		//����JDBD����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//��������
		User u = null;
		try {
			//��������
			conn = DBUtil.getConnection();
			//����MySQL����
			String sql = "select * from t_user where uname=? and pwd=?";
			//����SQL�������
			ps = conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//ִ��SQL����
			rs = ps.executeQuery();
			//����
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			 	u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirthday(rs.getString("birthday"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{//�ر���Դ
			DBUtil.closeAll(rs, ps, conn);
		}
		
		//���ؽ��
		return u;
	}

	//����û���Ϣ
	@Override
	public int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday) {
		//����SQL���
		String sql = "insert into t_user values(default,?,?,?,?,?)";
		return DBUtil.executeDML(sql,uname,pwd,sex,age,birthday);
	}

	@Override
	public int changePwdInfoDao(int uid, int pwd) {
		// TODO Auto-generated method stub
		//����SQL���
			String sql = "update t_user set pwd="+pwd+" where uid = '"+uid+"'";
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
			System.out.println("���޸��û�"+uid+"������");					
			return result;
	}

}
