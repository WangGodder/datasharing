package top.godder.datamoduleapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 针对数据提出问题
 */
public class Question {
    private Long questionId;

    /**
     * 问题名称
     */
    private String questionName;

    /**
     * 问题描述
     */
    private String questionDescription;

    /**
     * 问题积分
     */
    private Integer questionCredit;

    /**
     * 提问人ID
     */
    private Long quizUser;

}