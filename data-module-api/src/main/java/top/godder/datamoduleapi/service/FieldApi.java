package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import top.godder.datamoduleapi.domain.entity.Field;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: godder
 * @date: 2019/5/21
 */
@FeignClient(value = "service-data", url = "${service.service-data}")
public interface FieldApi {
    /**
     * 获取全部的领域
     * @return
     */
    @RequestMapping(value = Urls.FieldApi.GET_ALL_FIELD, method = POST)
    List<Field> getAllField();

    /**
     * 获取指定领域ID下的全部领域
     * @param parentId
     * @return
     */
    @RequestMapping(value = Urls.FieldApi.GET_SUB_FIELD, method = POST)
    List<Field> getSubField(Long parentId);

    /**
     * 获取指定文件的所在领域
     * @param fileId
     * @return
     */
    @RequestMapping(value = Urls.FieldApi.GET_FIELD_BY_FILE, method = POST)
    List<Field> getFieldByFile(Long fileId);

    /**
     * 添加领域，在redis中记录，在指定时间插入数据库
     * @param field
     * @return
     */
    @RequestMapping(value = Urls.FieldApi.ADD_FIELD, method = POST)
    boolean addField(Field field);

    /**
     * 更新领域，在redis中记录，在指定时间写入数据库
     * @param field
     * @return
     */
    @RequestMapping(value = Urls.FieldApi.UPDATE_FIELD, method = POST)
    boolean updateField(Field field);
}
