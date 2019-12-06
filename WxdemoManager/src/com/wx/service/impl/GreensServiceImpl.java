package com.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.GreensMapper;
import com.wx.service.GreensService;
import com.wx.vo.PageBean;
import com.wx.vo.Product;

@Service
public class GreensServiceImpl implements GreensService{
	@Autowired
	private GreensMapper greensMapper;

	@Override
	public PageBean findGreens(Integer page, Integer pageSize,String title) {
		PageBean pb = new PageBean();
		//1.查询总数据的数目
		int totalCount = greensMapper.getTotalCount(title);
		//2.修改页码
		int newPage = (page - 1) * pageSize;
		//3.查询要显示的数据
		List<Product> list = greensMapper.findGreens(newPage,pageSize,title);
		//4.封装数据
		pb.setCode(0);
		pb.setMsg("ok");
		pb.setCount(totalCount);
		pb.setData(list);
		return pb;
	}

	@Override
	public String judgeProductIdWithData(String newProductId) {
		String result = "yes";
		List<Product> productList = greensMapper.getAllProductId();
		Product p = null;
		//判断ProductId是否存在。
		for(int i = 0;i<productList.size();i++) {
			p = productList.get(i);
			if(p.getProductId().equals(newProductId)) {
				result = "no";
			}
		}
		return result;
	}

	
	@Override
	public String saveProductInfo(Product productInfo) {
		String result = "";
		try {
			//保存总菜单
			greensMapper.saveProductInfo(productInfo);
			
			//保存子菜单
			String type = productInfo.getType();
			if(type.equals("1")) {
				greensMapper.saveChunCaiProductInfo(productInfo);
			}else if(type.equals("2")){
				greensMapper.saveYueCaiProductInfo(productInfo);
			}else if(type.equals("3")){
				greensMapper.saveSuCaiProductInfo(productInfo);
			}else if(type.equals("4")){
				greensMapper.saveLuCaiProductInfo(productInfo);
			}
			result = "ok";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Product findProductById(Integer id) {
		return greensMapper.findProductById(id);
	}

	
	@Override
	public String updateProductInfoById(Product productInfo) {
		String result = "";
		try {
			//更新总菜单
			greensMapper.updateProductInfoById(productInfo);
			
			String type= productInfo.getType();
			//更新子菜单
			if(type.equals("1")) {
				greensMapper.updateChuancaicaiProductByProductId(productInfo);
			}else if(type.equals("2")){
				greensMapper.updateYuecaiProductByProductId(productInfo);
			}else if(type.equals("3")){
				greensMapper.updateSucaiProductByProductId(productInfo);
			}else if(type.equals("4")){
				greensMapper.updateLucaiProductByProductId(productInfo);
			}
			result = "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public String delProductByProductId(Integer productId,String type) {
		String result = "";
		
		try {
			//删除总订单的菜品
			greensMapper.delProductByProductId(productId);
			
			//删除子订单的菜品
			if(type.equals("1")) {
				greensMapper.delChuanCaiProductByProductId(productId);
			}else if(type.equals("2")) {
				greensMapper.delYueCaiProductByProductId(productId);
			}else if(type.equals("3")) {
				greensMapper.delSuCaiCaiProductByProductId(productId);
			}else if(type.equals("4")) {
				greensMapper.delLuCaiProductByProductId(productId);
			}
			result = "ok";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

	
	@Override
	public void updateProductIsFinish(Integer id, int isFinish) {
		
		greensMapper.updateProductIsFinish(id,isFinish);
		
		Product p =  greensMapper.findGreen(id);
		String type = p.getType();
		String productId = p.getProductId();
		
		if(type.equals("1")) {
			greensMapper.updateChuancaiFinish(productId,isFinish);
		}else if(type.equals("2")) {
			greensMapper.updateYuecaiFinish(productId,isFinish);
		}else if(type.equals("3")) {
			greensMapper.updateSucaiFinish(productId,isFinish);
		}else if(type.equals("4")) {
			greensMapper.updateLucaiFinish(productId,isFinish);
		}
		
		
	}

	
	
	
	
}
