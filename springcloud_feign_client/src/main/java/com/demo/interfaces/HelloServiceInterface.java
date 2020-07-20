package com.demo.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("HELLO-SERVICE") //明确该接口对应eureka中的哪个服务
@FeignClient(value = "HELLO-SERVICE",fallback = HelloServiceHystrixImpl.class) //明确该接口对应eureka中的哪个服务， fallback 指明服务不可用时的实现类
public interface HelloServiceInterface {

    @RequestMapping("/hello/hello")
    String hello(@RequestParam("name") String name);
}
