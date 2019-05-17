package top.godder.usermodule.infrastructure.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermoduleapi.domain.entity.City;
import top.godder.usermodule.infrastructure.dao.CityDao;
import top.godder.usermodule.infrastructure.mapper.CityMapper;
import top.godder.usermoduleapi.domain.entity.City;


import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/7
 */
@Service
public class CityDaoImpl implements CityDao {
    @Autowired
    private CityMapper mapper;

    @Override
    public City findCityById(Integer id) {
        return mapper.findCityById(id);
    }

    @Override
    public List<City> findAllCity() {
        return mapper.findAllCity();
    }

    @Override
    public List<City> findCityByProvinceId(Integer provinceId) {
        return mapper.findCityByProvinceId(provinceId);
    }

    @Override
    public Integer updateCity(City city) {
        return mapper.updateCity(city);
    }

    @Override
    public boolean addCity(City city) {
        return mapper.addCity(city);
    }

    @Override
    public Integer deleteCity(Integer id) {
        return mapper.deleteCity(id);
    }
}
