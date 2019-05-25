package top.godder.webmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
