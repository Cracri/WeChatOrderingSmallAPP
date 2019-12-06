package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.wx.pojo.Address;
import com.wx.service.AddressService;
import com.wx.service.UserService;

import net.sf.json.JSONArray;

public class FindDetailAddressServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter print = response.getWriter();
		
		String username = request.getParameter("username");
		
		UserService us = new UserService();
		int uid = us.findUIdByUsername(username);
		
		AddressService as = new AddressService();
		//通过uid 查询该用户 所具有的详情地址列表
		List<Address> addressList = as.findUserDetailAddress(uid);
		
		if(StringUtils.isEmpty(addressList)) {
			//如果地址集合为空的话
			print.write("null");
		}else {
			JSONArray json = JSONArray.fromObject(addressList);
			print.println(json);
		}
		
		
	}
}

