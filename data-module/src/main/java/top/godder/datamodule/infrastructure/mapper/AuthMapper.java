package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.Auth;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface AuthMapper extends BaseMapper<Auth> {
    Auth findOne(Integer authId);

    List<Auth> findAll();

    List<Auth> findByRoleId(Long roleId);
}
