package com.wx.pojo;

public class MenuYueCai {
	private int id;
	private String productName;
	private String productId;
	private String productPrice;
	private int discount;
	private String productPic;
	private int buyCount;
	private int isBuy;
	private int isFinish;
	private String type;
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
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public int getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}
	public int getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MenuYueCai [id=" + id + ", productName=" + productName + ", productId=" + productId + ", productPrice="
				+ productPrice + ", discount=" + discount + ", productPic=" + productPic + ", buyCount=" + buyCount
				+ ", isBuy=" + isBuy + ", isFinish=" + isFinish + ", type=" + type + "]";
	}
	
	
	


	
	
	
}
