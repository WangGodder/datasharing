package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.UserInfoService;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.vo.UserInfoChangeNameReq;
import top.godder.datamoduleapi.service.UserInfoApi;
import top.godder.infrastructurecommon.result.JsonResult;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@RestController
public class UserInfoRest implements UserInfoApi {
    @Autowired
    private UserInfoService userInfoService;

    @Override
    @RequestMapping(value = Urls.UserInfoApi.GET_BASE_INFO, method = POST)
    public UserBaseInfo getBaseInfo(@RequestBody String jwt) {
        return userInfoService.getBaseInfo(jwt);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_NAME, method = POST)
    public boolean changeName(@RequestBody UserInfoChangeNameReq req) {
        Long userId = req.getUserId();
        String name = req.getNewName();
        return userInfoService.changeName(userId, name);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_CREDIT, method = POST)
    public Integer changeCredit(@RequestBody Map<String, Object> map) {
        Long userId = ((Number) map.get("userId")).longValue();
        Integer credit = (Integer) map.get("credit");
        return userInfoService.changeCredit(userId, credit);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.ADD_FIELD, method = POST)
    public boolean addField(Map<String, Long> map) {
        Long userId = map.get("userId");
        Long fieldId = map.get("fieldId");
        return userInfoService.addUserField(userId, fieldId);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.DELETE_FIELD, method = POST)
    public boolean deleteField(Map<String, Long> map) {
        Long userId = map.get("userId");
        Long fieldId = map.get("fieldId");
        return userInfoService.deleteUserFeild(userId, fieldId);
    }
}
