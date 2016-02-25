package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 租赁设置数据表单
 * @author  gwc
 */
public class LeaseSettingForm implements ApiMessage {

	/**
	 * 医院id 
	 */
	private long hospitalId;

	/**
	 * 设备押金 
	 */
	private double foregift;

	/**
	 * 单次询问的价格 
	 */
	private double askPrice;

	/**
	 * 单日租赁的价格 
	 */
	private double dayPrice;

	/**
	 * 租期满一周的折扣 
	 */
	private double weekDiscount;

	/**
	 * 耦合剂的价格 
	 */
	private double couplantPrice;

	public LeaseSettingForm() {
	}

	public LeaseSettingForm(long hospitalId, double foregift, double askPrice, double dayPrice, double weekDiscount,
			double couplantPrice) {
		this.hospitalId = hospitalId;
		this.foregift = foregift;
		this.askPrice = askPrice;
		this.dayPrice = dayPrice;
		this.weekDiscount = weekDiscount;
		this.couplantPrice = couplantPrice;
	}

	/**
	 * 医院id 
	 */
	public long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院id 
	 */
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
	}

	/**
	 * 设备押金 
	 */
	public double getForegift() {
		return foregift;
	}

	/**
	 * 设备押金 
	 */
	public void setForegift(double foregift) {
		this.foregift = foregift;
	}

	/**
	 * 单次询问的价格 
	 */
	public double getAskPrice() {
		return askPrice;
	}

	/**
	 * 单次询问的价格 
	 */
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}

	/**
	 * 单日租赁的价格 
	 */
	public double getDayPrice() {
		return dayPrice;
	}

	/**
	 * 单日租赁的价格 
	 */
	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
	}

	/**
	 * 租期满一周的折扣 
	 */
	public double getWeekDiscount() {
		return weekDiscount;
	}

	/**
	 * 租期满一周的折扣 
	 */
	public void setWeekDiscount(double weekDiscount) {
		this.weekDiscount = weekDiscount;
	}

	/**
	 * 耦合剂的价格 
	 */
	public double getCouplantPrice() {
		return couplantPrice;
	}

	/**
	 * 耦合剂的价格 
	 */
	public void setCouplantPrice(double couplantPrice) {
		this.couplantPrice = couplantPrice;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "foregift", foregift));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "askPrice", askPrice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "dayPrice", dayPrice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "weekDiscount", weekDiscount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "couplantPrice", couplantPrice));

		return $list;
	}

	@Override
	public String toString() {
		return "LeaseSettingForm [hospitalId=" + hospitalId + ",foregift=" + foregift + ",askPrice=" + askPrice
				+ ",dayPrice=" + dayPrice + ",weekDiscount=" + weekDiscount + ",couplantPrice=" + couplantPrice + ", ]";
	}
}