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

public class SysRoleDO extends EntityObject<SysRoleDO, SysRoleDO.Key>{

	/**角色id*/
	private long id;
	/**角色名*/
	private String roleName;
	/**医院id*/
	private long hospitalId;

	public static class Key implements KeyObject<SysRoleDO, SysRoleDO.Key>{
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
			return "SysRole[id:"+ id+ "]";
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
				return "SysRole[id:"+ id+ "]";
			}
		};
	}


	public SysRoleDO() {
    }

	public SysRoleDO(String roleName,long hospitalId) {
		this.roleName = roleName;
		this.hospitalId = hospitalId;
	}

	/**
	 * 角色id
	 **/
	public long getId() {
		return id;
	}

	/**
	 * 角色id
	 **/
	public void setId(long id) {
		this.id = id;
		changeProperty("id",id);
	}

	/**
	 * 角色名
	 **/
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 角色名
	 **/
	public void setRoleName(String roleName) {
		this.roleName = roleName;
		changeProperty("roleName",roleName);
	}

	/**
	 * 医院id
	 **/
	public long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院id
	 **/
	public void setHospitalId(long hospitalId) {
		this.hospitalId = hospitalId;
		changeProperty("hospitalId",hospitalId);
	}

	@Override
	public String toString() {
		return "SysRole[id:"+ id+",roleName:"+ (roleName == null ?"null":roleName.substring(0, Math.min(roleName.length(), 64)))+",hospitalId:"+ hospitalId+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<SysRoleDO ,Key>{
		public static final String DB_TABLE_NAME = "sys_role";

		public static final String ID_DB_NAME = "id";
		public static final String ROLE_NAME_DB_NAME = "role_name";
		public static final String HOSPITAL_ID_DB_NAME = "hospital_id";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `sys_role` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `sys_role` WHERE `id`=?";
		}

		@Override
		public int setPreparedStatement(SysRoleDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			if(isSetUnique){
				ps.setObject(i++, t.getRoleName());
			}
			ps.setObject(i++, t.getHospitalId());
			return i;
		}

		@Override
        public int setAllPreparedStatement(SysRoleDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getId());
        	ps.setObject(i++, t.getRoleName());
        	ps.setObject(i++, t.getHospitalId());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(SysRoleDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `sys_role` (`role_name`,`hospital_id`) VALUES (?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `sys_role` (`id`,`role_name`,`hospital_id`) VALUES (?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `sys_role` (`role_name`,`hospital_id`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `sys_role` SET `hospital_id`=? WHERE `id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `sys_role` WHERE `id`=? ORDER BY `id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `sys_role`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `sys_role` ORDER BY `id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `sys_role` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `sys_role` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<SysRoleDO> getRowMapper(){
			return new RowMapper<SysRoleDO>() {
				@Override
				public SysRoleDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysRoleDO o=new SysRoleDO();
					o.id = rs.getLong("id");
					o.roleName = rs.getString("role_name");
					o.hospitalId = rs.getLong("hospital_id");
					return o;
				}
			};
		}

		@Override public <C extends SysRoleDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setId(rs.getLong("id"));
						o.setRoleName(rs.getString("role_name"));
						o.setHospitalId(rs.getLong("hospital_id"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
