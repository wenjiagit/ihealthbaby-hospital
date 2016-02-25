package cn.ihealthbaby.hospital.form;

import javax.validation.constraints.NotNull;

public class RolePermForm {
	@NotNull
	private long roleId;
	@NotNull
	private long[] permIds;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long[] getPermIds() {
		return permIds;
	}

	public void setPermIds(long[] permIds) {
		this.permIds = permIds;
	}

}
