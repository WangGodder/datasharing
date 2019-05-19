package top.godder.datamodule.domain.dao;

import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface UserLocalInfoDao {
    UserLocalInfo findOne(Long userId);

    boolean insertOne(UserLocalInfo info);

    boolean updateCredit(@Param("userId") Long userId, @Param("credit") int credit);

    boolean updateName(@Param("userId") Long userId, @Param("name") String name);

    boolean deleteOne(Long userId);
}
