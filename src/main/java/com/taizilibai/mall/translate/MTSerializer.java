package com.taizilibai.mall.translate;

/**
 * @ClassName MTSerializer
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/1
 * @Version: 1.0.0
 * @Description: 序列化消息接口
 */
public interface MTSerializer {

    /**
     * 把Request数据结构编码成一个DataBuffer
     */
    public DataBuffer encode();

    /**
     * 把DataBuffer解包构造一个Response对象，getResponse函数必须在调用完decode函数之后才能得到真实的包
     */
    public void decode(DataBuffer buffer);
}
