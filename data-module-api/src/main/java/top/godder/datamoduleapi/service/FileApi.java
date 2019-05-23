package top.godder.datamoduleapi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import top.godder.datamoduleapi.config.MultipartSupportConfig;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.vo.DataFileReq;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/21
 */
@FeignClient(value = "service-data", url = "${service.service-data}", configuration = MultipartSupportConfig.class)
public interface FileApi {
    /**
     * 获取全部数据文件
     * @return
     */
    @PostMapping(value = Urls.FileApi.GET_ALL_DATA_FILE)
    List<DataFile> getAllDataFile();

    /**
     * 获取指定用户上传的全部数据文件
     * @param userId
     * @return
     */
    @PostMapping(value = Urls.FileApi.GET_DATA_FILE_BY_USER)
    List<DataFile> getDataFileByUser(Long userId);

    /**
     * 获取指定领域下的全部数据文件
     * @param fieldId
     * @return
     */
    @PostMapping(value = Urls.FileApi.GET_DATA_FILE_SUB_FIELD)
    List<DataFile> getDataFileByField(Long fieldId);

    /**
     * 获取指定数据文件
     * @param fileId
     * @return
     */
    @PostMapping(value = Urls.FileApi.GET_DATA_FILE)
    DataFile getDataFile(Long fileId);

    /**
     * 通过查询对象获取数据文件
     * @param req
     * @return 若为空则查询结果不存在
     */
    @PostMapping(value = Urls.FileApi.GET_DATA_FILE_BY_REQ)
    List<DataFile> getDataFileByReq(DataFileReq req);

    /**
     * 获取数据文件下所有的可下载文件名称
     * @param fileId
     * @return
     */
    @PostMapping(value = Urls.FileApi.GET_DATA_FILE_NAME_LIST)
    List<String> getDataFileNameList(Long fileId);

    /**
     * 获取指定文件和用户是否购买
     * @param fileId
     * @param userId
     * @return
     */
    @PostMapping(value = Urls.FileApi.USER_HAS_BUY)
    boolean userHasBuy(Long fileId, Long userId);

    /**
     * 获取指定用户的数据购买列表
     * @param userId
     * @return
     */
    @PostMapping(value = Urls.FileApi.USER_BUY_LIST)
    List<DataFile> userBuyList(Long userId);

    /**
     * 上传数据文件并添加相关数据库信息
     * @param files
     * @param dataFile
     * @return
     */
    @PostMapping(value = Urls.FileApi.UPLOAD_DATA_FILE, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    boolean uploadDataFile(@RequestPart(value = "file") MultipartFile[] files, @RequestPart(value = "dataFile") DataFile dataFile);

    /**
     * 删除数据文件,和相关信息
     * @param fileId
     * @return
     */
    @PostMapping(value = Urls.FileApi.DELETE_DATA_FILE)
    boolean deleteDataFile(Long fileId);

    /**
     * 下载数据文件
     * @param fileId 数据文件ID
     * @param fileName 详细数据文件名称
     * @param request 来自client的request
     * @return responseEntity 可直接作为response body内容返回给client
     */
    @PostMapping(value = Urls.FileApi.DOWNLOAD_DATA_FILE)
    ResponseEntity downloadDataFile(Long fileId, String fileName, HttpServletRequest request);
}
