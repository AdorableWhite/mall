package com.taizilibai.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2020/10/26 17:40
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String secret;
    private String issuser;
    private String subject;
    private String audience;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getIssuser() {
        return issuser;
    }

    public void setIssuser(String issuser) {
        this.issuser = issuser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
