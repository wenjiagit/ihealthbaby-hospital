package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  qiang on 2015/8/31.
 * jinliqiang@ihbaby.com
 */
public class AdviceDataForm implements ApiMessage {

	/**
	 * 用户id
	 */
	private int replyResult;

	private long userId;

	/**
	 * 监护id
	 */
	private long adviceId;

	/**
	 * 询问id
	 */
	private long askId;

	/**
	 * 回复内容
	 */
	private String replyContext;

	/**
	 * 回复时间
	 */
	private Date replyTime;

	/**
	 * 回复的类型  1  院方医生回复  2  远程值班医生回复
	 */
	private int replyType;

	/**
	 * 回复医生id
	 */
	private long doctorId;

	/**
	 * 医院id
	 */
	private long hospitalId;

	private int babyHeartRate;

	/**
	 * 最大心率
	 */
	private int maxHeartRate;

	/**
	 * 最小心率
	 */
	private int minHeartRate;

	/**
	 * 基线率
	 */
	private int baselineRate;

	/**
	 * 基线类型 0 平直,1 窄幅,2 平直-窄幅,3 窄幅-平直 ,4 波浪, 5 跳跃
	 */
	private int baselineType;

	/**
	 * 基线变异率
	 */
	private int baselineVariability;

	/**
	 * 胎动次数
	 */
	private int fetalMoveCount;

	/**
	 * 加速时长  单位秒
	 */
	private int speedupDuration;

	/**
	 * 加速次数
	 */
	private int speedupCount;

	/**
	 * 加速的幅度 
	 */
	private int speedupRange;

	/**
	 * 变异周期
	 */
	private int variabilityCycle;

	/**
	 * 减速次数
	 */
	private int decelerateCount;

	/**
	 * 减速时长
	 */
	private int decelerateDuration;

	/**
	 * 减速幅度
	 */
	private int decelerateRange;

	/**
	 * 晚减速次数
	 */
	private int lateDecelerateCount;

	/**
	 * 晚减速时长
	 */
	private int lateDecelerateDuration;

	/**
	 * 晚减速幅度
	 */
	private int lateDecelerateRange;

	/**
	 * 是否是正弦曲线 0  不是 1 是
	 */
	private boolean isSin;

	private int nstResult;

	/**
	 * cat结果  1  Cat.I,2  Cat.II , 3  Cat.III 
	 */
	private int catResult;

	public AdviceDataForm() {
	}

	public AdviceDataForm(int replyResult, long userId, long adviceId, long askId, String replyContext, Date replyTime,
			int replyType, long doctorId, long hospitalId, int babyHeartRate, int maxHeartRate, int minHeartRate,
			int baselineRate, int baselineType, int baselineVariability, int fetalMoveCount, int speedupDuration,
			int speedupCount, int speedupRange, int variabilityCycle, int decelerateCount, int decelerateDuration,
			int decelerateRange, int lateDecelerateCount, int lateDecelerateDuration, int lateDecelerateRange,
			boolean isSin, int nstResult, int catResult) {
		this.replyResult = replyResult;
		this.userId = userId;
		this.adviceId = adviceId;
		this.askId = askId;
		this.replyContext = replyContext;
		this.replyTime = replyTime;
		this.replyType = replyType;
		this.doctorId = doctorId;
		this.hospitalId = hospitalId;
		this.babyHeartRate = babyHeartRate;
		this.maxHeartRate = maxHeartRate;
		this.minHeartRate = minHeartRate;
		this.baselineRate = baselineRate;
		this.baselineType = baselineType;
		this.baselineVariability = baselineVariability;
		this.fetalMoveCount = fetalMoveCount;
		this.speedupDuration = speedupDuration;
		this.speedupCount = speedupCount;
		this.speedupRange = speedupRange;
		this.variabilityCycle = variabilityCycle;
		this.decelerateCount = decelerateCount;
		this.decelerateDuration = decelerateDuration;
		this.decelerateRange = decelerateRange;
		this.lateDecelerateCount = lateDecelerateCount;
		this.lateDecelerateDuration = lateDecelerateDuration;
		this.lateDecelerateRange = lateDecelerateRange;
		this.isSin = isSin;
		this.nstResult = nstResult;
		this.catResult = catResult;
	}

	/**
	 * 用户id
	 */
	public int getReplyResult() {
		return replyResult;
	}

	/**
	 * 用户id
	 */
	public void setReplyResult(int replyResult) {
		this.replyResult = replyResult;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * 监护id
	 */
	public long getAdviceId() {
		return adviceId;
	}

	/**
	 * 监护id
	 */
	public void setAdviceId(long adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * 询问id
	 */
	public long getAskId() {
		return askId;
	}

	/**
	 * 询问id
	 */
	public void setAskId(long askId) {
		this.askId = askId;
	}

	/**
	 * 回复内容
	 */
	public String getReplyContext() {
		return replyContext;
	}

	/**
	 * 回复内容
	 */
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}

	/**
	 * 回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}

	/**
	 * 回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	/**
	 * 回复的类型  1  院方医生回复  2  远程值班医生回复
	 */
	public int getReplyType() {
		return replyType;
	}

	/**
	 * 回复的类型  1  院方医生回复  2  远程值班医生回复
	 */
	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}

	/**
	 * 回复医生id
	 */
	public long getDoctorId() {
		return doctorId;
	}

	/**
	 * 回复医生id
	 */
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
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

	public int getBabyHeartRate() {
		return babyHeartRate;
	}

	public void setBabyHeartRate(int babyHeartRate) {
		this.babyHeartRate = babyHeartRate;
	}

	/**
	 * 最大心率
	 */
	public int getMaxHeartRate() {
		return maxHeartRate;
	}

	/**
	 * 最大心率
	 */
	public void setMaxHeartRate(int maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}

	/**
	 * 最小心率
	 */
	public int getMinHeartRate() {
		return minHeartRate;
	}

	/**
	 * 最小心率
	 */
	public void setMinHeartRate(int minHeartRate) {
		this.minHeartRate = minHeartRate;
	}

	/**
	 * 基线率
	 */
	public int getBaselineRate() {
		return baselineRate;
	}

	/**
	 * 基线率
	 */
	public void setBaselineRate(int baselineRate) {
		this.baselineRate = baselineRate;
	}

	/**
	 * 基线类型 0 平直,1 窄幅,2 平直-窄幅,3 窄幅-平直 ,4 波浪, 5 跳跃
	 */
	public int getBaselineType() {
		return baselineType;
	}

	/**
	 * 基线类型 0 平直,1 窄幅,2 平直-窄幅,3 窄幅-平直 ,4 波浪, 5 跳跃
	 */
	public void setBaselineType(int baselineType) {
		this.baselineType = baselineType;
	}

	/**
	 * 基线变异率
	 */
	public int getBaselineVariability() {
		return baselineVariability;
	}

	/**
	 * 基线变异率
	 */
	public void setBaselineVariability(int baselineVariability) {
		this.baselineVariability = baselineVariability;
	}

	/**
	 * 胎动次数
	 */
	public int getFetalMoveCount() {
		return fetalMoveCount;
	}

	/**
	 * 胎动次数
	 */
	public void setFetalMoveCount(int fetalMoveCount) {
		this.fetalMoveCount = fetalMoveCount;
	}

	/**
	 * 加速时长  单位秒
	 */
	public int getSpeedupDuration() {
		return speedupDuration;
	}

	/**
	 * 加速时长  单位秒
	 */
	public void setSpeedupDuration(int speedupDuration) {
		this.speedupDuration = speedupDuration;
	}

	/**
	 * 加速次数
	 */
	public int getSpeedupCount() {
		return speedupCount;
	}

	/**
	 * 加速次数
	 */
	public void setSpeedupCount(int speedupCount) {
		this.speedupCount = speedupCount;
	}

	/**
	 * 加速的幅度 
	 */
	public int getSpeedupRange() {
		return speedupRange;
	}

	/**
	 * 加速的幅度 
	 */
	public void setSpeedupRange(int speedupRange) {
		this.speedupRange = speedupRange;
	}

	/**
	 * 变异周期
	 */
	public int getVariabilityCycle() {
		return variabilityCycle;
	}

	/**
	 * 变异周期
	 */
	public void setVariabilityCycle(int variabilityCycle) {
		this.variabilityCycle = variabilityCycle;
	}

	/**
	 * 减速次数
	 */
	public int getDecelerateCount() {
		return decelerateCount;
	}

	/**
	 * 减速次数
	 */
	public void setDecelerateCount(int decelerateCount) {
		this.decelerateCount = decelerateCount;
	}

	/**
	 * 减速时长
	 */
	public int getDecelerateDuration() {
		return decelerateDuration;
	}

	/**
	 * 减速时长
	 */
	public void setDecelerateDuration(int decelerateDuration) {
		this.decelerateDuration = decelerateDuration;
	}

	/**
	 * 减速幅度
	 */
	public int getDecelerateRange() {
		return decelerateRange;
	}

	/**
	 * 减速幅度
	 */
	public void setDecelerateRange(int decelerateRange) {
		this.decelerateRange = decelerateRange;
	}

	/**
	 * 晚减速次数
	 */
	public int getLateDecelerateCount() {
		return lateDecelerateCount;
	}

	/**
	 * 晚减速次数
	 */
	public void setLateDecelerateCount(int lateDecelerateCount) {
		this.lateDecelerateCount = lateDecelerateCount;
	}

	/**
	 * 晚减速时长
	 */
	public int getLateDecelerateDuration() {
		return lateDecelerateDuration;
	}

	/**
	 * 晚减速时长
	 */
	public void setLateDecelerateDuration(int lateDecelerateDuration) {
		this.lateDecelerateDuration = lateDecelerateDuration;
	}

	/**
	 * 晚减速幅度
	 */
	public int getLateDecelerateRange() {
		return lateDecelerateRange;
	}

	/**
	 * 晚减速幅度
	 */
	public void setLateDecelerateRange(int lateDecelerateRange) {
		this.lateDecelerateRange = lateDecelerateRange;
	}

	/**
	 * 是否是正弦曲线 0  不是 1 是
	 */
	public boolean getIsSin() {
		return isSin;
	}

	/**
	 * 是否是正弦曲线 0  不是 1 是
	 */
	public void setIsSin(boolean isSin) {
		this.isSin = isSin;
	}

	public int getNstResult() {
		return nstResult;
	}

	public void setNstResult(int nstResult) {
		this.nstResult = nstResult;
	}

	/**
	 * cat结果  1  Cat.I,2  Cat.II , 3  Cat.III 
	 */
	public int getCatResult() {
		return catResult;
	}

	/**
	 * cat结果  1  Cat.I,2  Cat.II , 3  Cat.III 
	 */
	public void setCatResult(int catResult) {
		this.catResult = catResult;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "replyResult", replyResult));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "userId", userId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "adviceId", adviceId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "askId", askId));

		if (replyContext != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "replyContext", replyContext));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "replyTime", replyTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "replyType", replyType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorId", doctorId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalId", hospitalId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "babyHeartRate", babyHeartRate));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "maxHeartRate", maxHeartRate));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "minHeartRate", minHeartRate));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "baselineRate", baselineRate));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "baselineType", baselineType));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "baselineVariability", baselineVariability));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "fetalMoveCount", fetalMoveCount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "speedupDuration", speedupDuration));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "speedupCount", speedupCount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "speedupRange", speedupRange));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "variabilityCycle", variabilityCycle));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "decelerateCount", decelerateCount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "decelerateDuration", decelerateDuration));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "decelerateRange", decelerateRange));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "lateDecelerateCount", lateDecelerateCount));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "lateDecelerateDuration", lateDecelerateDuration));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "lateDecelerateRange", lateDecelerateRange));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "isSin", isSin));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "nstResult", nstResult));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "catResult", catResult));

		return $list;
	}

	@Override
	public String toString() {
		return "AdviceDataForm [replyResult=" + replyResult + ",userId=" + userId + ",adviceId=" + adviceId + ",askId="
				+ askId + ",replyContext=" + replyContext + ",replyTime=" + replyTime + ",replyType=" + replyType
				+ ",doctorId=" + doctorId + ",hospitalId=" + hospitalId + ",babyHeartRate=" + babyHeartRate
				+ ",maxHeartRate=" + maxHeartRate + ",minHeartRate=" + minHeartRate + ",baselineRate=" + baselineRate
				+ ",baselineType=" + baselineType + ",baselineVariability=" + baselineVariability + ",fetalMoveCount="
				+ fetalMoveCount + ",speedupDuration=" + speedupDuration + ",speedupCount=" + speedupCount
				+ ",speedupRange=" + speedupRange + ",variabilityCycle=" + variabilityCycle + ",decelerateCount="
				+ decelerateCount + ",decelerateDuration=" + decelerateDuration + ",decelerateRange=" + decelerateRange
				+ ",lateDecelerateCount=" + lateDecelerateCount + ",lateDecelerateDuration=" + lateDecelerateDuration
				+ ",lateDecelerateRange=" + lateDecelerateRange + ",isSin=" + isSin + ",nstResult=" + nstResult
				+ ",catResult=" + catResult + ", ]";
	}
}