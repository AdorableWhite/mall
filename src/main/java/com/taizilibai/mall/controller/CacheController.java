package com.taizilibai.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试缓存
 * @Date: 2020/8/11 18:45
 */
@RestController
public class CacheController {

    private Logger logger = LoggerFactory.getLogger(CacheController.class);

    @GetMapping("/test")
    public String test(){
        logger.debug("---api入口 [{}]", "debug");
        logger.info("---api入口 [{}]", "info");
        logger.warn("---api入口 [{}]", "warn");
        logger.error("---api入口 [{}]", "error");
        logger.trace("---api入口 [{}]", "trace");
        return "调用成功";
    }
}
