package com.laptrinhjavaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;

@Proxy(lazy = false)
@Entity
@Table(name = "R81DMVT")
public class DmVt extends BaseEntity {

	@NotNull
	@Column(name = "ma_vt")
	private String maVt;
	
	@Column(name = "ten_vt")
	private String tenVt;

	@Size(max = 10)
	@Column(name = "dvt1")
	private String dvt1;

	@ManyToOne
	@JoinColumn(name = "ma_nh_vt") // thông qua khóa ngoại ma_nh_vt = id trong dm_nh_vt đã tạo sẵn trong dababase
	private DmNhVt nhomVt;

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

	public DmNhVt getNhomVt() {
		return nhomVt;
	}

	public void setNhomVt(DmNhVt nhomVt) {
		this.nhomVt = nhomVt;
	}

}
