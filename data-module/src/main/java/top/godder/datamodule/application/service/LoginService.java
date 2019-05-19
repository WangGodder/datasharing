package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamodule.infrastructure.util.JwtUtil;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermoduleapi.service.LoginApi;

import java.net.ConnectException;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Service
public class LoginService {
    @Autowired
    private LoginApi loginApi;
    @Autowired
    private UserLocalInfoDao userLocalInfoDao;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(String username, String password) {
        UserTk userTk = new UserTk(username, password);
        Long userId;
        try {
            userId = loginApi.login(userTk);
        } catch (Exception e) {
            return "wrong";
        }
        if (userId == -1L) {
            return "";
        }
        userTk = new UserTk(userId, username);
        String jwt = jwtUtil.createJWT(userTk);
        return jwt;
    }

    public boolean register(Long userId) {
        UserLocalInfo localInfo = userLocalInfoDao.findOne(userId);
        if (localInfo == null) {
            UserLocalInfo userLocalInfo = UserLocalInfo.builder().userId(userId).credit(10).build();
            return userLocalInfoDao.insertOne(userLocalInfo);
        }
        return false;
    }
}
