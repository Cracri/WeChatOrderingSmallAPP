package com.wx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.mapper.MoneyMapper;
import com.wx.service.MoneyService;

@Service
public class MoneyServiceImpl implements MoneyService{
	@Autowired
	private MoneyMapper moneyMapper;

	
	@Override
	public List<Map<String, Object>> findMonthData() {
		return moneyMapper.findMonthData();
	}


	@Override
	public List<Map<String, Object>> findDayData() {
		return moneyMapper.findDayData();
	}
	
	
	
	
}
