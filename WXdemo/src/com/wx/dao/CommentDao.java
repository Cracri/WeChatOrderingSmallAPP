package com.wx.dao;

import java.util.List;

import com.wx.pojo.Comment;

public interface CommentDao {

	List<Comment> getComments();

	String AddComment(String value, String userPic, String userName);

	String gaveLikes(int id, int count);

	String cancleLikes(int id, int count);

}
