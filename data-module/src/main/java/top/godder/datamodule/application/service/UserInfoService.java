package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamodule.infrastructure.util.JwtUtil;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.infrastructurecommon.result.JsonResult;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@Service
public class UserInfoService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserLocalInfoDao userLocalInfoDao;
    @Autowired
    private FieldDao fieldDao;

    public UserBaseInfo getBaseInfo(String jwt) {
        if (jwt == null || jwt.isEmpty()) {
            return null;
        }
        return jwtUtil.verifyJWT(jwt);
    }

    public boolean changeName(Long userId, String name) {
        if (userId == null || name == null || name.isEmpty()) {
            return false;
        }
        return userLocalInfoDao.updateName(userId, name);
    }

    public JsonResult changeCredit(Long userId, int credit) {
        if (userId == null) {
            return JsonResult.fail(2,"userId is null");
        }
        int currentCredit = userLocalInfoDao.findOne(userId).getCredit();
        if (currentCredit + credit < 0) {
            return JsonResult.fail(4,"credit is not enough");
        }
        if (userLocalInfoDao.updateCredit(userId, currentCredit + credit)) {
            return JsonResult.success(currentCredit + credit);
        }
        return JsonResult.fail(3,"update credit is fail");
    }

    public JsonResult addUserField(Long userId, Long fieldId) {
        if (userId == null || fieldId == null) {
            return JsonResult.fail(2, "user id and field id is null");
        }
        if (fieldDao.insertUserField(fieldId, userId)) {
            return JsonResult.success();
        }
        return JsonResult.fail(3, "insert fail");
    }

    public JsonResult deleteUserFeild(Long userId, Long fieldId) {
        if (userId == null || fieldId == null) {
            return JsonResult.fail(2, "user id and field id is null");
        }
        if (fieldDao.deleteUserField(fieldId, userId)) {
            return JsonResult.success();
        }
        return JsonResult.fail(3, "delete fail");
    }
}
