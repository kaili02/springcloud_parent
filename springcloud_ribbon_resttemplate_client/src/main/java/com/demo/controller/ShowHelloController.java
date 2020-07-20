package com.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/show")
public class ShowHelloController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "errorHello") // 服务都不可用时，响应方法errorHello
    public String showHello(String name){
        // 第一种
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:8989/hello/hello?name=" + name, String.class);
//        System.out.println("for Object: " + forObject);

        //第二种
//        ServiceInstance serviceInstance = loadBalancerClient.choose("hello-service");
//        System.out.println(serviceInstance.getHost());
//        System.out.println(serviceInstance.getServiceId());
//        System.out.println(serviceInstance.getUri());
//        System.out.println(serviceInstance.getPort());
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello/hello?name=" + name, String.class);
//        System.out.println("object: " + forObject);

        /*第三种
        *
        * HELLO-SERVICE 为注册服务名称
        * */
        String forObject1 = this.restTemplate.getForObject("http://hello-service/hello/hello?name=" + name, String.class);

        System.out.println(forObject1);
        return forObject1;



    }


    public String errorHello(String name){
        return "Servers is shotdown, name : " + name;
    }
}
