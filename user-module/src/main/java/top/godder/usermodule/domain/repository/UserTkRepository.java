package top.godder.usermodule.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.infrastructurecommon.util.DIUtil;
import top.godder.usermodule.domain.entity.UserTk;
import top.godder.usermodule.infrastructure.dao.UserTkDao;
import top.godder.usermodule.infrastructure.util.MD5;

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
            return -1l;
        }
        if (userTk.getUserName().isEmpty() || userTk.getUserPs().isEmpty()) {
            return -1l;
        }
        UserTk findUserTk = userTkDao.findUserTkByUserName(userTk.getUserName());
        if (userTk.verify(findUserTk)) {
            return findUserTk.getId();
        }
        return -1l;
    }

    public boolean register(UserTk userTk) {
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
        return userTkDao.addUserTk(userTk);
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
        if (userId == -1l) {
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
}
