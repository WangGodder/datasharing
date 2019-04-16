package top.godder.usermoduleapi.dto;

import lombok.Data;

/**
 * @author: godder
 * @date: 2019/4/15
 */
@Data
public class Province {
    private Integer provinceId;

    /**
     * 省份名称
     */
    private String name;

    /**
     * 省份信息
     */
    private String comment;
}
