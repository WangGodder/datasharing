package top.godder.usermodule.infrastructure.mapper;

import top.godder.infrastructurecommon.database.BaseMapper;
import top.godder.usermodule.domain.entity.UserTk;


public interface UserTkMapper extends BaseMapper<UserTk> {
    UserTk findUserTkByUserName(String userName);

    boolean addUserTk(UserTk userTk);

    Integer updateUserTk(UserTk userTk);

    Integer deleteUserTk(UserTk userTk);
}