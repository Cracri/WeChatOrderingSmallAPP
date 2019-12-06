package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Userinfo;
import com.wx.service.UserService;

public class TestDemo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write =  response.getWriter();
		
		UserService us  = new UserService();
		
		Userinfo u = us.findUserText();
		
		write.println(u);
		
	}
}

