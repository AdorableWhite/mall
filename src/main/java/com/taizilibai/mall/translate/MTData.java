package com.taizilibai.mall.translate;

/**
 * @ClassName MTData
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/15
 * @Version: 1.0.0
 * @Description: 报文数据
 */
public class MTData  implements MTSerializer{

    private byte[]      datas;

    @Override
    public DataBuffer encode() {
        DataBuffer buffer = new DataBuffer(datas.length);
        buffer.writeBytes(datas);
        return buffer;
    }

    @Override
    public void decode(DataBuffer buffer) {
        datas = buffer.readBytes(buffer.readableBytes());
    }

    public byte[] getDatas() {
        return datas;
    }

    public void setDatas(byte[] datas) {
        this.datas = datas;
    }
}
