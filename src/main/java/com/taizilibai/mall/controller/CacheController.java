package com.taizilibai.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试缓存
 * @Author: zxx
 * @Date: 2020/8/11 18:45
 */
@RestController
public class CacheController {

    @GetMapping("/test")
    public String test(){
        return "调用成功";
    }
}
