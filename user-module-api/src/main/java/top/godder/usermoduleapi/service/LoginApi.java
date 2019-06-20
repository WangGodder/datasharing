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

    /**
     * 注册新用户
     * @param userTk
     * @return 注册用户ID
     */
    @RequestMapping(value = Urls.UserTkApiUrl.REGISTER, method = POST)
    Long register( UserTk userTk);

    /**
     * 检测用户名是否存在
     * @param userName 检测用户名
     * @return 是否存在
     */
    @RequestMapping(value = Urls.UserTkApiUrl.USER_NAME_EXIST, method = POST)
    boolean userNameExist(String userName);

    /**
     * 修改用户密码
     * @param userTkMap 包含用户名，用户新密码，用户旧密码
     * @return 是否修改成功
     */
    @RequestMapping(value = Urls.UserTkApiUrl.UPDATE_USER_TK, method = POST)
    boolean updatePs( Map<String, Object> userTkMap);

    /**
     * 删除用户
     * @param userTk 用户名，用户密码
     * @return 是否删除成功
     */
    @RequestMapping(value = Urls.UserTkApiUrl.DELETE_USER_TK, method = POST)
    boolean deleteUserTk( UserTk userTk);

}
