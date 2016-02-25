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

public class SysRolePermissionDO extends EntityObject<SysRolePermissionDO, SysRolePermissionDO.Key>{

	/**角色id*/
	private long roleId;
	/**资源id*/
	private long permissionId;

	public static class Key implements KeyObject<SysRolePermissionDO, SysRolePermissionDO.Key>{
    	private long roleId;
    	private long permissionId;

		public Key() {
   		}

		public Key(long roleId,long permissionId) {
			this.roleId = roleId;
			this.permissionId = permissionId;
		}

		@JsonIgnore
		@Transient
		@Override
		public Object[] getQueryParams() {
			return new Object[]{
				getRoleId(),
				getPermissionId()
			};
		}

		public long getRoleId() {
			return roleId;
		}
		public void setRoleId(long roleId) {
			this.roleId = roleId;
		}

		public long getPermissionId() {
			return permissionId;
		}
		public void setPermissionId(long permissionId) {
			this.permissionId = permissionId;
		}


		@Override
		public ThisTableInfo getTableInfo() {
			return TABLE_INFO;
		}

		@Override
		public String toString() {
			return "SysRolePermission[roleId:"+ roleId+",permissionId:"+ permissionId+ "]";
		}
	}

	@Override
	public Key getKey() {
		return new Key() {

			public long getRoleId() {
				return roleId;
			}

			public void setRoleId(long roleId) {
				SysRolePermissionDO.this.roleId  = roleId;
				SysRolePermissionDO.this.changeProperty("roleId",roleId);
			}

			public long getPermissionId() {
				return permissionId;
			}

			public void setPermissionId(long permissionId) {
				SysRolePermissionDO.this.permissionId  = permissionId;
				SysRolePermissionDO.this.changeProperty("permissionId",permissionId);
			}

			@Override
			public String toString() {
				return "SysRolePermission[roleId:"+ roleId+",permissionId:"+ permissionId+ "]";
			}
		};
	}


	public SysRolePermissionDO() {
    }

	public SysRolePermissionDO(long roleId,long permissionId) {
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	/**
	 * 角色id
	 **/
	public long getRoleId() {
		return roleId;
	}

	/**
	 * 角色id
	 **/
	public void setRoleId(long roleId) {
		this.roleId = roleId;
		changeProperty("roleId",roleId);
	}

	/**
	 * 资源id
	 **/
	public long getPermissionId() {
		return permissionId;
	}

	/**
	 * 资源id
	 **/
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
		changeProperty("permissionId",permissionId);
	}

	@Override
	public String toString() {
		return "SysRolePermission[roleId:"+ roleId+",permissionId:"+ permissionId+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<SysRolePermissionDO ,Key>{
		public static final String DB_TABLE_NAME = "sys_role_permission";

		public static final String ROLE_ID_DB_NAME = "role_id";
		public static final String PERMISSION_ID_DB_NAME = "permission_id";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `sys_role_permission` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `role_id`=? AND `permission_id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `sys_role_permission` WHERE `role_id`=? AND `permission_id`=?";
		}

		@Override
		public int setPreparedStatement(SysRolePermissionDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			if(isSetUnique){
				ps.setObject(i++, t.getRoleId());
			}
			if(isSetUnique){
				ps.setObject(i++, t.getPermissionId());
			}
			return i;
		}

		@Override
        public int setAllPreparedStatement(SysRolePermissionDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getRoleId());
        	ps.setObject(i++, t.getPermissionId());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(SysRolePermissionDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getRoleId());
			ps.setObject(i++, t.getPermissionId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getRoleId());
			ps.setObject(i++, k.getPermissionId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `sys_role_permission` (`role_id`,`permission_id`) VALUES (?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `sys_role_permission` (`role_id`,`permission_id`) VALUES (?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `sys_role_permission` (`role_id`,`permission_id`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `sys_role_permission` SET  WHERE `role_id`=? AND `permission_id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `sys_role_permission` WHERE `role_id`=? AND `permission_id`=? ORDER BY `role_id` DESC,`permission_id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `sys_role_permission`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `sys_role_permission` ORDER BY `role_id` DESC,`permission_id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `sys_role_permission` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `sys_role_permission` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `role_id` DESC,`permission_id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<SysRolePermissionDO> getRowMapper(){
			return new RowMapper<SysRolePermissionDO>() {
				@Override
				public SysRolePermissionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysRolePermissionDO o=new SysRolePermissionDO();
					o.roleId = rs.getLong("role_id");
					o.permissionId = rs.getLong("permission_id");
					return o;
				}
			};
		}

		@Override public <C extends SysRolePermissionDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setRoleId(rs.getLong("role_id"));
						o.setPermissionId(rs.getLong("permission_id"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
