package top.godder.usermodule.infrastructure.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermodule.infrastructure.dao.UserInfoDao;
import top.godder.usermodule.infrastructure.mapper.UserInfoMapper;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;


import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/27
 */
@Service
public class UserInfoDaoImpl implements UserInfoDao {
    @Autowired
    private UserInfoMapper mapper;

    @Override
    public UserInfo findUserInfoById(Long id) {
        return mapper.findUserInfoById(id);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return mapper.findAllUserInfo();
    }

    @Override
    public List<UserInfo> findUserInfoByReq(UserInfoReq req) {
        return mapper.findUserInfoByReq(req);
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        return mapper.addUserInfo(userInfo);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return mapper.updateUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserInfo(Long id) {
        return mapper.deleteUserInfo(id);
    }
}
