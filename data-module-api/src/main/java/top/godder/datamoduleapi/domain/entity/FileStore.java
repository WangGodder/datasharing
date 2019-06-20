package top.godder.datamoduleapi.domain.entity;

import lombok.Builder;
import lombok.Data;


/**
 * @author: godder
 * @date: 2019/6/20
*/
@Data
@Builder
public class FileStore {
    private Long fileId;

    /**
    * 文件名称
    */
    private String fileName;

    /**
    * 文件大小
    */
    private Integer fileSize;
}