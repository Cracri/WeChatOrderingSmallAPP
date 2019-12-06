package com.wx.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBconn {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet res = null;
	
	static String url = "jdbc:mysql://172.27.0.14:3306/greens";
	static String username = "root";
	static String password = "xh19990928";
	
	//数据库的链接
	static public void init() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库链接失败");
			e.printStackTrace();
		}	
	}
	
	
	//数据库的关闭
	static public void closeconn() {
		try {
			conn.close();
			ps.close();
			res.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭异常");
			e.printStackTrace();
		}	
	}
	
	//数据库的查询方法
	static public ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("数据查询异常");
			e.printStackTrace();
		}
		return res;
	}
	
	//数据库的DML(增删改)方法
	static public int addUpdDel(String sql) {
		int i=0;
		try {
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("数据DML出现异常");
			e.printStackTrace();
		}
		return i;
		
	}
	
	
	//在添加一条数据后，返回该数据的id
	static public int addUpdDelForId(String sql) {
		int i=0;
		try {
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				i = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
}
