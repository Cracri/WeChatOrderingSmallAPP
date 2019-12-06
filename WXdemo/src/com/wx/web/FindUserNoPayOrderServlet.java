package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.wx.service.OrderService;
import com.wx.vo.UserProductVo;

import net.sf.json.JSONArray;

public class FindUserNoPayOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter print = response.getWriter();
		
		String username = request.getParameter("username");
		
		OrderService service = new OrderService();
		
		List<UserProductVo> userProductVoList =  service.findNoPayOrder(username);
		if(StringUtils.isEmpty(userProductVoList)) {
			print.println();
		}else {
			JSONArray json   = JSONArray.fromObject(userProductVoList);
			print.println(json);
		}
		
		
		
	}	
}

