package com.wx.web;

import java.awt.Window.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.OrderService;
import com.wx.vo.Product;

import net.sf.json.JSONArray;

public class FindDelProductServlet extends HttpServlet {
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
		
		String delArray = request.getParameter("delArray");
		
//		System.out.println("delArray:"+delArray);
		
		OrderService orderService = new OrderService();
		
		List<Product> list = orderService.findDelProduct(delArray);
//		System.out.println(list);
		
		JSONArray json = JSONArray.fromObject(list);
		
		print.println(json);
		
	}
}

