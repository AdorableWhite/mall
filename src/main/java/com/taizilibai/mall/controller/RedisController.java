package com.taizilibai.mall.controller;

import com.taizilibai.mall.domain.User;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: redis 操作测试
 * @Date: 2020/8/19 11:10
 */
@RestController("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

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

    }
}
