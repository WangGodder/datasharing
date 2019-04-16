package top.godder.usermodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.godder.usermodule.application.api.RegionApi;
import top.godder.usermodule.application.service.RegionService;
import top.godder.usermodule.domain.entity.City;
import top.godder.usermodule.domain.entity.Province;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/9
 */
@RestController
public class RegionRest implements RegionApi {
    @Autowired
    private RegionService service;

    @Override
    public Province findProvinceById(Integer id) {
        return service.findProvinceById(id);
    }

    @Override
    public List<Province> findAllProvince() {
        return service.findAllProvince();
    }

    @Override
    public boolean addProvince(Province province) {
        return service.addProvince(province);
    }

    @Override
    public boolean updateProvince(Province province) {
        return service.updateProvince(province);
    }

    @Override
    public boolean deleteProvince(Integer id) {
        return service.deleteProvince(id);
    }

    @RequestMapping(value = Urls.CityApiUrl.GET_CITY, method = POST)
    @Override
    public City findCityById(Integer id) {
        return service.findCityById(id);
    }

    @Override
    public List<City> findAllCity() {
        return service.findAllCity();
    }

    @Override
    public List<City> findCityByProvince(Integer provinceId) {
        return service.findCityByProvince(provinceId);
    }

    @Override
    public boolean addCity(City city) {
        return service.addCity(city);
    }

    @Override
    public boolean updateCity(City city) {
        return service.updateCity(city);
    }

    @Override
    public boolean deleteCity(Integer id) {
        return service.deleteCity(id);
    }
}
