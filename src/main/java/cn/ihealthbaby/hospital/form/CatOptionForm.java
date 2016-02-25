package cn.ihealthbaby.hospital.form;

import javax.validation.constraints.NotNull;

public class CatOptionForm {
	/**选项名*/
	@NotNull
	private String catOptionName;
	/**选项含义*/
	@NotNull
	private String catOptionDetail;
	public String getCatOptionName() {
		return catOptionName;
	}
	public void setCatOptionName(String catOptionName) {
		this.catOptionName = catOptionName;
	}
	public String getCatOptionDetail() {
		return catOptionDetail;
	}
	public void setCatOptionDetail(String catOptionDetail) {
		this.catOptionDetail = catOptionDetail;
	}
	
}
