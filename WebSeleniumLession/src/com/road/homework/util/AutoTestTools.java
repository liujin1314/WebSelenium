package com.road.homework.util;

import java.io.IOException;
import java.util.Properties;

public class AutoTestTools {
	
	//ʹ��properties������ȡ�����ļ��е�������
	public static String getConfigFromProperties(String p_key) {
		try {
			Properties pro = new Properties();
			//ͨ���������������������������������ص�properties������
			pro.load(AutoTestTools.class.getClassLoader().getResourceAsStream("config.properties"));
			return pro.getProperty(p_key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("***");
		//System.out.println(getConfigFromProperties("baseURL"));
		System.out.println(AutoTestTools.class.getClassLoader().getSystemResource("config.properties").getPath());
		System.out.println(AutoTestTools.class.getClassLoader().getResource("config.properties").getPath());
	}

}
