package top.godder.webmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamoduleapi.domain.vo.SystemLoginReq;
import top.godder.datamoduleapi.service.SystemLoginApi;
import top.godder.infrastructurecommon.result.JsonResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Service
public class LoginService {
    @Autowired
    private SystemLoginApi systemLoginApi;
    private final static String SERVER_OUTTIME_JWT = "wrong";

    public JsonResult login(String userName, String password) {
        SystemLoginReq req = new SystemLoginReq(userName, password);
        String jwt;
        jwt = systemLoginApi.login(req);
//        try {
//            jwt = systemLoginApi.login(userInfoMap);
//        } catch (Exception e) {
//            return JsonResult.fail(2,"系统服务器连接失败");
////        }
        if (SERVER_OUTTIME_JWT.equals(jwt)) {
            return JsonResult.fail(3,"用户服务连接失败");
        }
        if (jwt == null || jwt.isEmpty()) {
            return JsonResult.fail(4,"用户名、密码错误");
        }
        return JsonResult.success((Object)jwt);
    }
}
