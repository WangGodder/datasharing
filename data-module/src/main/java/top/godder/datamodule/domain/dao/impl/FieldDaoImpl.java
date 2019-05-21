package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamodule.infrastructure.mapper.FieldMapper;
import top.godder.datamoduleapi.domain.entity.Field;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Repository
public class FieldDaoImpl implements FieldDao {
    @Autowired
    private FieldMapper mapper;

    @Override
    public Field findByFieldId(Long fieldId) {
        return mapper.findByFieldId(fieldId);
    }

    @Override
    public List<Field> findByParentFields(Long fieldId) {
        return mapper.findByParentFields(fieldId);
    }

    @Override
    public List<Field> findByFieldLevel(int level) {
        return mapper.findByFieldLevel(level);
    }

    @Override
    public List<Field> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Field> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public boolean insertOne(Field field) {
        return mapper.insertOne(field) == 1;
    }

    @Override
    public boolean insertUserField(Long fieldId, Long userId) {
        return mapper.insertUserField(fieldId, userId) == 1;
    }

    @Override
    public boolean updateOne(Field field) {
        return mapper.updateOne(field) == 1;
    }

    @Override
    public boolean deleteByFieldId(Long fieldId) {
        return deleteByFieldId(fieldId) && mapper.deleteByFieldId(fieldId) == 1;
    }

    @Override
    public boolean deleteByParent(Long fieldId) {
        return mapper.deleteByParent(fieldId) == mapper.countParentFields(fieldId);
    }

    @Override
    public boolean deleteUserField(Long fieldId, Long userId) {
        return mapper.deleteUserField(fieldId, userId) == 1;
    }
}
