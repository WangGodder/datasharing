package top.godder.usermodule.infrastructure.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.godder.usermodule.domain.entity.Province;
import top.godder.usermodule.infrastructure.dao.ProvinceDao;
import top.godder.usermodule.infrastructure.mapper.ProvinceMapper;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/4/7
 */
@Service
public class ProvinceDaoImpl implements ProvinceDao {
    @Autowired
    private ProvinceMapper mapper;

    @Override
    public Province findProvinceById(Integer id) {
        return mapper.findProvinceById(id);
    }

    @Override
    public List<Province> findAllProvince() {
        return mapper.findAllProvince();
    }

    @Override
    public boolean addProvince(Province province) {
        return mapper.addProvince(province);
    }

    @Override
    public Integer updateProvince(Province province) {
        return mapper.updateProvince(province);
    }

    @Override
    public Integer deleteProvince(Integer id) {
        return mapper.deleteProvince(id);
    }
}
