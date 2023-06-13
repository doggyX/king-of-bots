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

    public List<Map<String,String>> getBotInfo() {
        List<Map<String,String>> mapList = new LinkedList<>();
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();

        map1.put("name","lx");
        map1.put("age","20");

        map2.put("name","yx");
        map2.put("age","26");

        mapList.add(map1);
        mapList.add(map2);

        return mapList;
    }
}
