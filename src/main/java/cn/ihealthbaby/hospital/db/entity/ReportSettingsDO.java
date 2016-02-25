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

public class ReportSettingsDO extends EntityObject<ReportSettingsDO, ReportSettingsDO.Key>{

	/**id*/
	private long id;
	/**走纸速度*/
	private Integer paperspeed;
	/**打印报告显示设置 (0:不显示 1：显示)*/
	private Boolean reportPrintView;
	/**打印页cat显隐*/
	private Boolean reportPrintCatView;
	/**打印报告nst显示设置 (0:不显示 1：显示)*/
	private Boolean reportPrintNstView;
	/**签发页显示(0:不显示 1：显示)*/
	private Boolean signpageView;
	/**签发页cat显示(0:不显示 1：显示)*/
	private Boolean signpageCatView;
	/**签发页nst显示(0:不显示 1：显示)*/
	private Boolean signpageNstView;
	/**nst选项*/
	private Long nstOption;
	/**cat选项*/
	private Long catOption;
	/**所属医院*/
	private Long hospitalId;
	/**横轴刻度*/
	private Integer divisionX;
	/**纵轴刻度*/
	private Integer divisionY;
	/**缩放倍数*/
	private Double zoom;
	/**模板名*/
	private String template;

	public static class Key implements KeyObject<ReportSettingsDO, ReportSettingsDO.Key>{
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
			return "ReportSettings[id:"+ id+ "]";
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
				return "ReportSettings[id:"+ id+ "]";
			}
		};
	}


	public ReportSettingsDO() {
    }

	public ReportSettingsDO(Integer paperspeed,Boolean reportPrintView,Boolean reportPrintCatView,Boolean reportPrintNstView,Boolean signpageView,Boolean signpageCatView,Boolean signpageNstView,Long nstOption,Long catOption,Long hospitalId,Integer divisionX,Integer divisionY,Double zoom,String template) {
		this.paperspeed = paperspeed;
		this.reportPrintView = reportPrintView;
		this.reportPrintCatView = reportPrintCatView;
		this.reportPrintNstView = reportPrintNstView;
		this.signpageView = signpageView;
		this.signpageCatView = signpageCatView;
		this.signpageNstView = signpageNstView;
		this.nstOption = nstOption;
		this.catOption = catOption;
		this.hospitalId = hospitalId;
		this.divisionX = divisionX;
		this.divisionY = divisionY;
		this.zoom = zoom;
		this.template = template;
	}

	/**
	 * id
	 **/
	public long getId() {
		return id;
	}

	/**
	 * id
	 **/
	public void setId(long id) {
		this.id = id;
		changeProperty("id",id);
	}

	/**
	 * 走纸速度
	 **/
	public Integer getPaperspeed() {
		return paperspeed;
	}

	/**
	 * 走纸速度
	 **/
	public void setPaperspeed(Integer paperspeed) {
		this.paperspeed = paperspeed;
		changeProperty("paperspeed",paperspeed);
	}

	/**
	 * 打印报告显示设置 (0:不显示 1：显示)
	 **/
	public Boolean getReportPrintView() {
		return reportPrintView;
	}

	/**
	 * 打印报告显示设置 (0:不显示 1：显示)
	 **/
	public void setReportPrintView(Boolean reportPrintView) {
		this.reportPrintView = reportPrintView;
		changeProperty("reportPrintView",reportPrintView);
	}

	/**
	 * 打印页cat显隐
	 **/
	public Boolean getReportPrintCatView() {
		return reportPrintCatView;
	}

	/**
	 * 打印页cat显隐
	 **/
	public void setReportPrintCatView(Boolean reportPrintCatView) {
		this.reportPrintCatView = reportPrintCatView;
		changeProperty("reportPrintCatView",reportPrintCatView);
	}

	/**
	 * 打印报告nst显示设置 (0:不显示 1：显示)
	 **/
	public Boolean getReportPrintNstView() {
		return reportPrintNstView;
	}

	/**
	 * 打印报告nst显示设置 (0:不显示 1：显示)
	 **/
	public void setReportPrintNstView(Boolean reportPrintNstView) {
		this.reportPrintNstView = reportPrintNstView;
		changeProperty("reportPrintNstView",reportPrintNstView);
	}

	/**
	 * 签发页显示(0:不显示 1：显示)
	 **/
	public Boolean getSignpageView() {
		return signpageView;
	}

	/**
	 * 签发页显示(0:不显示 1：显示)
	 **/
	public void setSignpageView(Boolean signpageView) {
		this.signpageView = signpageView;
		changeProperty("signpageView",signpageView);
	}

	/**
	 * 签发页cat显示(0:不显示 1：显示)
	 **/
	public Boolean getSignpageCatView() {
		return signpageCatView;
	}

	/**
	 * 签发页cat显示(0:不显示 1：显示)
	 **/
	public void setSignpageCatView(Boolean signpageCatView) {
		this.signpageCatView = signpageCatView;
		changeProperty("signpageCatView",signpageCatView);
	}

	/**
	 * 签发页nst显示(0:不显示 1：显示)
	 **/
	public Boolean getSignpageNstView() {
		return signpageNstView;
	}

	/**
	 * 签发页nst显示(0:不显示 1：显示)
	 **/
	public void setSignpageNstView(Boolean signpageNstView) {
		this.signpageNstView = signpageNstView;
		changeProperty("signpageNstView",signpageNstView);
	}

	/**
	 * nst选项
	 **/
	public Long getNstOption() {
		return nstOption;
	}

	/**
	 * nst选项
	 **/
	public void setNstOption(Long nstOption) {
		this.nstOption = nstOption;
		changeProperty("nstOption",nstOption);
	}

	/**
	 * cat选项
	 **/
	public Long getCatOption() {
		return catOption;
	}

	/**
	 * cat选项
	 **/
	public void setCatOption(Long catOption) {
		this.catOption = catOption;
		changeProperty("catOption",catOption);
	}

	/**
	 * 所属医院
	 **/
	public Long getHospitalId() {
		return hospitalId;
	}

	/**
	 * 所属医院
	 **/
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
		changeProperty("hospitalId",hospitalId);
	}

	/**
	 * 横轴刻度
	 **/
	public Integer getDivisionX() {
		return divisionX;
	}

	/**
	 * 横轴刻度
	 **/
	public void setDivisionX(Integer divisionX) {
		this.divisionX = divisionX;
		changeProperty("divisionX",divisionX);
	}

	/**
	 * 纵轴刻度
	 **/
	public Integer getDivisionY() {
		return divisionY;
	}

	/**
	 * 纵轴刻度
	 **/
	public void setDivisionY(Integer divisionY) {
		this.divisionY = divisionY;
		changeProperty("divisionY",divisionY);
	}

	/**
	 * 缩放倍数
	 **/
	public Double getZoom() {
		return zoom;
	}

	/**
	 * 缩放倍数
	 **/
	public void setZoom(Double zoom) {
		this.zoom = zoom;
		changeProperty("zoom",zoom);
	}

	/**
	 * 模板名
	 **/
	public String getTemplate() {
		return template;
	}

	/**
	 * 模板名
	 **/
	public void setTemplate(String template) {
		this.template = template;
		changeProperty("template",template);
	}

	@Override
	public String toString() {
		return "ReportSettings[id:"+ id+",paperspeed:"+ paperspeed+",reportPrintView:"+ reportPrintView+",reportPrintCatView:"+ reportPrintCatView+",reportPrintNstView:"+ reportPrintNstView+",signpageView:"+ signpageView+",signpageCatView:"+ signpageCatView+",signpageNstView:"+ signpageNstView+",nstOption:"+ nstOption+",catOption:"+ catOption+",hospitalId:"+ hospitalId+",divisionX:"+ divisionX+",divisionY:"+ divisionY+",zoom:"+ zoom+",template:"+ (template == null ?"null":template.substring(0, Math.min(template.length(), 64)))+ "]";
	}

	@Override
	@JsonIgnore
    @Transient
	public ThisTableInfo getTableInfo() {
		return TABLE_INFO;
	}

	public static final ThisTableInfo TABLE_INFO= new ThisTableInfo();

	public static final class ThisTableInfo implements TableInfo<ReportSettingsDO ,Key>{
		public static final String DB_TABLE_NAME = "report_settings";

		public static final String ID_DB_NAME = "id";
		public static final String PAPERSPEED_DB_NAME = "paperspeed";
		public static final String REPORT_PRINT_VIEW_DB_NAME = "report_print_view";
		public static final String REPORT_PRINT_CAT_VIEW_DB_NAME = "report_print_cat_view";
		public static final String REPORT_PRINT_NST_VIEW_DB_NAME = "report_print_nst_view";
		public static final String SIGNPAGE_VIEW_DB_NAME = "signpage_view";
		public static final String SIGNPAGE_CAT_VIEW_DB_NAME = "signpage_cat_view";
		public static final String SIGNPAGE_NST_VIEW_DB_NAME = "signpage_nst_view";
		public static final String NST_OPTION_DB_NAME = "nst_option";
		public static final String CAT_OPTION_DB_NAME = "cat_option";
		public static final String HOSPITAL_ID_DB_NAME = "hospital_id";
		public static final String DIVISIONX_DB_NAME = "divisionX";
		public static final String DIVISIONY_DB_NAME = "divisionY";
		public static final String ZOOM_DB_NAME = "zoom";
		public static final String TEMPLATE_DB_NAME = "template";

		private ThisTableInfo(){
		}

		@Override public String getKeyUpdatePartialPrefixSql(){
			return "UPDATE `report_settings` SET ";
		}
		@Override public String getKeyWhereByKeySql(){
			return " WHERE `id`=?";
		}
		@Override public String getKeyDeleteSql(){
			return "DELETE FROM `report_settings` WHERE `id`=?";
		}

		@Override
		public int setPreparedStatement(ReportSettingsDO t, PreparedStatement ps, int i, boolean isSetUnique) throws SQLException {
			ps.setObject(i++, t.getPaperspeed());
			ps.setObject(i++, t.getReportPrintView());
			ps.setObject(i++, t.getReportPrintCatView());
			ps.setObject(i++, t.getReportPrintNstView());
			ps.setObject(i++, t.getSignpageView());
			ps.setObject(i++, t.getSignpageCatView());
			ps.setObject(i++, t.getSignpageNstView());
			ps.setObject(i++, t.getNstOption());
			ps.setObject(i++, t.getCatOption());
			ps.setObject(i++, t.getHospitalId());
			ps.setObject(i++, t.getDivisionX());
			ps.setObject(i++, t.getDivisionY());
			ps.setObject(i++, t.getZoom());
			ps.setObject(i++, t.getTemplate());
			return i;
		}

		@Override
        public int setAllPreparedStatement(ReportSettingsDO t, PreparedStatement ps, int i) throws SQLException {
        	ps.setObject(i++, t.getId());
        	ps.setObject(i++, t.getPaperspeed());
        	ps.setObject(i++, t.getReportPrintView());
        	ps.setObject(i++, t.getReportPrintCatView());
        	ps.setObject(i++, t.getReportPrintNstView());
        	ps.setObject(i++, t.getSignpageView());
        	ps.setObject(i++, t.getSignpageCatView());
        	ps.setObject(i++, t.getSignpageNstView());
        	ps.setObject(i++, t.getNstOption());
        	ps.setObject(i++, t.getCatOption());
        	ps.setObject(i++, t.getHospitalId());
        	ps.setObject(i++, t.getDivisionX());
        	ps.setObject(i++, t.getDivisionY());
        	ps.setObject(i++, t.getZoom());
        	ps.setObject(i++, t.getTemplate());
        	return i;
        }

		@Override
		public int setPreparedStatementKeys(ReportSettingsDO t, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, t.getId());
			return i;
		}

		@Override
		public int setKeyPreparedStatement(Key k, PreparedStatement ps, int i) throws SQLException {
			ps.setObject(i++, k.getId());
			return i;
		}

		@Override public String getInsertSql(){
			return "INSERT INTO `report_settings` (`paperspeed`,`report_print_view`,`report_print_cat_view`,`report_print_nst_view`,`signpage_view`,`signpage_cat_view`,`signpage_nst_view`,`nst_option`,`cat_option`,`hospital_id`,`divisionX`,`divisionY`,`zoom`,`template`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}

		@Override public String getReplaceSql(){
        	return "REPLACE INTO `report_settings` (`id`,`paperspeed`,`report_print_view`,`report_print_cat_view`,`report_print_nst_view`,`signpage_view`,`signpage_cat_view`,`signpage_nst_view`,`nst_option`,`cat_option`,`hospital_id`,`divisionX`,`divisionY`,`zoom`,`template`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

		@Override public String getFastInsertPrefixSql(){
			return "INSERT INTO `report_settings` (`paperspeed`,`report_print_view`,`report_print_cat_view`,`report_print_nst_view`,`signpage_view`,`signpage_cat_view`,`signpage_nst_view`,`nst_option`,`cat_option`,`hospital_id`,`divisionX`,`divisionY`,`zoom`,`template`) VALUES ";
		}
		@Override public String getFastInsertValueItemsSql(){
			return " (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		}
		@Override public String getUpdateSql(){
			return "UPDATE `report_settings` SET `paperspeed`=?,`report_print_view`=?,`report_print_cat_view`=?,`report_print_nst_view`=?,`signpage_view`=?,`signpage_cat_view`=?,`signpage_nst_view`=?,`nst_option`=?,`cat_option`=?,`hospital_id`=?,`divisionX`=?,`divisionY`=?,`zoom`=?,`template`=? WHERE `id`=?";
		}

		@Override public String getSelectByKeySql(){
			return "SELECT * FROM `report_settings` WHERE `id`=? ORDER BY `id` DESC";
		}
		@Override public String getSelectCountSql(){
			return "SELECT count(*) FROM `report_settings`";
		}
		@Override public String getFormatSelectSql(){
			return "SELECT %s FROM `report_settings` ORDER BY `id` DESC";
		}
		@Override public String getFormatSelectPrefixSql(){
			return "SELECT %s FROM `report_settings` ";
		}
		@Override public String getSelectPrefixSql(){
			return "SELECT * FROM `report_settings` ";
		}
		@Override public String getOrderByIdDescSql(){
			return " ORDER BY `id` DESC";
		}
		@Override public String getDbTableName(){
			return DB_TABLE_NAME;
		}

		@Override public RowMapper<ReportSettingsDO> getRowMapper(){
			return new RowMapper<ReportSettingsDO>() {
				@Override
				public ReportSettingsDO mapRow(ResultSet rs, int rowNum) throws SQLException {
					ReportSettingsDO o=new ReportSettingsDO();
					o.id = rs.getLong("id");
					o.paperspeed = rs.getInt("paperspeed");
					o.reportPrintView = rs.getBoolean("report_print_view");
					o.reportPrintCatView = rs.getBoolean("report_print_cat_view");
					o.reportPrintNstView = rs.getBoolean("report_print_nst_view");
					o.signpageView = rs.getBoolean("signpage_view");
					o.signpageCatView = rs.getBoolean("signpage_cat_view");
					o.signpageNstView = rs.getBoolean("signpage_nst_view");
					o.nstOption = rs.getLong("nst_option");
					o.catOption = rs.getLong("cat_option");
					o.hospitalId = rs.getLong("hospital_id");
					o.divisionX = rs.getInt("divisionX");
					o.divisionY = rs.getInt("divisionY");
					o.zoom = rs.getDouble("zoom");
					o.template = rs.getString("template");
					return o;
				}
			};
		}

		@Override public <C extends ReportSettingsDO> RowMapper<C>  getRowMapper(final Class<C> cls){
			return new RowMapper<C>() {
				@Override
				public C mapRow(ResultSet rs, int rowNum) throws SQLException {
					C o;
					try{
						o = cls.newInstance();
						o.setId(rs.getLong("id"));
						o.setPaperspeed(rs.getInt("paperspeed"));
						o.setReportPrintView(rs.getBoolean("report_print_view"));
						o.setReportPrintCatView(rs.getBoolean("report_print_cat_view"));
						o.setReportPrintNstView(rs.getBoolean("report_print_nst_view"));
						o.setSignpageView(rs.getBoolean("signpage_view"));
						o.setSignpageCatView(rs.getBoolean("signpage_cat_view"));
						o.setSignpageNstView(rs.getBoolean("signpage_nst_view"));
						o.setNstOption(rs.getLong("nst_option"));
						o.setCatOption(rs.getLong("cat_option"));
						o.setHospitalId(rs.getLong("hospital_id"));
						o.setDivisionX(rs.getInt("divisionX"));
						o.setDivisionY(rs.getInt("divisionY"));
						o.setZoom(rs.getDouble("zoom"));
						o.setTemplate(rs.getString("template"));
                        return o;
					} catch (InstantiationException | IllegalAccessException e) {
						throw new SQLException("必须实现默认构造函数",e);
					}
				}
			};
		}
	}
}
