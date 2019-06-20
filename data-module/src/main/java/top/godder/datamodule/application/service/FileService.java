package top.godder.datamodule.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.godder.datamodule.domain.dao.DataFileDao;
import top.godder.datamodule.domain.dao.FileStoreDao;
import top.godder.datamoduleapi.domain.entity.DataFile;
import top.godder.datamoduleapi.domain.entity.FileStore;
import top.godder.datamoduleapi.domain.vo.DataFileReq;
import top.godder.infrastructurecommon.util.RedisUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    private FileStoreDao fileStoreDao;
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

    public List<DataFile> getDataFileByReq(DataFileReq req) {
        if (req == null) {
            return null;
        }
        return dataFileDao.findByReq(req);
    }

    public Integer getFileCredit(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return dataFileDao.findCreditByFileId(fileId);
    }

    public boolean fileBuy(Long fileId, Long userId) {
        if (userId == null || fileId == null) {
            return false;
        }
        return dataFileDao.buyFile(fileId, userId);
    }

    public List<DataFile> buyList(Long userId) {
        if (userId == null) {
            return null;
        }
        return dataFileDao.findByUserBuy(userId);
    }

    public boolean insertDataFile(DataFile dataFile) {
        if (dataFile == null) {
            return false;
        }
        return dataFileDao.insertOne(dataFile);
    }

    public boolean userBuy(Long fileId, Long userId) {
        if (userId == null || fileId == null) {
            return false;
        }
        return dataFileDao.userBuyFile(fileId, userId);
    }

    public List<FileStore> getFileStore(Long fileId) {
        if (fileId == null) {
            return null;
        }
        return fileStoreDao.findFileStoreByFileId(fileId);
    }

//    public boolean insertDataFileRedis(DataFile dataFile) {
//        if (dataFile == null) {
//            return false;
//        }
//        String key = new StringBuilder("insert_file_").append(dataFile.getFileId()).toString();
//        redisUtil.set(key, JSON.toJSONString(dataFile));
//        return true;
//    }

    public boolean deleteDataFile(Long fileId) {
        if (fileId == null) {
            return false;
        }
        deleteFile(fileId);
        return dataFileDao.deleteByFileId(fileId);
    }

    private boolean deleteFile(Long fileId) {
        if (fileId == null) {
            return false;
        }
        File dir = new File(this.dataStoreDir + fileId);
        if (!dir.exists()) {
            return true;
        }
        return dir.delete();
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

    public ResponseEntity<byte[]> downloadDataFile(Long fileId, String fileName, HttpServletRequest request) throws IOException {
        File file = getDownloadDataFile(fileId, fileName);
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        try (InputStream in = new FileInputStream(file)) {
            byte[] bytes = new byte[in.available()];
            String name = file.getName();
            //处理IE下载文件的中文名称乱码的问题
            String header = request.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                name = URLEncoder.encode(name, "utf-8");
                //IE下载文件名空格变+号问题
                name = name.replace("+", "%20");
            } else {
                name = new String(name.getBytes(), StandardCharsets.ISO_8859_1);
            }
            entity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }

    private File getDownloadDataFile(Long fileId, String fileName) {
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
            FileStore fileStore = FileStore.builder()
                    .fileId(fileId)
                    .fileName(name)
                    .fileSize((int) file.getSize())
                    .build();
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            fileStoreDao.insertFileStore(fileStore);
        }
        return true;
    }
}
