package com.wx.pojo;

public class MenuDessert {
	private int id;
	private String productName;
	private String productId;
	private String productPrice;
	private int discount;
	private String productPic;
	private int surplus;
	private int buyCount;
	
	
	
	public int getBuyCount() {
		return buyCount;
	}



	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}



	public int getSurplus() {
		return surplus;
	}



	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}



	public String getProductPic() {
		return productPic;
	}



	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}



	@Override
	public String toString() {
		return "MenuDessert [id=" + id + ", productName=" + productName + ", productId=" + productId + ", productPrice="
				+ productPrice + ", discount=" + discount + ", productPic=" + productPic + ", surplus=" + surplus + "]";
	}



	
	
	
	
}
