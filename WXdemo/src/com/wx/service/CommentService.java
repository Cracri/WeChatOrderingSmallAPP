package com.wx.service;

import java.util.List;

import com.wx.dao.CommentDao;
import com.wx.dao.CommentDaoImpl;
import com.wx.pojo.Comment;

public class CommentService {
	
	CommentDao cd = new CommentDaoImpl();

	//获取评论信息
	public List<Comment> getComments() {
		return cd.getComments();
	}

	public String AddComment(String value, String userPic, String userName) {
		String result = "";
		result = cd.AddComment(value,userPic,userName);
		return result;
	}

	public String gaveLikes(int id, int count) {
		//将点赞次数+1
		count ++;
		String result = cd.gaveLikes(id,count);
		return result;
	}

	public String cancleLikes(int id, int count) {
		//将点赞次数-1
		count --;
		String result = cd.cancleLikes(id,count);
		return result;
	}

}
