package com.wx.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.OrderService;
import com.wx.vo.OrderVo;

public class SubProductCountServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* 星号表示所有的异域请求都可以接受， */  
		response.setHeader("Access-Control-Allow-Methods", "POST,GET");  
		request.setCharacterEncoding("UTF-8");
		
		String orderNumber = request.getParameter("orderNumber");
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		
		OrderVo orderVo = new OrderVo();
		orderVo.setOrderNumber(orderNumber);
		orderVo.setProductId(Integer.parseInt(productId));
		orderVo.setProductPrice(Double.parseDouble(productPrice));
		
		
		OrderService orderService = new OrderService();
		orderService.subProductCount(orderVo);

	}
}
