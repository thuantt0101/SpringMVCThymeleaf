package com.laptrinhjavaweb.dto;

public class DmVtDTO extends BaseDTO<DmVtDTO> {

	private String maVt;
	private String tenVt;
	private String dvt1;
	private Integer maNhVtId;

	public Integer getMaNhVtId() {
		return maNhVtId;
	}

	public void setMaNhVtId(Integer maNhVtId) {
		this.maNhVtId = maNhVtId;
	}

	public String getMaVt() {
		return maVt;
	}

	public void setMaVt(String maVt) {
		this.maVt = maVt;
	}

	public String getTenVt() {
		return tenVt;
	}

	public void setTenVt(String tenVt) {
		this.tenVt = tenVt;
	}

	public String getDvt1() {
		return dvt1;
	}

	public void setDvt1(String dvt1) {
		this.dvt1 = dvt1;
	}

	public DmVtDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DmVtDTO(String maVt, String tenVt, String dvt1, Integer maNhVtId) {
		super();
		this.maVt = maVt;
		this.tenVt = tenVt;
		this.dvt1 = dvt1;
		this.maNhVtId = maNhVtId;
	}

}
