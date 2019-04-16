package top.godder.datamodule.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_field")
public class UserField {
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 所在领域
     */
    @Column(name = "field_id")
    private Long fieldId;

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取所在领域
     *
     * @return field_id - 所在领域
     */
    public Long getFieldId() {
        return fieldId;
    }

    /**
     * 设置所在领域
     *
     * @param fieldId 所在领域
     */
    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }
}