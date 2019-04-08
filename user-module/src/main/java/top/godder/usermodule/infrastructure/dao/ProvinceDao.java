package top.godder.usermodule.infrastructure.dao;


import top.godder.usermodule.domain.entity.Province;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/7
 */
public interface ProvinceDao {
    Province findProvinceById(Integer id);

    List<Province> findAllProvince();

    boolean addProvince(Province province);

    Integer updateProvince(Province province);

    Integer deleteProvince(Integer id);
}
