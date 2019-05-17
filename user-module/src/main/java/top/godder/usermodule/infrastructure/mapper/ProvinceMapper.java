package top.godder.usermodule.infrastructure.mapper;

import top.godder.infrastructurecommon.database.BaseMapper;
import top.godder.usermoduleapi.domain.entity.Province;

import java.util.List;

public interface ProvinceMapper extends BaseMapper<Province> {
    Province findProvinceById(Integer id);

    List<Province> findAllProvince();

    boolean addProvince(Province province);

    Integer updateProvince(Province province);

    Integer deleteProvince(Integer id);
}