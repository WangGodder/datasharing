package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.Field;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
public interface FieldDao {
    Field findByFieldId(Long fieldId);

    /**
     * 返回指定领域内内所有下一级领域
     * @param fieldId
     * @return
     */
    List<Field> findByParentFields(Long fieldId);

    List<Field> findByFieldLevel(int level);

    List<Field> findAll();

    /**
     * 返回指定用户所在的领域
     * @param userId
     * @return
     */
    List<Field> findByUserId(Long userId);

    boolean insertOne(Field field);

    boolean updateOne(Field field);

    /**
     * 删除指定领域，同时删除所有下一级领域
     * warning: 不会自动删除超过一级的下级领域，若下级领域超过一层则会报错
     * @param fieldId
     * @return
     */
    boolean deleteByFieldId(Long fieldId);

    /**
     * 删除所有上级领域为指定值的所有领域
     * @param fieldId
     * @return
     */
    boolean deleteByParent(Long fieldId);
}
