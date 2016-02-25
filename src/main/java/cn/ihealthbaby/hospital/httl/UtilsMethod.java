package cn.ihealthbaby.hospital.httl;

import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.services.PermissionService;
import com.isnowfox.core.PageResult;
import com.isnowfox.spring.AccountHandlerInterceptor;
import com.isnowfox.util.JsonUtils;
import com.isnowfox.util.UUID;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zuoge85 on 15/5/18.
 */
public class UtilsMethod {
    public static final int PAGE_NUMS = 5;
    private MessageSourceAccessor messageAccessor;
    private static PermissionService permissionService;

    public UtilsMethod() {
        WebApplicationContext webApplicationContext = HttlWebEngine.getWebApplicationContext();
        if (webApplicationContext == null) {
            throw new RuntimeException("哎呀，这个必须在spring 和 web 项目里面使用！");
        }
        MessageSource messageSource = webApplicationContext.getBean(MessageSource.class);
        this.messageAccessor = new MessageSourceAccessor(messageSource);
        permissionService= webApplicationContext.getBean(PermissionService.class);
    }

    public String toJson(Object obj){
        return JsonUtils.serialize(obj);
    }

    public String page(PageResult<?> page, String goString) {
        ///user/{page}/{pageSize}.do

//        <ul class="pagination pagination-sm no-margin pull-right">
//        <li><a href="#">«</a></li>
//        <li><a href="#">1</a></li>
//        <li><a href="#">2</a></li>
//        <li><a href="#">3</a></li>
//        <li><a href="#">»</a></li>
//        </ul>
        goString = goString.replace("{pageSize}", Integer.toString(page.getPageSize()));
        int pageCount = page.getPageCount();
        int curPage = page.getPage();
        String uuid = UUID.random();
        StringBuilder sb = new StringBuilder()
                .append("            <nav  class=\"pull-left\">\n")
                .append("                <ul class=\"pagination pagination-sm  no-margin pull-right\">\n");

        if (curPage > PageResult.START) {
            sb.append("                    <li>\n").append("                        <a onclick=\"")
                    .append(goString.replace("{page}", Integer.toString(curPage - 1)))
                    .append("\" href=\"javascript:;\" aria-label=\"Previous\">\n")
                    .append("                            <span aria-hidden=\"true\">&laquo;</span>\n")
                    .append("                        </a>\n")
                    .append("                    </li>\n");
        }


        for (int i = Math.max(curPage - PAGE_NUMS, PageResult.START); i < curPage; i++) {
            sb.append("                    <li><a onclick=\"");
            sb.append(goString.replace("{page}", Integer.toString(i)));
            sb.append("\" href=\"javascript:;\">").append(i).append("</a></li>\n");
        }

        sb.append("                    <li class='disabled active'><a href=\"javascript:;\">").append(curPage).append("</a></li>\n");

        for (int i = curPage + 1; i <= pageCount && i < curPage + PAGE_NUMS; i++) {
            sb.append("                    <li><a onclick=\"");
            sb.append(goString.replace("{page}", Integer.toString(i)));
            sb.append("\" href=\"javascript:;\">").append(i).append("</a></li>\n");
        }

        if (curPage < pageCount) {
            sb.append("                    <li>\n")
                    .append("                        <a onclick=\"")
                    .append(goString.replace("{page}", Integer.toString(curPage + 1)))
                    .append("\" href=\"javascript:;\" aria-label=\"Next\">\n")
                    .append("                            <span aria-hidden=\"true\">&raquo;</span>\n")
                    .append("                        </a>\n")
                    .append("                    </li>\n");
        }

        sb.append("                </ul>\n")
                .append("            </nav>\n")
                .append("            <span class=\"pull-right pageinfo\">\n")
                .append("                <i class=\"fa fa-info-circle\"></i>\n")
                .append(messageAccessor.getMessage("web.page", new Object[]{curPage, pageCount, page.getCount()}))
                .append("            </span>\n");


        return sb.toString();
    }

    public static boolean perm(String value) throws Exception {
        HttpServletRequest request = HttlWebEngine.getRequest();
        UserAccount account = (UserAccount) request.getAttribute(AccountHandlerInterceptor.ACCOUNT_REQUEST_ATTRIBUTE);
        if (account != null) {
            String[] v = {value};
            return account.checkPermission(v);
        } else {
            return false;
        }
    }

    public static String permName(String value) throws Exception{
		return permissionService.getPermissionKeyMap().get(value).getPermissionName();
    }

    public static String MoneyFormat(Integer money) throws Exception{

        BigDecimal moneyBD = new BigDecimal(money);
        BigDecimal divisorBD = new BigDecimal(100);
        // RoundingMode.HALF_UP = 2
        return moneyBD.divide(divisorBD, 2, RoundingMode.HALF_UP).toString();
    }
    public static String getAccountantMoney(Integer money) throws Exception{
        String disposeMoneyStr = MoneyFormat(money);
        int dotPosition = disposeMoneyStr.indexOf(".");
        String exceptDotMoeny = null;// 小数点之前的字符串
        String dotMeony = null;// 小数点之后的字符串
        if (dotPosition > 0) {
            exceptDotMoeny = disposeMoneyStr.substring(0, dotPosition);
            dotMeony = disposeMoneyStr.substring(dotPosition);
        } else {
            exceptDotMoeny = disposeMoneyStr;
        }
        // 负数处理
        int negativePosition = exceptDotMoeny.indexOf("-");
        if (negativePosition == 0) {
            exceptDotMoeny = exceptDotMoeny.substring(1);
        }
        StringBuffer reverseExceptDotMoney = new StringBuffer(exceptDotMoeny);
        reverseExceptDotMoney.reverse();// 字符串倒转
        // reverse(reverseExceptDotMoeny);
        char[] moneyChar = reverseExceptDotMoney.toString().toCharArray();
        StringBuffer returnMeony = new StringBuffer();// 返回值
        for (int i = 0; i < moneyChar.length; i++) {
            if (i != 0 && i % 3 == 0) {
                returnMeony.append(",");// 每隔3位加','
            }
            returnMeony.append(moneyChar[i]);
        }
        returnMeony.reverse();// 字符串倒转
        // reverse(returnMeony);
        if (dotPosition > 0) {
            returnMeony.append(dotMeony);
        }
        if (negativePosition == 0) {
            return "-" + returnMeony.toString();
        } else {
            return returnMeony.toString();
        }
    }

    public static String FormatTestTime(Integer time){
        if(time==null){
            return "";
        }
        int min=time/60;
        int sec =time%60;
        return min+"分"+sec+"秒";
    }
    public static String NumberFormat(Long num){
        if(num==null){
            return "";
        }
        return String.format("%05d", num);
    }
}
