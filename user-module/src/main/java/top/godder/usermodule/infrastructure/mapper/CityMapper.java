package top.godder.usermodule.infrastructure.mapper;

import top.godder.infrastructurecommon.database.BaseMapper;
import top.godder.usermoduleapi.domain.entity.City;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {
    City findCityById(Integer id);

    List<City> findAllCity();

    List<City> findCityByProvinceId(Integer provinceId);

    Integer updateCity(City city);

    boolean addCity(City city);

    Integer deleteCity(Integer id);
}