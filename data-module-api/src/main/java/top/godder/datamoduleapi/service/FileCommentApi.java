package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import top.godder.datamoduleapi.domain.entity.FileComment;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/23
 */
@FeignClient(value = "service-data", url = "${service.service-data}")
public interface FileCommentApi {
    /**
     * 获取指定文件的所有评价
     * @param fileId
     * @return
     */
    @PostMapping(value = Urls.FileCommentApi.GET_COMMENT_BY_FILE)
    List<FileComment> getCommentByFile(Long fileId);

    /**
     * 获取指定用户的所有文件评论
     * @param userId
     * @return
     */
    @PostMapping(value = Urls.FileCommentApi.GET_COMMENT_BY_USER)
    List<FileComment> getCommentByUser(Long userId);

    /**
     * 获取指定评价等级的所有评论
     * @param level
     * @return
     */
    @PostMapping(value = Urls.FileCommentApi.GET_COMMENT_BY_LEVEL)
    List<FileComment> getCommentByLevel(Integer level);

    /**
     * 获取指定文件的评价评价
     * @param fileId
     * @return
     */
    @PostMapping(value = Urls.FileCommentApi.GET_AVG_LEVEL)
    Float getAvgLevel(Long fileId);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping(value = Urls.FileCommentApi.ADD_COMMENT)
    boolean addComment(FileComment comment);
}
