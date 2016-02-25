package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class AdviceSetting implements ApiMessage {

	private long id;

	/**
	 * 自动开始监护的时间设置 单位秒 
	 */
	private int autoBeginAdvice;

	/**
	 * 自动开始监护的时长 单位分钟 
	 */
	private int autoAdviceTimeLong;

	/**
	 * 重复胎动计时时间间隔 单位秒 
	 */
	private int fetalMoveTime;

	/**
	 * 自动开始记录的时长 单位 秒 
	 */
	private int autoBeginRecord;

	/**
	 * 询问医生最短时长 单位分钟 
	 */
	private int askMinTime;

	/**
	 * 医院id 
	 */
	private long hospitalId;

	public AdviceSetting() {
	}

	public AdviceSetting(long id, int autoBeginAdvice, int autoAdviceTimeLong, int fetalMoveTime, int autoBeginRecord,
			int askMinTime, long hospitalId) {
		this.id = id;
		this.autoBeginAdvice = autoBeginAdvice;
		this.autoAdviceTimeLong = autoAdviceTimeLong;
		this.fetalMoveTime = fetalMoveTime;
		this.autoBeginRecord = autoBeginRecord;
		this.askMinTime = askMinTime;
		this.hospitalId = hospitalId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 自动开始监护的时间设置 单位秒 
	 */
	public int getAutoBeginAdvice() {
		return autoBeginAdvice;
	}

	/**
	 * 自动开始监护的时间设置 单位秒 
	 */
	public void setAutoBeginAdvice(int autoBeginAdvice) {
		this.autoBeginAdvice = autoBeginAdvice;
	}

	/**
	 * 自动开始监护的时长 单位分钟 
	 */
	public int getAutoAdviceTimeLong() {
		return autoAdviceTimeLong;
	}

	/**
	 * 自动开始监护的时长 单位分钟 
	 */
	public void setAutoAdviceTimeLong(int autoAdviceTimeLong) {
		this.autoAdviceTimeLong = autoAdviceTimeLong;
	}

	/**
	 * 重复胎动计时时间间隔 单位秒 
	 */
	public int getFetalMoveTime() {
		return fetalMoveTime;
	}

	/**
	 * 重复胎动计时时间间隔 单位秒 
	 */
	public void setFetalMoveTime(int fetalMoveTime) {
		this.fetalMoveTime = fetalMoveTime;
	}

	/**
	 * 自动开始记录的时长 单位 秒 
	 */
	public int getAutoBeginRecord() {
		return autoBeginRecord;
	}

	/**
	 * 自动开始记录的时长 单位 秒 
	 */
	public void setAutoBeginRecord(int autoBeginRecord) {
		this.autoBeginRecord = autoBeginRecord;
	}

	/**
	 * 询问医生最短时长 单位分钟 
	 */
	public int getAskMinTime() {
		return askMinTime;
	}

	/**
	 * 询问医生最短时长 单位分钟 
	 */
	public void setAskMinTime(int askMinTime) {
		this.askMinTime = askMinTime;
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

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoBeginAdvice", autoBeginAdvice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoAdviceTimeLong", autoAdviceTimeLong));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "fetalMoveTime", fetalMoveTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoBeginRecord", autoBeginRecord));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "askMinTime", askMinTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		return $list;
	}

	@Override
	public String toString() {
		return "AdviceSetting [id=" + id + ",autoBeginAdvice=" + autoBeginAdvice + ",autoAdviceTimeLong="
				+ autoAdviceTimeLong + ",fetalMoveTime=" + fetalMoveTime + ",autoBeginRecord=" + autoBeginRecord
				+ ",askMinTime=" + askMinTime + ",hospitalId=" + hospitalId + ", ]";
	}
}