package cn.ihealthbaby.hospital.admin.client.model;

import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85 on 15/10/19.
 */
public class SyncResult implements ApiMessage {

	/**
	 * 是否创建
	 */
	private boolean create;

	/**
	 * 对应id
	 */
	private long id;

	public SyncResult() {
	}

	public SyncResult(boolean create, long id) {
		this.create = create;
		this.id = id;
	}

	/**
	 * 是否创建
	 */
	public boolean getCreate() {
		return create;
	}

	/**
	 * 是否创建
	 */
	public void setCreate(boolean create) {
		this.create = create;
	}

	/**
	 * 对应id
	 */
	public long getId() {
		return id;
	}

	/**
	 * 对应id
	 */
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "create", create));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "id", id));

		return $list;
	}

	@Override
	public String toString() {
		return "SyncResult [create=" + create + ",id=" + id + ", ]";
	}
}