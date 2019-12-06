package com.wx.dao;
import java.util.List;

import com.wx.pojo.Menu;
import com.wx.pojo.MenuChuanCai;
import com.wx.pojo.MenuDessert;
import com.wx.pojo.MenuLuCai;
import com.wx.pojo.MenuSuCai;
import com.wx.pojo.MenuYueCai;

public interface MenusDao {
	
	//查询总菜单
	public List<Menu> findIndexGreens() ;
	//查询川菜
	public List<MenuChuanCai> findChuanCai();
	//查找粤菜
	public List<MenuYueCai> findYueCai();
	//查找苏菜
	public List<MenuSuCai> findSuCai();
	//查找鲁菜
	public List<MenuLuCai> findLuCai();
	//查找甜品
	public List<MenuDessert> findDessert();

}
