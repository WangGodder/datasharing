package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.AnswerDao;
import top.godder.datamodule.infrastructure.mapper.AnswerMapper;
import top.godder.datamoduleapi.domain.entity.Answer;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class AnswerDaoImpl implements AnswerDao {
    @Autowired
    private AnswerMapper mapper;

    @Override
    public Answer findByAnswerId(Long answerId) {
        return mapper.findByAnswerId(answerId);
    }

    @Override
    public List<Answer> findByQuestionId(Long questionId) {
        return mapper.findByQuestionId(questionId);
    }

    @Override
    public List<Answer> findByAnswerUser(Long userId) {
        return mapper.findByAnswerUser(userId);
    }

    @Override
    public List<Answer> findAll() {
        return mapper.findAll();
    }

    @Override
    public boolean insertOne(Answer answer) {
        return mapper.insertOne(answer) == 1;
    }

    @Override
    public boolean updateAnswerContent(Long answerId, String newContent) {
        return mapper.updateAnswerContent(answerId, newContent) == 1;
    }

    @Override
    public boolean deleteByAnswerId(Long answerId) {
        return mapper.deleteByAnswerId(answerId) == 1;
    }

    @Override
    public boolean deleteByQuestionId(Long questionId) {
        return mapper.deleteByQuestionId(questionId) == mapper.countQuestionId(questionId);
    }

    @Override
    public boolean deleteByAnswerUser(Long userId) {
        return mapper.deleteByAnswerUser(userId) == mapper.countAnswerUser(userId);
    }
}
