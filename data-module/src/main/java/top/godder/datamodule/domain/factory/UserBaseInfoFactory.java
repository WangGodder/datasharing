package top.godder.datamodule.domain.factory;

import org.springframework.beans.factory.annotation.Autowired;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamodule.domain.dao.RoleDao;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.domain.entity.Role;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
public class UserBaseInfoFactory {
    @Autowired
    private static UserLocalInfoDao userLocalInfoDao;

    @Autowired
    private static FieldDao fieldDao;

    @Autowired
    private static RoleDao roleDao;

    public static UserBaseInfo createUserBaseInfo(Long userId) {
        UserLocalInfo userLocalInfo = userLocalInfoDao.findOne(userId);
        List<Role> roleList = roleDao.findByUserId(userId);
        List<Field> fieldList = fieldDao.findByUserId(userId);
        UserBaseInfo userBaseInfo = UserBaseInfo.builder()
                .userId(userId)
                .localName(userLocalInfo.getName())
                .credit(userLocalInfo.getCredit())
                .fieldList(fieldList)
                .roleList(roleList)
                .build();
        return userBaseInfo;
    }
}
