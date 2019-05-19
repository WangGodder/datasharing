package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;
import top.godder.infrastructurecommon.database.BaseMapper;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Mapper
public interface UserLocalInfoMapper extends BaseMapper<UserLocalInfo> {
    UserLocalInfo findOne(Long userId);

    int insertOne(UserLocalInfo info);

    int updateCredit(@Param("userId") Long userId, @Param("credit") int credit);

    int updateName(@Param("userId") Long userId, @Param("name") String name);

    int deleteOne(Long userId);
}
