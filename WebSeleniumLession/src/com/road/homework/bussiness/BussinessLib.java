package com.road.homework.bussiness;

import java.awt.AWTException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.road.homework.test.SettingPageObjectStore;
import com.road.robot.RobotUtil;

public class BussinessLib {
	
	private  WebDriver driver;
	
	public void login(WebDriver p_driver , String p_username , String p_password) throws InterruptedException{
		driver = p_driver;
		Thread.sleep(1000);
		driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_LINK)).click();
		Thread.sleep(1000);
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_USER)).clear();
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_USER)).sendKeys(p_username);
	    Thread.sleep(1000);
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_PWD)).clear();
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_PWD)).sendKeys(p_password);
	    driver.findElement(BussinessLib.parseObject(LoginPageObjectStore.LOGIN_BTN)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void settingInfo(WebDriver p_driver , String p_picPath , String p_age , String p_sex , String p_company , String p_qq , String p_email , String p_phone) {
		driver = p_driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_BTN)).click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    //ֻ���ļ��ϴ��ı�ǩ��input��ʱ�򣬲���ʹ��sendKeys�ķ�ʽ����
	   driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SEETING_PHONTO)).clear();
	   driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SEETING_PHONTO)).sendKeys(p_picPath);
	    
	    
	    //������ͨ��robot��ķ�ʽȥʵ���ļ��ϴ�
	   // driver.findElement(By.id("file")).click();
	    //driver.findElement(By.xpath("//*[@id='personInfo']/div[1]/div[3]/form/a")).click();
	    //Thread.sleep(10000);
	    //String path = System.getProperty("user.dir") + File.separator + "p1.jpg";
	    //System.out.println(path);
	    //RobotUtil.getInstace().typeString(path);
	    //RobotUtil.getInstace().enterKey("tab", 2);
	    //RobotUtil.getInstace().enterKey("enter", 1);
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_AGE)).clear();
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_AGE)).sendKeys(p_age);
	    
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SEX)).click();
	    
	    if("��".equals(p_sex)){
	    	driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SEX_MALE)).click();
	    }else{
	    	driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SEX_FEMALE)).click();
	    }
	    
	    //driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SEX_MALE)).click();
	    //driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SEX)).sendKeys(p_sex);
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_COMPANY)).clear();
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_COMPANY)).sendKeys(p_company);
	    
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_QQ)).clear();
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_QQ)).sendKeys(p_qq);
	    
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_PHONE)).clear();
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_PHONE)).sendKeys(p_phone);
	    
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_EMAIL)).clear();
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_EMAIL)).sendKeys(p_email);
	    
	    
	    driver.findElement(BussinessLib.parseObject(SettingPageObjectStore.SETTING_SAVE)).click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/*
	 * parseObject(String p_object)
	 * ͨ�����ݽ�����ҳ��Ԫ�ؽ��н���  ���ݵ�ҳ��Ԫ�ظ�ʽΪ�� [ҳ��Ԫ������=·��]
	 */
	public static By parseObject(String p_object){
		String newObject = null;
		
		if(p_object.startsWith(".//") || p_object.startsWith("//") ){
			//���ݽ�����ҳ��Ԫ��Ϊ//��ʼ�Ļ���.//��ʼ�ľ���Ϊ��xpath��λ
			return By.xpath(p_object);
		}else if (p_object.toUpperCase().startsWith("LINK=")){
			//Link��λ
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.linkText(newObject);
		}else if (p_object.toUpperCase().startsWith("ID=")){
			//id��λ
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.id(newObject);
		}else if (p_object.toUpperCase().startsWith("CLASS=")){
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.className(newObject);
		}else if (p_object.toUpperCase().startsWith("CSS=")){
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.cssSelector(newObject);
		}else if(p_object.toUpperCase().startsWith("NAME=")){
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.name(newObject);
		}else if(p_object.toUpperCase().startsWith("TAGNAME=")){
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.tagName(newObject);
		}else if(p_object.toUpperCase().startsWith("XPATH=")){
			newObject = p_object.substring(p_object.indexOf("=") + 1);
			return By.xpath(newObject);
		}else{
			return null;
		}
		
	}

}
