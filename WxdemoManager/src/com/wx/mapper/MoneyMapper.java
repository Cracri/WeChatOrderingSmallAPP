package com.wx.mapper;

import java.util.List;
import java.util.Map;

public interface MoneyMapper {

	List<Map<String, Object>> findMonthData();

	List<Map<String, Object>> findDayData();

}
