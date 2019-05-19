package top.godder.datamodule.domain.dao;

import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.Question;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface QuestionDao {
    Question findByQuestionId(Long questionId);

    List<Question> findByQuizUser(Long userId);

    int countQuizUser(Long userId);

    boolean insertOne(Question question);

    boolean updateDescription(@Param("questionId") Long questionid, @Param("description") String description);

    boolean deleteByQuestionId(Long questionId);

    boolean deleteByQuizUser(Long userId);
}
