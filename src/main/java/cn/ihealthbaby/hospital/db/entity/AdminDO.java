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

public class AdminDO extends EntityObject<AdminDO, AdminDO.Key>{

	private String name;
	private String password;
	private java.util.Date updateTime;
	private java.util.Date createTime;

	public static class Key implements KeyObject<AdminDO, AdminDO.Key>{
    	private String name;

		public Key() {
   		}

		public Key(String name) {
			this.name = name;
		}

		@JsonIgnore
		@Transient
		@Override
		public Object[] getQueryParams() {
			return new Object[]{
				getName()
			};
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}


		@Override
		public ThisTableInfo getTableInfo() {
			return TABLE_INFO;
		}

		@Override
		public String toString() {
			return "Admin[name:"+ name+ "]";
		}
	}

	@Override
	public Key getKey() {
		return new Key() {

			public String getName() {
				return name;
			}

			public void setName(String name) {
				AdminDO.this.name  = name;
				AdminDO.this.changeProperty("name",name);
			}

			@Override
			public String toString() {
				return "Admin[name:"+ name+ "]";
			}
		};
	}


	public AdminDO() {
    }

	public AdminDO(String name,String password,java.util.Date updateTime,java.util.Date createTime) {
		this.name = name;
		this.password = password;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changeProperty("name",name);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		changeProperty("password",password);
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
		changeProperty("updateTime",updateTime);
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
		changeProperty("createTime",createTime);
	}

	@Override
	public String toString() {
		return "Admin[name:"+ name+",password:"+ password+",updateTime:"+ updateTime+",createTime:"+ createTime+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<AdminDO ,Key>{
		public static final String DB_TABLE_NAME = "admin";

		public static final String NAME_DB_NAME = "name";
		public static final String PASSWORD_DB_NAME = "password";
		public static final String UPDATE_TIME_DB_NAME = "update_time";
		public static final String CREATE_TIME_DB_NAME = "create_time";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `admin` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `name`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `admin` WHERE `name`=?";
		}

		@Override
		public int setPreparedStatement(AdminDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			if(isSetUnique){
				ps.setObject(i++, t.getName());
			}
			ps.setObject(i++, t.getPassword());
			ps.setObject(i++, t.getUpdateTime());
			ps.setObject(i++, t.getCreateTime());
			return i;
		}

		@Override
        public int setAllPreparedStatement(AdminDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getName());
        	ps.setObject(i++, t.getPassword());
        	ps.setObject(i++, t.getUpdateTime());
        	ps.setObject(i++, t.getCreateTime());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(AdminDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getName());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getName());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `admin` (`name`,`password`,`update_time`,`create_time`) VALUES (?,?,?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `admin` (`name`,`password`,`update_time`,`create_time`) VALUES (?,?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `admin` (`name`,`password`,`update_time`,`create_time`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?,?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `admin` SET `password`=?,`update_time`=?,`create_time`=? WHERE `name`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `admin` WHERE `name`=? ORDER BY `name` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `admin`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `admin` ORDER BY `name` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `admin` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `admin` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `name` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<AdminDO> getRowMapper(){
			return new RowMapper<AdminDO>() {
				@Override
				public AdminDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminDO o=new AdminDO();
					o.name = rs.getString("name");
					o.password = rs.getString("password");
					o.updateTime = rs.getTimestamp("update_time");
					o.createTime = rs.getTimestamp("create_time");
					return o;
				}
			};
		}

		@Override public <C extends AdminDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setName(rs.getString("name"));
						o.setPassword(rs.getString("password"));
						o.setUpdateTime(rs.getTimestamp("update_time"));
						o.setCreateTime(rs.getTimestamp("create_time"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
