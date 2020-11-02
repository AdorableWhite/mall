package com.taizilibai.mall;

import com.taizilibai.mall.manager.SocketTransceiver;
import com.taizilibai.mall.manager.TcpClient;
import org.apache.catalina.startup.ContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableCaching
public class MallApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MallApplication.class, args);
        //  获取当前运行环境
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();

    }

}
