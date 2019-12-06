package com.wx.vo;

public class OrderVo {
	private String orderNumber;
	private String productName;
	private int productId;
	private double productPrice;
	private String productPic;
	private String orderConsignee;
	private int orderDeskNumber;
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	public String getOrderConsignee() {
		return orderConsignee;
	}
	public void setOrderConsignee(String orderConsignee) {
		this.orderConsignee = orderConsignee;
	}
	public int getOrderDeskNumber() {
		return orderDeskNumber;
	}
	public void setOrderDeskNumber(int orderDeskNumber) {
		this.orderDeskNumber = orderDeskNumber;
	}
	@Override
	public String toString() {
		return "OrderVo [orderNumber=" + orderNumber + ", productName=" + productName + ", productId=" + productId
				+ ", productPrice=" + productPrice + ", productPic=" + productPic + ", orderConsignee=" + orderConsignee
				+ ", orderDeskNumber=" + orderDeskNumber + "]";
	}
	
	
	
//	String orderNumber = request.getParameter("orderNumber");
//	String productName = request.getParameter("proName");
//	String productId = request.getParameter("proId");
//	String productPrice = request.getParameter("proPrc");
//	String productPic = request.getParameter("proPic");
//	String orderConsignee = request.getParameter("orderConsignee");
//	String orderDeskNumber = request.getParameter("orderDeskNumber");
}
