package top.godder.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.infrastructurecommon.result.JsonResult;
import top.godder.webmodule.service.UserService;

/**
 * @author: godder
 * @date: 2019/5/25
 */
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "/user/verifyJwt")
    public JsonResult verfiyJwt(@RequestBody String jwt) {
        if (jwt == null) {
            return JsonResult.fail("jwt is empty");
        }
        UserBaseInfo userBaseInfo = service.readJwt(jwt);
        return JsonResult.success(userBaseInfo);
    }
}
