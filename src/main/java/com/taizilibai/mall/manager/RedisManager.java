package com.taizilibai.mall.manager;

import com.taizilibai.mall.exception.BizException;

import java.util.List;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 11:50
 */
public interface RedisManager {
    public List<String> getList();
}
