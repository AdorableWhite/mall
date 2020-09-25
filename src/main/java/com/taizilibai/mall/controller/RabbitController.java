package com.taizilibai.mall.controller;

import com.taizilibai.mall.config.domain.SimpleSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/9/22 19:57
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Resource
    private SimpleSender simpleSender;

    @GetMapping("/sendHello")
    public void sendHello() throws InterruptedException {
        for(int i=0; i<10; i++) {
            simpleSender.send();
            Thread.sleep(1000);
        }
    }
}
