package top.godder.datamodule.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.QuestionDao;
import top.godder.datamodule.infrastructure.mapper.QuestionMapper;
import top.godder.datamoduleapi.domain.entity.Question;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class QuestionDaoImpl implements QuestionDao {
    @Autowired
    private QuestionMapper mapper;

    @Override
    public Question findByQuestionId(Long questionId) {
        return mapper.findByQuestionId(questionId);
    }

    @Override
    public List<Question> findByQuizUser(Long userId) {
        return mapper.findByQuizUser(userId);
    }

    @Override
    public int countQuizUser(Long userId) {
        return mapper.countQuizUser(userId);
    }

    @Override
    public boolean insertOne(Question question) {
        return mapper.insertOne(question) == 1;
    }

    @Override
    public boolean updateDescription(Long questionid, String description) {
        return mapper.updateDescription(questionid, description) == 1;
    }

    @Override
    public boolean deleteByQuestionId(Long questionId) {
        return mapper.deleteByQuestionId(questionId) == 1;
    }

    @Override
    public boolean deleteByQuizUser(Long userId) {
        return mapper.deleteByQuizUser(userId) == mapper.countQuizUser(userId);
    }
}
