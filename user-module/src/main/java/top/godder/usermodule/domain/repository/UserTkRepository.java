package top.godder.usermodule.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.infrastructurecommon.util.DIUtil;
import top.godder.infrastructurecommon.util.MD5;
import top.godder.usermoduleapi.domain.entity.UserTk;
import top.godder.usermodule.infrastructure.dao.UserTkDao;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Repository
public class UserTkRepository {
    @Autowired
    private UserTkDao userTkDao;

    public Long getUserId(UserTk userTk) {
        // 空值检测,减少无效数据库访问
        if (userTk == null || userTk.getUserName() == null || userTk.getUserPs() == null) {
            return -1L;
        }
        if (userTk.getUserName().isEmpty() || userTk.getUserPs().isEmpty()) {
            return -1L;
        }
        UserTk findUserTk = userTkDao.findUserTkByUserName(userTk.getUserName());
        if (userTk.verify(findUserTk)) {
            return findUserTk.getId();
        }
        return -1L;
    }

    public Long register(UserTk userTk) {
        // 空值检测,减少无效数据库访问
        if (userTk == null || userTk.getUserName() == null || userTk.getUserPs() == null) {
            return null;
        }
        if (userTk.getUserName().isEmpty() || userTk.getUserPs().isEmpty()) {
            return null;
        }
        if (!userTk.encryptionPs()) {
            return null;
        }
        if (userTkDao.addUserTk(userTk)) {
            return userTk.getId();
        }
        return null;
    }

    public boolean changeUserPs(Map<String, Object> userTkMap) {
        if (!userTkMap.containsKey("userName") || !userTkMap.containsKey("userPs") || !userTkMap.containsKey("newPs") ) {
            return false;
        }
        UserTk userTk = null;
        try {
            userTk = DIUtil.createByMap(userTkMap, UserTk.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String newPs = (String)userTkMap.get("newPs");
        Long userId = getUserId(userTk);
        if (userId == -1L) {
            return false;
        }
        userTk = new UserTk(userId, userTk.getUserName(), MD5.md5(newPs));
        return userTkDao.updateUserTk(userTk) == 1;
    }

    public boolean logout(UserTk userTk) {
        // 空值检测,减少无效数据库访问
        if (userTk == null || userTk.getUserName() == null || userTk.getUserPs() == null) {
            return false;
        }
        if (userTk.getUserName().isEmpty() || userTk.getUserPs().isEmpty()) {
            return false;
        }
        if (!userTk.encryptionPs()) {
            return false;
        }
        return userTkDao.deleteUserTk(userTk) == 1;
    }

    public boolean userNameEixst(String userName) {
        if (userName == null || userName.isEmpty()) {
            return false;
        }
        if (userTkDao.findUserTkByUserName(userName) == null) {
            return true;
        }
        return false;
    }

    public String getUserName(Long userId) {
        if (userId == null) {
            return null;
        }
        String name = userTkDao.findUserName(userId);
        if (name == null || name.isEmpty()) {
            return null;
        }
        return name;
    }
}
