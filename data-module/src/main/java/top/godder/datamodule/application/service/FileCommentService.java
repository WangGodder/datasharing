package top.godder.datamodule.application.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.FileCommentDao;
import top.godder.datamoduleapi.domain.entity.FileComment;
import top.godder.infrastructurecommon.util.RedisUtil;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/23
 */
@Service
public class FileCommentService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private FileCommentDao fileCommentDao;

    public List<FileComment> listCommentByFileId(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return fileCommentDao.findByFileId(fileId);
    }

    public List<FileComment> listCommentByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        return fileCommentDao.findByUserId(userId);
    }

    public List<FileComment> listCommentByLevel(Integer level) {
        if (level == null || level < 0) {
            return null;
        }
        return fileCommentDao.findByCommentLevel(level);
    }

    public boolean insertComment(FileComment comment) {
        if (comment == null) {
            return false;
        }
        return fileCommentDao.insertOne(comment);
    }

    public boolean insertCommentRedis(FileComment comment) {
        if (comment == null) {
            return false;
        }
        String key = new StringBuilder("insert_fileComment_").append(comment.getFileCommentId()).toString();
        redisUtil.set(key, JSON.toJSONString(comment));
        return true;
    }

    public Float getFileAvgLevel(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return fileCommentDao.findAvgLevel(fileId);
    }
}
