package com.wx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.wx.dao.OrderDao;
import com.wx.dao.OrderDaoImpl;
import com.wx.dao.OrderDetailDao;
import com.wx.dao.OrderDetailDaoImpl;
import com.wx.pojo.Order;
import com.wx.pojo.OrderDetail;
import com.wx.vo.OrderVo;
import com.wx.vo.Product;
import com.wx.vo.UserProductVo;


public class OrderService {

	OrderDao od = new OrderDaoImpl();
	OrderDetailDao odd = new OrderDetailDaoImpl();

	//添加订单 和 详情订单
	public String addOrderAndOrderDetail(OrderVo vo) {
		//得到订单的编号
		String orderNumber = vo.getOrderNumber();
		//判断Order 中是否存在该订单 
		Order order = od.findOrderNumber(orderNumber);
		
		if(StringUtils.isEmpty(order)) {									//如果该订单不存在   就创建该订单
			Order o = new Order();
			o.setOrderNumber(orderNumber);
			o.setOrderState("未付款");
			o.setTotalCount(1);
			o.setTotalPrice(vo.getProductPrice());
			o.setOrderDeskNumber(vo.getOrderDeskNumber());				//   测试目前 始终为 1号桌
			o.setOrderConsignee(vo.getOrderConsignee());
			
			//将该订单 添加 到 数据库,并返回该条数据的（订单id）
			 od.addOrder(o);
			//通过刚才添加的数据，再次查找订单的id
			Order findorder = od.findOrderNumber(orderNumber);
			int orderId = findorder.getId();
			
			addOrderDetail(vo,orderId);
		}else {																
			//通过刚才添加的数据，再次查找订单的id
			Order findorder = od.findOrderNumber(orderNumber);
			int orderId = findorder.getId();
			//如果该订单存在,就修改订单中的 一些数据
			int newTotalCount = order.getTotalCount()+1;
			double newTotalPrice = order.getTotalPrice() + vo.getProductPrice();
			
			od.updateOrder(newTotalCount,newTotalPrice,orderId);
			
			//同时 也将该数据添加至 详情表单中
			addOrderDetail(vo,orderId);
		}
		return null;
	}
	
	//添加详情订单的方法
	private void addOrderDetail(OrderVo vo, int orderId) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderNumber(vo.getOrderNumber());
		orderDetail.setOrderId(orderId);
		orderDetail.setProductId(vo.getProductId());
		orderDetail.setProductName(vo.getProductName());
		orderDetail.setProductPrice(vo.getProductPrice());
		orderDetail.setProductCount(1);
		orderDetail.setProductDiscount(0);
		orderDetail.setTotalPrice(vo.getProductPrice());
		orderDetail.setProductPic(vo.getProductPic());
		//添加详情订单
		odd.addOrderDetail(orderDetail);
	}



	//删除订单
	public void delOrder(OrderVo vo) {
		//通过订单编号 找到订单
		Order order = od.findOrderNumber(vo.getOrderNumber());
		int orderId = order.getId();
		//得到订单 的  购买数量(productCount)
		int productCount = order.getTotalCount();
		//得到   详情订单中该商品的   数量
		int detailProductCount = odd.getDetailProductCount(vo.getOrderNumber(),orderId,vo.getProductId());
		
		//判断 该订单  购买量 是否 <= 1 是的话 就直接删除该订单  		 否则  修改数量
//		if(productCount <= 1) {
//			//删除该订单  并且删除  详情订单
//			//od.delOrder(vo.getOrderNumber());
//			//odd.delOrderDetail(orderId,vo.getProductId());
//		}else {
			int newTotalCount = order.getTotalCount() - detailProductCount;
			double newTotalPrice = order.getTotalPrice() - vo.getProductPrice();
			
			od.updateOrder(newTotalCount, newTotalPrice, orderId);
			odd.delOrderDetail(orderId,vo.getProductId());
//		}
		
	}

	
	
	
	//增加商品的数量
	public void addProductCount(OrderVo orderVo) {
		
		String orderNumber  = orderVo.getOrderNumber();
		//根据订单编号 找到 该订单
		Order order = od.findOrderNumber(orderNumber);
		int orderId = order.getId();
		//找到 详情订单中的  几号 菜品
		OrderDetail orderDetail = odd.findOrderDetail(orderId,orderVo.getProductId());
		//判断订单是否存在
		if(StringUtils.isEmpty(order)) {		//如果订单不存在
			
		}else {						//订单存在  ----->  就修改  详情订单中的点餐数量
			int newProductCount = orderDetail.getProductCount() + 1;
			double newTotalPrice = newProductCount * orderDetail.getProductPrice();
			
			//更新详情订单
			odd.updateOrderDetailCountAndTotalPrice(orderId,orderVo.getProductId(),newProductCount,newTotalPrice);
			
			int newOrderCount = order.getTotalCount() + 1;
			double newOrderPrice = order.getTotalPrice() + orderVo.getProductPrice();
			
			//更新订单数量 和 金额
			od.updateOrderCountAndTotalPrice(orderVo.getOrderNumber(),newOrderCount,newOrderPrice);
		}
	}

	
	//减少商品的数量
	public void subProductCount(OrderVo orderVo) {
		String orderNumber  = orderVo.getOrderNumber();
		//根据订单编号 找到 该订单
		Order order = od.findOrderNumber(orderNumber);
		int orderId = order.getId();
		//找到 详情订单中的  几号 菜品
		OrderDetail orderDetail = odd.findOrderDetail(orderId,orderVo.getProductId());
		//判断订单 是否存在
		if(StringUtils.isEmpty(order)) {				//如果不存在
			
		}else {			//订单存在  ----->  就修改  详情订单中的点餐数量
			int newProductCount = orderDetail.getProductCount() - 1;
			double newTotalPrice = newProductCount * orderDetail.getProductPrice();
			
			//更新详情订单
			odd.updateOrderDetailCountAndTotalPrice(orderId,orderVo.getProductId(),newProductCount,newTotalPrice);
			
			int newOrderCount = order.getTotalCount() - 1;
			double newOrderPrice = order.getTotalPrice() - orderVo.getProductPrice();
			
			//更新订单数量 和 金额
			od.updateOrderCountAndTotalPrice(orderVo.getOrderNumber(),newOrderCount,newOrderPrice);
		}
	}


	
	/**
	 * 1.根据订单编号找到该订单
	 * 2.删除详情订单中的商品，并更新订单中的数据
	 * 3.查找剩余的 商品 并且返回给前台
	 * */
	//删除商品 并 返回  剩余的 商品给前台
	public List<OrderDetail> DelProductCount(OrderVo orderVo) {
		List<OrderDetail> list = null;
		String orderNumber = orderVo.getOrderNumber();
		//根据订单编号 找到 该订单
		Order order = od.findOrderNumber(orderNumber);
		//得到订单的Id
		int orderId = order.getId();
		//找到 详情订单中的  几号 菜品
		OrderDetail orderDetail = odd.findOrderDetail(orderId,orderVo.getProductId());
		
		//判断订单是否存在
		if(StringUtils.isEmpty(order)) {
			/*如果不存在*/
			
		}else {				//如果存在，就对详情订单 操作
			/*得到  该菜品  的数量 和  总价格，  来更新  总订单的 数量*/
			//删除 该 菜品
			int productCount = orderDetail.getProductCount();
			double productTotalPrice = orderDetail.getTotalPrice();
			odd.delProductCount(orderId,orderVo.getProductId());
			
			//更总订单的数据
			int newOrderCount = order.getTotalCount() - productCount;
			double newOrderPrice = order.getTotalPrice() - productTotalPrice;
			od.updateOrderCountAndTotalPrice(orderNumber, newOrderCount, newOrderPrice);
			
			//对总订单操作后，判断是否还有数据，如果没有就删除
//			if(order.getTotalCount() <= 0) {
//				od.delOrder(orderNumber);
//			}
			
			//得到 删除某商品后，剩余商品的 集合
			list = odd.GetOrderDetails(orderId);
		}
		return list;
	}

	
	public List<Product> findDelProduct(String delArray) {
		return od.findDelProduct(delArray);
	}

	
	//支付订单
	public String PayOrderServlet(String orderNumber,String remark,String address) {
		String result = "";
		//找到该订单
		Order order = od.findOrderNumber(orderNumber);
		int orderId = order.getId();
		
		try {
			result = od.paySuccess(orderId,remark,address);
			order = od.findOrderNumber(orderNumber);
			if(result.equals("ok")) {
				//如果支付成功.向临时订单中，添加数据，为方便语音的读取
				od.insertTempOrder(order);
			}
		} catch (Exception e) {
			System.out.println("支付过程失败");
		}
		
		return result ;
	}

	public List<UserProductVo> findUserOrder(String username) {
		 List<UserProductVo> userProductVoList = new ArrayList<UserProductVo>();
		 //查找总订单
		 List<Order> orderList =  od.findUserOrder(username);
		
		 if(StringUtils.isEmpty(orderList)) {
			 //如果该用户并没有，支付订单的话，返回一个null
			 return null;
		 }else {
			 for(int i=0;i<orderList.size();i++) {
				 UserProductVo userProductVo = new UserProductVo();
				 //查找详情订单,通过订单的id
				 int orderId = orderList.get(i).getId();
				 List<OrderDetail> orderDetailList = odd.findUserOrderDetail(orderId);
				 
				 //每查找一次详情订单，就封装一次数据
				 userProductVo.setOrderNumber(orderList.get(i).getOrderNumber());
				 userProductVo.setOrderDeskNumber(orderList.get(i).getOrderDeskNumber());
				 userProductVo.setAddress(orderList.get(i).getAddress());
				 userProductVo.setOrderDetail(orderDetailList);
				 userProductVo.setTotalCount(orderList.get(i).getTotalCount());
				 userProductVo.setTotalPrice(orderList.get(i).getTotalPrice());
				 userProductVo.setRemark(orderList.get(i).getRemark());
				 userProductVo.setIsAcept(orderList.get(i).getIsAcept());
				 userProductVo.setIsFinish(orderList.get(i).getIsFinish());
				 userProductVo.setCreateTime(orderList.get(i).getCreateOrderTime());
				 userProductVoList.add(userProductVo);
			 }
			 return userProductVoList;
		 }
	}

	
	public List<UserProductVo> findNoPayOrder(String username) {
		List<UserProductVo> userProductVoList = new ArrayList<UserProductVo>();
		
		//通过名字查找到该用户的未付款订单
		List<Order> orderList = od.findNoPayOrderByUsername(username);
		
		//判断
		if(StringUtils.isEmpty(orderList)) {
			//如果没有未付款的订单，就返回一个Null
			return null;
		}else {
			for(int i=0;i<orderList.size();i++) {
				UserProductVo userProductVo = new UserProductVo();
				 //查找详情订单,通过订单的id
				 int orderId = orderList.get(i).getId();
				 List<OrderDetail> orderDetailList = odd.findUserOrderDetail(orderId);
				 
				 //每查找一次详情订单，就封装一次数据
				 userProductVo.setOrderNumber(orderList.get(i).getOrderNumber());
				 userProductVo.setOrderDeskNumber(orderList.get(i).getOrderDeskNumber());
				 userProductVo.setOrderDetail(orderDetailList);
				 userProductVo.setTotalCount(orderList.get(i).getTotalCount());
				 userProductVo.setTotalPrice(orderList.get(i).getTotalPrice());
				 userProductVo.setRemark(orderList.get(i).getRemark());
				 userProductVo.setCreateTime(orderList.get(i).getCreateOrderTime());
				 userProductVoList.add(userProductVo);
			 }
			 return userProductVoList;
			}
		
	}

	//删除已经支付的订单
	public String delOrderByOrderNumber(String orderNumber) {
		String result = "";
		//删除支付订单前，先判断该订单 ，厨师是否已经完成。(0---未完成。1---完成)
		int isFinish = od.findOrderIsFinish(orderNumber);
		//完成菜单后，才可以删除。
		if(isFinish == 1) {
			try {
				//删除订单
				od.delOrderByOrderNumber(orderNumber);
				//删除详情订单
				odd.delOrderDetailByOrderNumber(orderNumber);
				result = "ok";
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			result = "error";
		}
		return result;
	}

	//删除未支付的订单
	public String delNoPayOrderByOrderNumber(String orderNumber) {
		String result = "";
		try {
			//删除订单
			od.delOrderByOrderNumber(orderNumber);
			//删除详情订单
			odd.delOrderDetailByOrderNumber(orderNumber);
			result = "ok";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}


	
	
	

	
	
}
