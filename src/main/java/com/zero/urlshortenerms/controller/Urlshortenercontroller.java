package com.zero.urlshortenerms.controller;

import cn.hutool.core.lang.Snowflake;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Urlshortenercontroller {


    Snowflake snowflake = new Snowflake();
    @GetMapping("/hello")
    public String hello(){
        return snowflake.nextIdStr();
    }

}
