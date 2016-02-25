package  cn.ihealthbaby.hospital.db.entity;

import java.beans.Transient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.isnowfox.core.dao.EntityObject;
import com.isnowfox.core.dao.KeyObject;
import com.isnowfox.core.dao.TableInfo;

public class SysPermissionDO extends EntityObject<SysPermissionDO, SysPermissionDO.Key>{

	/**资源id*/
	private long id;
	/**资源名称*/
	private String permissionName;
	/**资源类型（菜单:1，按钮:2）*/
	private Integer permissionType;
	/**资源key(唯一值)*/
	private String permissionKey;
	/**资源url*/
	private String permissionUrl;
	/**图标*/
	private String permissionIcon;
	/**权重*/
	private Integer weight;
	/**是否显示（1:显示 0：不显示）*/
	private boolean sidebar;
	/**备注*/
	private String remarks;
	/**医院是否显示 0：不显示 1：显示*/
	private Boolean display;

	public static class Key implements KeyObject<SysPermissionDO, SysPermissionDO.Key>{
    	private long id;

		public Key() {
   		}

		public Key(long id) {
			this.id = id;
		}

		@JsonIgnore
		@Transient
		@Override
		public Object[] getQueryParams() {
			return new Object[]{
				getId()
			};
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}


		@Override
		public ThisTableInfo getTableInfo() {
			return TABLE_INFO;
		}

		@Override
		public String toString() {
			return "SysPermission[id:"+ id+ "]";
		}
	}

	@Override
	public Key getKey() {
		return new Key() {

			public long getId() {
				return id;
			}

			@Override
			public String toString() {
				return "SysPermission[id:"+ id+ "]";
			}
		};
	}


	public SysPermissionDO() {
    }

	public SysPermissionDO(String permissionName,Integer permissionType,String permissionKey,String permissionUrl,String permissionIcon,Integer weight,boolean sidebar,String remarks,Boolean display) {
		this.permissionName = permissionName;
		this.permissionType = permissionType;
		this.permissionKey = permissionKey;
		this.permissionUrl = permissionUrl;
		this.permissionIcon = permissionIcon;
		this.weight = weight;
		this.sidebar = sidebar;
		this.remarks = remarks;
		this.display = display;
	}

	/**
	 * 资源id
	 **/
	public long getId() {
		return id;
	}

	/**
	 * 资源id
	 **/
	public void setId(long id) {
		this.id = id;
		changeProperty("id",id);
	}

	/**
	 * 资源名称
	 **/
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * 资源名称
	 **/
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
		changeProperty("permissionName",permissionName);
	}

	/**
	 * 资源类型（菜单:1，按钮:2）
	 **/
	public Integer getPermissionType() {
		return permissionType;
	}

	/**
	 * 资源类型（菜单:1，按钮:2）
	 **/
	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
		changeProperty("permissionType",permissionType);
	}

	/**
	 * 资源key(唯一值)
	 **/
	public String getPermissionKey() {
		return permissionKey;
	}

	/**
	 * 资源key(唯一值)
	 **/
	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
		changeProperty("permissionKey",permissionKey);
	}

	/**
	 * 资源url
	 **/
	public String getPermissionUrl() {
		return permissionUrl;
	}

	/**
	 * 资源url
	 **/
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
		changeProperty("permissionUrl",permissionUrl);
	}

	/**
	 * 图标
	 **/
	public String getPermissionIcon() {
		return permissionIcon;
	}

	/**
	 * 图标
	 **/
	public void setPermissionIcon(String permissionIcon) {
		this.permissionIcon = permissionIcon;
		changeProperty("permissionIcon",permissionIcon);
	}

	/**
	 * 权重
	 **/
	public Integer getWeight() {
		return weight;
	}

	/**
	 * 权重
	 **/
	public void setWeight(Integer weight) {
		this.weight = weight;
		changeProperty("weight",weight);
	}

	/**
	 * 是否显示（1:显示 0：不显示）
	 **/
	public boolean getSidebar() {
		return sidebar;
	}

	/**
	 * 是否显示（1:显示 0：不显示）
	 **/
	public void setSidebar(boolean sidebar) {
		this.sidebar = sidebar;
		changeProperty("sidebar",sidebar);
	}

	/**
	 * 备注
	 **/
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注
	 **/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
		changeProperty("remarks",remarks);
	}

	/**
	 * 医院是否显示 0：不显示 1：显示
	 **/
	public Boolean getDisplay() {
		return display;
	}

	/**
	 * 医院是否显示 0：不显示 1：显示
	 **/
	public void setDisplay(Boolean display) {
		this.display = display;
		changeProperty("display",display);
	}

	@Override
	public String toString() {
		return "SysPermission[id:"+ id+",permissionName:"+ (permissionName == null ?"null":permissionName.substring(0, Math.min(permissionName.length(), 64)))+",permissionType:"+ permissionType+",permissionKey:"+ (permissionKey == null ?"null":permissionKey.substring(0, Math.min(permissionKey.length(), 64)))+",permissionUrl:"+ (permissionUrl == null ?"null":permissionUrl.substring(0, Math.min(permissionUrl.length(), 64)))+",permissionIcon:"+ (permissionIcon == null ?"null":permissionIcon.substring(0, Math.min(permissionIcon.length(), 64)))+",weight:"+ weight+",sidebar:"+ sidebar+",remarks:"+ (remarks == null ?"null":remarks.substring(0, Math.min(remarks.length(), 64)))+",display:"+ display+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<SysPermissionDO ,Key>{
		public static final String DB_TABLE_NAME = "sys_permission";

		public static final String ID_DB_NAME = "id";
		public static final String PERMISSION_NAME_DB_NAME = "permission_name";
		public static final String PERMISSION_TYPE_DB_NAME = "permission_type";
		public static final String PERMISSION_KEY_DB_NAME = "permission_key";
		public static final String PERMISSION_URL_DB_NAME = "permission_url";
		public static final String PERMISSION_ICON_DB_NAME = "permission_icon";
		public static final String WEIGHT_DB_NAME = "weight";
		public static final String SIDEBAR_DB_NAME = "sidebar";
		public static final String REMARKS_DB_NAME = "remarks";
		public static final String DISPLAY_DB_NAME = "display";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `sys_permission` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `sys_permission` WHERE `id`=?";
		}

		@Override
		public int setPreparedStatement(SysPermissionDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			ps.setObject(i++, t.getPermissionName());
			ps.setObject(i++, t.getPermissionType());
			if(isSetUnique){
				ps.setObject(i++, t.getPermissionKey());
			}
			ps.setObject(i++, t.getPermissionUrl());
			ps.setObject(i++, t.getPermissionIcon());
			ps.setObject(i++, t.getWeight());
			ps.setObject(i++, t.getSidebar());
			ps.setObject(i++, t.getRemarks());
			ps.setObject(i++, t.getDisplay());
			return i;
		}

		@Override
        public int setAllPreparedStatement(SysPermissionDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getId());
        	ps.setObject(i++, t.getPermissionName());
        	ps.setObject(i++, t.getPermissionType());
        	ps.setObject(i++, t.getPermissionKey());
        	ps.setObject(i++, t.getPermissionUrl());
        	ps.setObject(i++, t.getPermissionIcon());
        	ps.setObject(i++, t.getWeight());
        	ps.setObject(i++, t.getSidebar());
        	ps.setObject(i++, t.getRemarks());
        	ps.setObject(i++, t.getDisplay());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(SysPermissionDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `sys_permission` (`permission_name`,`permission_type`,`permission_key`,`permission_url`,`permission_icon`,`weight`,`sidebar`,`remarks`,`display`) VALUES (?,?,?,?,?,?,?,?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `sys_permission` (`id`,`permission_name`,`permission_type`,`permission_key`,`permission_url`,`permission_icon`,`weight`,`sidebar`,`remarks`,`display`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `sys_permission` (`permission_name`,`permission_type`,`permission_key`,`permission_url`,`permission_icon`,`weight`,`sidebar`,`remarks`,`display`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?,?,?,?,?,?,?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `sys_permission` SET `permission_name`=?,`permission_type`=?,`permission_url`=?,`permission_icon`=?,`weight`=?,`sidebar`=?,`remarks`=?,`display`=? WHERE `id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `sys_permission` WHERE `id`=? ORDER BY `id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `sys_permission`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `sys_permission` ORDER BY `id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `sys_permission` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `sys_permission` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<SysPermissionDO> getRowMapper(){
			return new RowMapper<SysPermissionDO>() {
				@Override
				public SysPermissionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysPermissionDO o=new SysPermissionDO();
					o.id = rs.getLong("id");
					o.permissionName = rs.getString("permission_name");
					o.permissionType = rs.getInt("permission_type");
					o.permissionKey = rs.getString("permission_key");
					o.permissionUrl = rs.getString("permission_url");
					o.permissionIcon = rs.getString("permission_icon");
					o.weight = rs.getInt("weight");
					o.sidebar = rs.getBoolean("sidebar");
					o.remarks = rs.getString("remarks");
					o.display = rs.getBoolean("display");
					return o;
				}
			};
		}

		@Override public <C extends SysPermissionDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setId(rs.getLong("id"));
						o.setPermissionName(rs.getString("permission_name"));
						o.setPermissionType(rs.getInt("permission_type"));
						o.setPermissionKey(rs.getString("permission_key"));
						o.setPermissionUrl(rs.getString("permission_url"));
						o.setPermissionIcon(rs.getString("permission_icon"));
						o.setWeight(rs.getInt("weight"));
						o.setSidebar(rs.getBoolean("sidebar"));
						o.setRemarks(rs.getString("remarks"));
						o.setDisplay(rs.getBoolean("display"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
