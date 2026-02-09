CREATE TABLE `t_demo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(64) NOT NULL COMMENT '名称',
  `code` VARCHAR(64) DEFAULT NULL COMMENT '编码',
  `type` VARCHAR(32) DEFAULT NULL COMMENT '类型',
  `status` CHAR(1) DEFAULT '0' COMMENT '状态(0正常 1停用)',
  `sort` INT DEFAULT 0 COMMENT '排序',
  `remark` VARCHAR(500) DEFAULT NULL COMMENT '备注',
  `create_by` VARCHAR(64) DEFAULT '' COMMENT '创建者',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` VARCHAR(64) DEFAULT '' COMMENT '更新者',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` CHAR(1) DEFAULT '0' COMMENT '逻辑删除(0存在 2删除)',
  PRIMARY KEY (`id`),
  KEY `idx_demo_code` (`code`),
  KEY `idx_demo_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='示例表';
