package com.wx.service;

import java.util.List;

import com.wx.pojo.OrderDetail;
import com.wx.vo.PageBean;

public interface OrderService {

	PageBean getOrderList(Integer page, Integer pageSize);
	//修改订单是否接收的状态
	String updateOrderIsAccpet(Integer id, int  isAcpet);
	//同时语音提示有新的订单已支付
	void GetNewPayOrder();
	//通过ID查看该订单的详情菜品
	List<OrderDetail> returnGetOrderDetails(Integer orderId);

}
