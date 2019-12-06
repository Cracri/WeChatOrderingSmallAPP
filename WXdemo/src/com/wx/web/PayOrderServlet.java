package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.OrderService;

public class PayOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		PrintWriter print = response.getWriter();
		
		String orderNumber = request.getParameter("orderNumber");
		String remark = request.getParameter("remark");
		String address= request.getParameter("address");
		
		
		if(remark.equals("") || remark.equals("undefined")) {
			remark = "нч";
		}
		
		OrderService orderService = new OrderService();
		
		String resulut = orderService.PayOrderServlet(orderNumber,remark,address);
		
		if(resulut.equals("ok")) {
			print.println("ok");
		}else {
			print.println("error");
		}
		
	}
}

