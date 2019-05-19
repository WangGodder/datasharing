package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 *
 *  @author: godder
 *  @date: 2019/4/12
 * 提问者对回答的评价
 */
public class AnswerEvaluate {
    private Long answerId;

    /**
     * 对回答评价的用户ID
     */
    private Long userId;

    /**
     * 对回答的评价级别(1-5分)
     */
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