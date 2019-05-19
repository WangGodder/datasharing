package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.Role;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface RoleDao {
    Role findOne(Long roleId);

    List<Role> findAll();

    List<Role> findByUserId(Long userId);

    boolean insertOne(Role role);

    boolean deleteOne(Long roleId);
}
