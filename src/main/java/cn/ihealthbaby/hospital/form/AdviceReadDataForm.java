package cn.ihealthbaby.hospital.form;

/**
 * @author qiang on 2015/8/31.
 *         jinliqiang@ihbaby.com
 */
public class AdviceReadDataForm {
    private int replyResult;
    /**用户id*/
    private long userId;
    /**监护id*/
    private long adviceId;
    /**询问id*/
    private long askId;
    /**回复内容*/
    private String replyContext;
    /**回复医生id*/
    private long doctorId;
    /**医院id*/
    private long hospitalId;

    private int babyHeartRate;
    /**最大心率*/
    private int maxHeartRate;
    /**最小心率*/
    private int minHeartRate;
    /**基线率*/
    private int baselineRate;
    /**基线类型 0 平直,1 窄幅,2 平直-窄幅,3 窄幅-平直 ,4 波浪, 5 跳跃*/
    private int baselineType;
    /**基线变异率*/
    private int baselineVariability;
    /**胎动次数*/
    private int fetalMoveCount;
    /**加速时长  单位秒*/
    private int speedupDuration;
    /**加速次数*/
    private int speedupCount;
    /**加速的幅度 */
    private int speedupRange;
    /**变异周期*/
    private int variabilityCycle;
    /**减速次数*/
    private int decelerateCount;
    /**减速时长*/
    private int decelerateDuration;
    /**减速幅度*/
    private int decelerateRange;
    /**晚减速次数*/
    private int lateDecelerateCount;
    /**晚减速时长*/
    private int lateDecelerateDuration;
    /**晚减速幅度*/
    private int lateDecelerateRange;
    /**是否是正弦曲线 0  不是 1 是*/
    private boolean isSin;

    private int nstResult;
    /**cat结果  1  Cat.I,2  Cat.II , 3  Cat.III */
    private int catResult;

    public int getNstResult() {
        return nstResult;
    }

    public void setNstResult(int nstResult) {
        this.nstResult = nstResult;
    }

    public int getCatResult() {
        return catResult;
    }

    public void setCatResult(int catResult) {
        this.catResult = catResult;
    }

    public long getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(long adviceId) {
        this.adviceId = adviceId;
    }

    public long getAskId() {
        return askId;
    }

    public void setAskId(long askId) {
        this.askId = askId;
    }

    public String getReplyContext() {
        return replyContext;
    }

    public void setReplyContext(String replyContext) {
        this.replyContext = replyContext;
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

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getBabyHeartRate() {
        return babyHeartRate;
    }

    public void setBabyHeartRate(int babyHeartRate) {
        this.babyHeartRate = babyHeartRate;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(int maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public int getMinHeartRate() {
        return minHeartRate;
    }

    public void setMinHeartRate(int minHeartRate) {
        this.minHeartRate = minHeartRate;
    }

    public int getBaselineRate() {
        return baselineRate;
    }

    public void setBaselineRate(int baselineRate) {
        this.baselineRate = baselineRate;
    }

    public int getBaselineType() {
        return baselineType;
    }

    public void setBaselineType(int baselineType) {
        this.baselineType = baselineType;
    }

    public int getBaselineVariability() {
        return baselineVariability;
    }

    public void setBaselineVariability(int baselineVariability) {
        this.baselineVariability = baselineVariability;
    }

    public int getFetalMoveCount() {
        return fetalMoveCount;
    }

    public void setFetalMoveCount(int fetalMoveCount) {
        this.fetalMoveCount = fetalMoveCount;
    }

    public int getSpeedupDuration() {
        return speedupDuration;
    }

    public void setSpeedupDuration(int speedupDuration) {
        this.speedupDuration = speedupDuration;
    }

    public int getSpeedupCount() {
        return speedupCount;
    }

    public void setSpeedupCount(int speedupCount) {
        this.speedupCount = speedupCount;
    }

    public int getSpeedupRange() {
        return speedupRange;
    }

    public void setSpeedupRange(int speedupRange) {
        this.speedupRange = speedupRange;
    }

    public int getVariabilityCycle() {
        return variabilityCycle;
    }

    public void setVariabilityCycle(int variabilityCycle) {
        this.variabilityCycle = variabilityCycle;
    }

    public int getDecelerateCount() {
        return decelerateCount;
    }

    public void setDecelerateCount(int decelerateCount) {
        this.decelerateCount = decelerateCount;
    }

    public int getDecelerateDuration() {
        return decelerateDuration;
    }

    public void setDecelerateDuration(int decelerateDuration) {
        this.decelerateDuration = decelerateDuration;
    }

    public int getDecelerateRange() {
        return decelerateRange;
    }

    public void setDecelerateRange(int decelerateRange) {
        this.decelerateRange = decelerateRange;
    }

    public int getLateDecelerateCount() {
        return lateDecelerateCount;
    }

    public void setLateDecelerateCount(int lateDecelerateCount) {
        this.lateDecelerateCount = lateDecelerateCount;
    }

    public int getLateDecelerateDuration() {
        return lateDecelerateDuration;
    }

    public void setLateDecelerateDuration(int lateDecelerateDuration) {
        this.lateDecelerateDuration = lateDecelerateDuration;
    }

    public int getLateDecelerateRange() {
        return lateDecelerateRange;
    }

    public void setLateDecelerateRange(int lateDecelerateRange) {
        this.lateDecelerateRange = lateDecelerateRange;
    }

    public boolean getIsSin() {
        return isSin;
    }

    /**
     * 是否是正弦曲线 0  不是 1 是
     */
    public void setIsSin(boolean isSin) {
        this.isSin = isSin;
    }

    public int getReplyResult() {
        return replyResult;
    }

    public void setReplyResult(int replyResult) {
        this.replyResult = replyResult;
    }
}
