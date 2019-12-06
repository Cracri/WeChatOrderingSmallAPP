package com.wx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.service.MoneyService;

@RequestMapping("money")
@Controller
public class MoneyController {
	
	@Autowired
	private MoneyService moneyService;
	
	//返回日收入页面
	@RequestMapping("/returnDailyIncome")
	public String returnDailyIncome() {
		return "money/dailyIncome.jsp";
	}
	
	//返回月收入页面
	@RequestMapping("/returnMonthlyIncome")
	public String returnMonthlyIncome() {
		return "money/monthlyIncome.jsp";
	}
	
//	
	
	@RequestMapping("/findMonthData")
	@ResponseBody
	public List<Map<String,Object>> findMonthData() {
		return moneyService.findMonthData();
	}
	
	

}
