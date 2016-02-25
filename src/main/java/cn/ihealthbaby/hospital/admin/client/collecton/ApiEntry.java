package cn.ihealthbaby.hospital.admin.client.collecton;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85 on 15/10/19.
 */
public class ApiEntry<K extends ApiMessage, V extends ApiMessage> implements ApiMessage {

	private K key;

	private V value;

	public ApiEntry() {
	}

	public ApiEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (key != null) {
			key.encode(parent + "key.", $list);
		}

		if (value != null) {
			value.encode(parent + "value.", $list);
		}

		return $list;
	}

	@Override
	public String toString() {
		return "ApiEntry [key=" + key + ",value=" + value + ", ]";
	}
}