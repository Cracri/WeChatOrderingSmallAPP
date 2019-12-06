package com.wx.service;

import java.util.List;
import java.util.Map;

public interface MoneyService {

	List<Map<String, Object>> findMonthData();

	List<Map<String, Object>> findDayData();

}
