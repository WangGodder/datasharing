package top.godder.usermodule.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.usermoduleapi.domain.entity.Province;
import top.godder.usermodule.infrastructure.dao.ProvinceDao;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/8
 */
@Repository
public class ProvinceRepository {
    @Autowired
    private ProvinceDao provinceDao;

    public Province findProvinceById(Integer id) {
        if (id < 0) {
            return new Province();
        }
        Province result = provinceDao.findProvinceById(id);
        return result;
    }

    public List<Province> findAllProvince() {
        return provinceDao.findAllProvince();
    }

    public boolean addProvince(Province province) {
        if (province == null) {
            return false;
        }
        return provinceDao.addProvince(province);
    }

    public boolean updateProvince(Province province) {
        if (province == null) {
            return false;
        }
        return provinceDao.updateProvince(province) == 1;
    }

    public boolean deleteProvince(Integer id) {
        if (id < 0) {
            return false;
        }
        return provinceDao.deleteProvince(id) == 1;
    }
}
