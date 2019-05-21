package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.AuthDao;
import top.godder.datamodule.infrastructure.mapper.AuthMapper;
import top.godder.datamoduleapi.domain.entity.Auth;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class AuthDaoImpl implements AuthDao {
    @Autowired
    private AuthMapper mapper;

    @Override
    public Auth findOne(Integer authId) {
        return mapper.findOne(authId);
    }

    @Override
    public List<Auth> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Auth> findByRoleId(Long roleId) {
        return mapper.findByRoleId(roleId);
    }

    @Override
    public boolean insertRoleAuth(Long roleId, Integer authId) {
        return mapper.insertRoleAuth(roleId, authId) == 1;
    }

}
