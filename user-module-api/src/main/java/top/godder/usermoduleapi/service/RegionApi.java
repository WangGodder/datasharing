package top.godder.usermoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.usermoduleapi.domain.entity.City;
import top.godder.usermoduleapi.domain.entity.Province;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/4/1
 */
@FeignClient(value = "service-user", url = "${service.service-user}")
public interface RegionApi {
    // province
    /**
     * get the province dto by province id
     * @param id
     * @return
     */
    @RequestMapping(value = Urls.ProvinceApiUrl.GET_PROVINCE, method = POST)
    Province findProvinceById(@RequestBody Integer id);

    /**
     * get all province dto
     * @return
     */
    @RequestMapping(value = Urls.ProvinceApiUrl.GET_ALL_PROVINCE, method = GET)
    List<Province> findAllProvince();

    /**
     * add province into db
     * @param province province to add
     * @return if success
     */
    @RequestMapping(value = Urls.ProvinceApiUrl.ADD_PROVINCE, method = POST)
    boolean addProvince(@RequestBody Province province);

    @RequestMapping(value = Urls.ProvinceApiUrl.UPDATE_PROVINCE, method = POST)
    boolean updateProvince(@RequestBody Province province);

    @RequestMapping(value = Urls.ProvinceApiUrl.DELETE_PROVINCE, method = DELETE)
    boolean deleteProvince(@RequestBody Integer id);

    // city
    /**
     * get the city dto by city id
     * @param id
     * @return
     */
    @RequestMapping(value = Urls.CityApiUrl.GET_CITY, method = POST)
    City findCityById(Integer id);

    @RequestMapping(value = Urls.CityApiUrl.GET_ALL_CITY, method = GET)
    List<City> findAllCity();

    @RequestMapping(value = Urls.CityApiUrl.GET_CITY_BY_PROVINCE, method = POST)
    List<City> findCityByProvince(Integer provinceId);

    @RequestMapping(value = Urls.CityApiUrl.ADD_CITY, method = POST)
    boolean addCity(@RequestBody City city);

    @RequestMapping(value = Urls.CityApiUrl.UPDATE_CITY, method = POST)
    boolean updateCity(@RequestBody City city);

    @RequestMapping(value = Urls.CityApiUrl.DELETE_CITY, method = DELETE)
    boolean deleteCity(@RequestBody Integer id);
}
