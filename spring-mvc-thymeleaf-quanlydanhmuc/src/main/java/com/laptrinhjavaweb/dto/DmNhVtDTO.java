package com.laptrinhjavaweb.dto;

public class DmNhVtDTO extends BaseDTO<DmNhVtDTO>{


	private String maNhVt;
	private String tenNhVt;
	private String maNhVtParent;
	
	
	public String getMaNhVt() {
		return maNhVt;
	}
	public void setMaNhVt(String maNhVt) {
		this.maNhVt = maNhVt;
	}
	public String getTenNhVt() {
		return tenNhVt;
	}
	public void setTenNhVt(String tenNhVt) {
		this.tenNhVt = tenNhVt;
	}
	public String getMaNhVtParent() {
		return maNhVtParent;
	}
	public void setMaNhVtParent(String maNhVtParent) {
		this.maNhVtParent = maNhVtParent;
	}
	

	public DmNhVtDTO(String maNhVt, String tenNhVt, String maNhVtParent) {
		super();
		this.maNhVt = maNhVt;
		this.tenNhVt = tenNhVt;
		this.maNhVtParent = maNhVtParent;
	}
	

	public DmNhVtDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
