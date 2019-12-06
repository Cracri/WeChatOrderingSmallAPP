package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.service.CommentService;

public class SendCommentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter write =  response.getWriter();
		
		String value = request.getParameter("value");
		String userPic = request.getParameter("userPic");
		String userName = request.getParameter("userName");	
		
		CommentService cs = new CommentService();
		String result = cs.AddComment(value,userPic,userName);
		
		if(result.equals("ok")) {
			write.write(result);
		}else {
			write.write("");
		}
		
		
		
		
	}
}

