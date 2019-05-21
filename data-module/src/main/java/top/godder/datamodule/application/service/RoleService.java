package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.AuthDao;
import top.godder.datamodule.domain.dao.RoleDao;
import top.godder.datamoduleapi.domain.entity.Role;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AuthDao authDao;

    public List<Role> allRole() {
        return roleDao.findAll();
    }

    public boolean addUserRole(Long userId, Long roleId) {
        return roleDao.insertUserRole(roleId, userId);
    }

    public Role createRole(String roleName, String comment, List<Integer> authList) {
        Role role = Role.builder().roleName(roleName).comment(comment).build();
        if (!roleDao.insertOne(role)) {
            return null;
        }
        for (Integer authId : authList) {
            authDao.insertRoleAuth(role.getRoleId(), authId);
        }
        return role;
    }
}
