package com.wx.dao;

import com.wx.pojo.Userinfo;

public interface UserDao {
	
	//±£¥Ê”√ªß
	public String saveUserinfo(Userinfo user);

	public int findUid(String username);

	public Userinfo findUserText();

}
