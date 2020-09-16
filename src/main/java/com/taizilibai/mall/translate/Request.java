package com.taizilibai.mall.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Request
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/2
 * @Version: 1.0.0
 * @Description: 终端请求数据
 */
public class Request {

    private final Logger logger = LoggerFactory.getLogger(Request.class);

    protected Header mHeader;

    protected MTData mData;

    protected Ender mEnder;

    /**
     * 对数据进行解码
     * @param buffer
     */
    public Request(DataBuffer buffer)
    {
        decode(buffer);
    }

    /**
     *
     *
     * @param buffer
     */
    public void decode(DataBuffer buffer)
    {
        if (buffer != null)
        {
            mHeader = new Header();
            mHeader.decode(buffer);
            //content
            mData = new MTData();
            mData.decode(buffer);
            //Ender
            mEnder = new Ender();
            mEnder.decode(buffer);
        }
    }

    public Header getHeader()
    {
        return mHeader;
    }

    public void setHeader(Header header)
    {
        mHeader = header;
    }

    public MTData getData()
    {
        return mData;
    }

    public void setData(MTData data)
    {
        mData = data;
    }

    public Ender getEnder()
    {
        return mEnder;
    }

    public void setEnder(Ender mEnder)
    {
        this.mEnder = mEnder;
    }


}
