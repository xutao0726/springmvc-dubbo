package com.jsw.zkClient;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Znode {
	// 全局节点
	public static final String DB_ADDRESS = "/db";
	public static final String DBA_ADDRESS = "/dba";
	public static List<String> getZnode() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
		  // TODO Auto-generated method stub
        //获取所有变量的值
        Class clazz = Class.forName("com.jsw.zkClient.Znode");
        Field[] fields = clazz.getFields();
        List<String> list = new ArrayList<String>();
        for( Field field : fields ){
        	list.add((String) field.get(clazz));
        }
        return list;
	}
}
