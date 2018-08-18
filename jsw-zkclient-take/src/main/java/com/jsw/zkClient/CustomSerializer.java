package com.jsw.zkClient;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.io.UnsupportedEncodingException;

/**
 * 自定义序列化类
 * 实现普通字符串的序列化与反序列化
 * 默认使用utf-8编码
 */
public class CustomSerializer implements ZkSerializer{
    /** default utf 8*/
    private String charset = "UTF-8";

    public CustomSerializer(){}

    public CustomSerializer(String charset){
        this.charset = charset;
    }
    public byte[] serialize(Object data) throws ZkMarshallingError {
        try{
            byte[] bytes = String.valueOf(data).getBytes(charset);
            return bytes;
        }catch (UnsupportedEncodingException e){
            throw new ZkMarshallingError("Wrong Charset:" + charset);
        }
    }

    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        String result = null;
        try {
            result = new String(bytes,charset);
        } catch (UnsupportedEncodingException e) {
            throw new ZkMarshallingError("Wrong Charset:" + charset);
        }
        return result;
    }
}