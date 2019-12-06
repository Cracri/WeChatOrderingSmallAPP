package com.wx.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//连接池
public class C3P0Utils {
		
		//在ComboPooledDataSource()  无参的情况下  默认读取c3p0-config.xml配置中的 默认选项。
		public static ComboPooledDataSource dataSourse = new ComboPooledDataSource();
		
		public static DataSource getDataSourse() {
			return dataSourse;
		} 
		
		public static Connection getConnection() {
			try {
				return dataSourse.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
}
