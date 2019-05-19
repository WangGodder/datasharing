package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamodule.infrastructure.mapper.UserLocalInfoMapper;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class UserLocalInfoDaoImpl implements UserLocalInfoDao {
    @Autowired
    private UserLocalInfoMapper mapper;

    @Override
    public UserLocalInfo findOne(Long userId) {
        return mapper.findOne(userId);
    }

    @Override
    public boolean insertOne(UserLocalInfo info) {
        return mapper.insertOne(info) == 1;
    }

    @Override
    public boolean updateCredit(Long userId, int credit) {
        return mapper.updateCredit(userId, credit) == 1;
    }

    @Override
    public boolean updateName(Long userId, String name) {
        return mapper.updateName(userId, name) == 1;
    }

    @Override
    public boolean deleteOne(Long userId) {
        return mapper.deleteOne(userId) == 1;
    }
}
