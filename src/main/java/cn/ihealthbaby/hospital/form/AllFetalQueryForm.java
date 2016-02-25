package cn.ihealthbaby.hospital.form;

/**
 * @author qiang on 2015/9/7.
 *         jinliqiang@ihbaby.com
 */
public class AllFetalQueryForm {
    private int page = 1;
    private int pageSize=10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
