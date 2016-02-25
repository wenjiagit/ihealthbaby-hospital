package cn.ihealthbaby.hospital.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by qiang on 2015/8/5.
 */
public class ServiceDealForm {
	@NotBlank
	@NotNull
	@Pattern(regexp = "1[1|3|5|7|8][0-9]{9}")
	private String mobile;
	@NotBlank
	@NotNull
	@Length(min = 2, max = 10)
	private String username;
	@NotNull
	private Date birthday;
	@NotNull
	private Date deliveryTime;
	@NotNull
	@NotBlank
	private String serialnum;

	private String caseNumber;
	@NotNull
	private long doctorId;
	@NotNull
	private long hospitalId;
	@NotNull
	private long departmentId;

	private long Pforegift = 0;

	private long Pcouplant = 0;

	private long PdayRent = 0;

	private long Paskprice = 0;

	private int Cforegift = 0;

	private int CdayRent = 0;

	private int Ccouplant = 0;

	private int Caskprice = 0;

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getPforegift() {
		return Pforegift;
	}

	public void setPforegift(long pforegift) {
		Pforegift = pforegift;
	}

	public long getPcouplant() {
		return Pcouplant;
	}

	public void setPcouplant(long pcouplant) {
		Pcouplant = pcouplant;
	}

	public long getPdayRent() {
		return PdayRent;
	}

	public void setPdayRent(long pdayRent) {
		PdayRent = pdayRent;
	}

	public long getPaskprice() {
		return Paskprice;
	}

	public void setPaskprice(long paskprice) {
		Paskprice = paskprice;
	}

	public int getCforegift() {
		return Cforegift;
	}

	public void setCforegift(int cforegift) {
		Cforegift = cforegift;
	}

	public int getCdayRent() {
		return CdayRent;
	}

	public void setCdayRent(int cdayRent) {
		CdayRent = cdayRent;
	}

	public int getCcouplant() {
		return Ccouplant;
	}

	public void setCcouplant(int ccouplant) {
		Ccouplant = ccouplant;
	}

	public int getCaskprice() {
		return Caskprice;
	}

	public void setCaskprice(int caskprice) {
		Caskprice = caskprice;
	}
}
