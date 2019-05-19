package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.FileDownloadDao;
import top.godder.datamodule.infrastructure.mapper.FileDownloadMapper;
import top.godder.datamoduleapi.domain.entity.FileDownload;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class FileDownloadDaoImpl implements FileDownloadDao {
    @Autowired
    private FileDownloadMapper mapper;

    @Override
    public int countFileId(Long fileId) {
        return mapper.countFileId(fileId);
    }

    @Override
    public int countDownloadUser(Long userId) {
        return mapper.countDownloadUser(userId);
    }

    @Override
    public boolean insertOne(FileDownload fileDownload) {
        return mapper.insertOne(fileDownload) == 1;
    }
}
