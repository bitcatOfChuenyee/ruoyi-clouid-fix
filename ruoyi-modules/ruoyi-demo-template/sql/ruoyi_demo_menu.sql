-- 示例管理 菜单及权限（根据实际 sys_menu 字段调整）
-- 顶级目录/菜单 ID 请按实际情况修改

-- 目录
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, is_frame, is_cache,
                      menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES (2000, '示例管理', 0, 1, 'demo', 'demo/index', NULL, 1, 0, 'C', '0', '0', 'demo:demo:list',
        'example', 'admin', NOW(), '', NULL, '示例管理目录');

-- 菜单
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, is_frame, is_cache,
                      menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES (2001, '示例列表', 2000, 1, 'list', 'demo/index', NULL, 1, 0, 'M', '0', '0', 'demo:demo:list',
        'list', 'admin', NOW(), '', NULL, '示例管理菜单');

-- 按钮权限
INSERT INTO sys_menu (menu_id, menu_name, parent_id, order_num, path, component, query, is_frame, is_cache,
                      menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
VALUES (2002, '示例查询', 2001, 1, '', '', NULL, 1, 0, 'F', '0', '0', 'demo:demo:query',
        '#', 'admin', NOW(), '', NULL, ''),
       (2003, '示例新增', 2001, 2, '', '', NULL, 1, 0, 'F', '0', '0', 'demo:demo:add',
        '#', 'admin', NOW(), '', NULL, ''),
       (2004, '示例修改', 2001, 3, '', '', NULL, 1, 0, 'F', '0', '0', 'demo:demo:edit',
        '#', 'admin', NOW(), '', NULL, ''),
       (2005, '示例删除', 2001, 4, '', '', NULL, 1, 0, 'F', '0', '0', 'demo:demo:remove',
        '#', 'admin', NOW(), '', NULL, '');

-- 角色绑定（以管理员角色为例，role_id=1）
INSERT INTO sys_role_menu (role_id, menu_id) VALUES
(1, 2000), (1, 2001), (1, 2002), (1, 2003), (1, 2004), (1, 2005);
