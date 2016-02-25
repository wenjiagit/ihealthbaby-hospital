package cn.ihealthbaby.hospital.helps;

import cn.ihealthbaby.hospital.httl.UtilsMethod;
import com.isnowfox.util.DateTimeUtils;

import java.util.Date;

/**
 * @author qiang on 2015/10/27.
 *         jinliqiang@ihbaby.com
 */
public class ContractNumUtils {
    public static String generateContractNum(Date date,long num){
        String dateStr= DateTimeUtils.convertDateToString(date,"yyyyMM");
        return dateStr+"-"+ UtilsMethod.NumberFormat(num);
    }
}
