package top.godder.usermodule.interfaces.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.godder.usermodule.application.service.LoginService;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermoduleapi.service.LoginApi;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author: godder
 * @date: 2019/4/3
 */
@RestController
public class LoginRest implements LoginApi {
    @Autowired
    private LoginService service;

    @Override
    @RequestMapping(value = Urls.UserTkApiUrl.LOGIN, method = POST)
    @ApiOperation(value = "用户登陆", notes = "传入用户名和未加密密码")
    public Long login(@RequestBody UserTk userTk) {
        return service.login(userTk);
    }

    @Override
    @RequestMapping(value = Urls.UserTkApiUrl.REGISTER, method = POST)
    public Long register(@RequestBody UserTk userTk) {
        return service.register(userTk);
    }

    @Override
    public boolean userNameExist(@RequestBody String userName) {
        return service.userNameExist(userName);
    }

    @Override
    @RequestMapping(value = Urls.UserTkApiUrl.UPDATE_USER_TK, method = POST)
    public boolean updatePs(@RequestBody Map<String, Object> userTkMap) {
        return service.changePs(userTkMap);
    }

    @Override
    @RequestMapping(value = Urls.UserTkApiUrl.DELETE_USER_TK, method = POST)
    public boolean deleteUserTk(@RequestBody UserTk userTk) {
        return service.logout(userTk);
    }
}
