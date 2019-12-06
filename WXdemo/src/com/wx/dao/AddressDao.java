package com.wx.dao;

import java.util.List;

import com.wx.pojo.Address;

public interface AddressDao {
	
	//´æ´¢Êý¾Ý
	void addAddress(Address address);

	List<Address> findUserDetailAddress(int uid);

	void delThisAddress(int id, int uid);

}
