package com.road.report.html;

public class RecordStore {
	//用来记录用例的期望结果
	public static String expected = "null";
	//用来记录用例的实际结果
	public static String actual = "null";
	//用来记录用例的最终状态
	public static String result = "null";
	
	//用来记录通过的用例数
	public static int p_pass;
	//用来记录执行失败的用例数
	public static int p_fail;

}
