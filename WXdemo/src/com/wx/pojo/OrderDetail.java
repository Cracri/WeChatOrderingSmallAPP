package com.wx.pojo;

public class OrderDetail {
	private int  id;
	private String orderNumber;
	private int orderId;
	private int productId;
	private String productName;
	private double productPrice;
	private int productCount;
	private String productPic;
	private int productDiscount;
	private double totalPrice;
	private int orderDeskNumber;
	private String orderConsignee;
	
	
	
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderDeskNumber() {
		return orderDeskNumber;
	}
	public void setOrderDeskNumber(int orderDeskNumber) {
		this.orderDeskNumber = orderDeskNumber;
	}
	public String getOrderConsignee() {
		return orderConsignee;
	}
	public void setOrderConsignee(String orderConsignee) {
		this.orderConsignee = orderConsignee;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderNumber=" + orderNumber + ", orderId=" + orderId + ", productId="
				+ productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productCount="
				+ productCount + ", productPic=" + productPic + ", productDiscount=" + productDiscount + ", totalPrice="
				+ totalPrice + ", orderDeskNumber=" + orderDeskNumber + ", orderConsignee=" + orderConsignee + "]";
	}
	
	
	
	
	
}
