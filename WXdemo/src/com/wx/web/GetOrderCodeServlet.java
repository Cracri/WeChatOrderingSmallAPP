package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.OrderService;
import com.wx.util.OrderCoderUtil;

public class GetOrderCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* 星号表示所有的异域请求都可以接受， */  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
		PrintWriter print = response.getWriter();
		
		//生成一个订单编号
		String code = OrderCoderUtil.getOrderCode(null);
		print.write(code);
		
		//生成之后，想订单插入一条空的订单 数据
		OrderService orderService = new OrderService();
	}
}
