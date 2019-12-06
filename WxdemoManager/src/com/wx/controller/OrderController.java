package com.wx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wx.pojo.OrderDetail;
import com.wx.service.OrderService;
import com.wx.vo.PageBean;

@RequestMapping("/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/returnOrder")
	public String returnOrder() {
		return "order/orderList.jsp";
	}
	
	
	@RequestMapping("/getOrderList")
	@ResponseBody
	public PageBean getOrderList(Integer page,Integer pageSize) {
		pageSize = 10;
		PageBean pb = orderService.getOrderList(page,pageSize);
		
		//同时语音提示有新的订单已支付
		orderService.GetNewPayOrder();
		
		return pb;
	}
	
	
	@RequestMapping("/updateOrderIsAccpet")
	@ResponseBody
	public String updateOrderIsAccpet(Integer id , boolean flag) {
		String result = "";
		int isAcpet[] = {flag?1:0};
		result = orderService.updateOrderIsAccpet(id,isAcpet[0]);
		
		return result;
	}
	
	
	//返回一个查看订单详情的页面，并且传输数据
	@RequestMapping("/returnGetOrderDetails")
	public ModelAndView returnGetOrderDetails(Integer OrderId) {
		ModelAndView modelAndView = new ModelAndView(); 
		//通过接收的值，查询订单的详情
//		System.out.println("OrderId:"+OrderId);
		List<OrderDetail> orderDetail = orderService.returnGetOrderDetails(OrderId);
		
		System.out.println(orderDetail);
		modelAndView.addObject("orderDetail",orderDetail);
		modelAndView.setViewName("order/getOrderDetails.jsp");
		return modelAndView;
	}
	

}
