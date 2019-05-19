package top.godder.datamodule.domain.dao;

import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.Answer;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public interface AnswerDao {
    Answer findByAnswerId(Long answerId);

    List<Answer> findByQuestionId(Long questionId);

    List<Answer> findByAnswerUser(Long userId);

    List<Answer> findAll();

    boolean insertOne(Answer answer);

    boolean updateAnswerContent(@Param("answerId") Long answerId, @Param("newContent") String newContent);

    boolean deleteByAnswerId(Long answerId);

    boolean deleteByQuestionId(Long questionId);

    boolean deleteByAnswerUser(Long userId);
}
