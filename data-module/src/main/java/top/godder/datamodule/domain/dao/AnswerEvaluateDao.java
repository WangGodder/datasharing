package top.godder.datamodule.domain.dao;

import top.godder.datamoduleapi.domain.entity.AnswerEvaluate;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface AnswerEvaluateDao {
    /**
     * 获取答案的平均评价
     * @param answerId
     * @return
     */
    Float findLevelAnswerId(Long answerId);

    /**
     * 获取答案的评价数
     * @param answerId
     * @return
     */
    Integer countByAnswerId(Long answerId);

    boolean insertOne(AnswerEvaluate answerEvaluate);

    boolean deleteByAnswerId(Long answerId);

    boolean deleteByUserId(Long userId);
}
