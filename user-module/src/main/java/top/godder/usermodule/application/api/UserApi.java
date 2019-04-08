package top.godder.usermodule.application.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.usermodule.domain.aggregates.LoginUser;
import top.godder.usermodule.domain.entity.UserInfo;
import top.godder.usermodule.domain.vo.UserInfoReq;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/3/31
 */
@FeignClient(value = "service-user", url = "${service.service-user}")
public interface UserApi {
    // user info
    @RequestMapping(value = Urls.UserInfoApiUrl.GET_USER_INFO, method = POST)
    UserInfo getUserInfo(@RequestBody Long id);

    @RequestMapping(value = Urls.UserInfoApiUrl.GET_ALL_USER_INFO, method = GET)
    List<UserInfo> getAllUserInfo();

    @RequestMapping(value = Urls.UserInfoApiUrl.REQ_USER_INFO, method = POST)
    List<UserInfo> requestUserInfo(@RequestBody UserInfoReq req);

    @RequestMapping(value = Urls.UserInfoApiUrl.ADD_USER_INFO, method = POST)
    boolean addUserInfo(@RequestBody UserInfo userInfo);

    @RequestMapping(value = Urls.UserInfoApiUrl.UPDATE_USER_INFO, method = POST)
    boolean updateUserInfo(@RequestBody UserInfo userInfo);

    @RequestMapping(value = Urls.UserInfoApiUrl.DELETE_USER_INFO, method = DELETE)
    boolean deleteUserInfo(@RequestBody Long id);

    // login user
    @RequestMapping(value = Urls.LoginUserApiUrl.GET_LOGIN_USER, method = POST)
    LoginUser getLoginUser(@RequestBody Long userId);

    @RequestMapping(value = Urls.LoginUserApiUrl.GET_ALL_LOGIN_USER, method = GET)
    List<LoginUser> getAllLoginUser();
}
