package com.wx.service;

import com.wx.vo.PageBean;
import com.wx.vo.Product;

public interface GreensService {
	
	public PageBean findGreens(Integer page, Integer pageSize, String title);
	
	public String judgeProductIdWithData(String productId);
	//新添菜品
	public String saveProductInfo(Product productInfo);
	//通过Id查找菜品
	public Product findProductById(Integer id);
	//通过ID修改菜品信息
	public String updateProductInfoById(Product productInfo);
	//通过productId 删除商品
	public String delProductByProductId(Integer productId, String type);
	
	//修改总菜单上下架
	public void updateProductIsFinish(Integer id, int isFinish);

	


}
