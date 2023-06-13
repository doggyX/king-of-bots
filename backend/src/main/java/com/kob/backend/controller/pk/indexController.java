package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// 为了体现前后端不分离 返回了html文件（字符串）
// 可删除
@Controller
@RequestMapping("/pk/") // 父目录
public class indexController {
    @RequestMapping("index/")
    public String index() {
        return "/pk/index.html";
    }
}
