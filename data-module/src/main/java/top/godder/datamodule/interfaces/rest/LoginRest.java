package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.LoginService;
import top.godder.datamoduleapi.service.LoginApi;
import top.godder.datamoduleapi.service.Urls;
import top.godder.usermoduleapi.domain.entity.UserTk;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@RestController
public class LoginRest implements LoginApi {
    @Autowired
    private LoginService loginService;

    @Override
    @RequestMapping(value = Urls.LoginApi.LOGIN, method = POST)
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return loginService.login(userName, password);
    }

    @Override
    @RequestMapping(value = Urls.LoginApi.REGISTER, method = POST)
    public boolean register(@RequestBody Long userId) {
        return loginService.register(userId);
    }
}
