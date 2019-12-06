package com.wx.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wx.pojo.Address;
import com.wx.util.C3P0Utils;

public class AddressDaoImpl implements AddressDao{

	@Override
	public void addAddress(Address address) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "insert into address values(?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,null,address.getConsignee(),address.getTelNumber(),address.getProvinceName(),
					address.getCityName(),address.getDistrictName(),address.getDetailInfo(),address.getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<Address> findUserDetailAddress(int uid) {
		List<Address> list = null;
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "select * from address where uid = ?";
		try {
			list = qr.query(sql, new BeanListHandler<Address>(Address.class),uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delThisAddress(int id, int uid) {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSourse());
		String sql = "delete from address where id = ? and uid = ?";
		try {
			qr.update(sql,id,uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
