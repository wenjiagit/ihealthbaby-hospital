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

public class LoginTokenDO extends EntityObject<LoginTokenDO, LoginTokenDO.Key>{

	private String token;
	private String name;
	private java.util.Date createDate;

	public static class Key implements KeyObject<LoginTokenDO, LoginTokenDO.Key>{
    	private String token;

		public Key() {
   		}

		public Key(String token) {
			this.token = token;
		}

		@JsonIgnore
		@Transient
		@Override
		public Object[] getQueryParams() {
			return new Object[]{
				getToken()
			};
		}

		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}


		@Override
		public ThisTableInfo getTableInfo() {
			return TABLE_INFO;
		}

		@Override
		public String toString() {
			return "LoginToken[token:"+ (token == null ?"null":token.substring(0, Math.min(token.length(), 64)))+ "]";
		}
	}

	@Override
	public Key getKey() {
		return new Key() {

			public String getToken() {
				return token;
			}

			public void setToken(String token) {
				LoginTokenDO.this.token  = token;
				LoginTokenDO.this.changeProperty("token",token);
			}

			@Override
			public String toString() {
				return "LoginToken[token:"+ (token == null ?"null":token.substring(0, Math.min(token.length(), 64)))+ "]";
			}
		};
	}


	public LoginTokenDO() {
    }

	public LoginTokenDO(String token,String name,java.util.Date createDate) {
		this.token = token;
		this.name = name;
		this.createDate = createDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
		changeProperty("token",token);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		changeProperty("name",name);
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
		changeProperty("createDate",createDate);
	}

	@Override
	public String toString() {
		return "LoginToken[token:"+ (token == null ?"null":token.substring(0, Math.min(token.length(), 64)))+",name:"+ (name == null ?"null":name.substring(0, Math.min(name.length(), 64)))+",createDate:"+ createDate+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<LoginTokenDO ,Key>{
		public static final String DB_TABLE_NAME = "login_token";

		public static final String TOKEN_DB_NAME = "token";
		public static final String NAME_DB_NAME = "name";
		public static final String CREATE_DATE_DB_NAME = "create_date";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `login_token` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `token`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `login_token` WHERE `token`=?";
		}

		@Override
		public int setPreparedStatement(LoginTokenDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			if(isSetUnique){
				ps.setObject(i++, t.getToken());
			}
			ps.setObject(i++, t.getName());
			ps.setObject(i++, t.getCreateDate());
			return i;
		}

		@Override
        public int setAllPreparedStatement(LoginTokenDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getToken());
        	ps.setObject(i++, t.getName());
        	ps.setObject(i++, t.getCreateDate());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(LoginTokenDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getToken());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getToken());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `login_token` (`token`,`name`,`create_date`) VALUES (?,?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `login_token` (`token`,`name`,`create_date`) VALUES (?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `login_token` (`token`,`name`,`create_date`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `login_token` SET `name`=?,`create_date`=? WHERE `token`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `login_token` WHERE `token`=? ORDER BY `token` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `login_token`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `login_token` ORDER BY `token` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `login_token` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `login_token` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `token` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<LoginTokenDO> getRowMapper(){
			return new RowMapper<LoginTokenDO>() {
				@Override
				public LoginTokenDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					LoginTokenDO o=new LoginTokenDO();
					o.token = rs.getString("token");
					o.name = rs.getString("name");
					o.createDate = rs.getTimestamp("create_date");
					return o;
				}
			};
		}

		@Override public <C extends LoginTokenDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setToken(rs.getString("token"));
						o.setName(rs.getString("name"));
						o.setCreateDate(rs.getTimestamp("create_date"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
