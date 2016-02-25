package cn.ihealthbaby.hospital.admin.client.collecton;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * api的list集合,用于封装list数据
 * @author  zuoge85 on 15/8/11.
 */
public class ApiList<T extends ApiMessage> implements ApiMessage {

	private List<T> list;

	public ApiList() {
	}

	public ApiList(List<T> list) {
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void addList(T list) {
		if (this.list == null) {
			this.list = new java.util.ArrayList<T>();
		}
		this.list.add(list);
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		if (list != null && (!list.isEmpty())) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).encode(parent + "list" + "[" + i + "].", $list);
			}
		}

		return $list;
	}

	@Override
	public String toString() {
		return "ApiList [list=" + list + ", ]";
	}
}