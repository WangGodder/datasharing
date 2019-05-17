package top.godder.usermoduleapi.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.usermoduleapi.domain.entity.UserTk;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/3/30
 */
@FeignClient(value = "service-user", url = "${service.service-user}")
public interface LoginApi {
    @RequestMapping(value = Urls.UserTkApiUrl.LOGIN, method = POST)
    Long login(UserTk userTk);

    @RequestMapping(value = Urls.UserTkApiUrl.REGISTER, method = POST)
    boolean register( UserTk userTk);

    @RequestMapping(value = Urls.UserTkApiUrl.UPDATE_USER_TK, method = POST)
    boolean updatePs( Map<String, Object> userTkMap);

    @RequestMapping(value = Urls.UserTkApiUrl.DELETE_USER_TK, method = POST)
    boolean deleteUserTk( UserTk userTk);
}
