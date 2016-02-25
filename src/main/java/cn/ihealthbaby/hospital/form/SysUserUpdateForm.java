package cn.ihealthbaby.hospital.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class SysUserUpdateForm {


	/**用户组编号*/
	private long[] roleid;

	public long[] getRoleid() {
		return roleid;
	}

	public void setRoleid(long[] roleid) {
		this.roleid = roleid;
	}
}
