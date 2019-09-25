package com.laptrinhjavaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Proxy(lazy = false)
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "parent_role_id")
	private Integer parentRoleId;
	
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="controller_link")
	private String controllerLink;


	public String getControllerLink() {
		return controllerLink;
	}


	public void setControllerLink(String controllerLink) {
		this.controllerLink = controllerLink;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Integer getParentRoleId() {
		return parentRoleId;
	}


	public void setParentRoleId(Integer parentRoleId) {
		this.parentRoleId = parentRoleId;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}	

}
