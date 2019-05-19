package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.FileDownload;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface FileDownloadDao {
    int countFileId(Long fileId);

    int countDownloadUser(Long userId);

    boolean insertOne(FileDownload fileDownload);
}
