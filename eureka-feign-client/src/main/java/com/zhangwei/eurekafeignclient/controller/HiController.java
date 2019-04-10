package com.zhangwei.eurekafeignclient.controller;

import com.zhangwei.eurekafeignclient.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "zhangwei",required = false) String name){
        return  hiService.sayHi(name);
    }
}
