package top.godder.webmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.domain.entity.FileComment;
import top.godder.datamoduleapi.service.FieldApi;
import top.godder.datamoduleapi.service.FileApi;
import top.godder.datamoduleapi.service.FileCommentApi;
import top.godder.datamoduleapi.service.UserInfoApi;
import top.godder.webmodule.vo.FileSimpleInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/5/24
 */
@Service
public class DataFileService {
    @Autowired
    private FileApi fileApi;
    @Autowired
    private UserInfoApi userInfoApi;
    @Autowired
    private FieldApi fieldApi;
    @Autowired
    private FileCommentApi fileCommentApi;


    public ResponseEntity download(Long fileId, String fileName, HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        if (jwt == null || jwt.isEmpty()) {
            return null;
        }
        UserBaseInfo userBaseInfo = userInfoApi.getBaseInfo(jwt);
        Map<String, Object> map = new HashMap<>(3);
        map.put("fileId", fileId);
        map.put("fileName", fileName);
        map.put("request", request);
        ResponseEntity downFile = fileApi.downloadDataFile(map);
        return downFile;
    }

    public boolean upload(MultipartFile[] files, DataFile dataFile) {
        return fileApi.uploadDataFile(files, dataFile);
    }

    public FileSimpleInfo getFileSimpleInfo(Long fileId) {
        DataFile dataFile = fileApi.getDataFile(fileId);
        List<Field> fieldList = fieldApi.getFieldByFile(fileId);
        Float level = fileCommentApi.getAvgLevel(fileId);
        return null;
    }
}
