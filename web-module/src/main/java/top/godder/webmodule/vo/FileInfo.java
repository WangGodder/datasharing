package top.godder.webmodule.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Data
public class FileInfo {
    private FileSimpleInfo fileSimpleInfo;
    private Integer downloadTimes;
    private List<String> fileList;
}
