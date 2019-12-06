package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Order;
import com.wx.service.OrderService;
import com.wx.vo.UserProductVo;

import net.sf.json.JSONArray;

public class FindUserOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter write = response.getWriter();
		
		String username = request.getParameter("username");
		
		OrderService orderService = new OrderService();
		
		//查找用户的订单及详情订单
		List<UserProductVo> payOrder =  orderService.findUserOrder(username);
		
		//转换为json格式
		JSONArray json = JSONArray.fromObject(payOrder);
		
		write.println(json);
		
	}
}
