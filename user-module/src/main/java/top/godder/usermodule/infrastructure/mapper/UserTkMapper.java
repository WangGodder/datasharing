package top.godder.usermodule.infrastructure.mapper;

import top.godder.infrastructurecommon.database.BaseMapper;
import top.godder.usermoduleapi.domain.entity.UserTk;


public interface UserTkMapper extends BaseMapper<UserTk> {
    UserTk findUserTkByUserName(String userName);

    String findUserName(Long userId);

    int addUserTk(UserTk userTk);

    Integer updateUserTk(UserTk userTk);

    Integer deleteUserTk(UserTk userTk);
}