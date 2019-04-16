package top.godder.datamodule.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Table(name = "answer_evaluate")
public class AnswerEvaluate {
    @Column(name = "answer_id")
    private Long answerId;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 提问者对回答的评价级别(1-5分)
     */
    @Column(name = "answer_level")
    private Integer answerLevel;

    /**
     * @return question_id
     */
    public Long getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId
     */
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

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
     * 获取提问者对回答的评价级别(1-5分)
     *
     * @return answer_level - 提问者对回答的评价级别(1-5分)
     */
    public Integer getAnswerLevel() {
        return answerLevel;
    }

    /**
     * 设置提问者对回答的评价级别(1-5分)
     *
     * @param answerLevel 提问者对回答的评价级别(1-5分)
     */
    public void setAnswerLevel(Integer answerLevel) {
        this.answerLevel = answerLevel;
    }
}