package cn.ihealthbaby.hospital.admin.client.model;

import java.util.List;
import cn.ihealthbaby.hospital.admin.client.ApiMessage;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * 
 */
public class PageData<T extends ApiMessage> implements ApiMessage {

	private int count;

	private int page;

	private int pageSize;

	private List<T> value;

	public PageData() {
	}

	public PageData(int count, int page, int pageSize, List<T> value) {
		this.count = count;
		this.page = page;
		this.pageSize = pageSize;
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getValue() {
		return value;
	}

	public void setValue(List<T> value) {
		this.value = value;
	}

	public void addValue(T value) {
		if (this.value == null) {
			this.value = new java.util.ArrayList<T>();
		}
		this.value.add(value);
	}

	@Override
	public List<Entry<String, Object>> encode(String parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "count", count));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "page", page));

		$list.add(new SimpleImmutableEntry<String, Object>(parent + "pageSize", pageSize));

		if (value != null && (!value.isEmpty())) {
			for (int i = 0; i < value.size(); i++) {
				value.get(i).encode(parent + "value" + "[" + i + "].", $list);
			}
		}

		return $list;
	}

	@Override
	public String toString() {
		return "PageData [count=" + count + ",page=" + page + ",pageSize=" + pageSize + ",value=" + value + ", ]";
	}
}