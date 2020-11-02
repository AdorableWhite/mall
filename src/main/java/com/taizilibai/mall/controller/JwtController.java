package com.taizilibai.mall.controller;

import com.taizilibai.mall.config.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/10/27 11:07
 */
@RestController
@RequestMapping("/jwtcontroller")
public class JwtController {

    @Autowired
    JwtConfig jwtConfig;

    @GetMapping("/testJwt")
    public String testJwt() {
        String audience = jwtConfig.getAudience();
        System.out.println(audience);
        return audience;

    }
}
