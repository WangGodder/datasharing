package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.FileStore;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/6/20
 */
public interface FileStoreDao {
    List<FileStore> findFileStoreByFileId(Long fileId);

    boolean insertFileStore(FileStore fileStore);

    boolean deleteFileStoreByFileId(Long fileId);
}
