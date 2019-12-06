package com.wx.vo;

public class PageBean {
	
	
	private Integer code; 				//: res.status, //解析接口状态
    private String msg;				//		: res.message, //解析提示文本
    private Integer count;			//: res.total, //解析数据长度
    private Object data	;		//: res.data.item //解析数据列表
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
}
