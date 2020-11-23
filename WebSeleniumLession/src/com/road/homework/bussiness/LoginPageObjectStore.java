package com.road.homework.bussiness;

public class LoginPageObjectStore {
	
	//µÇÂ½Ò³Ãæ
	public final static String LOGIN_LINK = "Link=µÇÂ¼";
	public final static String LOGIN_USER = "xpath=//input[@type='text']";
	public final static String LOGIN_PWD = "xpath=//input[@type='password']";
	public final static String LOGIN_BTN = "xpath=//button[@id='login']/span";
	
	//×¢Ïú
	public final static String LOGOUT_LIST = "xpath=//*[@id='app']/div[1]/div[2]/div/div[3]/div/span/span";
	public final static String LOGOUT_BTN="xpath=//ul[starts-with(@id ,'dropdown-menu')]/li[2]";
}
