package top.godder.usermodule.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.usermoduleapi.domain.entity.City;
import top.godder.usermodule.infrastructure.dao.CityDao;
import top.godder.usermoduleapi.domain.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Repository
public class CityRepository {
    @Autowired
    private CityDao cityDao;

    public City findCityById(Integer id) {
        if (id <= 0) {
            return new City();
        }
        City result = cityDao.findCityById(id);
        return result;
    }

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }

    public List<City> findCityByProvince(Integer provinceId) {
        if (provinceId < 0) {
            return new ArrayList<>(0);
        }
        return cityDao.findCityByProvinceId(provinceId);
    }

    public boolean addCity(City city) {
        if (city == null) {
            return false;
        }
        return cityDao.addCity(city);
    }

    public boolean updateCity(City city) {
        if (city == null) {
            return false;
        }
        return cityDao.updateCity(city) == 1;
    }

    public boolean deleteCity(Integer id) {
        if (id < 0) {
            return false;
        }
        return cityDao.deleteCity(id) == 1;
    }
}
