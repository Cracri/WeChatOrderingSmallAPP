package com.wx.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wx.pojo.Comment;
import com.wx.util.C3P0Utils;

public class CommentDaoImpl implements CommentDao{

	@Override
	public List<Comment> getComments() {
		List<Comment> list = null;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from comment order by commenttime desc";
		try {
			list = qr.query(sql, new BeanListHandler<Comment>(Comment.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public String AddComment(String value, String userPic, String userName) {
		String date = "current_timestamp";
		String result = "";
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "insert into comment values(?,?,?,?,?,0,0,"+date+")";
		try {
			qr.update(sql,null,userName,userPic,value,null);
			result = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public String gaveLikes(int id, int count) {
		String result = "";
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "update comment set Likes = ? where id = ?";
		try {
			qr.update(sql, count,id);
			result = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public String cancleLikes(int id, int count) {
		String result = "";
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "update comment set Likes = ? where id = ?";
		try {
			qr.update(sql, count,id);
			result = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
