package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Address;
import com.wx.service.AddressService;
import com.wx.service.UserService;

public class AddAddressServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		PrintWriter print = response.getWriter();
		
		
		AddressService as = new AddressService();
		UserService us = new UserService();
		
		String consignee = request.getParameter("consignee");
		String telNumber = request.getParameter("telNumber");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String detailInfo = request.getParameter("detailInfo");
		String username = request.getParameter("username");
		
		//通过username查找 uid
		int uid = us.findUIdByUsername(username);
		
		Address address=  new Address();
		//封装数据
		address.setConsignee(consignee);
		address.setTelNumber(telNumber);
		address.setProvinceName(province);
		address.setCityName(city);
		address.setDistrictName(district);
		address.setDetailInfo(detailInfo);
		address.setUid(uid);
		
		String result = as.addAddress(address);
		
		if(result.equals("ok")) {
			print.write("ok");
		}else {
			print.write("error");
		}
		
		
	}
}

