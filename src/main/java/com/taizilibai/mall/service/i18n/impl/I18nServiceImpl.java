package com.taizilibai.mall.service.i18n.impl;

import com.taizilibai.mall.service.i18n.I18nService;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 10:54
 */
public class I18nServiceImpl implements I18nService {
    @Override
    public Locale getLocale() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        request.getHeader("");

        return new Locale("zh_CN");

    }

    @Override
    public String getLoacleMessage(String propertyKey) {
        return null;
    }

    @Override
    public String getLoacleMessageWithPlaceHolder(String propertyKey, Object params) {
        return null;
    }
}
