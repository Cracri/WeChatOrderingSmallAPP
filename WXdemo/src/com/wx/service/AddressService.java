package com.wx.service;

import java.util.List;

import com.wx.dao.AddressDao;
import com.wx.dao.AddressDaoImpl;
import com.wx.pojo.Address;

public class AddressService {

	AddressDao ad = new AddressDaoImpl();
	
	//保存地址
	public String addAddress(Address address) {
		String result = "";
		try {
			ad.addAddress(address);
			result = "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//查询该用户的所有地址
	public List<Address> findUserDetailAddress(int uid) {
		return 	ad.findUserDetailAddress(uid);
	}

	//删除当前地址
	public String delThisAddress(int uid, int id) {
		String result = "";
		try {
			ad.delThisAddress(id,uid);
			result = "ok";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
}	
