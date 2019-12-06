package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.dao.OrderDetailDao;
import com.wx.dao.OrderDetailDaoImpl;
import com.wx.pojo.Order;
import com.wx.pojo.OrderDetail;
import com.wx.service.OrderDetailService;

import net.sf.json.JSONArray;

public class GetOrderDetailServlet extends HttpServlet {
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
		
		PrintWriter print = response.getWriter();
		
		String orderNumber = request.getParameter("orderNumber");

		
		OrderDetailService ods = new OrderDetailService();
		
		List<OrderDetail> orderDetailList =  ods.GetOrderDetails(orderNumber);
		
		//判断是否为空
		if(orderDetailList != null) {
			JSONArray json = JSONArray.fromObject(orderDetailList);
			print.println(json);
		}else {
			print.write("null");
		}
		
		
		
		
		
		

	}
}
