package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.Auth;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface AuthDao {
    Auth findOne(Integer authId);

    List<Auth> findAll();

    /**
     * 根据角色获取该角色所拥有的权限
     * @param roleId
     * @return
     */
    List<Auth> findByRoleId(Long roleId);

    boolean insertRoleAuth(Long roleId, Integer authId);
}
