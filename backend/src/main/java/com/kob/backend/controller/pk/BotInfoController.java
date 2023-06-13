package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController  // 这个注解变成了有res的就不返回html页面了
@RequestMapping("/pk/")
public class BotInfoController {
    @RequestMapping("getBotInfo/")  // 需求匹配？
   /* public String getBotInfo() {
       // return "/pk/index.html";
        return "hello";
    }*/

    public Map<String,String> getBotInfo() {
        Map<String,String> bot1 = new HashMap<>();


        bot1.put("name","tiger");
        bot1.put("rating","1500");


        return bot1;
    }
}
