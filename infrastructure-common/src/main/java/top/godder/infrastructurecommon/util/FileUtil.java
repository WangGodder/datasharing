package top.godder.infrastructurecommon.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author mhp
 * @date 2019/1/17
 */

@Service
public class FileUtil {
    public static Log log = LogFactory.getLog(FileUtil.class);

    public JSONObject uploadFile(String savePath, int maxSize, @RequestParam("") MultipartFile file) throws IOException {
        JSONObject obj = new JSONObject();
        //获取springBoot项目的绝对路径
        File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
//        File basePath = new File("E:\\projectFile");
        //传入相对路径
        File uploadNew = new File(basePath.getAbsolutePath(), savePath);
        if (!uploadNew.exists()) uploadNew.mkdirs();//不存在就创建
        //检查目录写权限
        if (!uploadNew.canWrite()) {
            return getMessage("上传目录没有写权限。");
        }

        long filesize = file.getSize();
        if (filesize > maxSize * 1024 * 1024) {
            return getMessage("上传文件大小超过" + maxSize + "MB限制。");
        }
        String fileName = file.getOriginalFilename();
        if (fileName.lastIndexOf("\\") > -1) {//不同文件路径表达式用不同方法
            fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
        }
        if (fileName.lastIndexOf("/") > -1) {
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
        }
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        String fileNameNum = System.currentTimeMillis() + "" + new Random().nextInt(1000);//文件名称
        String newFileName = fileNameNum + "." + fileExt;//文件名为时间好描述杂+随机数
        String saveUrl = savePath + newFileName;  //上传文件以后的存储路径，相对路径，包括文件扩展名等信息，用于存放在数据库的路径
//        if (fileName == null || fileName.equals("")) {
//            continue;
//        }
        //写文件

        String path = uploadNew + "\\" + newFileName;//本地绝对路径，写入时需要
        File newFile = new File(path);//新建一个带有路径的文件
        FileOutputStream out = new FileOutputStream(newFile);//输出流
        InputStream is = file.getInputStream();//构造输入流读文件
        double total = file.getSize();
        int length = 0;
        byte[] by = new byte[1024];
        int persent = 0;
        String prog = "";
        double bytesRead = 0;
        while ((length = is.read(by)) != -1) {
            //计算文件进度
            bytesRead += length;
            double a = bytesRead / total * 100;
            persent = (int) a;
            prog = String.valueOf(persent);
            out.write(by, 0, length);
//                        session.setAttribute("prog", prog);//进度条
//                        obj.put("loaded", persent);
        }
        out.close();


        String fieldName = file.getName().toLowerCase();//html中的Name为驼峰写法
        obj.put(fieldName, saveUrl);


//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        Iterator items;//迭代器（Iterator）
//        try {//所有字段在html处需要加上name属性才能获取
//            items = upload.parseRequest(req).iterator();
//            while (items.hasNext()) {
//                FileItem item = (FileItem) items.next();
//                if (item.isFormField()) {//如果是文本字段
//                    String fieldName = item.getFieldName().toLowerCase();//html中的Name为驼峰写法
//                    String fieldValue = item.getString();
//                    fieldValue = new String(fieldValue.getBytes("ISO-8859-1"), "UTF-8");//防止乱码
//                    obj.put(fieldName, fieldValue);
//                } else {         //上传的是文件
//                    long filesize = item.getSize();
//                    if (filesize > maxSize * 1024 * 1024) {
//                        return getMessage("上传文件大小超过" + maxSize + "MB限制。");
//                    }
//                    String fileName = item.getName();
//                    if (fileName.lastIndexOf("\\") > -1) {//不同文件路径表达式用不同方法
//                        fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
//                    }
//                    if (fileName.lastIndexOf("/") > -1) {
//                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
//                    }
//                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//                    String fileNameNum = System.currentTimeMillis() + "" + new Random().nextInt(1000);//文件名称
//                    String  newFileName =  fileNameNum + fileExt;//文件名为时间好描述杂+随机数
//                    String  saveUrl = savePath + newFileName;  //上传文件以后的存储路径，相对路径，包括文件扩展名等信息，用于存放在数据库的路径
//                    if (fileName == null || fileName.equals("")) {
//                        continue;
//                    }
//                    //写文件
//
//                    String  path = uploadNew + newFileName;//本地绝对路径，写入时需要
//                    File file = new File(path);//新建一个带有路径的文件
//                    FileOutputStream out = new FileOutputStream(file);//输出流
//                    InputStream is = item.getInputStream();//构造输入流读文件
//                    double total = item.getSize();
//                    int length = 0;
//                    byte[] by = new byte[1024];
//                    int persent = 0;
//                    String prog = "";
//                    double bytesRead = 0;
//                    while ((length = is.read(by)) != -1) {
//                        //计算文件进度
//                        bytesRead += length;
//                        double a = bytesRead / total * 100;
//                        persent = (int) a;
//                        prog = String.valueOf(persent);
//                        out.write(by, 0, length);
////                        session.setAttribute("prog", prog);//进度条
////                        obj.put("loaded", persent);
//                    }
//                    out.close();
//                    String fieldName = item.getFieldName().toLowerCase();//html中的Name为驼峰写法
//                    obj.put(fieldName, saveUrl);
//                }
//            }
        //   catch (Exception e) {
        //   throw new BsException("上传文件失败！", e);
        //    }
        return obj;
    }


    public static int delFile(String path) {
        try {
            File f = new File(path);
            if (f.exists()) {
                f.delete();
            }
            return 1;
        } catch (Exception e) {
            log.info(">>>操作：删除文件失败，文件位置:" + path);
            return 0;
        }
    }

    private static JSONObject getMessage(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", "1");
        obj.put("message", message);
        return obj;
    }

}
