package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class LeaseSetting implements ApiMessage {

	/**
	 * 主键id 
	 */
	private long id;

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

	/**
	 * 医院id 
	 */
	private long hospitalId;

	public LeaseSetting() {
	}

	public LeaseSetting(long id, double foregift, double askPrice, double dayPrice, double weekDiscount,
			double couplantPrice, long hospitalId) {
		this.id = id;
		this.foregift = foregift;
		this.askPrice = askPrice;
		this.dayPrice = dayPrice;
		this.weekDiscount = weekDiscount;
		this.couplantPrice = couplantPrice;
		this.hospitalId = hospitalId;
	}

	/**
	 * 主键id 
	 */
	public long getId() {
		return id;
	}

	/**
	 * 主键id 
	 */
	public void setId(long id) {
		this.id = id;
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

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "foregift", foregift));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "askPrice", askPrice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "dayPrice", dayPrice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "weekDiscount", weekDiscount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "couplantPrice", couplantPrice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		return $list;
	}

	@Override
	public String toString() {
		return "LeaseSetting [id=" + id + ",foregift=" + foregift + ",askPrice=" + askPrice + ",dayPrice=" + dayPrice
				+ ",weekDiscount=" + weekDiscount + ",couplantPrice=" + couplantPrice + ",hospitalId=" + hospitalId
				+ ", ]";
	}
}