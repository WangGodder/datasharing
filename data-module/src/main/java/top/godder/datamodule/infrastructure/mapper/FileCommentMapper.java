package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.FileComment;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface FileCommentMapper extends BaseMapper<FileComment> {
    FileComment findByFileCommentId(Long fileCommentId);

    List<FileComment> findByFileId(Long fileId);

    List<FileComment> findByUserId(Long userId);

    List<FileComment> findByCommentLevel(Integer level);

    Float findAvgLevel(Long fileId);

    int countFileId(Long fileId);

    int countCommentLevel(Integer level);

    int countUserId(Long userId);

    int insertOne(FileComment fileComment);

    int updateOne(FileComment fileComment);

    int deleteByFileCommentId(Long fileCOmmentId);

    int deleteByFileId(Long fileId);

    int deleteByUserId(Long userId);
}
