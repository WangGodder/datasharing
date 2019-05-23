package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.vo.DataFileReq;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface DataFileMapper extends BaseMapper<DataFile> {
    DataFile findByFiledId(Long fileId);

    List<DataFile> findByUserId(Long userId);

    List<DataFile> findByFieldId(Long fieldId);

    List<DataFile> findAll();

    List<DataFile> findByFileName(String fileName);

    List<DataFile> findByReq(DataFileReq req);

    List<DataFile> findByUserBuy(Long userId);

    boolean buyFile(@Param("fileId") Long fileId, @Param("userId") Long userId);

    Integer countUserId(Long userId);

    Integer countFileId(Long fieldId);

    int insertOne(DataFile dataFile);

    int deleteByFileId(Long fileId);

    int deleteByUserId(Long userId);

    int deleteByFieldId(Long fieldId);
}
