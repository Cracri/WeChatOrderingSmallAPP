package com.wx.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.wx.pojo.Order;
import com.wx.util.C3P0Utils;
import com.wx.vo.Product;

public class OrderDaoImpl implements OrderDao{

	@Override
	//查看该订单是否存在
	public Order findOrderNumber(String orderNumber) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_order where orderNumber =?";
		try {
			Order order = qr.query(sql, new BeanHandler<Order>(Order.class),orderNumber);
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addOrder(Order o) {
		String date = "current_timestamp";
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "insert into ex_order values(?,?,?,?,?,?,'无',?,?,?,?,"+date+")";
		try {
			qr.update(sql,null,o.getOrderNumber(),o.getOrderState(),
					o.getTotalCount(),o.getTotalPrice(),o.getOrderDeskNumber(),o.getOrderConsignee(),0,0,0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(int newTotalCount, double newTotalPrice, int orderId) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql  = "update ex_order set totalCount = ? , totalPrice = ? where id = ?";
		try {
			qr.update(sql,newTotalCount,newTotalPrice,orderId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void delOrder(String orderNumber) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "delete from ex_order where orderNumber = ?";
		try {
			qr.update(sql,orderNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void updateOrderCountAndTotalPrice(String orderNumber, int newOrderCount, double newOrderPrice) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "update ex_order set totalCount = ? , totalPrice = ? where orderNumber = ? ";
		try {
			qr.update(sql,newOrderCount,newOrderPrice,orderNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findDelProduct(String delArray) {
		if(delArray == null) {
			return null;
		}else {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
			String sql = "select * FROM "
					+ "(select * from ex_menu_chuancai union "
					+ "select * from ex_menu_yuecai union "
					+ "select * from ex_menu_lucai union "
					+ "select * from ex_menu_sucai) "
					+ "as aa where FIND_IN_SET(productId,'"+delArray+"')";
			try {
				List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}


	@Override
	public String  paySuccess(int orderId,String remark,String address) {
		String result = "";
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "update ex_order set orderState = '已付款' , remark = ? , address = ? where id = ?";
		try {
			qr.update(sql,remark,address,orderId);
			result = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public void insertTempOrder(Order o) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "insert into temporder values(?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,null,o.getOrderNumber(),o.getOrderState(),o.getTotalCount(),o.getTotalPrice(),o.getOrderDeskNumber(),o.getOrderConsignee(),o.getIsAcept(),o.getRemark(),o.getCreateOrderTime());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	@Override
	public List<Order> findUserOrder(String username) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse()); 
		String sql = "select * from ex_order where orderConsignee = ? and orderState = '已付款' order by createOrderTime desc";
		try {
			List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),username);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public List<Order> findNoPayOrderByUsername(String username) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse()); 
		String sql = "select * from ex_order where orderConsignee = ? and orderState = '未付款' order by createOrderTime desc";
		try {
			List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),username);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delOrderByOrderNumber(String orderNumber) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "delete from ex_order where orderNumber = ?";
		try {
			qr.update(sql,orderNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int findOrderIsFinish(String orderNumber) {
		int isFinish = 0;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select isFinish from ex_order where orderNumber =?";
		try {
			isFinish = (int) qr.query(sql, new ScalarHandler(),orderNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isFinish;
	}

}
