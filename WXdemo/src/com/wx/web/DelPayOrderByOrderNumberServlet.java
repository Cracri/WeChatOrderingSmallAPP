package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.OrderService;

public class DelPayOrderByOrderNumberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		OrderService os = new OrderService();
		
		String orderNumber = request.getParameter("orderNumber");
		
		//É¾³ý¶©µ¥
		String result = os.delOrderByOrderNumber(orderNumber);
		
		write.write(result);
	}
}
