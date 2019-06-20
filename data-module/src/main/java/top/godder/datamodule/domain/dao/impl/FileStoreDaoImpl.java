package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.FileStoreDao;
import top.godder.datamodule.infrastructure.mapper.FileStoreMapper;
import top.godder.datamoduleapi.domain.entity.FileStore;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/6/20
 */
@Repository
public class FileStoreDaoImpl implements FileStoreDao {
    @Autowired
    private FileStoreMapper mapper;


    @Override
    public List<FileStore> findFileStoreByFileId(Long fileId) {
        return mapper.selectByPrimaryKey(fileId);
    }

    @Override
    public boolean insertFileStore(FileStore fileStore) {
        return mapper.insertSelective(fileStore) == 1;
    }

    @Override
    public boolean deleteFileStoreByFileId(Long fileId) {
        return mapper.deleteByPrimaryKey(fileId) > 0;
    }
}
