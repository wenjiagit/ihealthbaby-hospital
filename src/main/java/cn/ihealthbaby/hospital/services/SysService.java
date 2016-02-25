package cn.ihealthbaby.hospital.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ihealthbaby.data.db.dao.readonly.DepartmentReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.HospitalReadOnlyDao;
import cn.ihealthbaby.data.db.dao.readonly.SysUserReadOnlyDao;
import cn.ihealthbaby.data.db.entity.DepartmentDO;
import cn.ihealthbaby.data.db.entity.HospitalDO;
import cn.ihealthbaby.data.db.entity.SysUserDO;
import cn.ihealthbaby.hospital.UserAccount;
import cn.ihealthbaby.hospital.admin.client.ApiManager;
import cn.ihealthbaby.hospital.admin.client.Result;
import cn.ihealthbaby.hospital.db.dao.cache.SysPermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRoleCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRolePermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;
import cn.ihealthbaby.hospital.db.entity.SysRolePermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.form.SysRoleForm;
import cn.ihealthbaby.hospital.form.SysUserForm;
import cn.ihealthbaby.hospital.form.SysUserUpdateForm;
import cn.ihealthbaby.hospital.model.SysUserModel;
import cn.ihealthbaby.hospital.permission.TreeNode;

import com.isnowfox.core.PageResult;
import com.isnowfox.core.dao.Order;
import com.isnowfox.core.dao.QueryParams;
import com.isnowfox.util.DigestUtils;

@Service
public class SysService {
	private static final Logger log = LoggerFactory.getLogger(SysService.class);
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
	private ApiManager apiManager;
	@Autowired
	private PermissionService permissionService;
	/**
	 * 登录用户列表
	 *
	 * @return
	 */
	public PageResult<SysUserModel> sysUserQuery(int page, int pageSize) {
		PageResult<SysUserDO> result = sysUserCacheDao.findPage(page, pageSize);
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

	public List<SysRoleDO> queryRole() {
		List<SysRoleDO> list = sysRoleCacheDao.find(MAX);
		return list;

	}

	public boolean isUserNameExsit(String username) {
		List<SysUserDO> list = sysUserCacheDao.find(MAX, QueryParams.create()
				.add(SysUserDO.ThisTableInfo.USERNAME_DB_NAME, username));
		return list.size() > 0;

	}

//	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
//	public void sysUserAdd(SysUserForm userform, UserAccount account) {
//		SysUserDO sysUserDO = new SysUserDO();
//		BeanUtils.copyProperties(userform, sysUserDO);
//		sysUserDO.setCreateTime(new Date());
//		sysUserDO.setPassword(DigestUtils.digest(userform.getPassword()));
//		if (userform.getHospitalId() == null) {
//			sysUserDO.setHospitalId(account.getSysUserDO().getHospitalId());
//		}
//		sysUserDO.setIsStopped(false);
//		// long id = sysUserCacheDao.insert(sysUserDO);
//		if (ArrayUtils.isNotEmpty(userform.getRoleid())) {
//			for (long rid : userform.getRoleid()) {
//				SysUserRoleDO userRole = new SysUserRoleDO();
//				userRole.setRoleId(rid);
//				userRole.setUserId(0);
//				sysUserRoleCacheDao.insert(userRole);
//			}
//		}
//	}

	public PageResult<SysRoleDO> roleQuery(int page, int pageSize) {
		QueryParams queryParams =QueryParams.create();
		queryParams.add(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,0).or(SysRoleDO.ThisTableInfo.HOSPITAL_ID_DB_NAME,1);
		PageResult<SysRoleDO> result = sysRoleCacheDao.findPage(queryParams,page, pageSize);
		return result;
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

	public List<TreeNode> buildTree() {
		List<SysPermissionDO> permlist = sysPermissionCacheDao.find(MAX,
				QueryParams.create(),
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

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public void updateSysUser(long id, SysUserUpdateForm form) {
		List<SysUserRoleDO> list = sysUserRoleCacheDao.find(10000, QueryParams
				.create().add(SysUserRoleDO.ThisTableInfo.USER_ID_DB_NAME, id));
		for (SysUserRoleDO userRoleDO : list) {
			sysUserRoleCacheDao.del(userRoleDO.getKey());
		}
		for (long roleId : form.getRoleid()) {
			SysUserRoleDO sysUserRoleDO = new SysUserRoleDO(id, roleId);
			sysUserRoleCacheDao.insert(sysUserRoleDO);
		}

	}

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public Result disableUser(Long[] ids) {
		return apiManager.adminDoctorApi.delete(Arrays.asList(ids));
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
		if (permIds != null){
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
		long roleId = sysRoleCacheDao.insert(new SysRoleDO(form.getRoleName(),0L));
		SysPermissionDO sp = sysPermissionCacheDao.findObject(
				SysPermissionDO.ThisTableInfo.PERMISSION_KEY_DB_NAME, "index");
		SysRolePermissionDO rpd = new SysRolePermissionDO();
		rpd.setRoleId(roleId);
		rpd.setPermissionId(sp.getId());
		long permId = sysRolePermissionCacheDao.insert(rpd);
		return roleId > 0 && permId > 0;

	}
	public List<HospitalDO> queryAllHospital() {
		return hospitalReadOnlyDao.find(MAX);
	}

	public List<DepartmentDO> queryDepartmentByHosId(long id) {
		return departmentReadOnlyDao.find(
				MAX,
				QueryParams.create().add(
						DepartmentDO.ThisTableInfo.HOSPITALID_DB_NAME, id));
	}
	public List<SysUserDO> getUserofRole(long id) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(SysUserRoleDO.ThisTableInfo.ROLE_ID_DB_NAME, id);
		List<SysUserRoleDO> list = sysUserRoleCacheDao.find(MAX, queryParams,
				Order.desc(SysUserRoleDO.ThisTableInfo.USER_ID_DB_NAME));
		List<SysUserDO> userDOList = new ArrayList<>();
		for (SysUserRoleDO sysUserRoleDO : list) {
			userDOList.add(sysUserCacheDao.findObject(QueryParams.create().add(
					SysUserDO.ThisTableInfo.ID_DB_NAME,
					sysUserRoleDO.getUserId())));

		}
		for (SysUserDO sysUserDO : userDOList) {
			if (sysUserDO.getHeadPic() != null) {
				sysUserDO.setHeadPic(qiNiuBasePath + sysUserDO.getHeadPic());
			}
		}
		return userDOList;
	}
	public List<Map<String, String>> userList(UserAccount account,
			String truename) {
		QueryParams queryParams = QueryParams.create();
		queryParams.add(SysUserDO.ThisTableInfo.HOSPITAL_ID_DB_NAME, account
				.getSysUserDO().getHospitalId());
		queryParams.add(SysUserDO.ThisTableInfo.ISSTOPPED_DB_NAME, 0);
		// queryParams.add(SysUserDO.ThisTableInfo.TRUENAME_DB_NAME,"%"+truename+"%",
		// QueryParam.OperatorType.LIKE);
		List<SysUserDO> list = sysUserCacheDao.find(MAX, queryParams);
		List<Map<String, String>> list1 = new ArrayList<>();
		for (SysUserDO userDO : list) {
			Map<String, String> map = new HashMap<>();
			// map.put("label",userDO.getTruename());
			map.put("value", userDO.getId() + "");
			list1.add(map);
		}
		return list1;
	}
}
