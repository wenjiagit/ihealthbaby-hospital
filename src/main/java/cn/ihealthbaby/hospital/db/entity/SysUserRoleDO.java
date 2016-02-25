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

public class SysUserRoleDO extends EntityObject<SysUserRoleDO, SysUserRoleDO.Key>{

	/**用户id*/
	private long userId;
	/**角色id*/
	private long roleId;

	public static class Key implements KeyObject<SysUserRoleDO, SysUserRoleDO.Key>{
    	private long userId;
    	private long roleId;

		public Key() {
   		}

		public Key(long userId,long roleId) {
			this.userId = userId;
			this.roleId = roleId;
		}

		@JsonIgnore
		@Transient
		@Override
		public Object[] getQueryParams() {
			return new Object[]{
				getUserId(),
				getRoleId()
			};
		}

		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
		}

		public long getRoleId() {
			return roleId;
		}
		public void setRoleId(long roleId) {
			this.roleId = roleId;
		}


		@Override
		public ThisTableInfo getTableInfo() {
			return TABLE_INFO;
		}

		@Override
		public String toString() {
			return "SysUserRole[userId:"+ userId+",roleId:"+ roleId+ "]";
		}
	}

	@Override
	public Key getKey() {
		return new Key() {

			public long getUserId() {
				return userId;
			}

			public void setUserId(long userId) {
				SysUserRoleDO.this.userId  = userId;
				SysUserRoleDO.this.changeProperty("userId",userId);
			}

			public long getRoleId() {
				return roleId;
			}

			public void setRoleId(long roleId) {
				SysUserRoleDO.this.roleId  = roleId;
				SysUserRoleDO.this.changeProperty("roleId",roleId);
			}

			@Override
			public String toString() {
				return "SysUserRole[userId:"+ userId+",roleId:"+ roleId+ "]";
			}
		};
	}


	public SysUserRoleDO() {
    }

	public SysUserRoleDO(long userId,long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	/**
	 * 用户id
	 **/
	public long getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 **/
	public void setUserId(long userId) {
		this.userId = userId;
		changeProperty("userId",userId);
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

	@Override
	public String toString() {
		return "SysUserRole[userId:"+ userId+",roleId:"+ roleId+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<SysUserRoleDO ,Key>{
		public static final String DB_TABLE_NAME = "sys_user_role";

		public static final String USER_ID_DB_NAME = "user_id";
		public static final String ROLE_ID_DB_NAME = "role_id";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `sys_user_role` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `user_id`=? AND `role_id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `sys_user_role` WHERE `user_id`=? AND `role_id`=?";
		}

		@Override
		public int setPreparedStatement(SysUserRoleDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			if(isSetUnique){
				ps.setObject(i++, t.getUserId());
			}
			if(isSetUnique){
				ps.setObject(i++, t.getRoleId());
			}
			return i;
		}

		@Override
        public int setAllPreparedStatement(SysUserRoleDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getUserId());
        	ps.setObject(i++, t.getRoleId());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(SysUserRoleDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getUserId());
			ps.setObject(i++, t.getRoleId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getUserId());
			ps.setObject(i++, k.getRoleId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `sys_user_role` (`user_id`,`role_id`) VALUES (?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `sys_user_role` (`user_id`,`role_id`) VALUES (?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `sys_user_role` (`user_id`,`role_id`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `sys_user_role` SET  WHERE `user_id`=? AND `role_id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `sys_user_role` WHERE `user_id`=? AND `role_id`=? ORDER BY `user_id` DESC,`role_id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `sys_user_role`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `sys_user_role` ORDER BY `user_id` DESC,`role_id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `sys_user_role` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `sys_user_role` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `user_id` DESC,`role_id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<SysUserRoleDO> getRowMapper(){
			return new RowMapper<SysUserRoleDO>() {
				@Override
				public SysUserRoleDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysUserRoleDO o=new SysUserRoleDO();
					o.userId = rs.getLong("user_id");
					o.roleId = rs.getLong("role_id");
					return o;
				}
			};
		}

		@Override public <C extends SysUserRoleDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setUserId(rs.getLong("user_id"));
						o.setRoleId(rs.getLong("role_id"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
