package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wx.pojo.Order;
import com.wx.pojo.OrderDetail;

public interface OrderMapper {

	int getTotalCount();

	List<Order> getOrderList(@Param("page")Integer page, @Param("pageSize")Integer pageSize);

	void updateOrderIsAccpet(@Param("id")Integer id, @Param("isAcpet")int isAcpet);

	List<Order> GetNewPayOrder();

	void delTempOrder();

	List<OrderDetail> returnGetOrderDetails(Integer orderId);

}
