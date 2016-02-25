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

public class ReportTempletDO extends EntityObject<ReportTempletDO, ReportTempletDO.Key>{

	private long id;
	/**模板名称*/
	private String templetName;

	public static class Key implements KeyObject<ReportTempletDO, ReportTempletDO.Key>{
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
			return "ReportTemplet[id:"+ id+ "]";
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
				return "ReportTemplet[id:"+ id+ "]";
			}
		};
	}


	public ReportTempletDO() {
    }

	public ReportTempletDO(String templetName) {
		this.templetName = templetName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		changeProperty("id",id);
	}

	/**
	 * 模板名称
	 **/
	public String getTempletName() {
		return templetName;
	}

	/**
	 * 模板名称
	 **/
	public void setTempletName(String templetName) {
		this.templetName = templetName;
		changeProperty("templetName",templetName);
	}

	@Override
	public String toString() {
		return "ReportTemplet[id:"+ id+",templetName:"+ (templetName == null ?"null":templetName.substring(0, Math.min(templetName.length(), 64)))+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<ReportTempletDO ,Key>{
		public static final String DB_TABLE_NAME = "report_templet";

		public static final String ID_DB_NAME = "id";
		public static final String TEMPLETNAME_DB_NAME = "templetName";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `report_templet` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `report_templet` WHERE `id`=?";
		}

		@Override
		public int setPreparedStatement(ReportTempletDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			ps.setObject(i++, t.getTempletName());
			return i;
		}

		@Override
        public int setAllPreparedStatement(ReportTempletDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getId());
        	ps.setObject(i++, t.getTempletName());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(ReportTempletDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `report_templet` (`templetName`) VALUES (?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `report_templet` (`id`,`templetName`) VALUES (?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `report_templet` (`templetName`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `report_templet` SET `templetName`=? WHERE `id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `report_templet` WHERE `id`=? ORDER BY `id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `report_templet`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `report_templet` ORDER BY `id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `report_templet` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `report_templet` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<ReportTempletDO> getRowMapper(){
			return new RowMapper<ReportTempletDO>() {
				@Override
				public ReportTempletDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					ReportTempletDO o=new ReportTempletDO();
					o.id = rs.getLong("id");
					o.templetName = rs.getString("templetName");
					return o;
				}
			};
		}

		@Override public <C extends ReportTempletDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setId(rs.getLong("id"));
						o.setTempletName(rs.getString("templetName"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
