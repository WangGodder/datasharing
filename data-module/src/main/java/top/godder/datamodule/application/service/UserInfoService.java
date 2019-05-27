package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamodule.infrastructure.util.JwtUtil;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
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

    public Integer changeCredit(Long userId, int credit) {
        // userId is null
        if (userId == null) {
            return 2;
        }
        // lost current user info
        UserLocalInfo userLocalInfo = userLocalInfoDao.findOne(userId);
        if (userLocalInfo == null) {
            return 5;
        }
        int currentCredit = userLocalInfo.getCredit();
        // credit is not enough
        if (currentCredit + credit < 0) {
            return 4;
        }
        if (userLocalInfoDao.updateCredit(userId, currentCredit + credit)) {
            return 0;
        }
        // update credit is fail
        return 3;
    }

    public boolean addUserField(Long userId, Long fieldId) {
        if (userId == null || fieldId == null) {
            return false;
        }
        if (fieldDao.insertUserField(fieldId, userId)) {
            return true;
        }
        return false;
    }

    public boolean deleteUserFeild(Long userId, Long fieldId) {
        if (userId == null || fieldId == null) {
            return false;
        }
        if (fieldDao.deleteUserField(fieldId, userId)) {
            return true;
        }
        return false;
    }
}
