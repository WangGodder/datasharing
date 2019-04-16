package top.godder.datamodule.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Question {
    @Id
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 问题名称
     */
    @Column(name = "question_name")
    private String questionName;

    /**
     * 问题描述
     */
    @Column(name = "question_description")
    private String questionDescription;

    /**
     * 问题积分
     */
    @Column(name = "question_credit")
    private Integer questionCredit;

    /**
     * 提问人ID
     */
    @Column(name = "quiz_user")
    private Long quizUser;

    /**
     * 问题相关领域
     */
    @Column(name = "field_id")
    private Long fieldId;

    /**
     * 问题相关文件ID，用,分割
     */
    @Column(name = "file_id")
    private String fileId;

    /**
     * @return question_id
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取问题名称
     *
     * @return question_name - 问题名称
     */
    public String getQuestionName() {
        return questionName;
    }

    /**
     * 设置问题名称
     *
     * @param questionName 问题名称
     */
    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    /**
     * 获取问题描述
     *
     * @return question_description - 问题描述
     */
    public String getQuestionDescription() {
        return questionDescription;
    }

    /**
     * 设置问题描述
     *
     * @param questionDescription 问题描述
     */
    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription == null ? null : questionDescription.trim();
    }

    /**
     * 获取问题积分
     *
     * @return question_credit - 问题积分
     */
    public Integer getQuestionCredit() {
        return questionCredit;
    }

    /**
     * 设置问题积分
     *
     * @param questionCredit 问题积分
     */
    public void setQuestionCredit(Integer questionCredit) {
        this.questionCredit = questionCredit;
    }

    /**
     * 获取提问人ID
     *
     * @return quiz_user - 提问人ID
     */
    public Long getQuizUser() {
        return quizUser;
    }

    /**
     * 设置提问人ID
     *
     * @param quizUser 提问人ID
     */
    public void setQuizUser(Long quizUser) {
        this.quizUser = quizUser;
    }

    /**
     * 获取问题相关领域
     *
     * @return field_id - 问题相关领域
     */
    public Long getFieldId() {
        return fieldId;
    }

    /**
     * 设置问题相关领域
     *
     * @param fieldId 问题相关领域
     */
    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    /**
     * 获取问题相关文件ID，用,分割
     *
     * @return file_id - 问题相关文件ID，用,分割
     */
    public String getFileId() {
        return fileId;
    }

    /**
     * 设置问题相关文件ID，用,分割
     *
     * @param fileId 问题相关文件ID，用,分割
     */
    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }
}