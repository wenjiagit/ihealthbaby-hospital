package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 监护数据表单
 * @author  gwc
 */
public class AdviceSettingForm implements ApiMessage {

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
	 * 自动开始检测的最大时间 单位 秒 
	 */
	private int autoBeginAdviceMax;

	/**
	 * 询问医生最短时长 单位分钟 
	 */
	private int askMinTime;

	/**
	 * 报警阀值设置 以-分割,代表正常范围 
	 */
	private String alarmHeartrateLimit;

	/**
	 * 医院id 
	 */
	private long hospitalId;

	public AdviceSettingForm() {
	}

	public AdviceSettingForm(int autoBeginAdvice, int autoAdviceTimeLong, int fetalMoveTime, int autoBeginAdviceMax,
			int askMinTime, String alarmHeartrateLimit, long hospitalId) {
		this.autoBeginAdvice = autoBeginAdvice;
		this.autoAdviceTimeLong = autoAdviceTimeLong;
		this.fetalMoveTime = fetalMoveTime;
		this.autoBeginAdviceMax = autoBeginAdviceMax;
		this.askMinTime = askMinTime;
		this.alarmHeartrateLimit = alarmHeartrateLimit;
		this.hospitalId = hospitalId;
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
	 * 自动开始检测的最大时间 单位 秒 
	 */
	public int getAutoBeginAdviceMax() {
		return autoBeginAdviceMax;
	}

	/**
	 * 自动开始检测的最大时间 单位 秒 
	 */
	public void setAutoBeginAdviceMax(int autoBeginAdviceMax) {
		this.autoBeginAdviceMax = autoBeginAdviceMax;
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
	 * 报警阀值设置 以-分割,代表正常范围 
	 */
	public String getAlarmHeartrateLimit() {
		return alarmHeartrateLimit;
	}

	/**
	 * 报警阀值设置 以-分割,代表正常范围 
	 */
	public void setAlarmHeartrateLimit(String alarmHeartrateLimit) {
		this.alarmHeartrateLimit = alarmHeartrateLimit;
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

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoBeginAdvice", autoBeginAdvice));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoAdviceTimeLong", autoAdviceTimeLong));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "fetalMoveTime", fetalMoveTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "autoBeginAdviceMax", autoBeginAdviceMax));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "askMinTime", askMinTime));

		if (alarmHeartrateLimit != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "alarmHeartrateLimit", alarmHeartrateLimit));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		return $list;
	}

	@Override
	public String toString() {
		return "AdviceSettingForm [autoBeginAdvice=" + autoBeginAdvice + ",autoAdviceTimeLong=" + autoAdviceTimeLong
				+ ",fetalMoveTime=" + fetalMoveTime + ",autoBeginAdviceMax=" + autoBeginAdviceMax + ",askMinTime="
				+ askMinTime + ",alarmHeartrateLimit=" + alarmHeartrateLimit + ",hospitalId=" + hospitalId + ", ]";
	}
}