package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.QuestionDao;
import top.godder.infrastructurecommon.util.RedisUtil;

/**
 * @author: godder
 * @date: 2019/5/23
 */
@Service
public class QuestionService {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private QuestionDao questionDao;


}
