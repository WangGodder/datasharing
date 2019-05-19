/**
 * @author: godder
 * @date: 2019/4/12
 */
package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 对问题的回答
 */
public class Answer {
    private Long answerId;

    /**
     * 问题ID
     */
    private Long questionId;

    /**
     * 回答人
     */
    private Long answerUser;

    /**
     * 回答内容(可选)
     */
    private String answerContent;

    /**
     * 回答时间
     */
    private Date answerDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return Objects.equals(answerId, answer.answerId) &&
                Objects.equals(questionId, answer.questionId) &&
                Objects.equals(answerUser, answer.answerUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, questionId, answerUser);
    }
}