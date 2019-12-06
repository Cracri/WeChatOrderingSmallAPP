package com.wx.service;


import java.util.List;

import com.wx.dao.UserDao;
import com.wx.dao.UserDaoImpl;
import com.wx.pojo.Address;
import com.wx.pojo.Userinfo;

public class UserService {
	UserDao ud = new UserDaoImpl();
	
	//保存用户
	public String saveUserinfo(Userinfo user) {
		return ud.saveUserinfo(user);
	}

	//查找用户id
	public int findUIdByUsername(String username) {
		return ud.findUid(username);
	}

	public Userinfo findUserText() {
		return ud.findUserText();
	}

	
	
	
	
}
