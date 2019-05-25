package top.godder.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.godder.infrastructurecommon.result.JsonResult;
import top.godder.webmodule.service.LoginService;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/postLogin")
    public JsonResult login(@RequestParam("username") String userName, @RequestParam("password") String password) {
        return loginService.login(userName, password);
    }
}
