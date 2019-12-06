package com.wx.service;

import java.util.List;

import com.wx.pojo.Menu;
import com.wx.pojo.MenuChuanCai;
import com.wx.pojo.MenuDessert;
import com.wx.pojo.MenuLuCai;
import com.wx.pojo.MenuSuCai;
import com.wx.pojo.MenuYueCai;
import com.wx.dao.MenusDao;
import com.wx.dao.MenusDaoImpl;

public class MenusService{
	
	MenusDao md = new MenusDaoImpl();
	
	//查询总菜单
	public List<Menu> findIndexGreens(){
		List<Menu> list  = md.findIndexGreens();
		return list;
	}
	//查询川菜
	public  List<MenuChuanCai> findChuanCai() {
		List<MenuChuanCai> list  = md.findChuanCai();
		return list;
	}
	//查询粤菜
	public List<MenuYueCai> findYueCai() {
		List<MenuYueCai> list  = md.findYueCai();
		return list;
	}
	//查询苏菜
	public List<MenuSuCai> findSuCai() {
		List<MenuSuCai> list  = md.findSuCai();
		return list;
	}
	//查询鲁菜
	public List<MenuLuCai> findLuCai() {
		List<MenuLuCai> list  = md.findLuCai();
		return list;
	}
	//查询甜品
	public List<MenuDessert> findDessert() {
		List<MenuDessert> list  = md.findDessert();
		return list;
	}
	
	
	

}
