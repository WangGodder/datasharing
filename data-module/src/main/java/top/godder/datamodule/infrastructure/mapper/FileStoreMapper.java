package top.godder.datamodule.infrastructure.mapper;

import top.godder.datamoduleapi.domain.entity.FileStore;

import java.util.List;


/**
 * @author: godder
 * @date: 2019/6/20
*/
public interface FileStoreMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(FileStore record);

    int insertSelective(FileStore record);

    List<FileStore> selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(FileStore record);

    int updateByPrimaryKey(FileStore record);
}