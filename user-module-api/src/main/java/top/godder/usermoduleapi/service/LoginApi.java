package top.godder.usermoduleapi.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import top.godder.usermoduleapi.dto.UserTk;

import java.util.Map;

/**
 * @author: godder
 * @date: 2019/3/30
 */
@FeignClient(value = "service-user", url = "${service.service-user}")
public interface LoginApi {
    Long login(UserTk userTk);

    boolean register( UserTk userTk);

    boolean updatePs( Map<String, Object> userTkMap);

    boolean deleteUserTk( UserTk userTk);
}
