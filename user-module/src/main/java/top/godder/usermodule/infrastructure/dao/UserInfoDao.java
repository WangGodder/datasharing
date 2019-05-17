package top.godder.usermodule.infrastructure.dao;

import top.godder.usermoduleapi.domain.entity.UserInfo;
import top.godder.usermoduleapi.domain.vo.UserInfoReq;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/27
 */
public interface UserInfoDao {
    UserInfo findUserInfoById(Long id);

    List<UserInfo> findAllUserInfo();

    List<UserInfo> findUserInfoByReq(UserInfoReq req);

    boolean addUserInfo(UserInfo userInfo);

    Integer updateUserInfo(UserInfo userInfo);

    Integer deleteUserInfo(Long id);
}
