package top.godder.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.godder.infrastructurecommon.result.JsonResult;
import top.godder.webmodule.service.DataFileService;
import top.godder.webmodule.vo.FileSimpleInfo;

/**
 * @author: godder
 * @date: 2019/6/20
 */
@RestController
@RequestMapping(value = "/dataFile")
public class DataFileController {
    @Autowired
    private DataFileService fileService;

    @PostMapping(value = "/fileInfo")
    public JsonResult getDataFileInfo(@RequestBody Long fileId) {
        FileSimpleInfo fileSimpleInfo = fileService.getFileSimpleInfo(fileId);
        if (fileSimpleInfo == null) {
            return JsonResult.fail(1, "not find");
        }
        return JsonResult.success(fileSimpleInfo);
    }
}
