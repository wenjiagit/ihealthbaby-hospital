package cn.ihealthbaby.hospital.admin.client.form;

import java.util.Date;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * Created by qiang on 2015/8/6.
 */
public class UserDO implements ApiMessage {

	/**
	 * 名称允许重复
	 */
	private String name;

	/**
	 * 拼音简写
	 */
	private String pinyin;

	/**
	 * 手机电话
	 */
	private String mobile;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 预产期
	 */
	private Date deliveryTime;

	/**
	 * 是否已开通服务 0 未开通,1已开通
	 */
	private boolean hasService;

	public UserDO() {
	}

	public UserDO(String name, String pinyin, String mobile, Date birthday, Date createTime, Date deliveryTime,
			boolean hasService) {
		this.name = name;
		this.pinyin = pinyin;
		this.mobile = mobile;
		this.birthday = birthday;
		this.createTime = createTime;
		this.deliveryTime = deliveryTime;
		this.hasService = hasService;
	}

	/**
	 * 名称允许重复
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称允许重复
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 拼音简写
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * 拼音简写
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * 手机电话
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 手机电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 生日
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 预产期
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * 预产期
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * 是否已开通服务 0 未开通,1已开通
	 */
	public boolean getHasService() {
		return hasService;
	}

	/**
	 * 是否已开通服务 0 未开通,1已开通
	 */
	public void setHasService(boolean hasService) {
		this.hasService = hasService;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "name", name));
		}

		if (pinyin != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "pinyin", pinyin));
		}

		if (mobile != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "mobile", mobile));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "birthday", birthday));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "createTime", createTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "deliveryTime", deliveryTime));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "hasService", hasService));

		return $list;
	}

	@Override
	public String toString() {
		return "UserDO [name=" + name + ",pinyin=" + pinyin + ",mobile=" + mobile + ",birthday=" + birthday
				+ ",createTime=" + createTime + ",deliveryTime=" + deliveryTime + ",hasService=" + hasService + ", ]";
	}
}