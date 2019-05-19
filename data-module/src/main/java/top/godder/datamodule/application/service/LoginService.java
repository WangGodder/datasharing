package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.usermoduleapi.service.LoginApi;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Service
public class LoginService {
    @Autowired
    private LoginApi loginApi;
    @Autowired
    private UserLocalInfoDao userLocalInfoDao;


}
