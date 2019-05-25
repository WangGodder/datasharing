package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.godder.datamodule.application.service.FieldService;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.service.FieldApi;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/21
 */
@RestController
public class FieldRest implements FieldApi {
    @Autowired
    private FieldService fieldService;

    @Override
    public List<Field> getAllField() {
        return fieldService.getAllTopLevelField();
    }

    @Override
    public List<Field> getSubField(Long parentId) {
        return fieldService.getSubField(parentId);
    }

    @Override
    public List<Field> getFieldByFile(Long fileId) {
        return null;
    }

    @Override
    public boolean addField(Field field) {
        return fieldService.addFieldRedis(field);
    }

    @Override
    public boolean updateField(Field field) {
        return fieldService.updateFieldRedis(field);
    }
}
