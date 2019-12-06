package com.wx.pojo;

public class Order {
	private int id;
	private String orderNumber;
	private String orderState;
	private int totalCount;
	private double totalPrice;
	private int orderDeskNumber;
	private String orderConsignee;
	private int isAcept;
	private String remark;
	private int isFinish;
	private String createOrderTime;
	private String address;
	
	
	
	public int getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsAcept() {
		return isAcept;
	}
	public void setIsAcept(int isAcept) {
		this.isAcept = isAcept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
	
	public String getCreateOrderTime() {
		return createOrderTime;
	}
	public void setCreateOrderTime(String createOrderTime) {
		this.createOrderTime = createOrderTime;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderState=" + orderState + ", totalCount="
				+ totalCount + ", totalPrice=" + totalPrice + ", orderDeskNumber=" + orderDeskNumber
				+ ", orderConsignee=" + orderConsignee + ", isAcept=" + isAcept + ", remark=" + remark + ", isFinish="
				+ isFinish + ", createOrderTime=" + createOrderTime + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
}
