package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Userinfo;
import com.wx.service.UserService;

public class SaveUserinfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter print = response.getWriter();
		
		String username = request.getParameter("username");
		String userprovince = request.getParameter("userprovince");
		String userpic = request.getParameter("userpic");
		
		Userinfo user = new Userinfo();
		user.setProvince(userprovince);
		user.setUserName(username);
		user.setUserPic(userpic);
		
		UserService us = new UserService();
		String result = us.saveUserinfo(user);
		
		print.write(result);

	}
}
