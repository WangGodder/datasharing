package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 领域
 */
public class Field {
    private Long fieldId;

    /**
     * 领域名称
     */
    private String fieldName;

    /**
     * 领域级别，数字越小级别越高
     */
    private Integer fieldLevel;

    /**
     * 上级领域id
     */
    private Long parentFields;

    /**
     * 领域介绍
     */
    private String introduction;

}