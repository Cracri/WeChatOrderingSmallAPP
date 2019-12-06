package com.wx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wx.pojo.OrderDetail;
import com.wx.util.C3P0Utils;
import com.wx.util.DBconn;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "insert into ex_order_detail values(?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,null,orderDetail.getOrderNumber(),orderDetail.getOrderId(),orderDetail.getProductId(),orderDetail.getProductName(),orderDetail.getProductPrice()
					,orderDetail.getProductCount(),orderDetail.getProductPic(),orderDetail.getProductDiscount(),orderDetail.getTotalPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderDetail> GetOrderDetails(int orderId) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "select * from ex_order_detail where orderid =?";
		 try {
			List<OrderDetail> list = qr.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class),orderId);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	
	@Override
	public void delOrderDetail(int orderId ,int productId) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "delete from ex_order_detail where orderId = ? and productid = ?";
		try {
			qr.update(sql, orderId,productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	@Override
	public int getDetailProductCount(String orderNumber,int orderId, int productId) {
		int count = 0;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select productCount from ex_order_detail where "
				+ " orderId =?  and productId = ?";
		try {
			count = (int)qr.query(sql, new ScalarHandler(),orderId,productId);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public OrderDetail findOrderDetail(int orderId, int productId) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "select * from ex_order_detail where orderId = ? and productId = ?";
		try {
			OrderDetail orderDetail = qr.query(sql, new BeanHandler<OrderDetail>(OrderDetail.class),orderId,productId);
			return orderDetail;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public void updateOrderDetailCountAndTotalPrice(int orderId, int productId, int newProductCount,
			double newTotalPrice) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "update ex_order_detail set productCount = ? , TotalPrice = ? where orderId = ? and productId = ? ";
		try {
			qr.update(sql,newProductCount,newTotalPrice,orderId,productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delProductCount(int orderId, int productId) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "delete from ex_order_detail where orderId = ? and  productId = ? ";
		try {
			qr.update(sql,orderId,productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderDetail> findUserOrderDetail(int orderId) {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql ="select * from ex_order_detail where orderId = ?";
		try {
			List<OrderDetail> list =qr.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class),orderId);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delOrderDetailByOrderNumber(String orderNumber) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "delete from ex_order_detail where orderNumber = ?";
		try {
			qr.update(sql,orderNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	

}
