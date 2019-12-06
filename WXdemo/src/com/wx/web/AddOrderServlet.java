package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Order;
import com.wx.service.OrderService;
import com.wx.vo.OrderVo;

public class AddOrderServlet extends HttpServlet {
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
		String productName = request.getParameter("proName");
		String productId = request.getParameter("proId");
		String productPrice = request.getParameter("proPrc");
		String productPic = request.getParameter("proPic");
		String orderConsignee = request.getParameter("orderConsignee");
		String orderDeskNumber = request.getParameter("orderDeskNumber");
		
		
		OrderVo ov = new OrderVo();
		ov.setOrderNumber(orderNumber);
		ov.setProductName(productName);
		ov.setProductId(Integer.parseInt(productId));
		ov.setProductPrice(Double.parseDouble(productPrice));
		ov.setProductPic(productPic);
		ov.setOrderConsignee(orderConsignee);
		ov.setOrderDeskNumber(Integer.parseInt(orderDeskNumber));
		
		OrderService  os = new OrderService();
		
		String result  = os.addOrderAndOrderDetail(ov);
	}
}
