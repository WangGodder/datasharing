package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.UserInfoService;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.service.Urls;
import top.godder.datamoduleapi.service.UserInfoApi;
import top.godder.infrastructurecommon.result.JsonResult;

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
    public UserBaseInfo getBaseInfo(String jwt) {
        return userInfoService.getBaseInfo(jwt);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_NAME, method = POST)
    public boolean changeName(@RequestParam("userId") Long userId, @RequestParam("name") String name) {
        return userInfoService.changeName(userId, name);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.CHANGE_CREDIT, method = POST)
    public JsonResult changeCredit(@RequestParam("userId") Long userId, @RequestParam("credit") Integer credit) {
        return userInfoService.changeCredit(userId, credit);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.ADD_FIELD, method = POST)
    public JsonResult addField(Long userId, Long fieldId) {
        return userInfoService.addUserField(userId, fieldId);
    }

    @Override
    @RequestMapping(value = Urls.UserInfoApi.DELETE_FIELD, method = POST)
    public JsonResult deleteField(Long userId, Long fieldId) {
        return userInfoService.deleteUserFeild(userId, fieldId);
    }
}
