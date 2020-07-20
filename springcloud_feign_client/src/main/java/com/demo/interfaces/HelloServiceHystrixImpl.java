package com.demo.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created By kaili
 * Date: 2020/01/13
 * Description: TODO
 */
@Component
public class HelloServiceHystrixImpl  implements  HelloServiceInterface{

    public String hello(String bb) {
        return "servers is down, name: "+bb;
    }
}
