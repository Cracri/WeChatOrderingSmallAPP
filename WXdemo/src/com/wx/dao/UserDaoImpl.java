package com.wx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wx.pojo.Userinfo;
import com.wx.util.C3P0Utils;
import com.wx.util.DBconn;

public class UserDaoImpl implements UserDao{

	@Override
	public String saveUserinfo(Userinfo user) {
		String result = "";
		try {
			DBconn.init();
			String sql = "insert into ex_userinfo values(null,'"+user.getUserName()+"','"+user.getUserPic()+"','"+user.getProvince()+"')";
			int i = DBconn.addUpdDel(sql);
			if(i > 0) {
				result ="ok";
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public int findUid(String username) {
		int uid = 0;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select id from ex_userinfo where username = ?";
		try {
			uid  = (int) qr.query(sql, new ScalarHandler(),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uid;
	}


	@Override
	public Userinfo findUserText() {
		Userinfo u = null;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_userinfo where id = 1";
		try {
			u = qr.query(sql, new BeanHandler<Userinfo>(Userinfo.class));
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		Userinfo u = new Userinfo();
//		try {
//			DBconn.init();
//			String sql = "select * from ex_userinfo where id = 1";
//			ResultSet rs = DBconn.selectSql(sql);
//			while(rs.next()) {
//				u.setId(rs.getInt("id"));
//				u.setUserName(rs.getString("username"));
//			}
//			return u;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
	}

}
