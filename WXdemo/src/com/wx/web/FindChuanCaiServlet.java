package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.MenuChuanCai;
import com.wx.service.MenusService;

import net.sf.json.JSONArray;

public class FindChuanCaiServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript;charset=utf-8");
//		/* ������Ӧͷ����ajax������� */  
//		response.setHeader("Access-Control-Allow-Origin", "*");  
//		/* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
//		response.setHeader("Access-Control-Allow-Methods", "POST,GET");  
		response.setCharacterEncoding("utf-8");
		
		PrintWriter print = response.getWriter();
		
		MenusService menusService = new MenusService();
		
		List<MenuChuanCai> menusChuanCaiList =  menusService.findChuanCai();
		
		JSONArray json  = JSONArray.fromObject(menusChuanCaiList);

		print.println(json);

	}
}