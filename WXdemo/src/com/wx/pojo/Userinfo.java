package com.wx.pojo;

public class Userinfo {
	private int id;
	private String userName;
	private String userPic;
	private String userPhone;
	private String province;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", userName=" + userName + ", userPic=" + userPic + ", userPhone=" + userPhone
				+ ", province=" + province + "]";
	}
	
	
	
	
}
