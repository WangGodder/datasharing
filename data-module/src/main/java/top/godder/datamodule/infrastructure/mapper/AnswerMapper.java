package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.Answer;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
    Answer findByAnswerId(Long answerId);

    List<Answer> findByQuestionId(Long questionId);

    List<Answer> findByAnswerUser(Long userId);

    List<Answer> findAll();

    Integer countQuestionId(Long questionId);

    Integer countAnswerUser(Long userId);

    int insertOne(Answer answer);

    int updateAnswerContent(@Param("answerId") Long answerId, @Param("newContent") String newContent);

    int deleteByAnswerId(Long answerId);

    int deleteByQuestionId(Long questionId);

    int deleteByAnswerUser(Long userId);
}
