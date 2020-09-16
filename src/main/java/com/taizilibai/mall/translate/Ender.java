package com.taizilibai.mall.translate;

/**
 * @ClassName Ender
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/15
 * @Version: 1.0.0
 * @Description: 数据包结尾
 */
public class Ender implements MTSerializer{
    public static final int PROTOCOL_ENDER_LENGTH   = 2;

    private int    checksum;   //数据校验码

    public Ender(){

    }

    public Ender(int checksum){
        this.checksum = checksum;
    }

    @Override
    public DataBuffer encode() {
        DataBuffer data = new DataBuffer(PROTOCOL_ENDER_LENGTH);
        data.writeShort((short)checksum);
        return data;
    }

    @Override
    public void decode(DataBuffer data) {
        checksum = data.readShort();
    }


    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }
}
