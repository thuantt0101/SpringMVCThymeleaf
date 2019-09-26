package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseDTO<T> {

	private Integer id;

	private Date createdDate;
	private List<T> listResult = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

}
