package cn.ihealthbaby.hospital.admin.client.form;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85 on 15/10/19.
 */
public class SyncAdviceDataForm implements ApiMessage {

	private long newServiceId;

	private long oldId;

	/**
	 * 监护的类型0 院内, 1 院外
	 */
	private int type;

	/**
	 * 主键id
	 */
	private int id;

	/**
	 * 用户id
	 */
	private int userid;

	/**
	 * 服务id
	 */
	private int service_id;

	/**
	 * 设备sn
	 */
	private String serialnum;

	/**
	 * 测试时间
	 */
	private String jiancetime;

	/**
	 * 孕周
	 */
	private String yunzhou;

	/**
	 * 监测时长
	 */
	private String jianceshichang;

	/**
	 * 胎音路径
	 */
	private String taiyin;

	/**
	 * 医院id
	 */
	private int hospitalid;

	/**
	 * 医生id
	 */
	private int doctorid;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 监护编号
	 */
	private int index_num;

	/**
	 * 基线率
	 */
	private String jixianlv;

	/**
	 * 基线类型
	 */
	private int jixian;

	/**
	 * 基线变异
	 */
	private String jixianbianyi;

	/**
	 * 加速周期
	 */
	private String jiasutimes;

	/**
	 * 加速幅度
	 */
	private String jiasuzhenfu;

	/**
	 * 加速次数
	 */
	private String jiansu;

	/**
	 * 减速幅度
	 */
	private String jiansuzhenfu;

	/**
	 * 减速时长
	 */
	private String jiansutimes;

	/**
	 * 晚减速次数
	 */
	private String wanjiansu;

	/**
	 * 晚减速幅度
	 */
	private String wanjiansuzhenfu;

	/**
	 * 晚减速时长
	 */
	private String wanjiansutimes;

	/**
	 * 胎儿平均心率
	 */
	private String babyxinly;

	/**
	 * 最大心率
	 */
	private String maxxinlv;

	/**
	 * 最小心率
	 */
	private String minxinlv;

	/**
	 * 是否正弦
	 */
	private int is_zhengxuan;

	/**
	 * nst结果
	 */
	private int nst_result;

	/**
	 * cat结果
	 */
	private String cat_result;

	/**
	 * 胎动次数
	 */
	private String taidongcishu;

	/**
	 * 评分
	 */
	private String pingfen;

	/**
	 * 变异周期
	 */
	private String bianyizhouqi;

	/**
	 * 减速次数
	 */
	private String jiasu;

	/**
	 * 是否进行nst计算
	 */
	private int is_nst;

	/**
	 * json数据处理暂存数据
	 */
	private String newdata;

	private String withoutdata;

	private String changdata;

	private String duandata;

	private String taidongjiasutime;

	private String taidongjiasufudu;

	private String jiansuzhouqi;

	private String wanjiansuzhouqi;

	private String doctorpinyin;

	private int super_id;

	private String chanjianhao;

	private String yuchanqi;

	private String lianxifangshi;

	private String remark;

	private String doctorname;

	private String flag;

	private String name;

	private double questiontime;

	private String question;

	private String reply;

	private String replytime;

	/**
	 * 数据
	 */
	private String data;

	public SyncAdviceDataForm() {
	}

	public SyncAdviceDataForm(long newServiceId, long oldId, int type, int id, int userid, int service_id,
			String serialnum, String jiancetime, String yunzhou, String jianceshichang, String taiyin, int hospitalid,
			int doctorid, String status, int index_num, String jixianlv, int jixian, String jixianbianyi,
			String jiasutimes, String jiasuzhenfu, String jiansu, String jiansuzhenfu, String jiansutimes,
			String wanjiansu, String wanjiansuzhenfu, String wanjiansutimes, String babyxinly, String maxxinlv,
			String minxinlv, int is_zhengxuan, int nst_result, String cat_result, String taidongcishu, String pingfen,
			String bianyizhouqi, String jiasu, int is_nst, String newdata, String withoutdata, String changdata,
			String duandata, String taidongjiasutime, String taidongjiasufudu, String jiansuzhouqi,
			String wanjiansuzhouqi, String doctorpinyin, int super_id, String chanjianhao, String yuchanqi,
			String lianxifangshi, String remark, String doctorname, String flag, String name, double questiontime,
			String question, String reply, String replytime, String data) {
		this.newServiceId = newServiceId;
		this.oldId = oldId;
		this.type = type;
		this.id = id;
		this.userid = userid;
		this.service_id = service_id;
		this.serialnum = serialnum;
		this.jiancetime = jiancetime;
		this.yunzhou = yunzhou;
		this.jianceshichang = jianceshichang;
		this.taiyin = taiyin;
		this.hospitalid = hospitalid;
		this.doctorid = doctorid;
		this.status = status;
		this.index_num = index_num;
		this.jixianlv = jixianlv;
		this.jixian = jixian;
		this.jixianbianyi = jixianbianyi;
		this.jiasutimes = jiasutimes;
		this.jiasuzhenfu = jiasuzhenfu;
		this.jiansu = jiansu;
		this.jiansuzhenfu = jiansuzhenfu;
		this.jiansutimes = jiansutimes;
		this.wanjiansu = wanjiansu;
		this.wanjiansuzhenfu = wanjiansuzhenfu;
		this.wanjiansutimes = wanjiansutimes;
		this.babyxinly = babyxinly;
		this.maxxinlv = maxxinlv;
		this.minxinlv = minxinlv;
		this.is_zhengxuan = is_zhengxuan;
		this.nst_result = nst_result;
		this.cat_result = cat_result;
		this.taidongcishu = taidongcishu;
		this.pingfen = pingfen;
		this.bianyizhouqi = bianyizhouqi;
		this.jiasu = jiasu;
		this.is_nst = is_nst;
		this.newdata = newdata;
		this.withoutdata = withoutdata;
		this.changdata = changdata;
		this.duandata = duandata;
		this.taidongjiasutime = taidongjiasutime;
		this.taidongjiasufudu = taidongjiasufudu;
		this.jiansuzhouqi = jiansuzhouqi;
		this.wanjiansuzhouqi = wanjiansuzhouqi;
		this.doctorpinyin = doctorpinyin;
		this.super_id = super_id;
		this.chanjianhao = chanjianhao;
		this.yuchanqi = yuchanqi;
		this.lianxifangshi = lianxifangshi;
		this.remark = remark;
		this.doctorname = doctorname;
		this.flag = flag;
		this.name = name;
		this.questiontime = questiontime;
		this.question = question;
		this.reply = reply;
		this.replytime = replytime;
		this.data = data;
	}

	public long getNewServiceId() {
		return newServiceId;
	}

	public void setNewServiceId(long newServiceId) {
		this.newServiceId = newServiceId;
	}

	public long getOldId() {
		return oldId;
	}

	public void setOldId(long oldId) {
		this.oldId = oldId;
	}

	/**
	 * 监护的类型0 院内, 1 院外
	 */
	public int getType() {
		return type;
	}

	/**
	 * 监护的类型0 院内, 1 院外
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 主键id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 用户id
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * 用户id
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}

	/**
	 * 服务id
	 */
	public int getService_id() {
		return service_id;
	}

	/**
	 * 服务id
	 */
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	/**
	 * 设备sn
	 */
	public String getSerialnum() {
		return serialnum;
	}

	/**
	 * 设备sn
	 */
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	/**
	 * 测试时间
	 */
	public String getJiancetime() {
		return jiancetime;
	}

	/**
	 * 测试时间
	 */
	public void setJiancetime(String jiancetime) {
		this.jiancetime = jiancetime;
	}

	/**
	 * 孕周
	 */
	public String getYunzhou() {
		return yunzhou;
	}

	/**
	 * 孕周
	 */
	public void setYunzhou(String yunzhou) {
		this.yunzhou = yunzhou;
	}

	/**
	 * 监测时长
	 */
	public String getJianceshichang() {
		return jianceshichang;
	}

	/**
	 * 监测时长
	 */
	public void setJianceshichang(String jianceshichang) {
		this.jianceshichang = jianceshichang;
	}

	/**
	 * 胎音路径
	 */
	public String getTaiyin() {
		return taiyin;
	}

	/**
	 * 胎音路径
	 */
	public void setTaiyin(String taiyin) {
		this.taiyin = taiyin;
	}

	/**
	 * 医院id
	 */
	public int getHospitalid() {
		return hospitalid;
	}

	/**
	 * 医院id
	 */
	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}

	/**
	 * 医生id
	 */
	public int getDoctorid() {
		return doctorid;
	}

	/**
	 * 医生id
	 */
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	/**
	 * 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 监护编号
	 */
	public int getIndex_num() {
		return index_num;
	}

	/**
	 * 监护编号
	 */
	public void setIndex_num(int index_num) {
		this.index_num = index_num;
	}

	/**
	 * 基线率
	 */
	public String getJixianlv() {
		return jixianlv;
	}

	/**
	 * 基线率
	 */
	public void setJixianlv(String jixianlv) {
		this.jixianlv = jixianlv;
	}

	/**
	 * 基线类型
	 */
	public int getJixian() {
		return jixian;
	}

	/**
	 * 基线类型
	 */
	public void setJixian(int jixian) {
		this.jixian = jixian;
	}

	/**
	 * 基线变异
	 */
	public String getJixianbianyi() {
		return jixianbianyi;
	}

	/**
	 * 基线变异
	 */
	public void setJixianbianyi(String jixianbianyi) {
		this.jixianbianyi = jixianbianyi;
	}

	/**
	 * 加速周期
	 */
	public String getJiasutimes() {
		return jiasutimes;
	}

	/**
	 * 加速周期
	 */
	public void setJiasutimes(String jiasutimes) {
		this.jiasutimes = jiasutimes;
	}

	/**
	 * 加速幅度
	 */
	public String getJiasuzhenfu() {
		return jiasuzhenfu;
	}

	/**
	 * 加速幅度
	 */
	public void setJiasuzhenfu(String jiasuzhenfu) {
		this.jiasuzhenfu = jiasuzhenfu;
	}

	/**
	 * 加速次数
	 */
	public String getJiansu() {
		return jiansu;
	}

	/**
	 * 加速次数
	 */
	public void setJiansu(String jiansu) {
		this.jiansu = jiansu;
	}

	/**
	 * 减速幅度
	 */
	public String getJiansuzhenfu() {
		return jiansuzhenfu;
	}

	/**
	 * 减速幅度
	 */
	public void setJiansuzhenfu(String jiansuzhenfu) {
		this.jiansuzhenfu = jiansuzhenfu;
	}

	/**
	 * 减速时长
	 */
	public String getJiansutimes() {
		return jiansutimes;
	}

	/**
	 * 减速时长
	 */
	public void setJiansutimes(String jiansutimes) {
		this.jiansutimes = jiansutimes;
	}

	/**
	 * 晚减速次数
	 */
	public String getWanjiansu() {
		return wanjiansu;
	}

	/**
	 * 晚减速次数
	 */
	public void setWanjiansu(String wanjiansu) {
		this.wanjiansu = wanjiansu;
	}

	/**
	 * 晚减速幅度
	 */
	public String getWanjiansuzhenfu() {
		return wanjiansuzhenfu;
	}

	/**
	 * 晚减速幅度
	 */
	public void setWanjiansuzhenfu(String wanjiansuzhenfu) {
		this.wanjiansuzhenfu = wanjiansuzhenfu;
	}

	/**
	 * 晚减速时长
	 */
	public String getWanjiansutimes() {
		return wanjiansutimes;
	}

	/**
	 * 晚减速时长
	 */
	public void setWanjiansutimes(String wanjiansutimes) {
		this.wanjiansutimes = wanjiansutimes;
	}

	/**
	 * 胎儿平均心率
	 */
	public String getBabyxinly() {
		return babyxinly;
	}

	/**
	 * 胎儿平均心率
	 */
	public void setBabyxinly(String babyxinly) {
		this.babyxinly = babyxinly;
	}

	/**
	 * 最大心率
	 */
	public String getMaxxinlv() {
		return maxxinlv;
	}

	/**
	 * 最大心率
	 */
	public void setMaxxinlv(String maxxinlv) {
		this.maxxinlv = maxxinlv;
	}

	/**
	 * 最小心率
	 */
	public String getMinxinlv() {
		return minxinlv;
	}

	/**
	 * 最小心率
	 */
	public void setMinxinlv(String minxinlv) {
		this.minxinlv = minxinlv;
	}

	/**
	 * 是否正弦
	 */
	public int getIs_zhengxuan() {
		return is_zhengxuan;
	}

	/**
	 * 是否正弦
	 */
	public void setIs_zhengxuan(int is_zhengxuan) {
		this.is_zhengxuan = is_zhengxuan;
	}

	/**
	 * nst结果
	 */
	public int getNst_result() {
		return nst_result;
	}

	/**
	 * nst结果
	 */
	public void setNst_result(int nst_result) {
		this.nst_result = nst_result;
	}

	/**
	 * cat结果
	 */
	public String getCat_result() {
		return cat_result;
	}

	/**
	 * cat结果
	 */
	public void setCat_result(String cat_result) {
		this.cat_result = cat_result;
	}

	/**
	 * 胎动次数
	 */
	public String getTaidongcishu() {
		return taidongcishu;
	}

	/**
	 * 胎动次数
	 */
	public void setTaidongcishu(String taidongcishu) {
		this.taidongcishu = taidongcishu;
	}

	/**
	 * 评分
	 */
	public String getPingfen() {
		return pingfen;
	}

	/**
	 * 评分
	 */
	public void setPingfen(String pingfen) {
		this.pingfen = pingfen;
	}

	/**
	 * 变异周期
	 */
	public String getBianyizhouqi() {
		return bianyizhouqi;
	}

	/**
	 * 变异周期
	 */
	public void setBianyizhouqi(String bianyizhouqi) {
		this.bianyizhouqi = bianyizhouqi;
	}

	/**
	 * 减速次数
	 */
	public String getJiasu() {
		return jiasu;
	}

	/**
	 * 减速次数
	 */
	public void setJiasu(String jiasu) {
		this.jiasu = jiasu;
	}

	/**
	 * 是否进行nst计算
	 */
	public int getIs_nst() {
		return is_nst;
	}

	/**
	 * 是否进行nst计算
	 */
	public void setIs_nst(int is_nst) {
		this.is_nst = is_nst;
	}

	/**
	 * json数据处理暂存数据
	 */
	public String getNewdata() {
		return newdata;
	}

	/**
	 * json数据处理暂存数据
	 */
	public void setNewdata(String newdata) {
		this.newdata = newdata;
	}

	public String getWithoutdata() {
		return withoutdata;
	}

	public void setWithoutdata(String withoutdata) {
		this.withoutdata = withoutdata;
	}

	public String getChangdata() {
		return changdata;
	}

	public void setChangdata(String changdata) {
		this.changdata = changdata;
	}

	public String getDuandata() {
		return duandata;
	}

	public void setDuandata(String duandata) {
		this.duandata = duandata;
	}

	public String getTaidongjiasutime() {
		return taidongjiasutime;
	}

	public void setTaidongjiasutime(String taidongjiasutime) {
		this.taidongjiasutime = taidongjiasutime;
	}

	public String getTaidongjiasufudu() {
		return taidongjiasufudu;
	}

	public void setTaidongjiasufudu(String taidongjiasufudu) {
		this.taidongjiasufudu = taidongjiasufudu;
	}

	public String getJiansuzhouqi() {
		return jiansuzhouqi;
	}

	public void setJiansuzhouqi(String jiansuzhouqi) {
		this.jiansuzhouqi = jiansuzhouqi;
	}

	public String getWanjiansuzhouqi() {
		return wanjiansuzhouqi;
	}

	public void setWanjiansuzhouqi(String wanjiansuzhouqi) {
		this.wanjiansuzhouqi = wanjiansuzhouqi;
	}

	public String getDoctorpinyin() {
		return doctorpinyin;
	}

	public void setDoctorpinyin(String doctorpinyin) {
		this.doctorpinyin = doctorpinyin;
	}

	public int getSuper_id() {
		return super_id;
	}

	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}

	public String getChanjianhao() {
		return chanjianhao;
	}

	public void setChanjianhao(String chanjianhao) {
		this.chanjianhao = chanjianhao;
	}

	public String getYuchanqi() {
		return yuchanqi;
	}

	public void setYuchanqi(String yuchanqi) {
		this.yuchanqi = yuchanqi;
	}

	public String getLianxifangshi() {
		return lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuestiontime() {
		return questiontime;
	}

	public void setQuestiontime(double questiontime) {
		this.questiontime = questiontime;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	/**
	 * 数据
	 */
	public String getData() {
		return data;
	}

	/**
	 * 数据
	 */
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "newServiceId", newServiceId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "oldId", oldId));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "type", type));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "userid", userid));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "service_id", service_id));

		if (serialnum != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "serialnum", serialnum));
		}

		if (jiancetime != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiancetime", jiancetime));
		}

		if (yunzhou != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "yunzhou", yunzhou));
		}

		if (jianceshichang != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jianceshichang", jianceshichang));
		}

		if (taiyin != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "taiyin", taiyin));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hospitalid", hospitalid));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorid", doctorid));

		if (status != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "status", status));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "index_num", index_num));

		if (jixianlv != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jixianlv", jixianlv));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "jixian", jixian));

		if (jixianbianyi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jixianbianyi", jixianbianyi));
		}

		if (jiasutimes != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiasutimes", jiasutimes));
		}

		if (jiasuzhenfu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiasuzhenfu", jiasuzhenfu));
		}

		if (jiansu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiansu", jiansu));
		}

		if (jiansuzhenfu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiansuzhenfu", jiansuzhenfu));
		}

		if (jiansutimes != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiansutimes", jiansutimes));
		}

		if (wanjiansu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "wanjiansu", wanjiansu));
		}

		if (wanjiansuzhenfu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "wanjiansuzhenfu", wanjiansuzhenfu));
		}

		if (wanjiansutimes != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "wanjiansutimes", wanjiansutimes));
		}

		if (babyxinly != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "babyxinly", babyxinly));
		}

		if (maxxinlv != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "maxxinlv", maxxinlv));
		}

		if (minxinlv != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "minxinlv", minxinlv));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "is_zhengxuan", is_zhengxuan));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "nst_result", nst_result));

		if (cat_result != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "cat_result", cat_result));
		}

		if (taidongcishu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "taidongcishu", taidongcishu));
		}

		if (pingfen != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "pingfen", pingfen));
		}

		if (bianyizhouqi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "bianyizhouqi", bianyizhouqi));
		}

		if (jiasu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiasu", jiasu));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "is_nst", is_nst));

		if (newdata != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "newdata", newdata));
		}

		if (withoutdata != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "withoutdata", withoutdata));
		}

		if (changdata != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "changdata", changdata));
		}

		if (duandata != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "duandata", duandata));
		}

		if (taidongjiasutime != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "taidongjiasutime", taidongjiasutime));
		}

		if (taidongjiasufudu != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "taidongjiasufudu", taidongjiasufudu));
		}

		if (jiansuzhouqi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "jiansuzhouqi", jiansuzhouqi));
		}

		if (wanjiansuzhouqi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "wanjiansuzhouqi", wanjiansuzhouqi));
		}

		if (doctorpinyin != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorpinyin", doctorpinyin));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "super_id", super_id));

		if (chanjianhao != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "chanjianhao", chanjianhao));
		}

		if (yuchanqi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "yuchanqi", yuchanqi));
		}

		if (lianxifangshi != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "lianxifangshi", lianxifangshi));
		}

		if (remark != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "remark", remark));
		}

		if (doctorname != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "doctorname", doctorname));
		}

		if (flag != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "flag", flag));
		}

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "questiontime", questiontime));

		if (question != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "question", question));
		}

		if (reply != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "reply", reply));
		}

		if (replytime != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "replytime", replytime));
		}

		if (data != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "data", data));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "SyncAdviceDataForm [newServiceId=" + newServiceId + ",oldId=" + oldId + ",type=" + type + ",id=" + id
				+ ",userid=" + userid + ",service_id=" + service_id + ",serialnum=" + serialnum + ",jiancetime="
				+ jiancetime + ",yunzhou=" + yunzhou + ",jianceshichang=" + jianceshichang + ",taiyin=" + taiyin
				+ ",hospitalid=" + hospitalid + ",doctorid=" + doctorid + ",status=" + status + ",index_num="
				+ index_num + ",jixianlv=" + jixianlv + ",jixian=" + jixian + ",jixianbianyi=" + jixianbianyi
				+ ",jiasutimes=" + jiasutimes + ",jiasuzhenfu=" + jiasuzhenfu + ",jiansu=" + jiansu + ",jiansuzhenfu="
				+ jiansuzhenfu + ",jiansutimes=" + jiansutimes + ",wanjiansu=" + wanjiansu + ",wanjiansuzhenfu="
				+ wanjiansuzhenfu + ",wanjiansutimes=" + wanjiansutimes + ",babyxinly=" + babyxinly + ",maxxinlv="
				+ maxxinlv + ",minxinlv=" + minxinlv + ",is_zhengxuan=" + is_zhengxuan + ",nst_result=" + nst_result
				+ ",cat_result=" + cat_result + ",taidongcishu=" + taidongcishu + ",pingfen=" + pingfen
				+ ",bianyizhouqi=" + bianyizhouqi + ",jiasu=" + jiasu + ",is_nst=" + is_nst + ",newdata=" + newdata
				+ ",withoutdata=" + withoutdata + ",changdata=" + changdata + ",duandata=" + duandata
				+ ",taidongjiasutime=" + taidongjiasutime + ",taidongjiasufudu=" + taidongjiasufudu + ",jiansuzhouqi="
				+ jiansuzhouqi + ",wanjiansuzhouqi=" + wanjiansuzhouqi + ",doctorpinyin=" + doctorpinyin + ",super_id="
				+ super_id + ",chanjianhao=" + chanjianhao + ",yuchanqi=" + yuchanqi + ",lianxifangshi="
				+ lianxifangshi + ",remark=" + remark + ",doctorname=" + doctorname + ",flag=" + flag + ",name=" + name
				+ ",questiontime=" + questiontime + ",question=" + question + ",reply=" + reply + ",replytime="
				+ replytime + ",data=" + data + ", ]";
	}
}