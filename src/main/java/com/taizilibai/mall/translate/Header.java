package com.taizilibai.mall.translate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Header
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/15
 * @Version: 1.0.0
 * @Description: 合并resp和req
 */
public class Header implements MTSerializer{

    private final Logger logger = LoggerFactory.getLogger(Header.class);

    /**
     *
     * 请求数据报文长度
     */
    public static final int PROTOCOL_HEADER_LENGTH = 26;

    private short       syn = 0x3aa3;               // 数据包标记
    private byte[]      res = {0x00,0x00,0x00};     // 保留字节
    private byte        ptrol;                      // 协议控制字
    private String      addr;                       // 出厂序列号

    private short       length;                     //报文长度
    private short       command;                    //命令

    @Override
    public DataBuffer encode() {
        if(!checkFlag())
            return null;
        DataBuffer data = new DataBuffer(PROTOCOL_HEADER_LENGTH);
        data.writeShort(syn);
        data.writeByteArray(res);
        data.writeByte(ptrol);
        data.writeString(addr, 16);
        data.writeShort(length);
        data.writeShort(command);
        return data;
    }

    @Override
    public void decode(DataBuffer buffer) {
        syn     = buffer.readShort();
        res     = buffer.readByteArray(3);
        ptrol   = buffer.readByte();
        addr    = buffer.readString(16);
        length  = buffer.readShort();
        command = buffer.readShort();
    }

    /**
     * @return
     */
    public Boolean checkFlag(){
        if(syn == 0x3aa3){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "Header{" +
                "SYN=" + this.getSyn() +
                ", ADDR(SN)=" + this.getAddr() +
                '}';
    }

    public short getSyn() {
        return syn;
    }

    public void setSyn(short syn) {
        this.syn = syn;
    }

    public byte[] getRes() {
        return res;
    }

    public void setRes(byte[] res) {
        this.res = res;
    }

    public byte getPtrol() {
        return ptrol;
    }

    public void setPtrol(byte ptrol) {
        this.ptrol = ptrol;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getCommand() {
        return command;
    }

    public void setCommand(short command) {
        this.command = command;
    }
}
