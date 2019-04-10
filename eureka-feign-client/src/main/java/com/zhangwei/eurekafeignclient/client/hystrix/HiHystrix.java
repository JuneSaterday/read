package com.zhangwei.eurekafeignclient.client.hystrix;

import com.zhangwei.eurekafeignclient.client.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
