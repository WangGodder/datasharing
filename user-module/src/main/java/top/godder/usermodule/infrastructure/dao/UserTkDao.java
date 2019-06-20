package top.godder.usermodule.infrastructure.dao;


import top.godder.usermoduleapi.domain.entity.UserTk;

/**
 * @author: godder
 * @date: 2019/3/27
 */
public interface UserTkDao {
    UserTk findUserTkByUserName(String userName);

    String findUserName(Long userId);

    boolean addUserTk(UserTk userTk);

    Integer updateUserTk(UserTk userTk);

    Integer deleteUserTk(UserTk userTk);
}
