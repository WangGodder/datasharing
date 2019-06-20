package top.godder.usermodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermodule.domain.repository.UserTkRepository;
import top.godder.usermodule.infrastructure.dao.UserTkDao;
import top.godder.usermoduleapi.domain.aggregate.LoginUser;
import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermodule.domain.factory.LoginUserFactory;
import top.godder.usermodule.domain.repository.UserInfoRepository;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserTkRepository userTkRepository;

    public UserInfo getUserInfo(Long userId) {
        return userInfoRepository.getUserInfoById(userId);
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.getAllUserInfo();
    }

    public List<UserInfo> getUserInfoByReq(UserInfoReq req) {
        return userInfoRepository.requestUserInfo(req);
    }

    public boolean addUserInfo(UserInfo userInfo) {
        return userInfoRepository.addUserInfo(userInfo);
    }

    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoRepository.updateUserInfo(userInfo);
    }

    public boolean deleteUserInfo(Long userId) {
        return userInfoRepository.deleteUserInfo(userId);
    }

    public LoginUser getLoginUser(Long userId) {
        return LoginUserFactory.getLoginUser(userId);
    }

    public String getUserName(Long userId) {
        return userTkRepository.getUserName(userId);
    }
}
