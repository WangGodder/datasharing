package top.godder.datamoduleapi.domain.vo;

import lombok.Data;

/**
 * @author: godder
 * @date: 2019/5/21
 */
@Data
public class DataFileReq {
    private String fileName;
    private Long fieldId;
    private Long userId;
}
