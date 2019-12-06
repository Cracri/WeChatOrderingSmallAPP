package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.AddressService;
import com.wx.service.UserService;

public class DelThisAddressServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter print = response.getWriter();
		
		UserService us = new UserService();
		
		String username = request.getParameter("username");
		int id = Integer.parseInt(request.getParameter("id"));
		
		int uid = us.findUIdByUsername(username);
		
		AddressService as = new AddressService();
		
		String result = as.delThisAddress(uid,id);
			
		print.write(result);
		
	}
}
