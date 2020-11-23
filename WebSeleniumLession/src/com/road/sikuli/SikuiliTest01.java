package com.road.sikuli;



import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuiliTest01 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(System.getProperty("user.dir") + File.separator + "chrome.png");
		printTime();
		System.out.println(isPicExist(System.getProperty("user.dir") + File.separator + "chrome.png"));
		printTime();
		//clickPic(System.getProperty("user.dir") + File.separator + "chrome.png");
		printTime();
		doubleClickPic(System.getProperty("user.dir") + File.separator + "chrome.png");
	}
	
	//�жϵ�ǰ�����Ƿ���ָ����ͼƬ��p_picPathΪָ��ͼƬ��·��
	public static boolean isPicExist(String p_picPath){
		Screen screen = new Screen();
		try {
			screen.wait(p_picPath);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	
	//���ָ����ͼƬ��p_picPathΪָ��ͼƬ��·��
	public static boolean clickPic(String p_picPath) {
		Screen screen = new Screen();
		try {
			screen.click(p_picPath);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	
	//˫��ָ����ͼƬ��p_picPathΪָ��ͼƬ��·������˫�������е������ͼ�꣩
	public static boolean doubleClickPic(String p_picPath) {
		Screen screen = new Screen();
		try {
			screen.doubleClick(p_picPath);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	
	public static void printTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
		String time = sdf.format(new Date());
		System.out.println(time);
	}

}
