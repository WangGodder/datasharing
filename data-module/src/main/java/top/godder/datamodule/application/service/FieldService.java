package top.godder.datamodule.application.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.godder.datamodule.domain.dao.DataFileDao;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.infrastructurecommon.util.RedisUtil;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@Service
public class FieldService {
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private RedisUtil redisUtil;

    public List<Field> getAllTopLevelField() {
        return fieldDao.findByFieldLevel(1);
    }

    public List<Field> getSubField(Long parentId) {
        if (parentId == null) {
            return null;
        }
        return fieldDao.findByParentFields(parentId);
    }

    public List<Field> getByFile(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return fieldDao.findByFileId(fileId);
    }

    public boolean addField(Field field) {
        if (field == null) {
            return false;
        }
        return fieldDao.insertOne(field);
    }

    public boolean addFieldRedis(Field field) {
        if (field == null) {
            return false;
        }
        String key = new StringBuilder("insert_field_").append(field.getFieldName()).toString();
        // 多次添加同一名称field覆盖上一次操作，保持最新操作
        redisUtil.set(key, JSON.toJSONString(field));
        return true;
    }

    public boolean updateField(Field field) {
        if (field == null) {
            return false;
        }
        return fieldDao.updateOne(field);
    }

    public boolean updateFieldRedis(Field field) {
        if (field == null) {
            return false;
        }
        String key = new StringBuilder("update_field_").append(field.getFieldId()).toString();
        // 多次修改同一IDfield覆盖上一次操作，保持最新操作
        redisUtil.set(key, JSON.toJSONString(field));
        return true;
    }

}
