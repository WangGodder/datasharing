package top.godder.datamodule.interfaces.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.LoginService;
import top.godder.datamoduleapi.domain.vo.SystemLoginReq;
import top.godder.datamoduleapi.service.SystemLoginApi;


import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@RestController
public class SystemLoginRest implements SystemLoginApi {
    @Autowired
    private LoginService loginService;

    @Override
    @RequestMapping(value = Urls.LoginApi.LOGIN, method = POST)
    @ApiOperation(value = "用户登陆", notes = "传入用户名和未加密密码")
    public String login(@RequestBody SystemLoginReq req) {
        String userName = req.getUserName();
        String password = req.getPassword();
        return loginService.login(userName, password);
    }

    @Override
    @RequestMapping(value = Urls.LoginApi.REGISTER, method = POST)
    public String register(@RequestBody Map<String, String> userTkMap) {
        String userName = userTkMap.get("userName");
        String password = userTkMap.get("password");
        return loginService.register(userName, password);
    }
}
