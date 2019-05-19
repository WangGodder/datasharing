package top.godder.datamodule.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.godder.datamoduleapi.domain.entity.AnswerEvaluate;
import top.godder.infrastructurecommon.database.BaseMapper;

/**
 * @author: godder
 * @date: 2019/5/18
 */
@Mapper
public interface AnswerEvaluateMapper extends BaseMapper<AnswerEvaluate> {
    Float findLevelAnswerId(Long answerId);

    Integer countByAnswerId(Long answerId);

    Integer countByUserId(Long userId);

    int insertOne(AnswerEvaluate answerEvaluate);

    int deleteByAnswerId(Long answerId);

    int deleteByUserId(Long userId);
}
