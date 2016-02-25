package cn.ihealthbaby.hospital.helps;

/**
 * @author qiang on 2015/10/16.
 *         jinliqiang@ihbaby.com
 */
public class SqlUtils {
    public static String Sqlfilter(String sql){
        return sql.trim().replace("'","''");
    }
}
