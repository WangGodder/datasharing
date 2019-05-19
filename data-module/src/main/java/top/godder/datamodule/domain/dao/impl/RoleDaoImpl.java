package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.RoleDao;
import top.godder.datamodule.infrastructure.mapper.RoleMapper;
import top.godder.datamoduleapi.domain.entity.Role;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private RoleMapper mapper;

    @Override
    public Role findOne(Long roleId) {
        return mapper.findOne(roleId);
    }

    @Override
    public List<Role> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Role> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public boolean insertOne(Role role) {
        return mapper.insertOne(role) == 1;
    }

    @Override
    public boolean deleteOne(Long roleId) {
        return mapper.deleteOne(roleId) == 1;
    }
}
