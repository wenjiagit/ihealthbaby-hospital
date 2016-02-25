-- ----------------------------
-- Table structure for `cat_option`
-- ----------------------------
DROP TABLE IF EXISTS `cat_option`;
CREATE TABLE `cat_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_option_name` varchar(100) DEFAULT NULL COMMENT '选项名',
  `cat_option_detail` varchar(100) DEFAULT NULL COMMENT '选项含义',
  `hospital_id` bigint(20) DEFAULT NULL COMMENT '医院id',
  `level` int(2) DEFAULT NULL COMMENT '优先级 0无1低2中3高',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for `login_token`
-- ----------------------------
DROP TABLE IF EXISTS `login_token`;
CREATE TABLE `login_token` (
  `token` varchar(64) NOT NULL,
  `name` varchar(45) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for `nst_option`
-- ----------------------------
DROP TABLE IF EXISTS `nst_option`;
CREATE TABLE `nst_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nst_option_name` varchar(100) DEFAULT NULL COMMENT '选项名',
  `nst_option_detail` varchar(100) DEFAULT NULL COMMENT '选项含义',
  `hospital_id` bigint(20) DEFAULT NULL COMMENT '医院id',
  `level` int(2) DEFAULT NULL COMMENT '优先级。0无1低2中3高',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for `report_settings`
-- ----------------------------
DROP TABLE IF EXISTS `report_settings`;
CREATE TABLE `report_settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `paperspeed` int(20) DEFAULT '7' COMMENT '走纸速度',
  `report_print_view` tinyint(1) DEFAULT NULL COMMENT '打印报告显示设置 (0:不显示 1：显示)',
  `report_print_cat_view` tinyint(1) DEFAULT NULL COMMENT '打印页cat显隐',
  `report_print_nst_view` tinyint(1) DEFAULT NULL COMMENT '打印报告nst显示设置 (0:不显示 1：显示)',
  `signpage_view` tinyint(1) DEFAULT NULL COMMENT '签发页显示(0:不显示 1：显示)',
  `signpage_cat_view` tinyint(1) DEFAULT NULL COMMENT '签发页cat显示(0:不显示 1：显示)',
  `signpage_nst_view` tinyint(1) DEFAULT NULL COMMENT '签发页nst显示(0:不显示 1：显示)',
  `nst_option` bigint(20) DEFAULT NULL COMMENT 'nst选项',
  `cat_option` bigint(20) DEFAULT NULL COMMENT 'cat选项',
  `hospital_id` bigint(20) DEFAULT NULL COMMENT '所属医院',
  `divisionX` int(10) DEFAULT '6' COMMENT '横轴刻度',
  `divisionY` int(10) DEFAULT '5' COMMENT '纵轴刻度',
  `zoom` double(2,1) DEFAULT '1.0' COMMENT '缩放倍数',
  `template` varchar(20) DEFAULT 'default' COMMENT '模板名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='报告设置表';

-- ----------------------------
-- Table structure for `report_templet`
-- ----------------------------
DROP TABLE IF EXISTS `report_templet`;
CREATE TABLE `report_templet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `templetName` varchar(100) DEFAULT NULL COMMENT '模板名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of report_templet
-- ----------------------------
INSERT INTO `report_templet` VALUES ('1', '标准版（7分钟一张图）');
INSERT INTO `report_templet` VALUES ('2', '单图版（20分钟一张图）');
INSERT INTO `report_templet` VALUES ('3', '双图版（10分钟一张图）');
INSERT INTO `report_templet` VALUES ('4', '单图2倍高版');
INSERT INTO `report_templet` VALUES ('5', '双图2倍高版');
INSERT INTO `report_templet` VALUES ('6', '双图信息版');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `permission_name` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `permission_type` int(10) DEFAULT NULL COMMENT '资源类型（菜单:1，按钮:2）',
  `permission_key` varchar(100) DEFAULT NULL COMMENT '资源key(唯一值)',
  `permission_url` varchar(255) DEFAULT NULL COMMENT '资源url',
  `permission_icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `weight` int(10) DEFAULT '1' COMMENT '权重',
  `sidebar` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否显示（1:显示 0：不显示）',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  `display` tinyint(1) DEFAULT '1' COMMENT '医院是否显示 0：不显示 1：显示',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permissionkey` (`permission_key`)
) ENGINE=InnoDB AUTO_INCREMENT=1308 DEFAULT CHARSET=utf8mb4 COMMENT='资源表';

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(100) NOT NULL COMMENT '角色名',
  `hospital_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '医院id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色资源映射表';

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';