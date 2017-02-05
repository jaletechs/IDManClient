package com.pairprogramming.client.dto;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PrivilegeDto implements Serializable, IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int privilegeId;
	private RoleDto roleDto;
	private String description;
	
	public int getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}
	public RoleDto getRoleDto() {
		return roleDto;
	}
	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + privilegeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PrivilegeDto)) {
			return false;
		}
		PrivilegeDto other = (PrivilegeDto) obj;
		if (privilegeId != other.privilegeId) {
			return false;
		}
		return true;
	}
	
	
	
}
