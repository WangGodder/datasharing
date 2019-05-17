package top.godder.usermodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.godder.usermodule.application.service.UserService;
import top.godder.usermoduleapi.domain.aggregate.LoginUser;
import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;
import top.godder.usermoduleapi.service.UserApi;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/9
 */
@RestController
public class UserRest implements UserApi {
    @Autowired
    private UserService userService;

    @Override
    public UserInfo getUserInfo(Long id) {
        return userService.getUserInfo(id);
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userService.getAllUserInfo();
    }

    @Override
    public List<UserInfo> requestUserInfo(UserInfoReq req) {
        return userService.getUserInfoByReq(req);
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        return userService.addUserInfo(userInfo);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userService.updateUserInfo(userInfo);
    }

    @Override
    public boolean deleteUserInfo(Long id) {
        return userService.deleteUserInfo(id);
    }

    @Override
    public LoginUser getLoginUser(Long userId) {
        return userService.getLoginUser(userId);
    }
}
