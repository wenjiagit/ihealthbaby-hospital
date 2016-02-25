package cn.ihealthbaby.hospital.admin.client.form;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 开通监护的数据表单
 * @author  gwc
 */
public class ServiceForm implements ApiMessage {

	private String mobile;

	private String username;

	private Date birthday;

	private Date deliveryTime;

	private String serialnum;

	private String caseNumber;

	private long doctorId;

	private long hospitalId;

	private long departmentId;

	private long Pforegift;

	private long Pcouplant;

	private long PdayRent;

	private long Paskprice;

	private int Cforegift;

	private int CdayRent;

	private int Ccouplant;

	private int Caskprice;

	public ServiceForm() {
	}

	public ServiceForm(String mobile, String username, Date birthday, Date deliveryTime, String serialnum,
			String caseNumber, long doctorId, long hospitalId, long departmentId, long Pforegift, long Pcouplant,
			long PdayRent, long Paskprice, int Cforegift, int CdayRent, int Ccouplant, int Caskprice) {
		this.mobile = mobile;
		this.username = username;
		this.birthday = birthday;
		this.deliveryTime = deliveryTime;
		this.serialnum = serialnum;
		this.caseNumber = caseNumber;
		this.doctorId = doctorId;
		this.hospitalId = hospitalId;
		this.departmentId = departmentId;
		this.Pforegift = Pforegift;
		this.Pcouplant = Pcouplant;
		this.PdayRent = PdayRent;
		this.Paskprice = Paskprice;
		this.Cforegift = Cforegift;
		this.CdayRent = CdayRent;
		this.Ccouplant = Ccouplant;
		this.Caskprice = Caskprice;
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

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
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

	public void setPforegift(long Pforegift) {
		this.Pforegift = Pforegift;
	}

	public long getPcouplant() {
		return Pcouplant;
	}

	public void setPcouplant(long Pcouplant) {
		this.Pcouplant = Pcouplant;
	}

	public long getPdayRent() {
		return PdayRent;
	}

	public void setPdayRent(long PdayRent) {
		this.PdayRent = PdayRent;
	}

	public long getPaskprice() {
		return Paskprice;
	}

	public void setPaskprice(long Paskprice) {
		this.Paskprice = Paskprice;
	}

	public int getCforegift() {
		return Cforegift;
	}

	public void setCforegift(int Cforegift) {
		this.Cforegift = Cforegift;
	}

	public int getCdayRent() {
		return CdayRent;
	}

	public void setCdayRent(int CdayRent) {
		this.CdayRent = CdayRent;
	}

	public int getCcouplant() {
		return Ccouplant;
	}

	public void setCcouplant(int Ccouplant) {
		this.Ccouplant = Ccouplant;
	}

	public int getCaskprice() {
		return Caskprice;
	}

	public void setCaskprice(int Caskprice) {
		this.Caskprice = Caskprice;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		if (username != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "username", username));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		if (caseNumber != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "caseNumber", caseNumber));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorId", doctorId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "departmentId", departmentId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Pforegift", Pforegift));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Pcouplant", Pcouplant));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "PdayRent", PdayRent));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Paskprice", Paskprice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Cforegift", Cforegift));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "CdayRent", CdayRent));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Ccouplant", Ccouplant));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "Caskprice", Caskprice));

		return $list;
	}

	@Override
	public String toString() {
		return "ServiceForm [mobile=" + mobile + ",username=" + username + ",birthday=" + birthday + ",deliveryTime="
				+ deliveryTime + ",serialnum=" + serialnum + ",caseNumber=" + caseNumber + ",doctorId=" + doctorId
				+ ",hospitalId=" + hospitalId + ",departmentId=" + departmentId + ",Pforegift=" + Pforegift
				+ ",Pcouplant=" + Pcouplant + ",PdayRent=" + PdayRent + ",Paskprice=" + Paskprice + ",Cforegift="
				+ Cforegift + ",CdayRent=" + CdayRent + ",Ccouplant=" + Ccouplant + ",Caskprice=" + Caskprice + ", ]";
	}
}