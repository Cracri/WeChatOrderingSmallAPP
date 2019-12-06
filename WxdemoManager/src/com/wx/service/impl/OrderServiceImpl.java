package com.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wx.mapper.OrderMapper;
import com.wx.pojo.Order;
import com.wx.pojo.OrderDetail;
import com.wx.service.OrderService;
import com.wx.util.SpeachUtil;
import com.wx.vo.PageBean;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public PageBean getOrderList(Integer page, Integer pageSize) {
		//查询总数
		int totalCount = orderMapper.getTotalCount();
		//更新查询的数据
		page = (page - 1) * pageSize;
		//查询要显示的数据
		List<Order> orderList = orderMapper.getOrderList(page,pageSize);
		System.out.println(orderList);
		//封装数据
		PageBean pb = new PageBean();
		pb.setMsg("ok");
		pb.setCode(0);
		pb.setCount(totalCount);
		pb.setData(orderList);
		return pb;
	}

	
	@Override
	public String updateOrderIsAccpet(Integer id, int  isAcpet) {
		String result = "";
		try {
			orderMapper.updateOrderIsAccpet(id,isAcpet);
			
			result = "ok";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	
	
	//同时语音提示有新的订单已支付
	public void GetNewPayOrder() {
		//得到新增的订单
		List<Order> list =  orderMapper.GetNewPayOrder();
		//如果list不为空，语音提示新增的订单
		if(!StringUtils.isEmpty(list)) {
			for(int i=0;i<list.size();i++) {
				int orderDeskNumber = list.get(i).getOrderDeskNumber();		//桌号
				double orderTotalPrice = list.get(i).getTotalPrice();				//总价
				String remark = list.get(i).getRemark();
				SpeachUtil.speakMessage(orderDeskNumber+"号桌支付"+orderTotalPrice+"块钱，备注:"+remark, 80, 2);
			}
			
			//阅读完完之后，删除临时订单中的订单，为下次刷新的时候，阅读新的订单
			orderMapper.delTempOrder();
		}
	}


	@Override
	public List<OrderDetail> returnGetOrderDetails(Integer orderId) {
		
		List<OrderDetail> list = orderMapper.returnGetOrderDetails(orderId);
		
		return list;
	}

}
