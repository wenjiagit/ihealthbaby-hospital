package cn.ihealthbaby.hospital.permission;

import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoge85 on 15/7/22.
 */
public class Menu {
    private List<Menu> childs = new ArrayList<>();

    private String key;
    private String name;
    private String url;
    private String icon;
    private Integer weight;
    @JsonIgnore
    private transient Menu parent;

    public Menu(SysPermissionDO sysPermissionDO) {
        this.key = sysPermissionDO.getPermissionKey();
        this.name = sysPermissionDO.getPermissionName();
        this.url = sysPermissionDO.getPermissionUrl();
        this.icon = sysPermissionDO.getPermissionIcon();
        this.weight=sysPermissionDO.getWeight();
    }

    public void add(Menu child) {
        childs.add(child);
    }

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    @Transient
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
