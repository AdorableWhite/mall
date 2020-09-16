package com.taizilibai.mall.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Response
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/1
 * @Version: 1.0.0
 * @Description: 服务器响应或发送终端消息结构
 */
public class Response {

    private final Logger logger = LoggerFactory.getLogger(Response.class);

    protected Header mHeader;

    protected MTData mData;

    protected Ender ender = null;

    public Header getHeader() {
        return mHeader;
    }

    public void setHeader(Header header) {
        mHeader = header;
    }

    public MTData getData() {
        return mData;
    }

    public void setData(MTData data) {
        mData = data;
    }

    public Ender getEnder() {
        return ender;
    }

    public void setEnder(Ender ender) {
        this.ender = ender;
    }

    /**
     *
     * @return buffer
     */
    public DataBuffer encode() {
        try {
            DataBuffer buffer = new DataBuffer();
            //数据头部
            if (mHeader == null) {
                return null;
            }
            buffer.writeDataBuffer(mHeader.encode());
            if(mData != null)
                buffer.writeDataBuffer(mData.encode());

            if(ender != null)
                buffer.writeDataBuffer(ender.encode());
            return buffer.readDataBuffer();
        } catch (Exception e) {
            logger.error("消息编码错误:{}", e.getLocalizedMessage());
            throw new RuntimeException("消息编码错误!!!");
        }
    }
}
