package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@FeignClient(value = "service-data", url = "${service.service-data}")
public interface LoginApi {
    /**
     * 登陆当前系统，并返回jwt或其他错误信息
     * @param userName 用户名
     * @param password 密码
     * @return wrong: 登陆模块连接错误
     *          "": 用户名、密码错误
     */
    @RequestMapping(value = Urls.LoginApi.LOGIN, method = POST)
    String login(String userName, String password);

    /**
     * 新用户注册初始化本地信息，创建UserLocalInfo，同时给予初始积分，和赋予用户角色
     * @param userId 新注册ID
     * @return 是否初始化成功
     */
    @RequestMapping(value = Urls.LoginApi.REGISTER, method = POST)
    boolean register(Long userId);
}
