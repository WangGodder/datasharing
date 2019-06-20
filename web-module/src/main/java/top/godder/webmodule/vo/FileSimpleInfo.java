package top.godder.webmodule.vo;

import lombok.Builder;
import lombok.Data;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.domain.entity.FileComment;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Data
@Builder
public class FileSimpleInfo {
    private DataFile file;
    private String uploaderName;
    private Integer downloadCredit;
    private Float level;
    private List<Field> fieldList;
    private List<FileComment> commentList;
}
