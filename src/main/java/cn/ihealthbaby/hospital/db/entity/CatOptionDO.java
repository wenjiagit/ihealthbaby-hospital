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

public class CatOptionDO extends EntityObject<CatOptionDO, CatOptionDO.Key>{

	private long id;
	/**选项名*/
	private String catOptionName;
	/**选项含义*/
	private String catOptionDetail;
	/**医院id*/
	private Long hospitalId;
	/**优先级 0无1低2中3高*/
	private Integer level;

	public static class Key implements KeyObject<CatOptionDO, CatOptionDO.Key>{
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
			return "CatOption[id:"+ id+ "]";
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
				return "CatOption[id:"+ id+ "]";
			}
		};
	}


	public CatOptionDO() {
    }

	public CatOptionDO(String catOptionName,String catOptionDetail,Long hospitalId,Integer level) {
		this.catOptionName = catOptionName;
		this.catOptionDetail = catOptionDetail;
		this.hospitalId = hospitalId;
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		changeProperty("id",id);
	}

	/**
	 * 选项名
	 **/
	public String getCatOptionName() {
		return catOptionName;
	}

	/**
	 * 选项名
	 **/
	public void setCatOptionName(String catOptionName) {
		this.catOptionName = catOptionName;
		changeProperty("catOptionName",catOptionName);
	}

	/**
	 * 选项含义
	 **/
	public String getCatOptionDetail() {
		return catOptionDetail;
	}

	/**
	 * 选项含义
	 **/
	public void setCatOptionDetail(String catOptionDetail) {
		this.catOptionDetail = catOptionDetail;
		changeProperty("catOptionDetail",catOptionDetail);
	}

	/**
	 * 医院id
	 **/
	public Long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 医院id
	 **/
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
		changeProperty("hospitalId",hospitalId);
	}

	/**
	 * 优先级 0无1低2中3高
	 **/
	public Integer getLevel() {
		return level;
	}

	/**
	 * 优先级 0无1低2中3高
	 **/
	public void setLevel(Integer level) {
		this.level = level;
		changeProperty("level",level);
	}

	@Override
	public String toString() {
		return "CatOption[id:"+ id+",catOptionName:"+ (catOptionName == null ?"null":catOptionName.substring(0, Math.min(catOptionName.length(), 64)))+",catOptionDetail:"+ (catOptionDetail == null ?"null":catOptionDetail.substring(0, Math.min(catOptionDetail.length(), 64)))+",hospitalId:"+ hospitalId+",level:"+ level+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<CatOptionDO ,Key>{
		public static final String DB_TABLE_NAME = "cat_option";

		public static final String ID_DB_NAME = "id";
		public static final String CAT_OPTION_NAME_DB_NAME = "cat_option_name";
		public static final String CAT_OPTION_DETAIL_DB_NAME = "cat_option_detail";
		public static final String HOSPITAL_ID_DB_NAME = "hospital_id";
		public static final String LEVEL_DB_NAME = "level";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `cat_option` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `cat_option` WHERE `id`=?";
		}

		@Override
		public int setPreparedStatement(CatOptionDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			ps.setObject(i++, t.getCatOptionName());
			ps.setObject(i++, t.getCatOptionDetail());
			ps.setObject(i++, t.getHospitalId());
			ps.setObject(i++, t.getLevel());
			return i;
		}

		@Override
        public int setAllPreparedStatement(CatOptionDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getId());
        	ps.setObject(i++, t.getCatOptionName());
        	ps.setObject(i++, t.getCatOptionDetail());
        	ps.setObject(i++, t.getHospitalId());
        	ps.setObject(i++, t.getLevel());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(CatOptionDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `cat_option` (`cat_option_name`,`cat_option_detail`,`hospital_id`,`level`) VALUES (?,?,?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `cat_option` (`id`,`cat_option_name`,`cat_option_detail`,`hospital_id`,`level`) VALUES (?,?,?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `cat_option` (`cat_option_name`,`cat_option_detail`,`hospital_id`,`level`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?,?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `cat_option` SET `cat_option_name`=?,`cat_option_detail`=?,`hospital_id`=?,`level`=? WHERE `id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `cat_option` WHERE `id`=? ORDER BY `id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `cat_option`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `cat_option` ORDER BY `id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `cat_option` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `cat_option` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<CatOptionDO> getRowMapper(){
			return new RowMapper<CatOptionDO>() {
				@Override
				public CatOptionDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					CatOptionDO o=new CatOptionDO();
					o.id = rs.getLong("id");
					o.catOptionName = rs.getString("cat_option_name");
					o.catOptionDetail = rs.getString("cat_option_detail");
					o.hospitalId = rs.getLong("hospital_id");
					o.level = rs.getInt("level");
					return o;
				}
			};
		}

		@Override public <C extends CatOptionDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setId(rs.getLong("id"));
						o.setCatOptionName(rs.getString("cat_option_name"));
						o.setCatOptionDetail(rs.getString("cat_option_detail"));
						o.setHospitalId(rs.getLong("hospital_id"));
						o.setLevel(rs.getInt("level"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
