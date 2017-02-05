package com.pairprogramming.client.dto;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RoleDto implements Serializable, IsSerializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleName;
	private String description;
	private List<PrivilegeDto> privileges;
	
	public List<PrivilegeDto> getPrivileges(){
		return privileges;
	}
	
	public void setPrivileges(List<PrivilegeDto> privileges){
		this.privileges = privileges;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		result = prime * result + roleId;
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
		if (!(obj instanceof RoleDto)) {
			return false;
		}
		RoleDto other = (RoleDto) obj;
		if (roleId != other.roleId) {
			return false;
		}
		return true;
	}
	
	
}
