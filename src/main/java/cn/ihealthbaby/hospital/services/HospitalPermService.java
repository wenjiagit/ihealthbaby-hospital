package cn.ihealthbaby.hospital.services;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.db.dao.cache.SysPermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRoleCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRolePermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;
import cn.ihealthbaby.hospital.db.entity.SysRolePermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.form.SysRoleForm;
import cn.ihealthbaby.hospital.model.SysUserModel;
import cn.ihealthbaby.hospital.permission.TreeNode;
import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParam;
import com.isnowfox.core.dao.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qiang on 2015/10/17.
 *         jinliqiang@ihbaby.com
 */
@Service
public class HospitalPermService {
    private static final Logger log = LoggerFactory.getLogger(HospitalPermService.class);
    public static final int MAX = 10000;
    @Value("${qiniu.base.path}")
    private String qiNiuBasePath;
    @Autowired
    private SysUserReadOnlyDao sysUserCacheDao;
    @Autowired
    private SysRoleCacheDao sysRoleCacheDao;
    @Autowired
    private SysUserRoleCacheDao sysUserRoleCacheDao;
    @Autowired
    private SysRolePermissionCacheDao sysRolePermissionCacheDao;
    @Autowired
    private SysPermissionCacheDao sysPermissionCacheDao;
    @Autowired
    private HospitalReadOnlyDao hospitalReadOnlyDao;
    @Autowired
    private DepartmentReadOnlyDao departmentReadOnlyDao;
    @Autowired
    private PermissionService permissionService;
    public PageResult<SysRoleDO> roleQuery(int page, int pageSize,UserAccount account) {
        QueryParams queryParams = QueryParams.create();
        queryParams.add(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,account.getSysUserDO().getHospitalId()).or(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,1);
        PageResult<SysRoleDO> result = sysRoleCacheDao.findPage(queryParams,page, pageSize);
        return result;
    }
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void addRole(SysRoleForm form,UserAccount account) {
        long roleId = sysRoleCacheDao.insert(new SysRoleDO(form.getRoleName(), account.getSysUserDO().getHospitalId()));
        SysPermissionDO sp = sysPermissionCacheDao.findObject(
                SysPermissionDO.ThisTableInfo.PERMISSION_KEY_DB_NAME, "index");
        SysRolePermissionDO rpd = new SysRolePermissionDO();
        rpd.setRoleId(roleId);
        rpd.setPermissionId(sp.getId());
        sysRolePermissionCacheDao.insert(rpd);
    }

    public PageResult<SysUserModel> sysUserQuery(int page, int pageSize,UserAccount account) {
        QueryParams params = QueryParams.create();
        params.add(SysUserDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, account.getSysUserDO().getHospitalId());
        PageResult<SysUserDO> result = sysUserCacheDao.findPage(params, page, pageSize);
        List<SysUserModel> list = new ArrayList<>();
        for (SysUserDO sysUserDO : result.getValue()) {
            SysUserModel sysUserModel = new SysUserModel();
            BeanUtils.copyProperties(sysUserDO, sysUserModel);
            sysUserModel.setHospitalDO(hospitalReadOnlyDao.get(sysUserDO
                    .getHospitalId()));
            sysUserModel.setDepartmentDO(departmentReadOnlyDao.get(sysUserDO
                    .getDepartmentId()));
            if (sysUserDO.getHeadPic() != null) {
                sysUserModel.setHeadPic(qiNiuBasePath + sysUserDO.getHeadPic());
            }
            list.add(sysUserModel);
        }
        return PageResult.createPage(result.getCount(), result.getPage(),
                result.getPageSize(), list);
    }


    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void addRolePermission(long roleId, long[] permIds) {
        SysPermissionDO perm = sysPermissionCacheDao.findObject(QueryParams.create().add(
                SysPermissionDO.ThisTableInfo.PERMISSION_KEY_DB_NAME, "index"));
        QueryParams params = QueryParams.create();
        params.add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME, roleId);
        List<SysRolePermissionDO> list = sysRolePermissionCacheDao
                .find(Integer.MAX_VALUE, params, Order.create(SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME, false));
        for (SysRolePermissionDO sysRole : list) {
            if (sysRole.getPermissionId() != perm.getId()) {
                sysRolePermissionCacheDao.del(sysRole.getKey());
            }
        }
        for (long pid : permIds) {
            SysRolePermissionDO rolePer = sysRolePermissionCacheDao.findObject(QueryParams.create()
                    .add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME, roleId)
                    .add(SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME, pid));
            if (rolePer != null) {
                continue;
            } else {
                SysRolePermissionDO rolePerm = new SysRolePermissionDO();
                rolePerm.setRoleId(roleId);
                rolePerm.setPermissionId(pid);
                sysRolePermissionCacheDao.insert(rolePerm);

            }
        }
        permissionService.updateRoleMap();

    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public boolean delRolePermission(long roleId, long[] permIds) {
        boolean flag = false;
        for (long pid : permIds) {
            SysRolePermissionDO rolePerm = sysRolePermissionCacheDao
                    .findObject(QueryParams
                            .create()
                            .add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME,
                                    roleId)
                            .add(SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME,
                                    pid));
            flag = sysRolePermissionCacheDao.del(rolePerm.getKey());
        }
        permissionService.updateRoleMap();
        return flag;

    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public boolean delRole(long[] ids) {
        boolean flag = false;
        for (long id : ids) {
            SysRoleDO role = sysRoleCacheDao.get(id);
            if (role != null) {
                flag = sysRoleCacheDao.del(role.getKey());
            }
            List<SysUserRoleDO> list =sysUserRoleCacheDao.find(MAX,SysUserRoleDO.ThisTableInfo.ROLE_ID_DB_NAME,id);
            for(SysUserRoleDO sysUserRoleDO : list){
                flag =sysUserRoleCacheDao.del(sysUserRoleDO.getKey());
            }
        }
        return flag;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public boolean addRole(SysRoleForm form) {
        long roleId = sysRoleCacheDao.insert(new SysRoleDO(form.getRoleName(),1L));
        SysPermissionDO sp = sysPermissionCacheDao.findObject(
                SysPermissionDO.ThisTableInfo.PERMISSION_KEY_DB_NAME, "index");
        SysRolePermissionDO rpd = new SysRolePermissionDO();
        rpd.setRoleId(roleId);
        rpd.setPermissionId(sp.getId());
        long permId = sysRolePermissionCacheDao.insert(rpd);
        return roleId > 0 && permId > 0;

    }

    public List<Long> getRolePermIds(long Roleid) {
        QueryParams params = QueryParams.create();
        params.add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME, Roleid);
        List<SysRolePermissionDO> list = sysRolePermissionCacheDao
                .find(Integer.MAX_VALUE,
                        params,
                        Order.create(
                                SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME,
                                false));
        List<Long> permidlist = new ArrayList<>();
        for (SysRolePermissionDO srpd : list) {
            permidlist.add(srpd.getPermissionId());
        }
        return permidlist;
    }
    public List<TreeNode> getRolePermList(long Roleid) {
        QueryParams params = QueryParams.create();
        params.add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME, Roleid);
        List<SysRolePermissionDO> list = sysRolePermissionCacheDao
                .find(Integer.MAX_VALUE,
                        params,
                        Order.create(
                                SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME,
                                false));
        List<SysPermissionDO> permlist =new ArrayList<>();
        for (SysRolePermissionDO sysRolePermissionDO : list){
            permlist.add(sysPermissionCacheDao.get(sysRolePermissionDO.getPermissionId()));
        }
        List<TreeNode> nodelist = new ArrayList<>();
        for (SysPermissionDO perm : permlist) {
            TreeNode node = new TreeNode();
            node.setId(perm.getId());
            node.setName(perm.getPermissionName());
            node.setType(perm.getPermissionType());
            node.setRemarks(perm.getRemarks());
            if (perm.getPermissionKey().equals("index")) {
                node.setKey(perm.getPermissionKey());
                node.setParent(perm.getPermissionKey());
            } else {
                node.setKey("index." + perm.getPermissionKey());
                node.setParent("index." + perm.getPermissionKey());
            }
            nodelist.add(node);
        }
        return getResult(nodelist);
    }

    public List<TreeNode> buildTree() {
        QueryParams queryParams =QueryParams.create();
        queryParams.add(SysPermissionDO.ThisTableInfo.DISPLAY_DB_NAME,1);
        List<SysPermissionDO> permlist = sysPermissionCacheDao.find(MAX,
                queryParams,
                Order.create(SysPermissionDO.ThisTableInfo.ID_DB_NAME, false));
        List<TreeNode> nodelist = new ArrayList<>();
        for (SysPermissionDO perm : permlist) {
            TreeNode node = new TreeNode();
            node.setId(perm.getId());
            node.setName(perm.getPermissionName());
            node.setType(perm.getPermissionType());
            node.setRemarks(perm.getRemarks());
            if (perm.getPermissionKey().equals("index")) {
                node.setKey(perm.getPermissionKey());
                node.setParent(perm.getPermissionKey());
            } else {
                node.setKey("index." + perm.getPermissionKey());
                node.setParent("index." + perm.getPermissionKey());
            }
            nodelist.add(node);
        }
        return getResult(nodelist);

    }

    public static List<TreeNode> getResult(List<TreeNode> src) {
        List<TreeNode> parents = new ArrayList<TreeNode>();
        for (TreeNode ent : src) {
            if (ent.getKey().equals("index")) {
                TreeNode result = ent;
                result.setChildNode(new ArrayList<TreeNode>());
                parents.add(result);
            }
        }
        List<TreeNode> last = new ArrayList<TreeNode>();
        for (TreeNode ent : src) {
            if (!ent.getKey().equals("index")) {
                last.add(ent);
            }
        }
        toTree(parents, last);
        return parents;
    }

    private static void toTree(List<TreeNode> parents, List<TreeNode> others) {
        List<TreeNode> record = new ArrayList<TreeNode>();
        for (Iterator<TreeNode> it = parents.iterator(); it.hasNext();) {
            TreeNode vi = it.next();
            if (vi.getKey() != null) {
                for (Iterator<TreeNode> otherIt = others.iterator(); otherIt
                        .hasNext();) {
                    TreeNode inVi = otherIt.next();
                    if (vi.getKey().equals(inVi.getParent())) {
                        if (null == vi.getChildNode()) {
                            vi.setChildNode(new ArrayList<TreeNode>());
                        }
                        vi.getChildNode().add(inVi);
                        record.add(inVi);
                        otherIt.remove();
                    }
                }
            }
        }
        if (others.size() == 0) {
            return;
        } else {
            if (record.size() > 0) {
                toTree(record, others);
            }
        }
    }
    public List<SysRoleDO> queryRole(UserAccount account) {
        List<SysRoleDO> list = sysRoleCacheDao.find(MAX, QueryParams.create()
                .add(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,account.getSysUserDO().getHospitalId()).or(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,1)
        );
        return list;

    }
    public SysUserModel getSysUserDetail(long id) {
        SysUserModel sysUserModel = new SysUserModel();
        QueryParams params = QueryParams.create();
        params.add(SysUserDO.ThisTableInfo.ID_DB_NAME, id);
        SysUserDO sysUserDO = sysUserCacheDao.findObject(params);
        BeanUtils.copyProperties(sysUserDO, sysUserModel);
        sysUserModel.setDepartmentDO(departmentReadOnlyDao.get(sysUserDO
                .getDepartmentId()));
        return sysUserModel;
    }
    public List<Long> getUserRole(long id) {
        List<Long> idlist = new ArrayList<>();
        List<SysUserRoleDO> list = sysUserRoleCacheDao.find(10000, QueryParams
                .create().add(SysUserRoleDO.ThisTableInfo.USER_ID_DB_NAME, id));
        for (SysUserRoleDO ur : list) {
            idlist.add(ur.getRoleId());
        }
        return idlist;
    }
}
