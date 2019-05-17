package top.godder.usermodule.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermodule.infrastructure.dao.UserInfoDao;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Repository
public class UserInfoRepository {
    @Autowired
    private UserInfoDao dao;

    public UserInfo getUserInfoById(Long userId) {
        UserInfo result = dao.findUserInfoById(userId);
        return result;
    }

    public List<UserInfo> getAllUserInfo() {
        return dao.findAllUserInfo();
    }

    public List<UserInfo> requestUserInfo(UserInfoReq req) {
        if (req == null) {
            return new ArrayList<>(0);
        }
        return dao.findUserInfoByReq(req);
    }

    public boolean addUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        return dao.addUserInfo(userInfo);
    }

    public boolean updateUserInfo(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        return dao.updateUserInfo(userInfo) == 1;
    }

    public boolean deleteUserInfo(Long userId) {
        return dao.deleteUserInfo(userId) == 1;
    }
}
