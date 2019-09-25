package com.laptrinhjavaweb.dto;

public class RoleDTO {

	private Integer id;
	private String roleName;
	private Integer parentRoleId;
	private Boolean enabled;
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


	public RoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoleDTO(Integer id, String roleName, Integer parentRoleId, Boolean enabled,String controllerLink) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.parentRoleId = parentRoleId;
		this.enabled = enabled;
		this.controllerLink=controllerLink;
	}
	
	
	
}
