package top.godder.webmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamoduleapi.service.LoginApi;
import top.godder.infrastructurecommon.result.JsonResult;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Service
public class LoginService {
    @Autowired
    private LoginApi loginApi;
    private final static String SERVER_OUTTIME_JWT = "wrong";

    public JsonResult login(String userName, String password) {
        String jwt = loginApi.login(userName, password);
        if (SERVER_OUTTIME_JWT.equals(jwt)) {
            return JsonResult.fail("用户服务连接失败");
        }
        if (jwt.isEmpty()) {
            return JsonResult.fail("用户名、密码错误");
        }
        return JsonResult.success(jwt);
    }
}
