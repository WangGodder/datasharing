package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.godder.datamoduleapi.domain.entity.Question;
import top.godder.infrastructurecommon.database.BaseMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
    Question findByQuestionId(Long questionId);

    List<Question> findByQuizUser(Long userId);

    int countQuizUser(Long userId);

    int insertOne(Question question);

    int updateDescription(@Param("questionId") Long questionid, @Param("description") String description);

    int deleteByQuestionId(Long questionId);

    int deleteByQuizUser(Long userId);
}
