package cn.ihealthbaby.hospital.form;

import javax.validation.constraints.NotNull;

public class NstOptionForm {
	/**选项名*/
	@NotNull
	private String nstOptionName;
	/**选项含义*/
	@NotNull
	private String nstOptionDetail;
	public String getNstOptionName() {
		return nstOptionName;
	}
	public void setNstOptionName(String nstOptionName) {
		this.nstOptionName = nstOptionName;
	}
	public String getNstOptionDetail() {
		return nstOptionDetail;
	}
	public void setNstOptionDetail(String nstOptionDetail) {
		this.nstOptionDetail = nstOptionDetail;
	}
	
}
