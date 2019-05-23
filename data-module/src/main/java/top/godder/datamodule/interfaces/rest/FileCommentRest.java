package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.FileCommentService;
import top.godder.datamoduleapi.domain.entity.FileComment;
import top.godder.datamoduleapi.service.FileCommentApi;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/23
 */
@RestController
public class FileCommentRest implements FileCommentApi {
    @Autowired
    private FileCommentService service;

    @Override
    public List<FileComment> getCommentByFile(Long fileId) {
        return service.listCommentByFileId(fileId);
    }

    @Override
    public List<FileComment> getCommentByUser(Long userId) {
        return service.listCommentByUserId(userId);
    }

    @Override
    public List<FileComment> getCommentByLevel(Integer level) {
        return service.listCommentByLevel(level);
    }

    @Override
    public Float getAvgLevel(Long fileId) {
        return service.getFileAvgLevel(fileId);
    }

    @Override
    public boolean addComment(FileComment comment) {
        return service.insertCommentRedis(comment);
    }
}
