package com.wx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wx.vo.Product;

public interface GreensMapper {

	//得到查询菜品的所有总数目
	public int getTotalCount(@Param("productName")String productName);
	//查询要显示的数据
	public List<Product> findGreens(@Param("page")Integer newPage, @Param("pageSize")Integer pageSize,
															@Param("productName")String productName);
	//得到所有商品Id
	public List<Product> getAllProductId();
	//保存菜品到 总菜单
	public void saveProductInfo(Product productInfo);
	//保存菜品 到 川菜
	public void saveChunCaiProductInfo(Product productInfo);
	//保存菜品 到 粤菜
	public void saveYueCaiProductInfo(Product productInfo);
	//保存菜品 到 苏菜
	public void saveSuCaiProductInfo(Product productInfo);
	//保存菜品 到 鲁菜
	public void saveLuCaiProductInfo(Product productInfo);
	
	//通过Id查找菜品
	public Product findProductById(Integer id);
	
	//通过ID修改菜品
	public void updateProductInfoById(Product productInfo);
	//更新川菜
	public void updateChuancaicaiProductByProductId(Product productInfo);
	//更新粤菜
	public void updateYuecaiProductByProductId(Product productInfo);
	//更新苏菜
	public void updateSucaiProductByProductId(Product productInfo);
	//更新鲁菜
	public void updateLucaiProductByProductId(Product productInfo);
	
	//删除总菜单菜品通过productId
	public void delProductByProductId(Integer productId);
	//删除川菜
	public void delChuanCaiProductByProductId(Integer productId);
	//删除粤菜
	public void delYueCaiProductByProductId(Integer productId);
	//删除苏菜
	public void delSuCaiCaiProductByProductId(Integer productId);
	//删除鲁菜
	public void delLuCaiProductByProductId(Integer productId);

	//修改总商品 上下架
	public void updateProductIsFinish(@Param("id")Integer id, @Param("isFinish")int isFinish);
	//修改子商品上下架
	public void updateChuancaiFinish(@Param("productId")String productId, @Param("isFinish")int isFinish);
	//修改子商品上下架
	public void updateYuecaiFinish(@Param("productId")String productId, @Param("isFinish")int isFinish);
	//修改子商品上下架
	public void updateSucaiFinish(@Param("productId")String productId, @Param("isFinish")int isFinish);
	//修改子商品上下架
	public void updateLucaiFinish(@Param("productId")String productId, @Param("isFinish")int isFinish);
	
	//查找商品
	public Product findGreen(Integer id);

	

}
