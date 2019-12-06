package com.wx.pojo;

public class Address {
	private int id;
	private String consignee;
	private String telNumber;
	private String provinceName;
	private String cityName;
	private String districtName;
	private String detailInfo;
	private int uid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", consignee=" + consignee + ", telNumber=" + telNumber + ", provinceName="
				+ provinceName + ", cityName=" + cityName + ", districtName=" + districtName + ", detailInfo="
				+ detailInfo + ", uid=" + uid + "]";
	}
	
	
	
	
}
