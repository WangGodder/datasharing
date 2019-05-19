package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.Role;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    Role findOne(Long roleId);

    List<Role> findAll();

    List<Role> findByUserId(Long userId);

    int insertOne(Role role);

    int deleteOne(Long roleId);
}
