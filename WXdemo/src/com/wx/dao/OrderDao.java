package com.wx.dao;

import java.util.List;

import com.wx.pojo.Order;
import com.wx.vo.Product;

public interface OrderDao {
	
	//查看该订单是否存在
	public Order findOrderNumber(String orderNumber);
	//添加订单
	public void addOrder(Order o);
	//修改订单的数量和金额
	public void updateOrder(int newTotalCount, double newTotalPrice, int orderId);
	//删除订单
	public void delOrder(String orderNumber);
	//更新订单数量 和 金额
	public void updateOrderCountAndTotalPrice(String orderNumber, int newOrderCount, double newOrderPrice);
	//
	public List<Product> findDelProduct(String delArray);
	//支付成功
	public String paySuccess(int orderId, String remark, String address);
	//向临时Order表添加数据
	public void insertTempOrder(Order order);
	//查询用户的已经付款的订单
	public List<Order> findUserOrder(String username);
	//查询用户的未付款的订单
	public List<Order> findNoPayOrderByUsername(String username);
	//删除订单通过编码
	public void delOrderByOrderNumber(String orderNumber);
	//查询支付订单是否完成
	public int findOrderIsFinish(String orderNumber);
	

}
