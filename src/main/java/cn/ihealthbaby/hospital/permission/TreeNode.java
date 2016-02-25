package cn.ihealthbaby.hospital.permission;

import java.util.List;

public class TreeNode {
	List<TreeNode> childNode;
	private String name;
	private int type;
	private long id;
	private String key;
	private String parent;
	private String remarks;

	
	public void setParent(String key) {
		if(key.contains(".")){
			String temp=key.substring(0,key.lastIndexOf("."));
			if(temp.contains(".")){
				this.parent = temp.substring(temp.lastIndexOf(".")+1, temp.length());
			}else{
				this.parent=temp;
			}
			
		}else{
			this.parent= null;
		}
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		if(key.contains(".")){
			
			this.key =key.substring(key.lastIndexOf(".")+1, key.length());
		}else{
			this.key= key;
		}
	}
	public List<TreeNode> getChildNode() {
		return childNode;
	}
	public void setChildNode(List<TreeNode> childNode) {
		this.childNode = childNode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParent(){
		return parent;
	}
}