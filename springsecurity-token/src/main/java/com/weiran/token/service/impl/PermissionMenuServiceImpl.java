package com.weiran.token.service.impl;

import com.weiran.token.mapper.PermissionMenuMapper;
import com.weiran.token.entity.PermissionMenuDTO;
import com.weiran.token.entity.TreeRoleMenuDTO;
import com.weiran.token.request.MenuReq;
import com.weiran.token.service.PermissionMenuService;
import com.weiran.token.utils.TreeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PermissionMenuServiceImpl implements PermissionMenuService {

    private final PermissionMenuMapper permissionMenuMapper;

    @Override
    public List<PermissionMenuDTO> findByRoleMenus(String search) {
        List<PermissionMenuDTO> roleMenuS;
        if (StringUtils.isEmpty(search)) {
            roleMenuS = permissionMenuMapper.findByRoleMenus();
        } else {
            roleMenuS = permissionMenuMapper.findByRoleMenusLike(search);
        }
        return TreeHelper.getSortedNodes(roleMenuS);
    }

    @Override
    public List<TreeRoleMenuDTO> findRoleMenus() {
        List<TreeRoleMenuDTO> treeRoleMenuDTOS = permissionMenuMapper.findRoleMenus();
        return TreeHelper.getSortedTreeNodes(treeRoleMenuDTOS);
    }

    @Override
    public boolean creatMenu(MenuReq menuReq) {
        menuReq.setLevel(menuReq.getLevel() + 1);
        Integer row = permissionMenuMapper.creatMenu(menuReq);
        return row > 0;
    }

    @Override
    public void deleteById(String id) {
        //并且删除子菜单
        permissionMenuMapper.deleteById(id);
    }

    @Override
    public boolean updateMenu(MenuReq menuReq) {
        Integer row = permissionMenuMapper.updateMenu(menuReq);
        return row > 0;
    }
}
