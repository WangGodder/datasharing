package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.RoleDao;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamodule.infrastructure.util.JwtUtil;
import top.godder.datamoduleapi.domain.entity.Role;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermoduleapi.service.LoginApi;

import java.net.ConnectException;
import java.util.List;

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
    private RoleDao roleDao;
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

    public String register(String userName, String password) {
        UserTk userTk = new UserTk(userName, password);
        Long userId = loginApi.register(userTk);
        UserLocalInfo localInfo = userLocalInfoDao.findOne(userId);
        List<Role> roles = roleDao.findByUserId(userId);
        if (localInfo == null) {
            UserLocalInfo userLocalInfo = UserLocalInfo.builder().userId(userId).credit(10).build();
            if (!userLocalInfoDao.insertOne(userLocalInfo)) {
                return "wrong";
            }
        }
        if (roles.size() == 0 || roles == null) {
            if (!roleDao.insertUserRole(1L, userId)) {
                return "wrong";
            }
        }

        String jwt = jwtUtil.createJWT(userTk);
        return jwt;
    }
}
