package com.sxt.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sxt.dao.UserDao;
import com.sxt.pojo.User;
import com.sxt.util.DBUtil;

public class UserDaoImpl implements UserDao {
	//查询用户信息
	@Override
	public User getUserInfoDao(String uname, String pwd) {
		//声明JDBD变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//声明变量
		User u = null;
		try {
			//创建连接
			conn = DBUtil.getConnection();
			//创建MySQL命令
			String sql = "select * from t_user where uname=? and pwd=?";
			//创建SQL命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			//执行SQL命令
			rs = ps.executeQuery();
			//遍历
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
		}finally{//关闭资源
			DBUtil.closeAll(rs, ps, conn);
		}
		
		//返回结果
		return u;
	}

	//添加用户信息
	@Override
	public int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday) {
		//创建SQL语句
		String sql = "insert into t_user values(default,?,?,?,?,?)";
		return DBUtil.executeDML(sql,uname,pwd,sex,age,birthday);
	}

	@Override
	public int changePwdInfoDao(int uid, int pwd) {
		// TODO Auto-generated method stub
		//创建SQL语句
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
			System.out.println("已修改用户"+uid+"的密码");					
			return result;
	}

}
