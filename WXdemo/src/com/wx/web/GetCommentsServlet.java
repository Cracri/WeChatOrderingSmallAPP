package com.wx.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.pojo.Comment;
import com.wx.service.CommentService;
import com.wx.service.UserService;

import net.sf.json.JSONArray;

public class GetCommentsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			response.setCharacterEncoding("utf-8");
			PrintWriter write = response.getWriter();
			
			CommentService cs = new CommentService();
			
			List<Comment> commentList = cs.getComments();
			
			JSONArray json = JSONArray.fromObject(commentList);
			
			write.println(json);
			
	}
}

