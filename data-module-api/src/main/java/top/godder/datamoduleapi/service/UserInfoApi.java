package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.infrastructurecommon.result.JsonResult;

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
     * @param userId
     * @param name
     * @return 是否成功修改名称
     */
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_NAME, method = POST)
    boolean changeName(Long userId, String name);

    /**
     * 修改用户积分
     * @param userId
     * @param credit 修改的积分大小 （原积分 + 修改积分）可为负数
     * @return 返回JsonResult对象记录状态
     * fail code = 2: user id is null
     * fail code = 3: update fail
     * fail code = 4: credit is not enough
     */
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_CREDIT, method = POST)
    JsonResult changeCredit(Long userId, Integer credit);

    /**
     * 添加用户涉及领域
     * @param userId
     * @param fieldId
     * @return 返回JsonResult对象记录状态
     * fail code = 2: user id is null
     * fail code = 3: delete fail
     */
    @RequestMapping(value = Urls.UserInfoApi.ADD_FIELD, method = POST)
    JsonResult addField(Long userId, Long fieldId);

    /**
     * 删除用户所在领域
     * @param userId
     * @param fieldId
     * @return 返回JsonResult对象记录状态
     * fail code = 2: user id is null
     * fail code = 3: delete fail
     */
    @RequestMapping(value = Urls.UserInfoApi.DELETE_FIELD, method = POST)
    JsonResult deleteField(Long userId, Long fieldId);
}
