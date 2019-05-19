package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.DataFileDao;
import top.godder.datamodule.infrastructure.mapper.DataFileMapper;
import top.godder.datamoduleapi.domain.entity.DataFile;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class DataFileDaoImpl implements DataFileDao {
    @Autowired
    private DataFileMapper mapper;

    @Override
    public DataFile findByFiledId(Long fileId) {
        return mapper.findByFiledId(fileId);
    }

    @Override
    public List<DataFile> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public List<DataFile> findByFieldId(Long fieldId) {
        return mapper.findByFieldId(fieldId);
    }

    @Override
    public List<DataFile> findAll() {
        return mapper.findAll();
    }

    @Override
    public boolean insertOne(DataFile dataFile) {
        return mapper.insertOne(dataFile) == 1;
    }

    @Override
    public boolean deleteByFileId(Long fileId) {
        return mapper.deleteByFileId(fileId) == 1;
    }

    @Override
    public boolean deleteByUserId(Long userId) {
        return mapper.deleteByUserId(userId) == mapper.countUserId(userId);
    }

    @Override
    public boolean deleteByFieldId(Long fieldId) {
        return mapper.deleteByFieldId(fieldId) == mapper.countFileId(fieldId);
    }

}
