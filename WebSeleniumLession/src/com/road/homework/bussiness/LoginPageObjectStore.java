package com.road.homework.bussiness;

public class LoginPageObjectStore {
	
	//��½ҳ��
	public final static String LOGIN_LINK = "Link=��¼";
	public final static String LOGIN_USER = "xpath=//input[@type='text']";
	public final static String LOGIN_PWD = "xpath=//input[@type='password']";
	public final static String LOGIN_BTN = "xpath=//button[@id='login']/span";
	
	//ע��
	public final static String LOGOUT_LIST = "xpath=//*[@id='app']/div[1]/div[2]/div/div[3]/div/span/span";
	public final static String LOGOUT_BTN="xpath=//ul[starts-with(@id ,'dropdown-menu')]/li[2]";
}
