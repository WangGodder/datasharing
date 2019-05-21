package top.godder.usermodule.infrastructure.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermodule.infrastructure.dao.UserTkDao;
import top.godder.usermodule.infrastructure.mapper.UserTkMapper;


/**
 * @author: godder
 * @date: 2019/3/27
 */
@Service
public class UserTkDaoImpl implements UserTkDao {
    @Autowired
    private UserTkMapper mapper;

    @Override
    public UserTk findUserTkByUserName(String userName) {
        return mapper.findUserTkByUserName(userName);
    }

    @Override
    public boolean addUserTk(UserTk userTk) {
        return mapper.addUserTk(userTk) == 1;
    }

    @Override
    public Integer updateUserTk(UserTk userTk) {
        return mapper.updateUserTk(userTk);
    }

    @Override
    public Integer deleteUserTk(UserTk userTk) {
        return mapper.deleteUserTk(userTk);
    }
}
