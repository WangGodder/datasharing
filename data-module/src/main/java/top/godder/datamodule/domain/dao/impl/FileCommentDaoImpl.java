package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.FileCommentDao;
import top.godder.datamodule.infrastructure.mapper.FileCommentMapper;
import top.godder.datamoduleapi.domain.entity.FileComment;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class FileCommentDaoImpl implements FileCommentDao {
    @Autowired
    private FileCommentMapper mapper;

    @Override
    public FileComment findByFileCommentId(Long fileCommentId) {
        return mapper.findByFileCommentId(fileCommentId);
    }

    @Override
    public List<FileComment> findByFileId(Long fileId) {
        return mapper.findByFileId(fileId);
    }

    @Override
    public List<FileComment> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public List<FileComment> findByCommentLevel(Integer level) {
        return mapper.findByCommentLevel(level);
    }

    @Override
    public Float findAvgLevel(Long fileId) {
        return mapper.findAvgLevel(fileId);
    }

    @Override
    public Integer countFileId(Long fileId) {
        return mapper.countFileId(fileId);
    }

    @Override
    public Integer countCommentLevel(Integer level) {
        return mapper.countCommentLevel(level);
    }

    @Override
    public boolean insertOne(FileComment fileComment) {
        return mapper.insertOne(fileComment) == 1;
    }

    @Override
    public boolean updateOne(FileComment fileComment) {
        return mapper.updateOne(fileComment) == 1;
    }

    @Override
    public boolean deleteByFileCommentId(Long fileCOmmentId) {
        return mapper.deleteByFileCommentId(fileCOmmentId) == 1;
    }

    @Override
    public boolean deleteByFileId(Long fileId) {
        return mapper.deleteByFileId(fileId) == mapper.countFileId(fileId);
    }

    @Override
    public boolean deleteByUserId(Long userId) {
        return mapper.deleteByUserId(userId) == mapper.countUserId(userId);
    }
}
