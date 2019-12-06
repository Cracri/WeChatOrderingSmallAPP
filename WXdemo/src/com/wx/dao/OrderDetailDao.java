package com.wx.dao;

import java.util.List;

import com.wx.pojo.OrderDetail;

public interface OrderDetailDao {

	//添加详情订单
	void addOrderDetail(OrderDetail orderDetail);
	//得到详情订单 中 点餐的内容
	List<OrderDetail> GetOrderDetails(int orderId);
	//删除订单
	void delOrderDetail(int orderId, int productId);
	//得到   详情订单中该商品的   数量
	int getDetailProductCount(String orderNumber, int orderId, int productId);
	//找到 详情订单中的  几号 菜品
	OrderDetail findOrderDetail(int orderId, int productId);
	//更新订单中的  数量 和 金钱
	void updateOrderDetailCountAndTotalPrice(int orderId, int productId, int newProductCount, double newTotalPrice);
	//删除 该 菜品
	void delProductCount(int orderId, int productId);
	//查找用户的详情订单
	List<OrderDetail> findUserOrderDetail(int orderId);
	//删除详情订单
	void delOrderDetailByOrderNumber(String orderNumber);
	

}
