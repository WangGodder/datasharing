package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
import top.godder.datamoduleapi.domain.vo.SystemLoginReq;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@FeignClient(name = "service-data", url = "${service.service-data}")
public interface SystemLoginApi {
    /**
     * 登陆当前系统，并返回jwt或其他错误信息
     * @param systemLoginReq 包含用户名,密码
     * @return wrong: 登陆模块连接错误
     *          "": 用户名、密码错误
     */
    @RequestMapping(value = Urls.LoginApi.LOGIN, method = POST)
    String login(@RequestBody SystemLoginReq systemLoginReq);

    /**
     * 注册新用户同时注册初始化本地信息，创建UserLocalInfo，同时给予初始积分，和赋予用户角色
     * @param userTkMap: 新注册用户名和密码
     * @return 新用户的jwt
     */
    @RequestMapping(value = Urls.LoginApi.REGISTER, method = POST)
    String register(Map<String, String> userTkMap);
}
