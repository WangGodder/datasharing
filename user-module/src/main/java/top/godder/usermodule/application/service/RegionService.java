package top.godder.usermodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermoduleapi.domain.entity.City;
import top.godder.usermoduleapi.domain.entity.Province;
import top.godder.usermodule.domain.repository.CityRepository;
import top.godder.usermodule.domain.repository.ProvinceRepository;
import top.godder.usermoduleapi.domain.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Service
public class RegionService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CityRepository cityRepository;

    // province
    public Province findProvinceById(Integer id) {
        if (id < 0) {
            return new Province();
        }
        Province result = provinceRepository.findProvinceById(id);
        return result;
    }

    public List<Province> findAllProvince() {
        return provinceRepository.findAllProvince();
    }

    public boolean addProvince(Province province) {
        if (province == null) {
            return false;
        }
        return provinceRepository.addProvince(province);
    }

    public boolean updateProvince(Province province) {
        if (province == null) {
            return false;
        }
        return provinceRepository.updateProvince(province);
    }

    public boolean deleteProvince(Integer id) {
        if (id < 0) {
            return false;
        }
        return provinceRepository.deleteProvince(id);
    }

    // city
    public City findCityById(Integer id) {
        if (id <= 0) {
            return new City();
        }
        City result = cityRepository.findCityById(id);
        return result;
    }

    public List<City> findAllCity(){
        return cityRepository.findAllCity();
    }

    public List<City> findCityByProvince(Integer provinceId) {
        if (provinceId < 0) {
            return new ArrayList<>(0);
        }
        return cityRepository.findCityByProvince(provinceId);
    }

    public boolean addCity(City city) {
        if (city == null) {
            return false;
        }
        return cityRepository.addCity(city);
    }

    public boolean updateCity(City city) {
        if (city == null) {
            return false;
        }
        return cityRepository.updateCity(city);
    }

    public boolean deleteCity(Integer id) {
        if (id < 0) {
            return false;
        }
        return cityRepository.deleteCity(id);
    }
}
