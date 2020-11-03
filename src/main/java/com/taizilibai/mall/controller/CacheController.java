package com.taizilibai.mall.controller;

import com.taizilibai.mall.domain.User;
import com.taizilibai.mall.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 测试缓存
 * @Date: 2020/8/11 18:45
 */
@RestController
@RequestMapping("/test")
public class CacheController {

    private Logger logger = LoggerFactory.getLogger(CacheController.class);

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String test(){
        logger.debug("---api入口 [{}]", "debug");
        logger.info("---api入口 [{}]", "info");
        logger.warn("---api入口 [{}]", "warn");
        logger.error("---api入口 [{}]", "error");
        logger.trace("---api入口 [{}]", "trace");
        return "调用成功";
    }

    @GetMapping("/redistest")
    public String redistest(){
        redisTemplate.opsForValue().set("name", "zhangsan");

        return "调用成功";
    }

    @GetMapping("/douguohua")
    public User douguohua(){
        User user = new User();
        user.setSex(true);
        user.setName("豆国华");
        user.setAge(25);
        return user;
    }



    @GetMapping("/exceptionThrow")
    public void exceptionThrow(){
        throw new BizException();
    }
}
