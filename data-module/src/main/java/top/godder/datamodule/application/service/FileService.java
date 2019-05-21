package top.godder.datamodule.application.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.godder.datamodule.domain.dao.DataFileDao;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.infrastructurecommon.util.RedisUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/20
 */
@Service
public class FileService {
    @Value(value = "${data_store_dir}")
    private String dataStoreDir;

    @Autowired
    private DataFileDao dataFileDao;
    @Autowired
    private RedisUtil redisUtil;

    public List<DataFile> getAllDataFile() {
        return dataFileDao.findAll();
    }

    public List<DataFile> getDataFileByField(Long fieldId) {
        if (fieldId == null) {
            return null;
        }
        return dataFileDao.findByFieldId(fieldId);
    }

    public List<DataFile> getDataFileByUser(Long userId) {
        if (userId == null) {
            return null;
        }
        return dataFileDao.findByUserId(userId);
    }

    public DataFile getDataFile(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return dataFileDao.findByFiledId(fileId);
    }

    public boolean insertDataFile(DataFile dataFile) {
        if (dataFile == null) {
            return false;
        }
        return dataFileDao.insertOne(dataFile);
    }

    public boolean insertDataFileRedis(DataFile dataFile) {
        if (dataFile == null) {
            return false;
        }
        String key = new StringBuilder("insert_file_").append(dataFile.getFileId()).toString();
        redisUtil.set(key, JSON.toJSONString(dataFile));
        return true;
    }

    public List<String> getDataFileNameList(Long fileId) {
        File dir = new File(this.dataStoreDir + fileId);
        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        List<String> names = new ArrayList<>(files.length);
        for (File file : files) {
            names.add(file.getName());
        }
        return names;
    }

    public File downloadDataFile(Long fileId, String fileName) {
        File dir = new File(this.dataStoreDir + fileId);
        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }
        File file = new File(dir + File.separator + fileName);
        return file;
    }

    public boolean uploadDataFile(MultipartFile[] files, Long fileId) {
        File dir = new File(this.dataStoreDir + fileId + File.separator);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                return false;
            }
        }
        for (MultipartFile file : files) {
            String name = file.getName();
            File dest = new File(dir + name);
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
