package cn.ihealthbaby.hospital.admin.client.model;

import java.util.Date;
import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85 on 15/6/17.
 */
public class TestObject implements ApiMessage {

	private String id;

	/**
	 * 签名
	 * @see java.lang
	 * @see java.lang
	 */
	private boolean booleanValue;

	private int intValue;

	private long longValue;

	private float floatValue;

	private double doubleValue;

	private String stringValue;

	private byte[] bytesValue;

	private Date regDate;

	private List<java.lang.Boolean> booleanValueArray;

	private List<java.lang.Integer> intValueArray;

	private List<java.lang.Long> longValueArray;

	private List<java.lang.Float> floatValueArray;

	private List<java.lang.Double> doubleValueArray;

	private List<java.lang.String> stringValueArray;

	private List<java.util.Date> regDateArray;

	public TestObject() {
	}

	public TestObject(String id, boolean booleanValue, int intValue, long longValue, float floatValue,
			double doubleValue, String stringValue, byte[] bytesValue, Date regDate,
			List<java.lang.Boolean> booleanValueArray, List<java.lang.Integer> intValueArray,
			List<java.lang.Long> longValueArray, List<java.lang.Float> floatValueArray,
			List<java.lang.Double> doubleValueArray, List<java.lang.String> stringValueArray,
			List<java.util.Date> regDateArray) {
		this.id = id;
		this.booleanValue = booleanValue;
		this.intValue = intValue;
		this.longValue = longValue;
		this.floatValue = floatValue;
		this.doubleValue = doubleValue;
		this.stringValue = stringValue;
		this.bytesValue = bytesValue;
		this.regDate = regDate;
		this.booleanValueArray = booleanValueArray;
		this.intValueArray = intValueArray;
		this.longValueArray = longValueArray;
		this.floatValueArray = floatValueArray;
		this.doubleValueArray = doubleValueArray;
		this.stringValueArray = stringValueArray;
		this.regDateArray = regDateArray;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 签名
	 * @see java.lang
	 * @see java.lang
	 */
	public boolean getBooleanValue() {
		return booleanValue;
	}

	/**
	 * 签名
	 * @see java.lang
	 * @see java.lang
	 */
	public void setBooleanValue(boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public long getLongValue() {
		return longValue;
	}

	public void setLongValue(long longValue) {
		this.longValue = longValue;
	}

	public float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public byte[] getBytesValue() {
		return bytesValue;
	}

	public void setBytesValue(byte[] bytesValue) {
		this.bytesValue = bytesValue;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<java.lang.Boolean> getBooleanValueArray() {
		return booleanValueArray;
	}

	public void setBooleanValueArray(List<java.lang.Boolean> booleanValueArray) {
		this.booleanValueArray = booleanValueArray;
	}

	public List<java.lang.Integer> getIntValueArray() {
		return intValueArray;
	}

	public void setIntValueArray(List<java.lang.Integer> intValueArray) {
		this.intValueArray = intValueArray;
	}

	public List<java.lang.Long> getLongValueArray() {
		return longValueArray;
	}

	public void setLongValueArray(List<java.lang.Long> longValueArray) {
		this.longValueArray = longValueArray;
	}

	public List<java.lang.Float> getFloatValueArray() {
		return floatValueArray;
	}

	public void setFloatValueArray(List<java.lang.Float> floatValueArray) {
		this.floatValueArray = floatValueArray;
	}

	public List<java.lang.Double> getDoubleValueArray() {
		return doubleValueArray;
	}

	public void setDoubleValueArray(List<java.lang.Double> doubleValueArray) {
		this.doubleValueArray = doubleValueArray;
	}

	public List<java.lang.String> getStringValueArray() {
		return stringValueArray;
	}

	public void setStringValueArray(List<java.lang.String> stringValueArray) {
		this.stringValueArray = stringValueArray;
	}

	public List<java.util.Date> getRegDateArray() {
		return regDateArray;
	}

	public void setRegDateArray(List<java.util.Date> regDateArray) {
		this.regDateArray = regDateArray;
	}

	public void addBooleanValueArray(java.lang.Boolean booleanValueArray) {
		if (this.booleanValueArray == null) {
			this.booleanValueArray = new java.util.ArrayList<java.lang.Boolean>();
		}
		this.booleanValueArray.add(booleanValueArray);
	}

	public void addIntValueArray(java.lang.Integer intValueArray) {
		if (this.intValueArray == null) {
			this.intValueArray = new java.util.ArrayList<java.lang.Integer>();
		}
		this.intValueArray.add(intValueArray);
	}

	public void addLongValueArray(java.lang.Long longValueArray) {
		if (this.longValueArray == null) {
			this.longValueArray = new java.util.ArrayList<java.lang.Long>();
		}
		this.longValueArray.add(longValueArray);
	}

	public void addFloatValueArray(java.lang.Float floatValueArray) {
		if (this.floatValueArray == null) {
			this.floatValueArray = new java.util.ArrayList<java.lang.Float>();
		}
		this.floatValueArray.add(floatValueArray);
	}

	public void addDoubleValueArray(java.lang.Double doubleValueArray) {
		if (this.doubleValueArray == null) {
			this.doubleValueArray = new java.util.ArrayList<java.lang.Double>();
		}
		this.doubleValueArray.add(doubleValueArray);
	}

	public void addStringValueArray(java.lang.String stringValueArray) {
		if (this.stringValueArray == null) {
			this.stringValueArray = new java.util.ArrayList<java.lang.String>();
		}
		this.stringValueArray.add(stringValueArray);
	}

	public void addRegDateArray(java.util.Date regDateArray) {
		if (this.regDateArray == null) {
			this.regDateArray = new java.util.ArrayList<java.util.Date>();
		}
		this.regDateArray.add(regDateArray);
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (id != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "booleanValue", booleanValue));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "intValue", intValue));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "longValue", longValue));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "floatValue", floatValue));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "doubleValue", doubleValue));

		if (stringValue != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "stringValue", stringValue));
		}

		if (bytesValue != null) {
			$list.add(new SimpleImmutableEntry<String, Object>(parent + "bytesValue", bytesValue));
		}

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "regDate", regDate));

		if (booleanValueArray != null && (!booleanValueArray.isEmpty())) {
			for (int i = 0; i < booleanValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "booleanValueArray", booleanValueArray
						.get(i)));
			}
		}

		if (intValueArray != null && (!intValueArray.isEmpty())) {
			for (int i = 0; i < intValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "intValueArray", intValueArray.get(i)));
			}
		}

		if (longValueArray != null && (!longValueArray.isEmpty())) {
			for (int i = 0; i < longValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "longValueArray", longValueArray.get(i)));
			}
		}

		if (floatValueArray != null && (!floatValueArray.isEmpty())) {
			for (int i = 0; i < floatValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "floatValueArray", floatValueArray.get(i)));
			}
		}

		if (doubleValueArray != null && (!doubleValueArray.isEmpty())) {
			for (int i = 0; i < doubleValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "doubleValueArray", doubleValueArray.get(i)));
			}
		}

		if (stringValueArray != null && (!stringValueArray.isEmpty())) {
			for (int i = 0; i < stringValueArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "stringValueArray", stringValueArray.get(i)));
			}
		}

		if (regDateArray != null && (!regDateArray.isEmpty())) {
			for (int i = 0; i < regDateArray.size(); i++) {
				$list.add(new SimpleImmutableEntry<String, Object>(parent + "regDateArray", regDateArray.get(i)));
			}
		}

		return $list;
	}

	@Override
	public String toString() {
		return "TestObject [id=" + id + ",booleanValue=" + booleanValue + ",intValue=" + intValue + ",longValue="
				+ longValue + ",floatValue=" + floatValue + ",doubleValue=" + doubleValue + ",stringValue="
				+ stringValue + ",bytesValue=" + bytesValue + ",regDate=" + regDate + ",booleanValueArray="
				+ booleanValueArray + ",intValueArray=" + intValueArray + ",longValueArray=" + longValueArray
				+ ",floatValueArray=" + floatValueArray + ",doubleValueArray=" + doubleValueArray
				+ ",stringValueArray=" + stringValueArray + ",regDateArray=" + regDateArray + ", ]";
	}
}