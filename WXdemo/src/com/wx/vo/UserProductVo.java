package com.wx.vo;

import java.util.ArrayList;
import java.util.List;

import com.wx.pojo.OrderDetail;

public class UserProductVo {
	private int id;
	private String orderNumber;
	private int totalCount;
	private double totalPrice;
	private int orderDeskNumber;
	private List<OrderDetail> orderDetail;
	private String remark;
	private int isAcept;
	private int isFinish;
	private String createTime;
	private String address;
	
	
	public int getIsAcept() {
		return isAcept;
	}
	public void setIsAcept(int isAcept) {
		this.isAcept = isAcept;
	}
	public int getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	public int getId() {
		return id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public int getOrderDeskNumber() {
		return orderDeskNumber;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public String getRemark() {
		return remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setOrderDeskNumber(int orderDeskNumber) {
		this.orderDeskNumber = orderDeskNumber;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserProductVo [id=" + id + ", orderNumber=" + orderNumber + ", totalCount=" + totalCount
				+ ", totalPrice=" + totalPrice + ", orderDeskNumber=" + orderDeskNumber + ", orderDetail=" + orderDetail
				+ ", remark=" + remark + ", isAcept=" + isAcept + ", isFinish=" + isFinish + ", createTime="
				+ createTime + ", address=" + address + "]";
	}
	
}
