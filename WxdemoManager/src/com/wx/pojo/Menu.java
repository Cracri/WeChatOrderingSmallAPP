package com.wx.pojo;

public class Menu {
	private int id;
	private String typeName;
	private String typePic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypePic() {
		return typePic;
	}
	public void setTypePic(String typePic) {
		this.typePic = typePic;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", typeName=" + typeName + ", typePic=" + typePic + "]";
	}
	
}
