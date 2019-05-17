package top.godder.usermodule.infrastructure.mapper;

import top.godder.infrastructurecommon.database.BaseMapper;
import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;


import java.util.List;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    UserInfo findUserInfoById(Long id);

    List<UserInfo> findAllUserInfo();

    List<UserInfo> findUserInfoByReq(UserInfoReq req);

    boolean addUserInfo(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfo(Long id);
}