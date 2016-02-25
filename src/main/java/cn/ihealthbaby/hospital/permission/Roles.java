package cn.ihealthbaby.hospital.permission;

import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.util.stream.Collectors.toList;

/**
 * @author zuoge85 on 15/7/22.
 */
public class Roles {
    private CopyOnWriteArraySet<Role> roleItems = new CopyOnWriteArraySet<>();

    public boolean checkPermission(String[] permissionkeys) {
        for (Role role : roleItems) {
            if (role.checkPermission(permissionkeys)) {
                return true;
            }
        }
        return false;
    }

    public void addRole(Role role) {
        roleItems.add(role);
    }

    public void init(ArrayList<Role> rolesList) {
        roleItems.addAll(rolesList);
    }

    public List<Menu> getSidebar() {
        Map<String, SysPermissionDO> map = new HashMap<>();
        Map<String, Menu> menuMap = new HashMap<>();
        List<String> parentPermissionKeys = new ArrayList<>();

        //将所有显示的菜单项封装到map中，并找出每个菜单项的父节点
        for (Role role : roleItems) {
            role.getPermissionsMap().values().stream().filter(SysPermissionDO::getSidebar).forEach(
                    sysPermissionDO -> {
                        map.put(sysPermissionDO.getPermissionKey(), sysPermissionDO);
                        String parentPermissionKey = getParentPermissionKey(sysPermissionDO.getPermissionKey());
                        parentPermissionKeys.add(parentPermissionKey);
                    }
            );
        }
        //循环父节点,封装到menu
        parentPermissionKeys.stream().forEach(parentPermissionKey -> {
            SysPermissionDO sysPermissionDO = map.get(parentPermissionKey);
            if (sysPermissionDO != null) {
                Menu menu = new Menu(sysPermissionDO);
                menuMap.put(parentPermissionKey, menu);
            }
        });
        //循环menu，封装子节点
        menuMap.values().stream().forEach(
                menu-> {
                    String parentMenuKey=getParentPermissionKey(menu.getKey());
                    if (parentMenuKey!=null){
                        Menu parentMenu = menuMap.get(parentMenuKey);
                        parentMenu.add(menu);
                        menu.setParent(parentMenu);
                    }
                }
        );
        map.values().stream().forEach(
                sysPermissionDO -> {
                    String parentPermissionKey = getParentPermissionKey(sysPermissionDO.getPermissionKey());
                    Menu menu = new Menu(sysPermissionDO);
                    Menu parentMenu = menuMap.get(parentPermissionKey);
                    if (parentMenu != null) {
                        if (!isChildHasExsit(parentMenu,menu)){
                            parentMenu.add(menu);
                            menu.setParent(parentMenu);
                        }
                    }else{
                        if(menuMap.get(sysPermissionDO.getPermissionKey())==null) {
                            Menu menu1 = new Menu(sysPermissionDO);
                            menuMap.put(sysPermissionDO.getPermissionKey(), menu1);
                        }
                    }
                }
        );
        return menuMap.values().stream().filter(
                menu -> menu.getParent() == null
        ).collect(toList());
    }

    private String getParentPermissionKey(String permissionKey) {
        int i = permissionKey.lastIndexOf('.');

        if (i > -1) {
           return permissionKey.substring(0, i);
        }
        return null;
    }
    private boolean isChildHasExsit(Menu parent,Menu child){
        boolean flag=false;
        if(parent.getChilds().size()>0){
           for (Menu c : parent.getChilds()){
               if(c.getKey().equals(child.getKey())){
                   return true;
               }else{
                   flag = false;
               }
           }
        }
        return flag;
    }
}
