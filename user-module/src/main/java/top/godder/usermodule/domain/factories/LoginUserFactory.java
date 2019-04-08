package top.godder.usermodule.domain.factories;

import org.springframework.beans.factory.annotation.Autowired;
import top.godder.usermodule.domain.aggregates.LoginUser;
import top.godder.usermodule.domain.entity.City;
import top.godder.usermodule.domain.entity.Province;
import top.godder.usermodule.domain.entity.UserInfo;
import top.godder.usermodule.infrastructure.dao.CityDao;
import top.godder.usermodule.infrastructure.dao.ProvinceDao;
import top.godder.usermodule.infrastructure.dao.UserInfoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
public class LoginUserFactory {
    @Autowired
    private static UserInfoDao userInfoDao;
    @Autowired
    private static ProvinceDao provinceDao;
    @Autowired
    private static CityDao cityDao;

    public static LoginUser getLoginUser(Long userId) {
        UserInfo userInfo = userInfoDao.findUserInfoById(userId);
        if (userInfo == null) {
            return new LoginUser();
        }
        Province province = null;
        if (userInfo.getProvinceId() != null) {
            province = provinceDao.findProvinceById(userInfo.getProvinceId());
        }
        City city = null;
        if (userInfo.getCityId() != null) {
            city = cityDao.findCityById(userInfo.getCityId());
        }
        return new LoginUser(userInfo, province, city);
    }

    public static List<LoginUser> getLoginUsers(List<Long> userIdList) {
        List<LoginUser> result = new ArrayList<>(userIdList.size());
        for (Long userId : userIdList) {
            result.add(getLoginUser(userId));
        }
        return result;
    }
}
