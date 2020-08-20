package com.taizilibai.mall.controller;

import com.taizilibai.mall.domain.Response;
import com.taizilibai.mall.domain.User;
import com.taizilibai.mall.exception.BizException;
import com.taizilibai.mall.manager.RedisManager;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @Description: redis 操作测试
 * @Date: 2020/8/19 11:10
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = LoggerFactory.getLogger(RedisController.class);


    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisManager redisManager;

    @GetMapping("/setUser")
    public void setUser(){
        User user = new User();
        user.setAge(13);
        user.setName("zhangsan");
        user.setSex(true);
        redisTemplate.opsForList().set("user", 20, user);

    }

    @GetMapping("/getUser")
    public Object getUser() {
        Long user = redisTemplate.getExpire("user");
        Object user1 = redisTemplate.opsForList().index("user", 1);
        return user1;

    }

    @GetMapping("/getString")
    public void getString() {
        redisTemplate.opsForValue().set("user", "zhangsan");

        logger.debug("user [{}]", redisTemplate.opsForValue().get("user"));

        Integer append = redisTemplate.opsForValue().append("user", "lisi");

        logger.debug("user_append [{}], append:[{}]", redisTemplate.opsForValue().get("user"), append);


    }

    @GetMapping("getException")
    public Response getException() throws BizException {
        throw new BizException();
    }

    @GetMapping("/getList")
    public void getList(){
        redisManager.getList();
    }
}
