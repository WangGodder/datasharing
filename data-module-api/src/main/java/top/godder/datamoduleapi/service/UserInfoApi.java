package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.vo.UserInfoChangeNameReq;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@FeignClient(value = "service-data", url = "${service.service-data}")
public interface UserInfoApi {
    /**
     * 根据JWT获取用户基本信息
     * @param jwt
     * @return 如果jwt为空则返回null，否之返回UserBaseInfo实例
     */
    @RequestMapping(value = Urls.UserInfoApi.GET_BASE_INFO, method = POST)
    UserBaseInfo getBaseInfo(String jwt);

    /**
     * 修改系统用户名称
     * @param req 记录用户ID和修改的新名称
     * @return 是否成功修改名称
     */
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_NAME, method = POST)
    boolean changeName(UserInfoChangeNameReq req);

    /**
     * 修改用户积分
     * @param map 用户ID，修改的积分大小 （原积分 + 修改积分）可为负数
     * @return Integer 返回状态码
     * success code = 0
     * fail code = 2: user id is null
     * fail code = 3: update fail
     * fail code = 4: credit is not enough
     * fail code = 5: current user info is not exist
     */
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_CREDIT, method = POST)
    Integer changeCredit(Map<String, Object> map);

    /**
     * 添加用户涉及领域
     *
     * @param map 用户ID和加入领域的Id
     * @return 返回是否成功添加
     */
    @RequestMapping(value = Urls.UserInfoApi.ADD_FIELD, method = POST)
    boolean addField(Map<String, Long> map);

    /**
     * 删除用户所在领域
     * @param map 用户ID和领域ID
     * @return 返回是否成功删除
     */
    @RequestMapping(value = Urls.UserInfoApi.DELETE_FIELD, method = POST)
    boolean deleteField(Map<String, Long> map);
}
