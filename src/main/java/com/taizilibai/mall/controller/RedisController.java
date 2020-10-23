package com.taizilibai.mall.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.taizilibai.mall.config.domain.BusinessHours;
import com.taizilibai.mall.domain.Response;
import com.taizilibai.mall.domain.User;
import com.taizilibai.mall.exception.BizException;
import com.taizilibai.mall.manager.RedisManager;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Description: redis 操作测试
 * @Date: 2020/8/19 11:10
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private Logger logger = LoggerFactory.getLogger(RedisController.class);


    @Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisManager redisManager;

    @PostMapping("/testBusinessHours")
    public void testBusinessHours(@RequestBody BusinessHours businessHours) {
        System.out.println(businessHours);
    }

    @PostMapping("/testString")
    public void testString(@RequestBody String value){
        System.out.println(value);
    }

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

    @PostMapping("/testLocalTimeList")
    public void testLocalTimeList(@RequestBody BusinessHours business) {
        LocalTime[][] bushour = business.getTimes();
        LocalTime[][] businessHours = new LocalTime[3][2];

        for(int i=0; i<bushour.length; i++) {
            businessHours[i] = bushour[i];
        }
        int length = bushour.length;

        for(LocalTime[] tmp:bushour) {
//            int length = businessHours.length;
            if(tmp[0].isAfter(tmp[1])) {
                LocalTime end = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime start = LocalTime.parse("00:00", DateTimeFormatter.ofPattern("HH:mm"));
                businessHours[length][0] = start;
                businessHours[length][1] = tmp[1];
                tmp[1] = end;
                length ++;
            }
        }


        System.out.println(businessHours);
    }
}
