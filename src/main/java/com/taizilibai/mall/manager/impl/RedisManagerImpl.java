package com.taizilibai.mall.manager.impl;

import com.taizilibai.mall.exception.BizException;
import com.taizilibai.mall.manager.RedisManager;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: zxx
 * @Date: 2020/8/20 11:51
 */
@Component
public class RedisManagerImpl implements RedisManager {

    @Override
    public List<String> getList(){
        throw new BizException();
    }
}
