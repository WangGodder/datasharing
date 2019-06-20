package top.godder.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import top.godder.webmodule.service.DataFileService;

/**
 * @author: godder
 * @date: 2019/5/24
 */

/**
 * 用于控制页面跳转的Controller
 */
@Controller
public class PageController {
    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    /**
     * 登陆页面
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 注册页面
     */
    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    /**
     * 数据仓库页面
     */
    @GetMapping(value = "/fileStore")
    public String fileStore() {
        return "fileStore";
    }

    /**
     * 数据社区页面
     * @return
     */
    @GetMapping(value = "/community")
    public String community() {
        return "community";
    }


    @GetMapping(value = "/filePage/{fileId}")
    public String filePage(@PathVariable("fileId") String fileId) {
        return "filePage";
    }
}
