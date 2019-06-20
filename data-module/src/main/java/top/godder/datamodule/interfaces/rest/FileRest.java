package top.godder.datamodule.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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
    public List<DataFile> getDataFileByUser(@RequestBody Long userId) {
        return fileService.getDataFileByUser(userId);
    }

    @Override
    public List<DataFile> getDataFileByField(@RequestBody Long fieldId) {
        return fileService.getDataFileByField(fieldId);
    }

    @Override
    public DataFile getDataFile(@RequestBody Long fileId) {
        return fileService.getDataFile(fileId);
    }

    @Override
    public List<DataFile> getDataFileByReq(@RequestBody DataFileReq req) {
        return fileService.getDataFileByReq(req);
    }

    @Override
    public List<String> getDataFileNameList(@RequestBody Long fileId) {
        return fileService.getDataFileNameList(fileId);
    }

    @Override
    public boolean userHasBuy(@RequestBody Map<String, Long> map) {
        Long fileId = map.get("fileId");
        Long userId = map.get("userId");
        return fileService.fileBuy(fileId, userId);
    }

    @Override
    public List<DataFile> userBuyList(@RequestBody Long userId) {
        return fileService.buyList(userId);
    }

    @Override
    public Integer fileDownloadCredit(@RequestBody Long fileId) {
        return fileService.getFileCredit(fileId);
    }

    @Override
    public boolean uploadDataFile(@RequestPart(value = "file") MultipartFile[] files, @RequestParam(value = "dataFile") DataFile dataFile) {
        if (!fileService.insertDataFile(dataFile)) {
            return false;
        }
        Long fileId = dataFile.getFileId();
        return fileService.uploadDataFile(files, fileId);
    }

    @Override
    public boolean userBuyFile(@RequestBody Map<String, Long> map) {
        Long fileId = map.get("fileId");
        Long userId = map.get("userId");
        return fileService.userBuy(fileId, userId);
    }


    @Override
    public boolean deleteDataFile(@RequestBody Long fileId) {
        return fileService.deleteDataFile(fileId);
    }

    @Override
    public ResponseEntity downloadDataFile(@RequestBody Map<String, Object> map) {
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
