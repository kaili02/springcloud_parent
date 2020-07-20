package com.demo.beans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Beans {

    @Bean
    @LoadBalanced //必须加  负责java.net.UnknownHostException:
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
