package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Menu;
import com.wx.service.MenusService;

import net.sf.json.JSONArray;


public class FindIndexGreensServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/* 设置响应头允许ajax跨域访问 */  
		response.setHeader("Access-Control-Allow-Origin", "*");  
		/* 星号表示所有的异域请求都可以接受， */  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
		
		PrintWriter print = response.getWriter();
		
//		System.out.println("开始找寻所有菜单菜品");
		
		MenusService ms = new MenusService();
		
		List<Menu> menusList = ms.findIndexGreens();
		
//		System.out.println("menusList:"+menusList);
		
		//将数据转换为json 数据
		JSONArray json  = JSONArray.fromObject(menusList);
//		System.out.println("json:"+json);
		
		print.print(json);
		
				
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        	
	}
}
