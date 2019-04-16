package top.godder.usermoduleapi.dto;

import lombok.Data;

/**
 * @author: godder
 * @date: 2019/4/15
 */
@Data
public class City {
    private Integer cityId;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 上级省份id
     */
    private Integer provinceId;

    /**
     * 城市信息
     */
    private String comment;
}
