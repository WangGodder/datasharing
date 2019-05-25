package top.godder.webmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.service.UserInfoApi;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Service
public class UserService {
    @Autowired
    private UserInfoApi userInfoApi;

    public UserBaseInfo readJwt(String jwt) {
        return userInfoApi.getBaseInfo(jwt);
    }
}
