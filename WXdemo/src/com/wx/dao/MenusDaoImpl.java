package com.wx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wx.pojo.Menu;
import com.wx.pojo.MenuChuanCai;
import com.wx.pojo.MenuDessert;
import com.wx.pojo.MenuLuCai;
import com.wx.pojo.MenuSuCai;
import com.wx.pojo.MenuYueCai;
import com.wx.util.C3P0Utils;
import com.wx.util.DBconn;

public class MenusDaoImpl implements MenusDao{

	public List<Menu> findIndexGreens() {
		
		try {
			DBconn.init();
			String sql = "select * from ex_menu";
			ResultSet rs = DBconn.selectSql(sql);
			List<Menu> list = new ArrayList<Menu>();
			while(rs.next()) {
				Menu m = new Menu();
				m.setId(rs.getInt("id"));
				m.setTypeName(rs.getString("typeName"));
				m.setTypePic(rs.getString("typePic"));
				list.add(m);
			}
			DBconn.closeconn();
			return list;
		} catch (SQLException e) {
			System.out.println("≤È—Ø≤Àµ• ß∞‹");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuChuanCai> findChuanCai() {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_menu_chuancai where isfinish = 1";
		try {
			List<MenuChuanCai> list = qr.query(sql, new BeanListHandler<MenuChuanCai>(MenuChuanCai.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuYueCai> findYueCai() {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_menu_yuecai where isfinish = 1";
		try {
			List<MenuYueCai> list = qr.query(sql, new BeanListHandler<MenuYueCai>(MenuYueCai.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuSuCai> findSuCai() {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_menu_sucai where isfinish = 1";
		try {
			List<MenuSuCai> list = qr.query(sql, new BeanListHandler<MenuSuCai>(MenuSuCai.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuLuCai> findLuCai() {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from ex_menu_lucai where isfinish = 1";
		try {
			List<MenuLuCai> list = qr.query(sql, new BeanListHandler<MenuLuCai>(MenuLuCai.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MenuDessert> findDessert() {
		try {
			DBconn.init();
			String sql = "select * from ex_menu_dessert";
			ResultSet rs =  DBconn.selectSql(sql);
			List<MenuDessert> list = new ArrayList<MenuDessert>();
			while(rs.next()) {
				MenuDessert dessert = new MenuDessert();
				dessert.setId(rs.getInt("id"));
				dessert.setProductName(rs.getString("productName"));
				dessert.setProductId(rs.getString("productId"));
				dessert.setProductPrice(rs.getString("productPrice"));
				dessert.setProductPic(rs.getString("productPic"));
				dessert.setSurplus(rs.getInt("surplus"));
				dessert.setBuyCount(rs.getInt("buycount"));
				list.add(dessert);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBconn.closeconn();
		}
		return null;
	}

}
