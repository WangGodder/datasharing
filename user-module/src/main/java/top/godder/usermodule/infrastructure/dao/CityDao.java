package top.godder.usermodule.infrastructure.dao;

import top.godder.usermodule.domain.entity.City;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/7
 */
public interface CityDao {
    City findCityById(Integer id);

    List<City> findAllCity();

    List<City> findCityByProvinceId(Integer provinceId);

    Integer updateCity(City city);

    boolean addCity(City city);

    Integer deleteCity(Integer id);
}
