package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.DataFileDao;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@Service
public class FileService {
    @Autowired
    private DataFileDao dataFileDao;
}
