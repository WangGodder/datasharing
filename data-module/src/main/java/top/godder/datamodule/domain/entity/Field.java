package top.godder.datamodule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @Column(name = "field_id")
    private Long fieldId;

    /**
     * 领域名称
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 领域级别，数字越小级别越高
     */
    @Column(name = "field_level")
    private Integer fieldLevel;

    /**
     * 包含下级领域id，用,隔开
     */
    @Column(name = "sub_fields")
    private String subFields;

    /**
     * 领域介绍
     */
    private String introduction;

    public Field(String fieldName, Integer fieldLevel, String subFields, String introduction) {
        this.fieldName = fieldName;
        this.fieldLevel = fieldLevel;
        this.subFields = subFields;
        this.introduction = introduction;
    }
}