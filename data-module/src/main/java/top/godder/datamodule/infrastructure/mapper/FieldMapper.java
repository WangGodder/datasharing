package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface FieldMapper extends BaseMapper<Field> {
    Field findByFieldId(Long fieldId);

    List<Field> findByParentFields(Long fieldId);

    List<Field> findByFieldLevel(int level);

    List<Field> findAll();

    List<Field> findByUserId(Long userId);

    int countParentFields(Long fieldId);

    int insertOne(Field field);

    int updateOne(Field field);

    int deleteByFieldId(Long fieldId);

    int deleteByParent(Long fieldId);
}
