package com.taizilibai.mall.translate;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.List;

/**
 * @ClassName DataBuffer
 * @Author: hellmash@gmail.com
 * @Date: 2020/3/1
 * @Version: 1.0.0
 * @Description: byteBuffer简单封装
 */
public class DataBuffer {
    protected ByteBuf mBuffer;

    public DataBuffer()
    {
        mBuffer = Unpooled.buffer();
    }

    public DataBuffer(ByteBuf binaryBuffer)
    {
        mBuffer = binaryBuffer;
    }

    public DataBuffer(int length)
    {
        mBuffer = Unpooled.buffer(length);
    }

    public boolean isReadable()
    {
        return mBuffer.isReadable();
    }

    public boolean isWritable()
    {
        return mBuffer.isWritable();
    }

    public byte[] array()
    {
        return mBuffer.array();
    }

    public void setOrignalBuffer(ByteBuf buffer)
    {
        this.mBuffer = buffer;
    }

    public ByteBuf getOrignalBuffer()
    {
        return mBuffer;
    }

    public void writeByte(int value)
    {
        mBuffer.writeByte(value);
    }

    public byte readByte()
    {
        return mBuffer.readByte();
    }

    public short readUnsignByte(){
        return mBuffer.readUnsignedByte();
    }

    public void writeBytes(byte[] bytes)
    {
        mBuffer.writeBytes(bytes);
    }

    public byte[] readBytes(int length)
    {
        byte[] bytes = new byte[length];
        mBuffer.readBytes(bytes);
        return bytes;
    }

    public int readInt()
    {
        if (mBuffer.isReadable())
        {
            return mBuffer.readInt();
        }
        else
        {
            return 0;
        }
    }

    public void writeInt(int value)
    {
        mBuffer.writeInt(value);
    }

    public short readShort()
    {
        if (mBuffer.isReadable())
        {
            return mBuffer.readShort();
        }
        else
        {
            return 0;
        }
    }

    public void writeShort(int value)
    {
        mBuffer.writeShort(value);
    }

    public char readChar()
    {
        return mBuffer.readChar();
    }

    public void writeChar(char c)
    {
        mBuffer.writeChar(c);
    }

    public long readLong()
    {
        if (mBuffer.isReadable())
        {
            return mBuffer.readLong();
        }
        else
        {
            return 0;
        }
    }

    public void writeLong(long value)
    {
        mBuffer.writeLong(value);
    }

    public double readDouble()
    {
        if (mBuffer.isReadable())
        {
            return mBuffer.readDouble();
        }
        else
        {
            return 0;
        }
    }

    public void writeDouble(double value)
    {
        mBuffer.writeDouble(value);
    }

    /**
     * 读取一个字符串
     *
     * @return 格式：前导length表示字符串的byte数 length(4字节)string(length字节)
     */
    public String readString(int length)
    {
        byte[] bytes = readBytes(length);
        return new String(bytes);
    }

    /**
     * 写入一个字符串
     *
     * @param str 数据格式见方法readString()
     */
    public void writeString(String str, int length)
    {
        writeStringFixed(str, length, (byte) 0x20);
    }

    public void writeStringFixed(String str, int length, byte value)
    {
        if(length <= 0)return;
        if (str == null)
        {
            str = "";
        }
        if(str.length() > length){
            str = str.substring(0, length-1);
        }
        byte[] bytes = str.getBytes();
        writeBytes(bytes);
        if(str.length() < length){
            for(int i = 0; i < (length - str.length()); ++i){
                writeByte(value);
            }
        }
    }



    /**
     * 读取int数组
     *
     * @return 格式：前导count表示数组中有多少个元素 count(4字节)int1(4字节)...intCount(4字节)
     */
    public int[] readIntArray(int length)
    {
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++)
        {
            intArray[i] = readInt();
        }
        return intArray;
    }

    /**
     * 写入int数组
     *
     * @param intArray 格式见readIntArray()
     */
    public void writeIntArray(int[] intArray)
    {
        int count = intArray.length;
        for (int i = 0; i < count; i++)
        {
            writeInt(intArray[i]);
        }
    }

    /**
     * @param intList
     * @Description: 写入一个int的list, list转数组太蛋疼了
     */
    public void writeIntList(List<Integer> intList)
    {
        if (intList == null || intList.isEmpty())
        {
            return;
        }
        int count = intList.size();
        for (int i = 0; i < count; i++)
        {
            writeInt(intList.get(i));
        }
    }

    /**
     * 读取byte数组
     *
     * @return 格式：前导count表示数组中有多少个元素 count(4字节)byte1(4字节)...byteCount(4字节)
     */
    public byte[] readByteArray(int length)
    {
        byte[] bytes = new byte[length];
        mBuffer.readBytes(bytes);
        return bytes;
    }

    /**
     * 写入byte数组
     *
     * @param byteArray 格式见readByteArray()
     */
    public void writeByteArray(byte[] byteArray)
    {
        mBuffer.writeBytes(byteArray);
    }

    /**
     * 获取有效(可读取)的byte数
     *
     * @return
     */
    public int readableBytes()
    {
        return mBuffer.readableBytes();
    }

    /**
     * 读取内容
     * @return
     */
    public DataBuffer readDataBuffer()
    {
        if (mBuffer == null || mBuffer.readableBytes() == 0)
        {
            return new DataBuffer(0);
        }
        int length = readableBytes();
        DataBuffer dataBuffer = new DataBuffer(length);
        dataBuffer.setOrignalBuffer(mBuffer.readBytes(length));
        mBuffer.release();
        return dataBuffer;
    }

    /**
     * 读取指定长度的内容
     * @param length
     * @return
     */
    public DataBuffer readDataBuffer(int length)
    {
        if (length > 0)
        {
            DataBuffer dataBuffer = new DataBuffer(0);
            dataBuffer.setOrignalBuffer(mBuffer.readBytes(length));
            mBuffer.release();
            return dataBuffer;
        }
        else
        {
            return new DataBuffer(0);
        }
    }

    public void writeDataBuffer(DataBuffer inputBuffer)
    {
        if (inputBuffer == null || inputBuffer.readableBytes() == 0)
        {
            return;
        }
        mBuffer.writeBytes(inputBuffer.readBytes(inputBuffer.readableBytes()));
    }
}
