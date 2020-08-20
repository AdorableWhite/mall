package com.taizilibai.mall.service.i18n;

import java.util.Locale;

/**
 * @Description:
 * @Date: 2020/8/20 10:52
 */
public interface I18nService {

    Locale getLocale();

    String getLoacleMessage(String propertyKey);

    String getLoacleMessageWithPlaceHolder(String propertyKey, Object params);

}
