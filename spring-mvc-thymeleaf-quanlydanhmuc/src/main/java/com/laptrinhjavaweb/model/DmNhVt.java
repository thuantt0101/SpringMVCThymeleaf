package com.laptrinhjavaweb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Proxy(lazy = false)
@Entity
@Table(name = "R81DMNHVT")
public class DmNhVt extends BaseEntity {

	@Column(name = "ma_nh_vt")
	private String maNhVt;

	@Column(name = "ten_nh_vt")
	private String tenNhVt;

	@Column(name = "ma_nh_vt_parent")
	private String maNhVtParent;
	
	@OneToMany(mappedBy = "nhomVt",cascade = CascadeType.ALL) //quan hệ 1:n với đối tượng bên dưới
	//mappedBy:trỏ tới biến nhomvt trong dmvt
	private List<DmVt> dmvts;

	public List<DmVt> getDmvts() {
		return dmvts;
	}

	public void setDmvts(List<DmVt> dmvts) {
		this.dmvts = dmvts;
	}

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


	public DmNhVt() {
		super();
		// TODO Auto-generated constructor stub
	}

}
