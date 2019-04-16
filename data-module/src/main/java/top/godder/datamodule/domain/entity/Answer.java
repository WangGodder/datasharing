package top.godder.datamodule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "answer_id")
    private Long answerId;

    /**
     * 问题ID
     */
    @Column(name = "question_id")
    private Long questionId;

    /**
     * 回答人
     */
    @Column(name = "answer_user")
    private Long answerUser;

    /**
     * 回答内容文件的名称
     */
    @Column(name = "answer_file_name")
    private String answerFileName;

    /**
     * 回答内容(可选)
     */
    @Column(name = "answer_content")
    private String answerContent;

    /**
     * 回答时间
     */
    @Column(name = "answer_date")
    private Date answerDate;

    public Answer(Long questionId, Long answerUser, String answerFileName, String answerContent, Date answerDate) {
        this.questionId = questionId;
        this.answerUser = answerUser;
        this.answerFileName = answerFileName;
        this.answerContent = answerContent.trim();
        this.answerDate = answerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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