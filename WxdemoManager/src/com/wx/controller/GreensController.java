package com.wx.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wx.service.GreensService;
import com.wx.vo.PageBean;
import com.wx.vo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/greens")
public class GreensController {
	@Autowired
	private GreensService greensService;
	
	//返回主界面 
	@RequestMapping("/returnIndex")
	public String returnIndex() {
		return "index.jsp";
	}
	
	//跳转
	@RequestMapping("/returnGreensList")
	public String returnGreensList() {
		return "product/greensList.jsp";
	}
	
	//返回一个新增页面
	@RequestMapping("/returnAddProduct")
	public String returnAddProduct() {
		return "product/addProduct.jsp";
	}
	
	//返回一个编辑页面
	@RequestMapping("/returnEditProduct")
	public ModelAndView returnEditProduct(Integer id) {
		ModelAndView mv = new ModelAndView();
		Product product =  greensService.findProductById(id);
		mv.addObject("product", product);
		mv.setViewName("product/editProduct.jsp");
		return mv;
	}

	@RequestMapping("/findGreens")
	@ResponseBody
	public PageBean findGreens(Integer page,Integer pageSize,String productName) {
		pageSize = 10;
		PageBean pb = greensService.findGreens(page,pageSize,productName);
		return pb;
	}
	
	//判断 输入的商品序号  是否存在
	@RequestMapping("/judgeProductIdWithData")
	@ResponseBody
	public String judgeProductIdWithData(String productId) {
		return greensService.judgeProductIdWithData(productId);
	}
	
	@RequestMapping("/saveProductInfo")
	@ResponseBody
	public String saveProductInfo(@RequestBody Product productInfo) {
		String result = greensService.saveProductInfo(productInfo);
		return result;
	}
	
	@RequestMapping("/updateProductInfo")
	@ResponseBody
	public String updateProductInfo(@RequestBody Product productInfo) {
		String result = greensService.updateProductInfoById(productInfo);
		return result;
	}
	
	@RequestMapping("/delProductByProductId")
	@ResponseBody
	public String delProductByProductId(Integer productId,String type) {
		String result = greensService.delProductByProductId(productId,type);
		
		return result;
	}
	
	@RequestMapping("/updateProductIsFinish")
	@ResponseBody
	public String updateProductIsFinish(Integer id , boolean flag) {
		String result = "";
		
		int[] isFinish = {flag?1:0};
		greensService.updateProductIsFinish(id,isFinish[0]);
		
		
		return result;
	}
	
	
	
}
