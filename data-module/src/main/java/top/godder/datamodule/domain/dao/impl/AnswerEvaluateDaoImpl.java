package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.AnswerEvaluateDao;
import top.godder.datamodule.infrastructure.mapper.AnswerEvaluateMapper;
import top.godder.datamoduleapi.domain.entity.AnswerEvaluate;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class AnswerEvaluateDaoImpl implements AnswerEvaluateDao {
    @Autowired
    private AnswerEvaluateMapper mapper;

    @Override
    public Float findLevelAnswerId(Long answerId) {
        return mapper.findLevelAnswerId(answerId);
    }

    @Override
    public Integer countByAnswerId(Long answerId) {
        return mapper.countByAnswerId(answerId);
    }

    @Override
    public boolean insertOne(AnswerEvaluate answerEvaluate) {
        return mapper.insertOne(answerEvaluate) == 1;
    }

    @Override
    public boolean deleteByAnswerId(Long answerId) {
        return mapper.deleteByAnswerId(answerId) == 1;
    }

    @Override
    public boolean deleteByUserId(Long userId) {
        return mapper.deleteByUserId(userId) == mapper.countByUserId(userId);
    }
}
