package cn.ihealthbaby.hospital.services;

import static java.util.stream.Collectors.toConcurrentMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import com.isnowfox.core.dao.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isnowfox.core.dao.QueryParams;

import cn.ihealthbaby.hospital.db.dao.cache.SysPermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRoleCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysRolePermissionCacheDao;
import cn.ihealthbaby.hospital.db.dao.cache.SysUserRoleCacheDao;
import cn.ihealthbaby.hospital.db.entity.SysPermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysRoleDO;
import cn.ihealthbaby.hospital.db.entity.SysRolePermissionDO;
import cn.ihealthbaby.hospital.db.entity.SysUserRoleDO;
import cn.ihealthbaby.hospital.permission.Role;
import cn.ihealthbaby.hospital.permission.Roles;

/**
 * @author zuoge85 on 15/7/21.
 */
@Service
public class PermissionService {
	private static final Logger log = LoggerFactory.getLogger(PermissionService.class);
	public static final int MAX = 100000;

	@Autowired
	private SysPermissionCacheDao sysPermissionCacheDao;
	@Autowired
	private SysRoleCacheDao sysRoleCacheDao;
	@Autowired
	private SysRolePermissionCacheDao sysRolePermissionCacheDao;
	@Autowired
	private SysUserRoleCacheDao sysUserRoleCacheDao;

	private ConcurrentMap<Long, Role> roleMap;
	private ConcurrentMap<Long, SysPermissionDO> permissionsMap;
	private ConcurrentMap<String, SysPermissionDO> permissionKeyMap;

	public ConcurrentMap<String, SysPermissionDO> getPermissionKeyMap() {
		return permissionKeyMap;
	}

	public void setPermissionKeyMap(ConcurrentMap<String, SysPermissionDO> permissionKeyMap) {
		this.permissionKeyMap = permissionKeyMap;
	}

	@PostConstruct
	public void init() {
		// 所有权限
		List<SysPermissionDO> permlist = sysPermissionCacheDao.find(MAX, QueryParams.create(), Order.asc(SysPermissionDO.ThisTableInfo.WEIGHT_DB_NAME));
		permissionsMap = permlist.parallelStream()
				.collect(toConcurrentMap(SysPermissionDO::getId, sysPermissionDO -> sysPermissionDO));
		permissionKeyMap = permlist.parallelStream()
				.collect(toConcurrentMap(SysPermissionDO::getPermissionKey, sysPermissionDO -> sysPermissionDO));

		roleMap = new ConcurrentHashMap<>();
		List<SysRoleDO> sysRoleDOs = sysRoleCacheDao.find(MAX);
		for (SysRoleDO roleDo : sysRoleDOs) {
			Role role = createRole(roleDo);
			roleMap.put(role.getId(), role);
		}
	}

	/**
	 * 创建角色对象
	 */
	public Role createRole(SysRoleDO sysRoleDO) {
		QueryParams params = QueryParams.create();
		params.add(SysRolePermissionDO.ThisTableInfo.ROLE_ID_DB_NAME, sysRoleDO.getId());

		List<SysRolePermissionDO> rolePermissions = sysRolePermissionCacheDao.find(MAX, params, Order.asc(SysRolePermissionDO.ThisTableInfo.PERMISSION_ID_DB_NAME));

		Role role = new Role(sysRoleDO);
		for (SysRolePermissionDO rolePermissionDO : rolePermissions) {
			SysPermissionDO sysPermissionDO = permissionsMap.get(rolePermissionDO.getPermissionId());
			if(sysPermissionDO!= null){
				role.addPermission(sysPermissionDO);
			}
		}
		return role;
	}

	/**
	 * 根据用户id 获取用户相关角色
	 */
	public Roles getRoles(long userId) {
		List<SysUserRoleDO> sysUserRoleDOs = sysUserRoleCacheDao.find(MAX, SysUserRoleDO.ThisTableInfo.USER_ID_DB_NAME,
				userId);
		Roles roles = new Roles();

		ArrayList<Role> rolesList = new ArrayList<>();
		for (SysUserRoleDO sysUserRoleDO : sysUserRoleDOs) {
			Role role = roleMap.get(sysUserRoleDO.getRoleId());
			rolesList.add(role);
		}
		if (!rolesList.isEmpty()) {
			roles.init(rolesList);
		}
		return roles;
	}
	public void updateRoleMap(){
		List<SysRoleDO> sysRoleDOs = sysRoleCacheDao.find(MAX);
		for (SysRoleDO roleDo : sysRoleDOs) {
			Role role = createRole(roleDo);
			roleMap.put(role.getId(), role);
		}
	}

}
