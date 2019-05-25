package top.godder.webmodule.vo;

import lombok.Data;
import top.godder.datamoduleapi.domain.entity.Field;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Data
public class FileSimpleInfo {
    private Long fileId;
    private String fileName;
    private String info;
    private Float level;
    private List<FileFieldInfo> fieldList;
}
