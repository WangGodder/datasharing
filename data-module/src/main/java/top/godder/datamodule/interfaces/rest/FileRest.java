package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.godder.datamodule.application.service.FileService;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.vo.DataFileReq;
import top.godder.datamoduleapi.service.FileApi;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: godder
 * @date: 2019/5/21
 */
@RestController
public class FileRest implements FileApi {
    @Autowired
    private FileService fileService;

    @Override
    public List<DataFile> getAllDataFile() {
        return fileService.getAllDataFile();
    }

    @Override
    public List<DataFile> getDataFileByUser(Long userId) {
        return fileService.getDataFileByUser(userId);
    }

    @Override
    public List<DataFile> getDataFileByField(Long fieldId) {
        return fileService.getDataFileByField(fieldId);
    }

    @Override
    public DataFile getDataFile(Long fileId) {
        return fileService.getDataFile(fileId);
    }

    @Override
    public List<DataFile> getDataFileByReq(DataFileReq req) {
        return fileService.getDataFileByReq(req);
    }

    @Override
    public List<String> getDataFileNameList(Long fileId) {
        return fileService.getDataFileNameList(fileId);
    }

    @Override
    public boolean userHasBuy(Map<String, Long> map) {
        Long fileId = map.get("fileId");
        Long userId = map.get("userId");
        return fileService.fileBuy(fileId, userId);
    }

    @Override
    public List<DataFile> userBuyList(Long userId) {
        return fileService.buyList(userId);
    }

    @Override
    public boolean uploadDataFile(MultipartFile[] files, DataFile dataFile) {
        if (!fileService.insertDataFile(dataFile)) {
            return false;
        }
        Long fileId = dataFile.getFileId();
        return fileService.uploadDataFile(files, fileId);
    }


    @Override
    public boolean deleteDataFile(Long fileId) {
        return fileService.deleteDataFile(fileId);
    }

    @Override
    public ResponseEntity downloadDataFile(Map<String, Object> map) {
        Long fileId = (Long) map.get("fileId");
        String fileName = (String) map.get("fileName");
        HttpServletRequest request = (HttpServletRequest) map.get("request");
        try {
            return fileService.downloadDataFile(fileId, fileName, request);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
