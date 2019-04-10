package com.zhangwei.eurekaribbonclient.controller;

import com.zhangwei.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "ribbon-client") String name){
        return  ribbonService.hi(name);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        return  instance.getHost() + ":" + instance.getPort();
    }


}
