package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.FileComment;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface FileCommentDao {
    FileComment findByFileCommentId(Long fileCommentId);

    /**
     * 返回指定数据文件的评价
     * @param fileId
     * @return
     */
    List<FileComment> findByFileId(Long fileId);

    List<FileComment> findByUserId(Long userId);

    List<FileComment> findByCommentLevel(Integer level);

    /**
     * 返回指定数据文件的评价评价
     * @param fileId
     * @return
     */
    Float findAvgLevel(Long fileId);

    Integer countFileId(Long fileId);

    Integer countCommentLevel(Integer level);

    boolean insertOne(FileComment fileComment);

    /**
     * 更改一个数据文件评价的内容和级别
     * @param fileComment
     * @return
     */
    boolean updateOne(FileComment fileComment);

    boolean deleteByFileCommentId(Long fileCommentId);

    boolean deleteByFileId(Long fileId);

    boolean deleteByUserId(Long userId);
}
