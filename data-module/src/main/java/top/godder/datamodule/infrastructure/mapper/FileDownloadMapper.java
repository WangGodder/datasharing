package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.FileDownload;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface FileDownloadMapper extends BaseMapper<FileDownload> {
    int countFileId(Long fileId);

    int countDownloadUser(Long userId);

    int insertOne(FileDownload fileDownload);
}
