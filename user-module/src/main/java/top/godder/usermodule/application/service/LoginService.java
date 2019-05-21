package top.godder.usermodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermodule.domain.repository.UserTkRepository;

import java.util.Map;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Service
public class LoginService {
    @Autowired
    private UserTkRepository userTkRepository;

    public Long login(UserTk userTk) {
        return userTkRepository.getUserId(userTk);
    }

    public Long register(UserTk userTk) {
        return userTkRepository.register(userTk);
    }

    public boolean changePs(Map<String, Object> userTkMap) {
        return userTkRepository.changeUserPs(userTkMap);
    }

    public boolean logout(UserTk userTk) {
        return userTkRepository.logout(userTk);
    }
}
